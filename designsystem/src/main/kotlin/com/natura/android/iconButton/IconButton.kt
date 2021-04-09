package com.natura.android.iconButton

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.getIntOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import com.natura.android.R
import com.natura.android.badge.BadgeDrawable
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getIconResourceIdFromName
import kotlinx.android.synthetic.main.icon_button.view.*

class IconButton @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var iconButtonAttributesArray: TypedArray

    private var iconColorResourceAttribute = 0
    private var iconSizeResourceAttribute = 0
    private var backgroundSizeResourceAttribute = 0
    private var widthResourceAttribute = 0
    private var rippleDrawableResourceAttribute = 0

    private var iconNameAttribute: String? = null
    private var colorAttribute: Int? = null
    private var notifyAttribute: Int = 0
    private var sizeAttribute: Int = 0
    private var enabledAttribute: Boolean = false

    private val iconButton by lazy { findViewById<ImageView>(R.id.iconButtonIcon) }
    private val iconButtonContainer by lazy { findViewById<ConstraintLayout>(R.id.iconButtonContainer) }
    private val badgeContainer by lazy { findViewById<ImageView>(R.id.iconButtonBadgeContainer) }

    init {
        try {
            View.inflate(context, R.layout.icon_button, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        iconButtonAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.IconButton)

        getAttributes()
        getAppereanceAttributesFromTheme()
        getSizeAttributeFromTheme()

        configureAppearance()
        configureNotification()
        configureEnabled()
        configureSize()

        iconButtonAttributesArray.recycle()
    }

    private fun configureEnabled() {
        isEnabled = enabledAttribute
    }

    private fun configureNotification() {
        if (notifyAttribute > 0) {
            badgeContainer.visibility = View.VISIBLE
            BadgeDrawable(context, notifyAttribute, badgeContainer.drawable)
        }
    }

    override fun setEnabled(enabled: Boolean) {
        iconButton.isEnabled = enabled
        if (!enabled) {
            setDisabledColor()
        }
        super.setEnabled(enabled)
    }

    private fun setDisabledColor() {
        iconButton.setColorFilter(getColorTokenFromTheme(context, R.attr.colorMediumEmphasis), android.graphics.PorterDuff.Mode.SRC_IN)
    }

    fun setIcon(icon: String?) {
        icon?.apply {
            val iconDrawableId = getIconResourceIdFromName(context, icon)
            iconButton.setImageResource(iconDrawableId)
        }
    }

    fun getIcon(): ImageView {
        return iconButton
    }

    fun getBadge(): ImageView {
        return badgeContainer
    }

    fun getColor(): Int? {
        return colorAttribute
    }

    fun getSize(): Int? {
        return sizeAttribute
    }

    private fun getAttributes() {
        getIconName()
        getColorAttribute()
        getEnabledAttribute()
        getNotify()
        getSizeAttribute()
    }

    private fun getNotify() {
        notifyAttribute = iconButtonAttributesArray.getInteger(R.styleable.IconButton_notify, 0)
    }

    private fun getIconName() {
        try {
            iconNameAttribute = iconButtonAttributesArray.getStringOrThrow(R.styleable.IconButton_iconName)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing iconName required argument. You MUST set the icon name.", e))
        }
    }

    private fun getColorAttribute() {
        try {
            colorAttribute = iconButtonAttributesArray.getIntOrThrow(R.styleable.IconButton_buttonColor)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing iconButton required argument. You MUST set the iconButton color.", e))
        }
    }

    private fun getEnabledAttribute() {
        enabledAttribute = iconButtonAttributesArray.getBoolean(R.styleable.IconButton_android_enabled, true)
    }

    private fun getSizeAttribute() {
        sizeAttribute = iconButtonAttributesArray.getInt(R.styleable.IconButton_sizeButton, Size.SEMI.ordinal)
    }

    private fun getAppereanceAttributesFromTheme() {
        try {
            when (colorAttribute) {
                PRIMARY -> {
                    setColorAttribute(R.attr.iconButtonPrimary)
                    setDrawableRippleAttribute(R.attr.iconButtonPrimary)
                }
                DEFAULT -> {
                    setColorAttribute(R.attr.iconButtonDefault)
                    setDrawableRippleAttribute(R.attr.iconButtonDefault)
                }
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun getSizeAttributeFromTheme() {
        try {
            when (sizeAttribute) {
                Size.SEMI.ordinal -> {
                    setSizeAttribute(R.attr.iconButtonSizeSemi)
                }
                Size.SEMIX.ordinal -> {
                    setSizeAttribute(R.attr.iconButtonSizeSemiX)
                }
                Size.MEDIUM.ordinal -> {
                    setSizeAttribute(R.attr.iconButtonSizeMedium)
                }
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun setDrawableRippleAttribute(iconButtonStyleFromTheme: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.IconButton,
                iconButtonStyleFromTheme,
                0
            )
            .apply {
                rippleDrawableResourceAttribute = this.getResourceIdOrThrow(R.styleable.IconButton_rippleDrawable)
            }
    }

    private fun setColorAttribute(attribute: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.IconButton,
                attribute,
                0
            )
            .apply {
                iconColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.IconButton_iconColor)
            }
    }

    private fun setSizeAttribute(attribute: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.IconButton,
                attribute,
                0
            )
            .apply {
                iconSizeResourceAttribute = this.getResourceIdOrThrow(R.styleable.IconButton_iconSize)
                backgroundSizeResourceAttribute = this.getResourceIdOrThrow(R.styleable.IconButton_backgroundSize)
            }
    }

    private fun configureAppearance() {
        setIcon(iconNameAttribute)
        iconButton.setColorFilter(ContextCompat.getColor(context, iconColorResourceAttribute), android.graphics.PorterDuff.Mode.SRC_IN)
        iconButtonContainer.background = resources.getDrawable(rippleDrawableResourceAttribute, context.theme)
    }

    private fun configureSize() {
        layoutParams = iconButtonContainer.layoutParams
        layoutParams.height = resources.getDimension(backgroundSizeResourceAttribute).toInt()
        layoutParams.width = resources.getDimension(backgroundSizeResourceAttribute).toInt()

        iconButtonContainer.layoutParams = layoutParams

        layoutParams = iconButton.layoutParams
        layoutParams.height = resources.getDimension(iconSizeResourceAttribute).toInt()
        layoutParams.width = resources.getDimension(iconSizeResourceAttribute).toInt()

        iconButton.layoutParams = layoutParams
    }

    companion object {
        const val DEFAULT = 0
        const val PRIMARY = 1
    }
}

enum class Size {
    SEMI, SEMIX, MEDIUM
}
