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
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
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

    private var labelAttribute: String? = ""
    private var typeAttribute: Int = CONTAINED
    private var enabledAttribute: Boolean = true
    private var colorAttribute: Int = PRIMARY
    private var notifyAttribute: Int = 0
    private var backgroundColorResourceAttribute = 0
    private var borderColorResourceAttribute = 0
    private var iconColorResourceAttribute = 0
    private var labelTextAppearanceResourceAttribute = 0
    private var iconAttribute: String? = null
    private var shortcutAttributesArray: TypedArray

    val labelContainer: TextView by lazy { findViewById(R.id.shortCutLabel) }
    private val backgroundContainer by lazy { findViewById<LinearLayout>(R.id.shortcutBackground) }
    private val iconContainer by lazy { findViewById<ImageView>(R.id.shortCutIcon) }
    private val notifyContainer by lazy { findViewById<Badge>(R.id.notifyContainer) }
    private val mainContainer by lazy { findViewById<ConstraintLayout>(R.id.shortcutMainContainer) }

    init {
        try {
            View.inflate(context, R.layout.shortcut, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        shortcutAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.Shortcut)

        getShortcutAttributes()
        getAttributesFromTheme(getStyleAttributeForEnabled())
        setAppearance(setBackground())

        configureEnabled()

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

    override fun setEnabled(enabled: Boolean) {
        mainContainer.isEnabled = enabled

        getAttributesFromTheme(
            if (!enabled) {
                getStyleAttributeForDisabled()
            } else {
                getStyleAttributeForEnabled()
            }
        )
        setAppearance(setBackground())

        super.setEnabled(enabled)
    }

    fun setLabel(text: String?) {
        labelContainer.text = text
        labelContainer.setAppearance(labelTextAppearanceResourceAttribute)
    }

    fun getLabel(): CharSequence? {
        return labelContainer.text
    }

    fun getType(): Int = typeAttribute

    fun getColor(): Int = colorAttribute

    fun setIcon(icon: String?) {
        icon?.apply {
            val drawableId = getIconResourceIdFromName(context, icon)

            iconContainer.setImageResource(drawableId)
            iconContainer.setColorFilter(
                ContextCompat.getColor(
                    context,
                    iconColorResourceAttribute
                ),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
        }
    }

    fun getIcon(): ImageView {
        return iconContainer
    }

    private fun configureEnabled() {
        isEnabled = enabledAttribute
    }

    private fun getStyleAttributeForEnabled(): Int {
        return when {
            typeAttribute == CONTAINED && colorAttribute == PRIMARY -> R.attr.shortcutContainedPrimary
            typeAttribute == CONTAINED && colorAttribute == NEUTRAL -> R.attr.shortcutContainedNeutral
            typeAttribute == OUTLINED && colorAttribute == PRIMARY -> R.attr.shortcutOutlinedPrimary
            typeAttribute == OUTLINED && colorAttribute == NEUTRAL -> R.attr.shortcutOutlinedNeutral
            else -> R.attr.shortcutContainedPrimary
        }
    }

    private fun getStyleAttributeForDisabled(): Int {
        return when (typeAttribute) {
            CONTAINED -> R.attr.shortcutContainedDisabled
            OUTLINED -> R.attr.shortcutOutlinedDisabled
            else -> R.attr.shortcutContainedDisabled
        }
    }

    private fun getAttributesFromTheme(styleAttr: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.ShortcutStyle,
                styleAttr,
                0
            )
            .apply {
                backgroundColorResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ShortcutStyle_colorBackground)
                iconColorResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ShortcutStyle_shct_icon_color)
                borderColorResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ShortcutStyle_shct_border_color)
                labelTextAppearanceResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ShortcutStyle_shct_label_appearance)
            }
    }

    private fun getShortcutAttributes() {
        getIconAttribute()
        shortcutAttributesArray.apply {
            try {
                enabledAttribute = getBoolean(R.styleable.Shortcut_android_enabled, true)
                notifyAttribute = getInteger(R.styleable.Shortcut_shct_notify, 0)
                typeAttribute = getInt(R.styleable.Shortcut_shct_type, CONTAINED)
                colorAttribute = getInt(R.styleable.Shortcut_shct_color, PRIMARY)
                labelAttribute = getString(R.styleable.Shortcut_shct_text_label) ?: ""
            } finally {
                recycle()
            }
        }
    }

    private fun getIconAttribute() {
        try {
            iconAttribute =
                shortcutAttributesArray.getStringOrThrow(R.styleable.Shortcut_shct_icon_name)
        } catch (e: Exception) {
            throw (
                IllegalArgumentException(
                    "⚠️ ⚠️ Missing shortcut required argument. You MUST set the shortcut icon(drawable).",
                    e
                )
                )
        }
    }

    private fun configureNotify() {
        notifyContainer.number = notifyAttribute
    }

    private fun setBackground(): GradientDrawable {
        val background = ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.shortcut_background,
            null
        ) as GradientDrawable
        background.cornerRadius = getDimenFromTheme(context, R.attr.shortcutBorderRadius)

        return background
    }

    private fun setAppearance(background: GradientDrawable) {
        background.mutate()
        if (typeAttribute == OUTLINED) {
            background.setStroke(
                BORDER_WIDTH,
                ContextCompat.getColor(context, borderColorResourceAttribute)
            )
        }

        backgroundContainer.elevation = when (typeAttribute) {
            CONTAINED -> getDimenFromTheme(context, R.attr.elevationTiny)
            else -> 0F
        }

        background.setColor(ContextCompat.getColor(context, backgroundColorResourceAttribute))
        backgroundContainer.background = background

        setLabel(labelAttribute)
        setIcon(iconAttribute)
        configureNotify()

        requestLayout()
    }

    companion object {
        const val OUTLINED = 0
        const val CONTAINED = 1

        const val PRIMARY = 0
        const val NEUTRAL = 1

        private const val BORDER_WIDTH = 1
    }
}
