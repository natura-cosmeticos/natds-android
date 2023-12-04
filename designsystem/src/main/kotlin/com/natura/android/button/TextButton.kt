package com.natura.android.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.natura.android.R
import com.natura.android.resources.getDimenFromTheme
import com.natura.android.resources.getFontFromTheme

class TextButton : MaterialButton {

    private lateinit var buttonAttributesArray: TypedArray
    private var attrs: AttributeSet? = null
    private var sizeAttribute: Int = 0
    private var colorAttribute: Int = 0

    constructor(context: Context, attrs: AttributeSet?) :
        super(context, attrs, R.attr.textButtonSmall) {
            this.attrs = attrs
            init()
        }

    constructor(context: Context) :
        super(context, null, R.attr.textButtonSmall) {
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
        this.backgroundTintList = ContextCompat.getColorStateList(context, R.color.button_text_background_v23)
        this.strokeColor = ContextCompat.getColorStateList(context, R.color.button_text_stroke_v23)
        this.textSize = getDimenFromTheme(context, R.attr.buttonLabelFontSize) / context.resources.displayMetrics.scaledDensity
        this.iconPadding = getDimenFromTheme(context, R.attr.spacingTiny).toInt()
        this.cornerRadius = getDimenFromTheme(context, R.attr.buttonBorderRadius).toInt()
        this.letterSpacing = getDimenFromTheme(context, R.attr.buttonLabelLetterSpacing)
        this.typeface = getFontFromTheme(context, R.attr.buttonLabelPrimaryFontWeight, R.attr.buttonLabelPrimaryFontWeight)

        when (colorAttribute) {
            DEFAULT -> {
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_text_label_default_v23)
                this.setTextColor(textColorStateList)
            }
            PRIMARY -> {
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_text_label_primary_v23)
                this.setTextColor(textColorStateList)
            }
            ONPRIMARY -> {
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_text_label_on_primary_v23)
                this.setTextColor(textColorStateList)
            }
            SECONDARY -> {
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_text_label_secondary_v23)
                this.setTextColor(textColorStateList)
            }
            ONSECONDARY -> {
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_text_label_on_secondary_v23)
                this.setTextColor(textColorStateList)
            }
            INVERSE -> {
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_text_label_inverse_v23)
                this.setTextColor(textColorStateList)
            }
            ONINVERSE -> {
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_text_label_on_inverse_v23)
                this.setTextColor(textColorStateList)
            }
            else -> {
                val textColorStateList = ContextCompat.getColorStateList(context, R.color.button_text_label_default_v23)
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
