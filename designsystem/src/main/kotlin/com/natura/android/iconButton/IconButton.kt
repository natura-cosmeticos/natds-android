package com.natura.android.iconButton

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.getIntOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import com.natura.android.R
import com.natura.android.badge.BadgeDrawable
import com.natura.android.databinding.IconButtonBinding
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getIconResourceIdFromName

class IconButton @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var iconButtonAttributesArray: TypedArray

    private var iconColorResourceAttribute = 0
    private var iconSizeResourceAttribute = 0
    private var backgroundSizeResourceAttribute = 0
    private var elevationResourceAttribute = 0
    private var rippleDrawableResourceAttribute = 0
    private var backgroundDrawableResourceAttribute = 0

    private var iconNameAttribute: String? = null
    private var colorAttribute: Int? = null
    private var notifyAttribute: Int = 0
    private var sizeAttribute: Int = 0
    private var styleAttribute: Int = 0
    private var enabledAttribute: Boolean = true

    private var binding: IconButtonBinding

    init {
        try {
            binding = IconButtonBinding.inflate(LayoutInflater.from(context), this, true)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        iconButtonAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.IconButton)

        getAttributes()
        getAppearanceAttributesFromTheme()
        getSizeAttributeFromTheme()
        getStyleAttributeFromTheme()
        configureAppearance()
        configureNotification()
        configureEnabled()
        configureSize()
        configureStyle()

        iconButtonAttributesArray.recycle()
    }

    private fun configureEnabled() {
        isEnabled = enabledAttribute
    }

    private fun configureNotification() {
        if (notifyAttribute > 0) {
            binding.iconButtonBadgeContainer.visibility = View.VISIBLE
            BadgeDrawable(context, notifyAttribute, binding.iconButtonBadgeContainer.drawable, 0, 0, 0, false)
        }
    }

    override fun setEnabled(enabled: Boolean) {
        binding.iconButtonIcon.isEnabled = enabled
        if (!enabled) {
            if (styleAttribute == Style.OVERLAY.value) {
                setDisabledIconColorWithOverlayStyle()
            } else {
                setDisabledIconColor()
            }
        }
        getStyleAttributeFromTheme()
        configureStyle()

        super.setEnabled(enabled)
    }

    private fun setDisabledIconColor() {
        binding.iconButtonIcon.setColorFilter(
            getColorTokenFromTheme(context, R.attr.colorMediumEmphasis),
            android.graphics.PorterDuff.Mode.SRC_IN
        )
    }

    private fun setDisabledIconColorWithOverlayStyle() {
        binding.iconButtonIcon.setColorFilter(
            getColorTokenFromTheme(context, R.attr.colorLowEmphasis),
            android.graphics.PorterDuff.Mode.SRC_IN
        )
    }

    fun setIcon(icon: String?) {
        icon?.apply {
            val iconDrawableId = getIconResourceIdFromName(context, icon)
            binding.iconButtonIcon.setImageResource(iconDrawableId)
        }
    }

    fun getIcon(): ImageView {
        return binding.iconButtonIcon
    }

    fun getBadge(): ImageView {
        return binding.iconButtonBadgeContainer
    }

    fun getColor(): Int? {
        return colorAttribute
    }

    fun getSize(): Int {
        return sizeAttribute
    }

    fun getStyle(): Int {
        return styleAttribute
    }

    private fun getAttributes() {
        getIconName()
        getColorAttribute()
        getEnabledAttribute()
        getNotify()
        getSizeAttribute()
        getStyleAttribute()
    }

    private fun getNotify() {
        notifyAttribute = iconButtonAttributesArray.getInteger(R.styleable.IconButton_notify, 0)
    }

    private fun getIconName() {
        try {
            iconNameAttribute =
                iconButtonAttributesArray.getStringOrThrow(R.styleable.IconButton_iconName)
        } catch (e: Exception) {
            throw (
                IllegalArgumentException(
                    "⚠️ ⚠️ Missing iconName required argument. You MUST set the icon name.",
                    e
                )
                )
        }
    }

    private fun getColorAttribute() {
        try {
            colorAttribute =
                iconButtonAttributesArray.getIntOrThrow(R.styleable.IconButton_buttonColor)
        } catch (e: Exception) {
            throw (
                IllegalArgumentException(
                    "⚠️ ⚠️ Missing iconButton required argument. You MUST set the iconButton color.",
                    e
                )
                )
        }
    }

    private fun getEnabledAttribute() {
        enabledAttribute =
            iconButtonAttributesArray.getBoolean(R.styleable.IconButton_android_enabled, true)
    }

    private fun getSizeAttribute() {
        sizeAttribute =
            iconButtonAttributesArray.getInt(R.styleable.IconButton_sizeButton, Size.SEMI.value)
    }

    private fun getStyleAttribute() {
        styleAttribute = iconButtonAttributesArray.getInt(
            R.styleable.IconButton_styleButton,
            Style.INHERIT.value
        )
    }

    private fun getAppearanceAttributesFromTheme() {
        try {
            when (colorAttribute) {
                PRIMARY -> setAppearanceAttributes(R.attr.iconButtonPrimary)
                DEFAULT -> setAppearanceAttributes(R.attr.iconButtonDefault)
                LIGHT -> setAppearanceAttributes(R.attr.iconButtonLight)
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun getSizeAttributeFromTheme() {
        try {
            when (sizeAttribute) {
                Size.SEMI.value -> setSizeAttribute(R.attr.iconButtonSizeSemi)
                Size.SEMIX.value -> setSizeAttribute(R.attr.iconButtonSizeSemiX)
                Size.MEDIUM.value -> setSizeAttribute(R.attr.iconButtonSizeMedium)
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun getEnabledStyleAttributeFromTheme() {
        try {
            when (styleAttribute) {
                Style.FLOATING.value -> setBackgroundAttributes(R.attr.iconButtonFloatingEnabled)
                Style.OVERLAY.value -> setBackgroundAttributes(R.attr.iconButtonOverlayEnabled)
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun getDisabledStyleAttributeFromTheme() {
        try {
            when (styleAttribute) {
                Style.FLOATING.value -> setBackgroundAttributes(R.attr.iconButtonFloatingDisabled)
                Style.OVERLAY.value -> setBackgroundAttributes(R.attr.iconButtonOverlayDisabled)
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun setAppearanceAttributes(attribute: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.IconButton,
                attribute,
                0
            )
            .apply {
                iconColorResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.IconButton_iconColor)
                rippleDrawableResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.IconButton_rippleDrawable)
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
                iconSizeResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.IconButton_iconSize)
                backgroundSizeResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.IconButton_backgroundSize)
            }
    }

    private fun setBackgroundAttributes(attribute: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.IconButton,
                attribute,
                0
            )
            .apply {
                backgroundDrawableResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.IconButton_backgroundDrawable)
                elevationResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.IconButton_customElevation)
            }
    }

    private fun configureAppearance() {
        setIcon(iconNameAttribute)
        binding.iconButtonIcon.setColorFilter(
            ContextCompat.getColor(context, iconColorResourceAttribute),
            android.graphics.PorterDuff.Mode.SRC_IN
        )
        binding.iconButtonRippleBackground.background =
            ResourcesCompat.getDrawable(context.resources,rippleDrawableResourceAttribute, context.theme)
    }

    private fun configureSize() {
        val containerlayoutParams = binding.iconButtonContainer.layoutParams
        containerlayoutParams.height =
            resources.getDimension(backgroundSizeResourceAttribute).toInt()
        containerlayoutParams.width =
            resources.getDimension(backgroundSizeResourceAttribute).toInt()

        binding.iconButtonContainer.layoutParams = containerlayoutParams

        val iconLayoutParams = binding.iconButtonIcon.layoutParams
        iconLayoutParams.height = resources.getDimension(iconSizeResourceAttribute).toInt()
        iconLayoutParams.width = resources.getDimension(iconSizeResourceAttribute).toInt()

        binding.iconButtonIcon.layoutParams = iconLayoutParams
    }

    private fun configureStyle() {
        if (styleAttribute != Style.INHERIT.value) {
            binding.iconButtonContainer.background =
                ResourcesCompat.getDrawable(context.resources,backgroundDrawableResourceAttribute, context.theme)
            binding.iconButtonContainer.elevation = resources.getDimension(elevationResourceAttribute)
        }
    }

    private fun getStyleAttributeFromTheme() {
        if (enabledAttribute) {
            getEnabledStyleAttributeFromTheme()
        } else {
            getDisabledStyleAttributeFromTheme()
        }
    }

    companion object {
        const val DEFAULT = 0
        const val PRIMARY = 1
        const val LIGHT = 2
    }
}

enum class Size(val value: Int) {
    SEMI(0),
    SEMIX(1),
    MEDIUM(2)
}

enum class Style(val value: Int) {
    INHERIT(0),
    FLOATING(1),
    OVERLAY(2)
}
