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
import androidx.core.content.res.getIntOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import androidx.core.graphics.drawable.DrawableCompat
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.extensions.getIconResourceIdFromName
import com.natura.android.extensions.setAppearance

class Shortcut @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var labelAttribute: String? = null
    private var typeAttribute: Int? = null
    private var backgroundColorResourceAttribute = 0
    private var iconColorResourceAttribute = 0
    private var labelTextAppearanceResourceAttribute = 0
    private var iconAttribute: String? = null
    private var shortcutAttributesArray: TypedArray

    val labelContainer by lazy { findViewById<TextView>(R.id.shortCutLabel) }
    private val backgroundContainer by lazy { findViewById<LinearLayout>(R.id.shortcutBackground) }
    private val iconContainer by lazy { findViewById<ImageView>(R.id.shortCutIcon) }

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
                iconColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Shortcut_colorIcon)
                labelTextAppearanceResourceAttribute = this.getResourceIdOrThrow(R.styleable.Shortcut_labelAppearance)
            }
    }

    private fun setOutlinedTypeAttributes() {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.Shortcut, R.attr.shortcutOutlined, 0)
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Shortcut_colorBackground)
                iconColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Shortcut_colorIcon)
                labelTextAppearanceResourceAttribute = this.getResourceIdOrThrow(R.styleable.Shortcut_labelAppearance)
            }
    }

    private fun getShortcutAttributes() {
        getLabelAttribute()
        getIconAttribute()
        getTypeAttribute()
    }

    private fun getTypeAttribute() {
        try {
            typeAttribute = shortcutAttributesArray.getIntOrThrow(R.styleable.Shortcut_type)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the shortcut type(contained or outlined).", e))
        }
    }

    private fun getIconAttribute() {
        try {
            iconAttribute = shortcutAttributesArray.getStringOrThrow(R.styleable.Shortcut_iconName)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the shortcut icon(drawable).", e))
        }
    }

    private fun getLabelAttribute() {
        try {
            labelAttribute = shortcutAttributesArray.getStringOrThrow(R.styleable.Shortcut_textLabel)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing shortcut required argument. You MUST set the shortcut label(string).", e))
        }
    }

    private fun configureShortCutByType(type: Int?) {
        type?.apply {
            setLabel(labelAttribute)
            setIcon(iconAttribute)

            when (this) {
                CONTAINED -> setBackgroundContained()
                OUTLINED -> setBackgroundOutlined()
            }
        }
    }

    private fun setBackgroundContained() {
        val background = resources.getDrawable(R.drawable.shortcut_background, null)
        val backgroundWrap = DrawableCompat.wrap(background).mutate()
        DrawableCompat.setTint(backgroundWrap, ContextCompat.getColor(context, backgroundColorResourceAttribute))

        backgroundContainer.background = background
    }

    private fun setBackgroundOutlined() {
        val background = resources.getDrawable(R.drawable.shortcut_background, null) as GradientDrawable
        background.setColor(ContextCompat.getColor(context, backgroundColorResourceAttribute))
        background.setStroke(1, ContextCompat.getColor(context, iconColorResourceAttribute))

        backgroundContainer.background = background
        backgroundContainer.elevation = 0F
    }

    companion object {
        const val ICON_NOT_FOUND = 0
        const val OUTLINED = 0
        const val CONTAINED = 1
    }
}
