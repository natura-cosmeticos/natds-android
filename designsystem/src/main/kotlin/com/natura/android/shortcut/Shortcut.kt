package com.natura.android.shortcut

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.getIntOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import androidx.core.graphics.drawable.DrawableCompat
import com.natura.android.R
import com.natura.android.badge.Badge
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.resources.getIconResourceIdFromName
import com.natura.android.extensions.setAppearance
import com.natura.android.resources.getDimenFromTheme

class Shortcut @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var labelAttribute: String? = null
    private var typeAttribute: Int? = null
    private var notifyAttribute: Int = 0
    private var backgroundColorResourceAttribute = 0
    private var iconColorResourceAttribute = 0
    private var labelTextAppearanceResourceAttribute = 0
    private var iconAttribute: String? = null
    private var shortcutAttributesArray: TypedArray

    val labelContainer: TextView by lazy { findViewById(R.id.shortCutLabel) }
    private val backgroundContainer by lazy { findViewById<LinearLayout>(R.id.shortcutBackground) }
    private val iconContainer by lazy { findViewById<ImageView>(R.id.shortCutIcon) }
    private val notifyContainer by lazy { findViewById<Badge>(R.id.notifyContainer) }

    init {
        try {
            View.inflate(context, R.layout.shortcut, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        shortcutAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.Shortcut)

        getShortcutAttributes()
        getAttributesFromTheme()
        configureShortCutByType(typeAttribute)

        shortcutAttributesArray.recycle()
    }

    var notify: Int = 0
        /**
         * Specifies the number showed as a notification at the corner of badge
         * When 0, notification is not visible, when bigger than 99, notification
         * shows 99+
         * @return a integer with current number
         * */
        get() = notifyAttribute
        /**
         * Change the number showed by notification at shortcut
         * When 0, notification is not visible, when bigger than 99, notification
         * shows 99+
         * */
        set(value) {
            field = value
            notifyAttribute = value
            configureNotify()
        }

    fun setLabel(text: String?) {
        labelContainer.text = text
        labelContainer.setAppearance(labelTextAppearanceResourceAttribute)
    }

    fun getLabel(): CharSequence? {
        return labelContainer.text
    }

    fun getType(): Int? = typeAttribute

    fun setIcon(icon: String?) {
        icon?.apply {
            val drawableId = getIconResourceIdFromName(context, icon)

            iconContainer.setImageResource(drawableId)
            iconContainer.setColorFilter(ContextCompat.getColor(context, iconColorResourceAttribute), android.graphics.PorterDuff.Mode.SRC_IN)
        }
    }

    fun getIcon(): ImageView {
        return iconContainer
    }

    private fun getAttributesFromTheme() {
        try {
            if (typeAttribute == CONTAINED) {
                setContainedTypeAttributes()
            } else {
                setOutlinedTypeAttributes()
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun setContainedTypeAttributes() {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.Shortcut,
                R.attr.shortcutContained,
                0
            )
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Shortcut_colorBackground)
                iconColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Shortcut_shct_icon_color)
                labelTextAppearanceResourceAttribute = this.getResourceIdOrThrow(R.styleable.Shortcut_shct_label_appearance)
            }
    }

    private fun setOutlinedTypeAttributes() {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.Shortcut, R.attr.shortcutOutlined, 0)
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Shortcut_colorBackground)
                iconColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Shortcut_shct_icon_color)
                labelTextAppearanceResourceAttribute = this.getResourceIdOrThrow(R.styleable.Shortcut_shct_label_appearance)
            }
    }

    private fun getShortcutAttributes() {
        getNotify()
        getLabelAttribute()
        getIconAttribute()
        getTypeAttribute()
    }

    private fun getNotify() {
        notifyAttribute = shortcutAttributesArray.getInteger(R.styleable.Shortcut_shct_notify, 0)
    }

    private fun getTypeAttribute() {
        try {
            typeAttribute = shortcutAttributesArray.getIntOrThrow(R.styleable.Shortcut_shct_type)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the shortcut type(contained or outlined).", e))
        }
    }

    private fun getIconAttribute() {
        try {
            iconAttribute = shortcutAttributesArray.getStringOrThrow(R.styleable.Shortcut_shct_icon_name)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the shortcut icon(drawable).", e))
        }
    }

    private fun getLabelAttribute() {
        try {
            labelAttribute = shortcutAttributesArray.getStringOrThrow(R.styleable.Shortcut_shct_text_label)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the shortcut label(string).", e))
        }
    }

    private fun configureShortCutByType(type: Int?) {
        type?.apply {
            setLabel(labelAttribute)
            setIcon(iconAttribute)
            configureNotify()

            when (this) {
                CONTAINED -> setContainedAppearance(setBackground())
                OUTLINED -> setOutlinedAppearance(setBackground())
            }
        }
    }

    private fun configureNotify() {
        notifyContainer.number = notifyAttribute
    }

    private fun setBackground(): GradientDrawable {
        val background = ResourcesCompat.getDrawable(context.resources,R.drawable.shortcut_background, null) as GradientDrawable
        background.cornerRadius = getDimenFromTheme(context, R.attr.shortcutBorderRadius)

        return background
    }

    private fun setContainedAppearance(background: GradientDrawable) {
        val backgroundWrap = DrawableCompat.wrap(background).mutate()
        DrawableCompat.setTint(backgroundWrap, ContextCompat.getColor(context, backgroundColorResourceAttribute))

        backgroundContainer.background = background
    }

    private fun setOutlinedAppearance(background: GradientDrawable) {
        background.setColor(ContextCompat.getColor(context, backgroundColorResourceAttribute))
        background.setStroke(1, ContextCompat.getColor(context, iconColorResourceAttribute))

        backgroundContainer.background = background
        backgroundContainer.elevation = 0F
    }

    companion object {
        const val OUTLINED = 0
        const val CONTAINED = 1
    }
}
