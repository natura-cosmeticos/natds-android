package com.natura.android.shortcut

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.natura.android.R
import com.natura.android.badge.GaYaBadgeDrawable
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getDimenFromTheme
import com.natura.android.resources.getIconResourceIdFromName

class GaYaShortcut @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var shortcutAttributesArray: TypedArray

    var iconName: String? = null
        set(value) {
            field = value
            setIcon(value)
        }

    var label: String? = ""
        set(value) {
            field = value
            labelContainer.text = value
        }

    var style: Int = GaYaShortcutStyle.Standard.value
        set(value) {
            if (field != value) {
                field = value
                updateLayout()
            }
        }

    var color: Int = GaYaShortcutColor.Primary.value
        set(value) {
            field = value
            configureAppearance(getDrawable())
        }

    var type: Int = GaYaShortcutType.Filled.value
        set(value) {
            field = value
            configureAppearance(getDrawable())
        }

    var isEnabledButton: Boolean = true
        set(value) {
            field = value
            configureEnabled()
        }

    lateinit var labelContainer: TextView
    private lateinit var backgroundContainer: LinearLayout
    private lateinit var rippleBackground: View
    private lateinit var iconContainer: ImageView
    private lateinit var mainContainer: ConstraintLayout
    private lateinit var shortcutContainer: View

    init {

        shortcutAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.GaYaShortcut)
        style = shortcutAttributesArray.getInt(
            R.styleable.GaYaShortcut_gshc_style,
            GaYaShortcutStyle.Standard.value
        )

        try {
            val layoutRes = if (style == GaYaShortcutStyle.Inline.value) {
                R.layout.gayashortcut_inline
            } else {
                R.layout.gayashortcut
            }
            View.inflate(context, layoutRes, this)
        } catch (e: Exception) {
            throw MissingThemeException()
        }

        shortcutAttributesArray =
            context.obtainStyledAttributes(attrs, R.styleable.GaYaShortcut)

        configureViews()

        getAttributes()
        shortcutAttributesArray.recycle()

        shortcutContainer.setOnClickListener {
            if (isEnabled) {
                performClick()
            }
        }
    }

    private fun updateLayout() {
        removeAllViews()

        val layoutRes = if (style == GaYaShortcutStyle.Inline.value) {
            R.layout.gayashortcut_inline
        } else {
            R.layout.gayashortcut
        }
        View.inflate(context, layoutRes, this)

        configureViews()

        if (style == GaYaShortcutStyle.Inline.value) {
            rippleBackground = findViewById(R.id.shortcutRippleBackground)
            rippleBackground.background = ContextCompat.getDrawable(context, R.drawable.chip_ripple_background)
        }
    }

    private fun configureViews() {
        labelContainer = findViewById(R.id.shortCutLabel)
        backgroundContainer = findViewById(R.id.shortcutBackground)
        rippleBackground = findViewById(R.id.shortcutRippleBackground)
        iconContainer = findViewById(R.id.shortCutIcon)
        mainContainer = findViewById(R.id.shortcutMainContainer)
        shortcutContainer = findViewById(R.id.shortcutContainer)

        configureEnabled()
        configureAppearance(getDrawable())
    }


    private fun getAttributes() {
        shortcutAttributesArray.apply {
            try {
                isEnabledButton = getBoolean(R.styleable.GaYaShortcut_android_enabled, true)
                type = getInt(R.styleable.GaYaShortcut_gshc_type, GaYaShortcutType.Filled.value)
                iconName = getString(R.styleable.GaYaShortcut_gshc_icon) ?: ""
                color = getInt(R.styleable.GaYaShortcut_gshc_color, GaYaShortcutColor.Primary.value)
                label = getString(R.styleable.GaYaShortcut_gshc_label) ?: ""
            } catch (e: Exception) {
                throw (
                    IllegalArgumentException(
                        "⚠️ ⚠️ GaYaIssue: Missing GaYaShortcut required argument. You MUST set the GaYaShortcut icon(drawable).",
                        e
                    )
                    )
            }
        }

        configureEnabled()
        configureAppearance(getDrawable())
    }

    private fun configureEnabled() {
        isEnabled = isEnabledButton
    }

    private fun getDrawable(): GradientDrawable {
        val backgroundDrawable = ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.shortcut_background,
            null
        )

        if (backgroundDrawable is LayerDrawable) {
            val layer = backgroundDrawable.findDrawableByLayerId(R.id.background_shape)
            if (layer is GradientDrawable) {
                return layer.mutate() as GradientDrawable
            } else {
                throw IllegalStateException(" ⚠️ ⚠️ GaYaIssue: Layer with ID R.id.background_shape is not a GradientDrawable")
            }
        } else if (backgroundDrawable is GradientDrawable) {
            return backgroundDrawable.mutate() as GradientDrawable
        }

        throw IllegalStateException(" ⚠️ ⚠️ GaYaIssue: Drawable with ID R.drawable.shortcut_background is not a LayerDrawable or GradientDrawable")
    }

    fun setIcon(icon: String?) {
        val iconDrawableId = if (icon.isNullOrEmpty()) {
            R.drawable.outlined_default_mockup
        } else {
            getIconResourceIdFromName(context, icon)
        }
        if (iconDrawableId == 0)
            iconContainer.setImageResource(R.drawable.outlined_default_mockup)
        else
            iconContainer.setImageResource(iconDrawableId)
    }

    override fun setEnabled(enabled: Boolean) {
        iconContainer.isEnabled = enabled
        backgroundContainer.isEnabled = enabled
        mainContainer.isEnabled = enabled
        labelContainer.isEnabled = enabled
        super.setEnabled(enabled)
    }

    private fun configureAppearance(backgroundDrawable: GradientDrawable) {
        setIcon(iconName)

        if (style == GaYaShortcutStyle.Standard.value) {
            backgroundDrawable.cornerRadius =
                getDimenFromTheme(context, R.attr.gayaShortcutBorderRadius)
        } else {
            backgroundDrawable.cornerRadius =
                getDimenFromTheme(context, R.attr.shortcutBorderRadius)
        }

        if (!isEnabled) {
            backgroundDrawable.setStroke(
                0,
                ResourcesCompat.getColor(resources, android.R.color.transparent, null)
            )
            rippleBackground.isClickable = false
            rippleBackground.background = null

            shortcutContainer.isClickable = false
            shortcutContainer.isFocusable = false
            shortcutContainer.background = null

            backgroundDrawable.setColor(
                getColorTokenFromTheme(
                    context,
                    R.attr.colorSurfaceDisabled
                )
            )
            backgroundContainer.background = backgroundDrawable
            iconContainer.setColorFilter(
                getColorTokenFromTheme(context, R.attr.colorOnSurfaceDisabled),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            if (style == GaYaShortcutStyle.Standard.value) {
                labelContainer.setTextColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorContentDisabled
                    )
                )
            } else {
                labelContainer.setTextColor(
                    getColorTokenFromTheme(
                        context,
                        R.attr.colorOnSurfaceDisabled
                    )
                )
            }

        } else {

            rippleBackground.isClickable = true
            rippleBackground.background = ContextCompat.getDrawable(context, R.drawable.chip_ripple_background)

            shortcutContainer.isClickable = true
            shortcutContainer.isFocusable = true

            when (type) {
                GaYaShortcutType.Filled.value -> configureFilledShortcut(backgroundDrawable)
                GaYaShortcutType.Outlined.value -> configureOutlinedShortcut(backgroundDrawable)
                GaYaShortcutType.Tonal.value -> configureTonalShortcut(backgroundDrawable)
            }
        }
    }

    private fun configureFilledShortcut(backgroundDrawable: GradientDrawable) {
        backgroundDrawable.setStroke(
            0,
            ResourcesCompat.getColor(resources, android.R.color.transparent, null)
        )

        when (color) {
            GaYaShortcutColor.Primary.value -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_filled_background_primary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimary),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnPrimary
                        )
                    )
                }
            }

            GaYaShortcutColor.OnPrimary.value -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_filled_background_on_primary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorNeutral900),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnPrimary
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorNeutral900
                        )
                    )
                }
            }

            GaYaShortcutColor.Secondary.value -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_filled_background_secondary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSecondary),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnSecondary
                        )
                    )
                }
            }

            GaYaShortcutColor.OnSecondary.value -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_filled_background_on_secondary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorNeutral900),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnSecondary
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorNeutral900
                        )
                    )
                }
            }

            GaYaShortcutColor.Neutral.value -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_filled_background_neutral_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSurfaceDark),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnSurfaceDark
                        )
                    )
                }
            }

            GaYaShortcutColor.Inverse.value -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_filled_background_inverse_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSurfaceFixedLight),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighlightFixedLight
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnSurfaceFixedLight
                        )
                    )
                }
            }

            else -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_filled_background_primary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimary),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnPrimary
                        )
                    )
                }
            }
        }
    }

    private fun configureOutlinedShortcut(backgroundDrawable: GradientDrawable) {
        backgroundDrawable.setColor(
            ResourcesCompat.getColor(
                resources,
                android.R.color.transparent,
                null
            )
        )

        when (color) {
            GaYaShortcutColor.Primary.value -> {
                backgroundDrawable.setStroke(
                    2,
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_outlined_stroke_primary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                }
            }

            GaYaShortcutColor.OnPrimary.value -> {
                backgroundDrawable.setStroke(
                    2,
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_outlined_stroke_on_primary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimary),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnPrimary
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnPrimary
                        )
                    )
                }
            }

            GaYaShortcutColor.Secondary.value -> {
                backgroundDrawable.setStroke(
                    2,
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_outlined_stroke_secondary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                }
            }

            GaYaShortcutColor.OnSecondary.value -> {
                backgroundDrawable.setStroke(
                    2,
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_outlined_stroke_on_secondary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSecondary),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnSecondary
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnSecondary
                        )
                    )
                }
            }

            GaYaShortcutColor.Neutral.value -> {
                backgroundDrawable.setStroke(
                    2,
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_outlined_stroke_neutral_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                }
            }

            GaYaShortcutColor.Inverse.value -> {
                backgroundDrawable.setStroke(
                    2,
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_outlined_stroke_inverse_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSurfaceFixedLight),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighlightFixedLight
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnSurfaceFixedLight
                        )
                    )
                }
            }

            else -> {
                backgroundDrawable.setStroke(
                    2,
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_outlined_stroke_primary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                }
            }
        }
    }

    private fun configureTonalShortcut(backgroundDrawable: GradientDrawable) {
        backgroundDrawable.setStroke(
            0,
            ResourcesCompat.getColor(resources, android.R.color.transparent, null)
        )

        when (color) {
            GaYaShortcutColor.Primary.value -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_tonal_background_primary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimaryLightest),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnPrimaryLightest
                        )
                    )
                }
            }

            GaYaShortcutColor.OnPrimary.value -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_tonal_background_on_primary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimaryLight),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnPrimaryLight
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnPrimaryLight
                        )
                    )
                }
            }

            GaYaShortcutColor.Secondary.value -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_tonal_background_secondary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSecondaryLightest),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnSecondaryLightest
                        )
                    )
                }
            }

            GaYaShortcutColor.OnSecondary.value -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_tonal_background_on_secondary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnSecondaryLight),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnSecondaryLight
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnSecondaryLight
                        )
                    )
                }
            }

            GaYaShortcutColor.Neutral.value -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_tonal_background_neutral_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorContentHighEmphasis),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                }
            }

            GaYaShortcutColor.Inverse.value -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_tonal_background_inverse_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorNeutral0),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighlightFixedLight
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorNeutral0
                        )
                    )
                }
            }

            else -> {
                backgroundDrawable.setColor(
                    ContextCompat.getColorStateList(
                        context,
                        R.color.gaya_tonal_background_primary_v23
                    )
                )
                backgroundContainer.background = backgroundDrawable
                iconContainer.setColorFilter(
                    getColorTokenFromTheme(context, R.attr.colorOnPrimaryLightest),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                if (style == GaYaShortcutStyle.Standard.value) {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorContentHighEmphasis
                        )
                    )
                } else {
                    labelContainer.setTextColor(
                        getColorTokenFromTheme(
                            context,
                            R.attr.colorOnPrimaryLightest
                        )
                    )
                }
            }
        }
    }
}

enum class GaYaShortcutStyle(val value: Int) {
    Standard(0),
    Inline(1)
}

enum class GaYaShortcutColor(val value: Int) {
    Primary(0),
    OnPrimary(1),
    Secondary(2),
    OnSecondary(3),
    Neutral(4),
    Inverse(5)
}

enum class GaYaShortcutType(val value: Int) {
    Filled(0),
    Outlined(1),
    Tonal(2)
}