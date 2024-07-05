package com.natura.android.iconButton

import android.content.Context
import android.content.res.TypedArray
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import com.natura.android.R
import com.natura.android.badge.BadgeColor
import com.natura.android.badge.GaYaBadgeDrawable
import com.natura.android.databinding.GayaiconbuttonBinding
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getIconResourceIdFromName

class GaYaIconButton @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var iconButtonAttributesArray: TypedArray

    //private var iconColorResourceAttribute = 0
    //private var iconSizeResourceAttribute = 0
    //private var backgroundSizeResourceAttribute = 0
    //private var elevationResourceAttribute = 0
    //private var rippleDrawableResourceAttribute = 0
    //private var backgroundDrawableResourceAttribute = 0

    private var iconNameAttribute: String? = null
    private var colorAttribute: Int? = null
    private var sizeAttribute: Int = 0
    private var typeAttribute: Int = 0
    private var enabledAttribute: Boolean = true
    private var notifyAttribute: Int = 0
    private var notifyColorAttribute: Int = 0
    private var notifyPositionAttribute: Int = 0

    private var binding: GayaiconbuttonBinding

    init {
        try {
            binding = GayaiconbuttonBinding.inflate(LayoutInflater.from(context), this, true)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        iconButtonAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.GaYaIconButton)

        getAttributes()
        configureEnabled()

        applyStyle()
        configureSize()
        configureNotification()

        iconButtonAttributesArray.recycle()
    }

    private fun getAttributes() {
        try {
            iconNameAttribute =
                iconButtonAttributesArray.getStringOrThrow(R.styleable.GaYaIconButton_gibt_iconName)
        } catch (e: Exception) {
            throw (
                IllegalArgumentException(
                    "⚠️ ⚠️ Missing iconName required argument. You MUST set the icon name.",
                    e
                ))
        }
        enabledAttribute = iconButtonAttributesArray.getBoolean(R.styleable.GaYaIconButton_android_enabled, true)
        typeAttribute = iconButtonAttributesArray.getInt(R.styleable.GaYaIconButton_gibt_type, GaYaIconButtonType.Filled.value)
        colorAttribute = iconButtonAttributesArray.getInt(R.styleable.GaYaIconButton_gibt_color, GaYaIconButtonColor.Primary.value)
        sizeAttribute = iconButtonAttributesArray.getInt(R.styleable.GaYaIconButton_gibt_size, GaYaIconButtonSize.Small.value)
        notifyAttribute = iconButtonAttributesArray.getInteger(R.styleable.GaYaIconButton_gibt_notify, 0)
        notifyPositionAttribute = iconButtonAttributesArray.getInteger(R.styleable.GaYaIconButton_gibt_notifyPosition,
            GaYaIconButtonNotifyPosition.EndTop.value)
        notifyColorAttribute = iconButtonAttributesArray.getInteger(R.styleable.GaYaIconButton_gibt_notifyColor,
            GaYaIconButtonNotifyColor.Alert.value)
    }

    private fun configureEnabled() {
        isEnabled = enabledAttribute
    }

//    private fun getAppearanceAttributesFromTheme() {
//        try {
//            when (colorAttribute) {
//                GaYaIconButtonColor.Primary.value -> setAppearanceAttributes(R.attr.iconButtonPrimary)
//                GaYaIconButtonColor.Secondary.value -> setAppearanceAttributes(R.attr.iconButtonDefault)
//                GaYaIconButtonColor.Neutral.value -> setAppearanceAttributes(R.attr.iconButtonLight)
//                GaYaIconButtonColor.OnPrimary.value -> setAppearanceAttributes(R.attr.iconButtonOnPrimary)
//                GaYaIconButtonColor.OnSecondary.value -> setAppearanceAttributes(R.attr.iconButtonOnSecondary)
//                GaYaIconButtonColor.Inverse.value -> setAppearanceAttributes(R.attr.iconButtonInverse)
//            }
//        } catch (e: Exception) {
//            throw (MissingThemeException())
//        }
//    }

//    private fun getSizeAttributeFromTheme() {
//        try {
//            when (sizeAttribute) {
//                GaYaIconButtonSize.Small.value -> setSizeAttribute(R.attr.iconButtonSizeSemi)
//                GaYaIconButtonSize.Medium.value -> setSizeAttribute(R.attr.iconButtonSizeSemiX)
//                GaYaIconButtonSize.Large.value -> setSizeAttribute(R.attr.iconButtonSizeMedium)
//            }
//        } catch (e: Exception) {
//            throw (MissingThemeException())
//        }
//    }

    private fun applyStyle() {

        //this.cornerRadius = getDimenFromTheme(context, R.attr.buttonBorderRadius).toInt()

        if (enabledAttribute)
        {
            val backgroundColor = when (colorAttribute) {
                GaYaIconButtonColor.Primary.value -> R.color.gayabutton_filled_background_primary_v23
                GaYaIconButtonColor.OnPrimary.value -> R.color.gayabutton_filled_background_on_primary_v23
                GaYaIconButtonColor.Secondary.value -> R.color.gayabutton_filled_background_secondary_v23
                GaYaIconButtonColor.OnSecondary.value -> R.color.gayabutton_filled_background_on_secondary_v23
                GaYaIconButtonColor.Inverse.value -> R.color.gayabutton_filled_background_inverse_v23
                GaYaIconButtonColor.Neutral.value -> R.color.gayabutton_filled_background_neutral_v23
                else -> R.color.gayabutton_filled_background_default_v23
            }

            val iconColor = when (colorAttribute) {
                GaYaIconButtonColor.Primary.value -> R.color.gayabutton_filled_label_primary_v23
                GaYaIconButtonColor.OnPrimary.value -> R.color.gayabutton_filled_label_on_primary_v23
                GaYaIconButtonColor.Secondary.value -> R.color.gayabutton_filled_label_secondary_v23
                GaYaIconButtonColor.OnSecondary.value -> R.color.gayabutton_filled_label_on_secondary_v23
                GaYaIconButtonColor.Inverse.value -> R.color.gayabutton_filled_label_inverse_v23
                GaYaIconButtonColor.Neutral.value -> R.color.gayabutton_filled_label_neutral_v23
                else -> R.color.gayabutton_filled_label_default_v23
            }

            when (typeAttribute) {
                GaYaIconButtonType.Filled.value -> configureFilledIconButton(backgroundColor, iconColor)
                GaYaIconButtonType.Outlined.value -> configureOutlinedIconButton(backgroundColor, iconColor)
                GaYaIconButtonType.Ghost.value -> configureGhostIconButton(backgroundColor, iconColor)
                GaYaIconButtonType.Tonal.value -> configureTonalIconButton(backgroundColor, iconColor)
            }
        }
        else {
            binding.iconButtonIcon.isEnabled = false
            binding.iconButtonContainer.isEnabled = false
            binding.iconButtonIcon.setColorFilter(getColorTokenFromTheme(context, R.attr.colorMediumEmphasis), PorterDuff.Mode.SRC_IN)
            binding.iconButtonContainer.background.setTintList(ContextCompat.getColorStateList(context, R.color.gayabutton_filled_background_primary_v23))
        }
    }

    private fun configureFilledIconButton(drawableColor:Int, iconColor:Int) {
        binding.iconButtonContainer.background.setTintList(ContextCompat.getColorStateList(context, drawableColor))
        binding.iconButtonIcon.setColorFilter(ContextCompat.getColor(context, iconColor), PorterDuff.Mode.SRC_IN)
    }

    private fun configureOutlinedIconButton(drawableColor:Int, iconColor:Int) {
        binding.iconButtonContainer.backgroundTintList = ContextCompat.getColorStateList(context, R.color.gayabutton_outlined_background_default_v23)
        binding.iconButtonContainer.background.setTintList(ContextCompat.getColorStateList(context, drawableColor))
        binding.iconButtonIcon.setColorFilter(ContextCompat.getColor(context, iconColor), PorterDuff.Mode.SRC_IN)
        //this.strokeColor = ContextCompat.getColorStateList(context, R.color.gayabutton_outlined_stroke_primary_v23)
    }

    private fun configureGhostIconButton(drawableColor:Int, iconColor:Int) {
        binding.iconButtonContainer.backgroundTintList = ContextCompat.getColorStateList(context, R.color.gayabutton_ghost_background_v23)
        //this.strokeColor = ContextCompat.getColorStateList(context, R.color.gayabutton_ghost_stroke_v23)
        binding.iconButtonIcon.setColorFilter(ContextCompat.getColor(context,
            iconColor), PorterDuff.Mode.SRC_IN)
    }

    private fun configureTonalIconButton(drawableColor:Int, iconColor:Int) {
        this.elevation = 0f * resources.displayMetrics.density
        this.stateListAnimator = null

        this.backgroundTintList = ContextCompat.getColorStateList(context, drawableColor)
        binding.iconButtonIcon.setColorFilter(ContextCompat.getColor(context,
            iconColor), PorterDuff.Mode.SRC_IN)
    }

    private fun configureNotification() {
        if (notifyAttribute > 0) {
            binding.iconButtonBadgeContainer.visibility = View.VISIBLE
            val badgeDrawable = GaYaBadgeDrawable(
                context, notifyAttribute, binding.iconButtonBadgeContainer.drawable, 0,
                BadgeColor.colorAlert, 0, false
            )

            val layoutParams = binding.iconButtonBadgeContainer.layoutParams as LayoutParams

            when (notifyPositionAttribute) {
                GaYaIconButtonNotifyPosition.EndTop.value -> {
                    layoutParams.endToEnd = LayoutParams.PARENT_ID
                    layoutParams.topToTop = LayoutParams.PARENT_ID
                }
                GaYaIconButtonNotifyPosition.EndBottom.value -> {
                    layoutParams.endToEnd = LayoutParams.PARENT_ID
                    layoutParams.bottomToBottom = LayoutParams.PARENT_ID
                }
                GaYaIconButtonNotifyPosition.StartBottom.value -> {
                    layoutParams.startToStart = LayoutParams.PARENT_ID
                    layoutParams.bottomToBottom = LayoutParams.PARENT_ID
                }
                GaYaIconButtonNotifyPosition.StartTop.value -> {
                    layoutParams.startToStart = LayoutParams.PARENT_ID
                    layoutParams.topToTop = LayoutParams.PARENT_ID
                }
            }

            binding.iconButtonBadgeContainer.layoutParams = layoutParams
        }
    }


    override fun setEnabled(enabled: Boolean) {
        binding.iconButtonIcon.isEnabled = enabled

        applyStyle()

        super.setEnabled(enabled)
    }

//    private fun setDisabledIconColor() {
//        binding.iconButtonIcon.setColorFilter(
//            getColorTokenFromTheme(context, R.attr.colorMediumEmphasis),
//            android.graphics.PorterDuff.Mode.SRC_IN
//        )
//    }
//
//    private fun setDisabledIconColorWithOverlayStyle() {
//        binding.iconButtonIcon.setColorFilter(
//            getColorTokenFromTheme(context, R.attr.colorLowEmphasis),
//            android.graphics.PorterDuff.Mode.SRC_IN
//        )
//    }

    fun setIcon(icon: String?) {
        icon?.apply {
            val iconDrawableId = getIconResourceIdFromName(context, icon)
            binding.iconButtonIcon.setImageResource(iconDrawableId)
        }
    }

    fun setButtonColor(color: IconButtonColor) {
        colorAttribute = color.value
        updateButtonPropertiesAccordingToStyle()
    }

    private fun updateButtonPropertiesAccordingToStyle() {
        val colorRes = when (colorAttribute) {
            IconButtonColor.DEFAULT.value -> R.attr.colorHighEmphasis
            IconButtonColor.PRIMARY.value -> R.attr.colorPrimary
            IconButtonColor.LIGHT.value -> R.attr.colorSurface
            IconButtonColor.ONPRIMARY.value -> R.attr.colorOnPrimary
            IconButtonColor.ONSECONDARY.value -> R.attr.colorOnSecondary
            IconButtonColor.INVERSE.value -> R.attr.colorSurfaceInverse
            else -> R.attr.colorHighEmphasis // Valor padrão
        }

        val typedValue = TypedValue()
        context.theme.resolveAttribute(colorRes, typedValue, true)
        val color = typedValue.data

        binding.iconButtonIcon.setColorFilter(
            color,
            android.graphics.PorterDuff.Mode.SRC_IN
        )
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
        return typeAttribute
    }

//    private fun getEnabledStyleAttributeFromTheme() {
//        try {
//            when (typeAttribute) {
//                GaYaIconButtonType.Filled.value -> setBackgroundAttributes(R.attr.iconButtonFloatingEnabled)
//                GaYaIconButtonType.Outlined.value -> setBackgroundAttributes(R.attr.iconButtonFloatingEnabled)
//                GaYaIconButtonType.Ghost.value -> setBackgroundAttributes(R.attr.iconButtonFloatingEnabled)
//                GaYaIconButtonType.Tonal.value -> setBackgroundAttributes(R.attr.iconButtonFloatingEnabled)
//            }
//        } catch (e: Exception) {
//            throw (MissingThemeException())
//        }
//    }

//    private fun getDisabledStyleAttributeFromTheme() {
//        try {
//            when (typeAttribute) {
//                GaYaIconButtonType.Filled.value -> setBackgroundAttributes(R.attr.iconButtonFloatingEnabled)
//                GaYaIconButtonType.Outlined.value -> setBackgroundAttributes(R.attr.iconButtonFloatingEnabled)
//                GaYaIconButtonType.Ghost.value -> setBackgroundAttributes(R.attr.iconButtonFloatingEnabled)
//                GaYaIconButtonType.Tonal.value -> setBackgroundAttributes(R.attr.iconButtonFloatingEnabled)
//            }
//        } catch (e: Exception) {
//            throw (MissingThemeException())
//        }
//    }

//    private fun setAppearanceAttributes(attribute: Int) {
//        context
//            .theme
//            .obtainStyledAttributes(
//                attrs,
//                R.styleable.GaYaIconButton,
//                attribute,
//                0
//            )
//            .apply {
//                iconColorResourceAttribute =
//                    this.getResourceIdOrThrow(R.styleable.GaYaIconButton_gibt_color)
//                rippleDrawableResourceAttribute =
//                    this.getResourceIdOrThrow(R.styleable.GaYaIconButton_rippleDrawable)
//            }
//    }

//    private fun setSizeAttribute(attribute: Int) {
//        context
//            .theme
//            .obtainStyledAttributes(
//                attrs,
//                R.styleable.GaYaIconButton,
//                attribute,
//                0
//            )
//            .apply {
//                iconSizeResourceAttribute =
//                    this.getResourceIdOrThrow(R.styleable.GaYaIconButton_gibt_size)
//                backgroundSizeResourceAttribute =
//                    this.getResourceIdOrThrow(R.styleable.GaYaIconButton_gibt_size)
//            }
//    }

//    private fun setBackgroundAttributes(attribute: Int) {
//        context
//            .theme
//            .obtainStyledAttributes(
//                attrs,
//                R.styleable.GaYaIconButton,
//                attribute,
//                0
//            )
//            .apply {
//                backgroundDrawableResourceAttribute =
//                    this.getResourceIdOrThrow(R.styleable.GaYaIconButton_gibt_backgroundDrawable)
//                elevationResourceAttribute =
//                    this.getResourceIdOrThrow(R.styleable.GaYaIconButton_customElevation)
//            }
//    }

//    private fun configureAppearance() {
//        setIcon(iconNameAttribute)
//        binding.iconButtonIcon.setColorFilter(
//            ContextCompat.getColor(context, iconColorResourceAttribute),
//            android.graphics.PorterDuff.Mode.SRC_IN
//        )
//        binding.iconButtonRippleBackground.background =
//            ResourcesCompat.getDrawable(context.resources, rippleDrawableResourceAttribute, context.theme)
//    }

    private fun configureSize() {

        when (sizeAttribute) {
                GaYaIconButtonSize.Small.value -> R.attr.iconButtonSizeSemi
                GaYaIconButtonSize.Medium.value -> R.attr.iconButtonSizeSemiX
                GaYaIconButtonSize.Large.value -> R.attr.iconButtonSizeMedium
            }

        val containerlayoutParams = binding.iconButtonContainer.layoutParams
        containerlayoutParams.height = resources.getDimension(sizeAttribute).toInt()
        containerlayoutParams.width = resources.getDimension(sizeAttribute).toInt()

        binding.iconButtonContainer.layoutParams = containerlayoutParams

        val iconLayoutParams = binding.iconButtonIcon.layoutParams
        iconLayoutParams.height = resources.getDimension(sizeAttribute).toInt()
        iconLayoutParams.width = resources.getDimension(sizeAttribute).toInt()

        binding.iconButtonIcon.layoutParams = iconLayoutParams
    }

//    private fun configureStyle() {
//
//        when (typeAttribute) {
//            GaYaIconButtonType.Filled.value -> configureFilledIconButton()
//            GaYaIconButtonType.Outlined.value -> configureOutlinedIconButton()
//            GaYaIconButtonType.Ghost.value -> configureGhostIconButton()
//            GaYaIconButtonType.Tonal.value -> configureTonalIconButton()
//        }
//
////        if (typeAttribute != Style.INHERIT.value) {
////            binding.iconButtonContainer.background =
////                ResourcesCompat.getDrawable(context.resources, backgroundDrawableResourceAttribute, context.theme)
////            binding.iconButtonContainer.elevation = resources.getDimension(elevationResourceAttribute)
////        }
//    }

}

enum class GaYaIconButtonColor(val value: Int) {
    Primary(0),
    OnPrimary(1),
    Secondary(2),
    OnSecondary(3),
    Neutral(4),
    Inverse(5)
}

enum class GaYaIconButtonSize(val value: Int) {
    Small(0),
    Medium(1),
    Large(2)
}

enum class GaYaIconButtonType(val value: Int) {
    Filled(0),
    Outlined(1),
    Ghost(2),
    Tonal(3)
}

enum class GaYaIconButtonNotifyPosition(val value: Int) {
    EndTop(0),
    EndBottom(1),
    StartBottom(2),
    StartTop(3)
}

enum class GaYaIconButtonNotifyColor(val value: Int) {
    Alert(0),
    Primary(1),
    Secondary(2),
    Success(3)
}