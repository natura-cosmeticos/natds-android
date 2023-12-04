package com.natura.android.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.natura.android.R
import com.natura.android.resources.getDimenFromTheme
import com.natura.android.resources.getFontFromTheme

class ContainedButton : MaterialButton {

    private lateinit var buttonAttributesArray: TypedArray
    private var attrs: AttributeSet? = null
    private var sizeAttribute: Int = 0
    private var colorAttribute: Int = 0

    constructor(context: Context, attrs: AttributeSet?) :
        super(context, attrs, R.attr.buttonStyleSmall) {
            this.attrs = attrs
            init()
        }

    constructor(context: Context) :
        super(context, null, R.attr.buttonStyleSmall) {
            init()
        }

    fun getSize(): Int {
        return sizeAttribute
    }

    fun getColor() : Int {
        return colorAttribute
    }

    private fun init() {
        buttonAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.Button)
        getAttributeValue()
        setAppearanceAttributesFromTheme()
        setComponentStyleBySize()
        configureAppearance()
    }

    private fun getAttributeValue() {
        sizeAttribute = buttonAttributesArray.getInteger(R.styleable.Button_bt_size, SEMIX_SIZE)
        colorAttribute = buttonAttributesArray.getInteger(R.styleable.Button_bt_color, DEFAULT)
    }

    private fun setComponentStyleBySize() {
        return when (sizeAttribute) {
            SEMI_SIZE -> {
                this.minHeight = getDimenFromTheme(context, R.attr.sizeSemi).toInt()
                this.insetBottom = getDimenFromTheme(context, R.attr.spacingMicro).toInt()
                this.insetTop = getDimenFromTheme(context, R.attr.spacingMicro).toInt()
            }
            SEMIX_SIZE -> {
                this.minHeight = getDimenFromTheme(context, R.attr.sizeSemiX).toInt()
                this.insetBottom = getDimenFromTheme(context, R.attr.spacingNone).toInt()
                this.insetTop = getDimenFromTheme(context, R.attr.spacingNone).toInt()
            }
            MEDIUM_SIZE -> {
                this.minHeight = getDimenFromTheme(context, R.attr.sizeMedium).toInt()
                this.insetBottom = getDimenFromTheme(context, R.attr.spacingNone).toInt()
                this.insetTop = getDimenFromTheme(context, R.attr.spacingNone).toInt()
            }
            else -> {
                this.minHeight = getDimenFromTheme(context, R.attr.sizeSemiX).toInt()
                this.insetBottom = getDimenFromTheme(context, R.attr.spacingNone).toInt()
                this.insetTop = getDimenFromTheme(context, R.attr.spacingNone).toInt()
            }
        }
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

    private fun configureAppearance() {
        this.rippleColor = ContextCompat.getColorStateList(context, R.color.button_ripple_color_v23)
        this.strokeColor = ContextCompat.getColorStateList(context, R.color.button_contained_stroke_default_v23)
        this.textSize = getDimenFromTheme(context, R.attr.buttonLabelFontSize) / context.resources.displayMetrics.scaledDensity
        this.iconPadding = getDimenFromTheme(context, R.attr.spacingTiny).toInt()
        this.cornerRadius = getDimenFromTheme(context, R.attr.buttonBorderRadius).toInt()
        this.letterSpacing = getDimenFromTheme(context, R.attr.buttonLabelLetterSpacing)
        this.typeface = getFontFromTheme(context, R.attr.buttonLabelPrimaryFontWeight, R.attr.buttonLabelPrimaryFontWeight)

        when (colorAttribute) {
            DEFAULT -> {
                this.backgroundTintList = ContextCompat.getColorStateList(context, R.color.button_contained_background_primary_v23)
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_contained_label_primary_v23)
                this.setTextColor(textColorStateList)
            }
            PRIMARY -> {
                this.backgroundTintList = ContextCompat.getColorStateList(context, R.color.button_contained_background_primary_v23)
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_contained_label_primary_v23)
                this.setTextColor(textColorStateList)
            }
            ONPRIMARY -> {
                this.backgroundTintList = ContextCompat.getColorStateList(context, R.color.button_contained_background_on_primary_v23)
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_contained_label_on_primary_v23)
                this.setTextColor(textColorStateList)
            }
            SECONDARY -> {
                this.backgroundTintList = ContextCompat.getColorStateList(context, R.color.button_contained_background_secondary_v23)
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_contained_label_secondary_v23)
                this.setTextColor(textColorStateList)
            }
            ONSECONDARY -> {
                this.backgroundTintList = ContextCompat.getColorStateList(context, R.color.button_contained_background_on_secondary_v23)
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_contained_label_on_secondary_v23)
                this.setTextColor(textColorStateList)
            }
            INVERSE -> {
                this.backgroundTintList = ContextCompat.getColorStateList(context, R.color.button_contained_background_inverse_v23)
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_contained_label_inverse_v23)
                this.setTextColor(textColorStateList)
            }
            ONINVERSE -> {
                this.backgroundTintList = ContextCompat.getColorStateList(context, R.color.button_contained_background_on_inverse_v23)
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_contained_label_on_inverse_v23)
                this.setTextColor(textColorStateList)
            }
            else -> {
                this.backgroundTintList = ContextCompat.getColorStateList(context, R.color.button_contained_background_primary_v23)
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_contained_label_primary_v23)
                this.setTextColor(textColorStateList)
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
