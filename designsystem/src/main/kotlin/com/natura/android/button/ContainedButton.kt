package com.natura.android.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily
import com.natura.android.R
import com.natura.android.resources.getDimenFromTheme
import com.natura.android.resources.getFontFromTheme

class ContainedButton : MaterialButton {

    private lateinit var buttonAttributesArray: TypedArray
    private var attrs: AttributeSet? = null
    private var sizeAttribute: Int = 0
    private var colorAttribute: Int = 0

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context) : super(context) {
        init(null)
    }

    private fun init(attrs: AttributeSet?) {

        buttonAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.Button)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Button, 0, 0).apply {
            try {
                sizeAttribute = buttonAttributesArray.getInteger(R.styleable.Button_bt_size, SEMIX_SIZE)
                colorAttribute = buttonAttributesArray.getInteger(R.styleable.Button_bt_color, DEFAULT)
            } finally {
                recycle()
            }
        }

        setComponentStyleBySize()
        applyStyle()
        setAppearanceAttributesFromTheme()
    }

    private fun setAppearanceAttributesFromTheme() {
        return when (colorAttribute) {
            DEFAULT -> getStyleAttributes(R.attr.buttonDefault)
            PRIMARY -> getStyleAttributes(R.attr.buttonPrimary)
            ONPRIMARY -> getStyleAttributes(R.attr.buttonOnPrimary)
            SECONDARY -> getStyleAttributes(R.attr.buttonSecondary)
            ONSECONDARY -> getStyleAttributes(R.attr.buttonOnSecondary)
            INVERSE -> getStyleAttributes(R.attr.buttonInverse)
            ONINVERSE -> getStyleAttributes(R.attr.buttonOnInverse)
            else -> getStyleAttributes(R.attr.buttonPrimary)
        }
    }

    private fun applyStyle() {

        val backgroundTint = when (colorAttribute) {
            DEFAULT -> R.color.button_contained_background_default_v23
            PRIMARY -> R.color.button_contained_background_primary_v23
            ONPRIMARY -> R.color.button_contained_background_on_primary_v23
            SECONDARY -> R.color.button_contained_background_secondary_v23
            ONSECONDARY -> R.color.button_contained_background_on_secondary_v23
            INVERSE -> R.color.button_contained_background_inverse_v23
            ONINVERSE -> R.color.button_contained_background_on_inverse_v23
            else -> R.color.button_contained_background_default_v23
        }
        this.backgroundTintList = ContextCompat.getColorStateList(context, backgroundTint)

        val textColor = when (colorAttribute) {
            DEFAULT -> { R.color.button_contained_label_default_v23 }
            PRIMARY -> { R.color.button_contained_label_primary_v23 }
            ONPRIMARY -> { R.color.button_contained_label_on_primary_v23 }
            SECONDARY -> { R.color.button_contained_label_secondary_v23 }
            ONSECONDARY -> { R.color.button_contained_label_on_secondary_v23 }
            INVERSE -> { R.color.button_contained_label_inverse_v23 }
            ONINVERSE -> { R.color.button_contained_label_on_inverse_v23 }
            else -> { R.color.button_contained_label_default_v23 }
        }

        val textColorStateList = ContextCompat.getColorStateList(context, textColor)
        this.setTextColor(textColorStateList)

        this.rippleColor = ContextCompat.getColorStateList(context, R.color.button_ripple_color_v23)
        this.textSize = getDimenFromTheme(context, R.attr.buttonLabelFontSize) / context.resources.displayMetrics.scaledDensity
        this.iconPadding = getDimenFromTheme(context, R.attr.spacingTiny).toInt()
        this.letterSpacing = getDimenFromTheme(context, R.attr.buttonLabelLetterSpacing)
        this.typeface = getFontFromTheme(context, R.attr.buttonLabelPrimaryFontWeight, R.attr.buttonLabelPrimaryFontWeight)

        val cornerRadius = getDimenFromTheme(context, R.attr.buttonBorderRadius).toInt()
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, cornerRadius.toFloat())
            .build()
    }

    private fun getStyleAttributes(componentAttr: Int) {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.ButtonStyle,
                componentAttr,
                0
            )
            .apply {
            }
    }

    private fun setComponentStyleBySize() {
        return when (sizeAttribute) {
            SEMI_SIZE -> {
                this.minHeight = getDimenFromTheme(context, R.attr.sizeSemi).toInt()
                this.insetBottom = getDimenFromTheme(context, R.attr.spacingTiny).toInt()
                this.insetTop = getDimenFromTheme(context, R.attr.spacingTiny).toInt()
            }
            SEMIX_SIZE -> {
                this.minHeight = getDimenFromTheme(context, R.attr.sizeSemiX).toInt()
                this.insetBottom = getDimenFromTheme(context, R.attr.spacingMicro).toInt()
                this.insetTop = getDimenFromTheme(context, R.attr.spacingMicro).toInt()
            }
            MEDIUM_SIZE -> {
                this.minHeight = getDimenFromTheme(context, R.attr.sizeMedium).toInt()
                this.insetBottom = getDimenFromTheme(context, R.attr.spacingNone).toInt()
                this.insetTop = getDimenFromTheme(context, R.attr.spacingNone).toInt()
            }
            else -> {
                this.minHeight = getDimenFromTheme(context, R.attr.sizeSemiX).toInt()
                this.insetBottom = getDimenFromTheme(context, R.attr.spacingMicro).toInt()
                this.insetTop = getDimenFromTheme(context, R.attr.spacingMicro).toInt()
            }
        }
    }

    companion object {
        const val SEMI_SIZE = 0
        const val SEMIX_SIZE = 1
        const val MEDIUM_SIZE = 2

        const val DEFAULT = 0
        const val PRIMARY = 1
        const val ONPRIMARY = 2
        const val SECONDARY = 3
        const val ONSECONDARY = 4
        const val INVERSE = 5
        const val ONINVERSE = 6
    }
}