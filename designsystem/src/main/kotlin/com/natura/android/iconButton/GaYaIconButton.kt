package com.natura.android.iconButton

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.getStringOrThrow
import com.natura.android.R
import com.natura.android.databinding.GayaiconbuttonBinding
import com.natura.android.badge.GaYaBadgeDrawable
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getDimenFromTheme
import com.natura.android.resources.getIconResourceIdFromName

class GaYaIconButton @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var iconButtonAttributesArray: TypedArray

    var iconName: String? = null
        set(value) {
            field = value
            setIcon(value)
        }

    var color: Int? = null
        set(value) {
            field = value
            configureAppearance(getDrawable())
        }

    var size: Int = 0
        set(value) {
            field = value
            configureSize()
        }

    var type: Int = 0
        set(value) {
            field = value
            configureAppearance(getDrawable())
        }

    var isEnabledButton: Boolean = true
        set(value) {
            field = value
            configureEnabled()
        }

    var notify: Int = 0
        set(value) {
            field = value
            configureNotification()
        }

    var notifyColor: Int = 0
    var notifyPosition: Int = 0

    private var binding: GayaiconbuttonBinding

    init {
        try {
            binding = GayaiconbuttonBinding.inflate(LayoutInflater.from(context), this, true)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        iconButtonAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.GaYaIconButton)
        getAttributes()
        iconButtonAttributesArray.recycle()

        binding.iconButtonRippleBackground.setOnClickListener {
            if (isEnabled) {
                performClick()
            }
        }
    }

    private fun getAttributes() {
        iconButtonAttributesArray.apply {
            size = getInt(R.styleable.GaYaIconButton_gibt_size, GaYaIconButtonSize.Medium.value)
            color = getInt(R.styleable.GaYaIconButton_gibt_color, GaYaIconButtonColor.Primary.value)
            type = getInt(R.styleable.GaYaIconButton_gibt_type, GaYaIconButtonType.Filled.value)
            isEnabledButton = getBoolean(R.styleable.GaYaIconButton_android_enabled, true)
            notify = getInt(R.styleable.GaYaIconButton_gibt_notify, 0)
            notifyPosition = getInt(R.styleable.GaYaIconButton_gibt_notifyPosition, GaYaIconButtonNotifyPosition.EndTop.value)
            notifyColor = getResourceId(R.styleable.GaYaIconButton_gibt_notifyColor, GaYaIconButtonNotifyColor.Alert.value)
        }

        configureEnabled()
        configureSize()
        configureAppearance(getDrawable())
        configureNotification()
    }

    private fun configureEnabled() {
        isEnabled = isEnabledButton
    }

    private fun configureSize() {
        try {
            val sizeContainer = when (size) {
                GaYaIconButtonSize.Small.value -> R.attr.sizeSemi
                GaYaIconButtonSize.Medium.value -> R.attr.sizeSemiX
                GaYaIconButtonSize.Large.value -> R.attr.sizeMedium
                else -> R.attr.sizeSemiX
            }

            val sizeIcon = when (size) {
                GaYaIconButtonSize.Small.value -> R.attr.sizeStandard
                GaYaIconButtonSize.Medium.value -> R.attr.sizeSemi
                GaYaIconButtonSize.Large.value -> R.attr.sizeSemiX
                else -> R.attr.sizeSemi
            }

            val containerlayoutParams = binding.iconButtonContainer.layoutParams
            containerlayoutParams.height = getDimenFromTheme(context, sizeContainer).toInt()
            containerlayoutParams.width = getDimenFromTheme(context, sizeContainer).toInt()
            binding.iconButtonContainer.layoutParams = containerlayoutParams

            val iconLayoutParams = binding.iconButtonIcon.layoutParams
            iconLayoutParams.height = getDimenFromTheme(context, sizeIcon).toInt()
            iconLayoutParams.width = getDimenFromTheme(context, sizeIcon).toInt()
            binding.iconButtonIcon.layoutParams = iconLayoutParams
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun configureNotification() {
        if (notify > 0) {
            binding.iconButtonBadgeContainer.visibility = View.VISIBLE
            GaYaBadgeDrawable(context, notify, binding.iconButtonBadgeContainer.drawable, 0, notifyColor, 0, false)

            val layoutParams = binding.iconButtonBadgeContainer.layoutParams as LayoutParams

            when (notifyPosition) {
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

    private fun getDrawable(): GradientDrawable {
        val backgroundDrawable = ResourcesCompat.getDrawable(context.resources, R.drawable.gayaiconbutton_background, null)

        if (backgroundDrawable is LayerDrawable) {
            val layer = backgroundDrawable.findDrawableByLayerId(R.id.background_shape)
            if (layer is GradientDrawable) {
                return layer.mutate() as GradientDrawable
            } else {
                throw IllegalStateException("Layer with ID R.id.background_shape is not a GradientDrawable")
            }
        } else if (backgroundDrawable is GradientDrawable) {
            return backgroundDrawable.mutate() as GradientDrawable
        }

        throw IllegalStateException("Drawable with ID R.drawable.gayaiconbutton_background is not a LayerDrawable or GradientDrawable")
    }

    private fun configureAppearance(backgroundDrawable: GradientDrawable) {
        setIcon(iconName)

        if (!isEnabled) {
            backgroundDrawable.cornerRadius = getDimenFromTheme(context, R.attr.iconButtonBorderRadius)
            backgroundDrawable.setColor(getColorTokenFromTheme(context, R.attr.colorSurfaceDisabled))
            backgroundDrawable.setStroke(0, ResourcesCompat.getColor(resources, android.R.color.transparent, null))
            binding.iconButtonContainer.background = backgroundDrawable
            binding.iconButtonIcon.setColorFilter(
                getColorTokenFromTheme(context, R.attr.colorOnSurfaceDisabled), android.graphics.PorterDuff.Mode.SRC_IN)
            binding.iconButtonRippleBackground.isClickable = false
            binding.iconButtonRippleBackground.background = null
        } else {
            binding.iconButtonRippleBackground.background =
                ResourcesCompat.getDrawable(context.resources, R.drawable.iconbutton_ripple_background_default, context.theme)

            when (type) {
                GaYaIconButtonType.Filled.value -> configureFilledIconButton(backgroundDrawable)
                GaYaIconButtonType.Outlined.value -> configureOutlinedIconButton(backgroundDrawable)
                GaYaIconButtonType.Ghost.value -> configureGhostIconButton(backgroundDrawable)
                GaYaIconButtonType.Tonal.value -> configureTonalIconButton(backgroundDrawable)
            }
        }
    }

    private fun configureFilledIconButton(backgroundDrawable: GradientDrawable) {
        backgroundDrawable.cornerRadius = getDimenFromTheme(context, R.attr.iconButtonBorderRadius)
        backgroundDrawable.setStroke(0, ResourcesCompat.getColor(resources, android.R.color.transparent, null))

        when (color) {
            GaYaIconButtonColor.Primary.value -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_filled_background_primary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimary), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.OnPrimary.value -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_filled_background_on_primary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorNeutral900), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.Secondary.value -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_filled_background_secondary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSecondary), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.OnSecondary.value -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_filled_background_on_secondary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorNeutral900), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.Neutral.value -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_filled_background_neutral_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSurfaceDark), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.Inverse.value -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_filled_background_inverse_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSurfaceFixedLight), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            else -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_filled_background_primary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimary), android.graphics.PorterDuff.Mode.SRC_IN)
            }
        }

    }

    private fun configureOutlinedIconButton(backgroundDrawable: GradientDrawable) {
        backgroundDrawable.cornerRadius = getDimenFromTheme(context, R.attr.iconButtonBorderRadius)
        backgroundDrawable.setColor(ResourcesCompat.getColor(resources, android.R.color.transparent, null))

        when (color) {
            GaYaIconButtonColor.Primary.value -> {
                backgroundDrawable.setStroke(2, ContextCompat.getColorStateList(context, R.color.gayabutton_outlined_stroke_primary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.OnPrimary.value -> {
                backgroundDrawable.setStroke(2, ContextCompat.getColorStateList(context, R.color.gayabutton_outlined_stroke_on_primary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimary), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.Secondary.value -> {
                backgroundDrawable.setStroke(2, ContextCompat.getColorStateList(context, R.color.gayabutton_outlined_stroke_secondary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.OnSecondary.value -> {
                backgroundDrawable.setStroke(2, ContextCompat.getColorStateList(context, R.color.gayabutton_outlined_stroke_on_secondary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSecondary), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.Neutral.value -> {
                backgroundDrawable.setStroke(2, ContextCompat.getColorStateList(context, R.color.gayabutton_outlined_stroke_neutral_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.Inverse.value -> {
                backgroundDrawable.setStroke(2, ContextCompat.getColorStateList(context, R.color.gayabutton_outlined_stroke_inverse_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSurfaceFixedLight), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            else -> {
                backgroundDrawable.setStroke(2, ContextCompat.getColorStateList(context, R.color.gayabutton_outlined_stroke_primary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis), android.graphics.PorterDuff.Mode.SRC_IN)
            }
        }
    }

    private fun configureGhostIconButton(backgroundDrawable: GradientDrawable) {
        backgroundDrawable.cornerRadius = getDimenFromTheme(context, R.attr.iconButtonBorderRadius)
        backgroundDrawable.setColor(ResourcesCompat.getColor(resources, android.R.color.transparent, null))
        backgroundDrawable.setStroke(0, ResourcesCompat.getColor(resources, android.R.color.transparent, null))
        binding.iconButtonContainer.background = backgroundDrawable

        when (color) {
            GaYaIconButtonColor.Primary.value -> {
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorPrimary), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.OnPrimary.value -> {
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimary), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.Secondary.value -> {
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorSecondary), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.OnSecondary.value -> {
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSecondary), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.Neutral.value -> {
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.Inverse.value -> {
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorContentHighlightFixedLight), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            else -> {
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorPrimary), android.graphics.PorterDuff.Mode.SRC_IN)
            }
        }
    }

    private fun configureTonalIconButton(backgroundDrawable: GradientDrawable) {
        backgroundDrawable.cornerRadius = getDimenFromTheme(context, R.attr.iconButtonBorderRadius)
        backgroundDrawable.setStroke(0, ResourcesCompat.getColor(resources, android.R.color.transparent, null))

        when (color) {
            GaYaIconButtonColor.Primary.value -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_tonal_background_primary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimaryLightest), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.OnPrimary.value -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_tonal_background_on_primary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimaryLight), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.Secondary.value -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_tonal_background_secondary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSecondaryLightest), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.OnSecondary.value -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_tonal_background_on_secondary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSecondaryLight), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.Neutral.value -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_tonal_background_neutral_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            GaYaIconButtonColor.Inverse.value -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_tonal_background_inverse_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorNeutral0), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            else -> {
                backgroundDrawable.setColor(ContextCompat.getColorStateList(context, R.color.gayabutton_tonal_background_primary_v23))
                binding.iconButtonContainer.background = backgroundDrawable
                binding.iconButtonIcon.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimaryLightest), android.graphics.PorterDuff.Mode.SRC_IN)
            }
        }
    }

    fun setIcon(icon: String?) {
        val iconDrawableId = if (icon.isNullOrEmpty()) {
            R.drawable.outlined_default_mockup
        } else {
            getIconResourceIdFromName(context, icon)
        }
        if (iconDrawableId == 0)
            binding.iconButtonIcon.setImageResource(R.drawable.outlined_default_mockup)
        else
            binding.iconButtonIcon.setImageResource(iconDrawableId)
    }

    override fun setEnabled(enabled: Boolean) {
        binding.iconButtonIcon.isEnabled = enabled
        binding.iconButtonContainer.isEnabled = enabled
        super.setEnabled(enabled)
    }
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