package com.natura.android.button

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.*
import com.google.android.material.button.MaterialButton
import com.natura.android.R

class Button : MaterialButton {

    private lateinit var buttonAttributesArray: TypedArray
    private var attrs: AttributeSet? = null
    private var typeAttribute: Int = 0
    private var sizeAttribute: Int = 0

    private var displayAttribute: Int = 0
    private var rippleColorResourceAttribute: Int = 0
    private var backgroundColorResourceAttribute: Int = 0

    private var textColorResourceAttribute: Int = 0
    private var strokeColorResourceAttribute: Int = 0
    private var textSizeResourceAttribute: Int = 0
    private var letterSpacingResourceAttribute: Float = 0F
    private var insetBottomResourceAttribute: Int = 0
    private var cornerRadiusResourceAttribute: Int = 0
    private var fontFamilyResourceAttribute: String = ""
    private var insetTopResourceAttribute: Int = 0
    private var minHeightResourceAttribute: Int = 0

    private val stylesMap = Array(3) { IntArray(3) }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) :
        super(context, attrs, R.attr.buttonStyle) {
            this.attrs = attrs
            init()
        }

    constructor(context: Context, attrs: AttributeSet?) :
        super(context, attrs, R.attr.buttonStyle) {
            this.attrs = attrs
            init()
        }

    constructor(context: Context) :
        super(context, null, R.attr.buttonStyle) {
            init()
        }

    private fun init() {

        fillStylesMap()

        buttonAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.Button)
        getAttributesValues()
        getStyleAttributes()
        configureAppearance()
    }

    private fun fillStylesMap() {
        stylesMap[CONTAINED_TYPE][SEMI_SIZE] = R.attr.buttonStyleSmall
        stylesMap[CONTAINED_TYPE][SEMIX_SIZE] = R.attr.buttonStyleMedium
        stylesMap[CONTAINED_TYPE][MEDIUM_SIZE] = R.attr.buttonStyleLarge

        stylesMap[OUTLINED_TYPE][SEMI_SIZE] = R.attr.outlinedButtonSmall
        stylesMap[OUTLINED_TYPE][SEMIX_SIZE] = R.attr.outlinedButtonMedium
        stylesMap[OUTLINED_TYPE][MEDIUM_SIZE] = R.attr.outlinedButtonLarge

        stylesMap[TEXT_TYPE][SEMI_SIZE] = R.attr.textButtonSmall
        stylesMap[TEXT_TYPE][SEMIX_SIZE] = R.attr.textButtonMedium
        stylesMap[TEXT_TYPE][MEDIUM_SIZE] = R.attr.textButtonLarge
    }

    private fun getAttributesValues() {
        sizeAttribute = buttonAttributesArray.getInteger(R.styleable.Button_bt_size, SEMIX_SIZE)
        displayAttribute = buttonAttributesArray.getInteger(R.styleable.Button_bt_display, INLINE_DISPLAY)

        try {
            typeAttribute = buttonAttributesArray.getIntOrThrow(R.styleable.Button_bt_type)
        } catch (e: Exception) {
            throw (
                IllegalArgumentException("⚠️ ⚠️ Missing button required argument. You MUST set the button type.", e)
                )
        }
    }

    private fun getComponentStyleAttribute(): Int {
        for (row in 0 until 3) {
            for (column in 0 until 3) {
                if ((row == typeAttribute) && (column == sizeAttribute)) {
                    return stylesMap[row][column]
                }
            }
        }
        return 0
    }

    private fun getStyleAttributes() {
        context
            .theme
            .obtainStyledAttributes(
                attrs,
                R.styleable.ButtonStyle,
                getComponentStyleAttribute(),
                0
            )
            .apply {
                rippleColorResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ButtonStyle_rippleColor)
                backgroundColorResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ButtonStyle_backgroundTint)
                textColorResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ButtonStyle_android_textColor)
                strokeColorResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ButtonStyle_strokeColor)
                textSizeResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ButtonStyle_android_textSize)
                letterSpacingResourceAttribute =
                    this.getFloatOrThrow(R.styleable.ButtonStyle_android_letterSpacing)
                cornerRadiusResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ButtonStyle_cornerRadius)
                fontFamilyResourceAttribute =
                    this.getStringOrThrow(R.styleable.ButtonStyle_fontFamily)
                minHeightResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ButtonStyle_android_minHeight)
                insetBottomResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ButtonStyle_android_insetBottom)
                insetTopResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ButtonStyle_android_insetTop)
            }
    }

    private fun configureAppearance() {
        this.setTextColor(ContextCompat.getColorStateList(context, textColorResourceAttribute))
        this.strokeColor = ContextCompat.getColorStateList(context, strokeColorResourceAttribute)
        this.backgroundTintList = ContextCompat.getColorStateList(context, backgroundColorResourceAttribute)
        this.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(textSizeResourceAttribute))
        this.cornerRadius = context.resources.getDimension(cornerRadiusResourceAttribute).toInt()
        this.minHeight = context.resources.getDimension(minHeightResourceAttribute).toInt()
        this.insetBottom = context.resources.getDimension(insetBottomResourceAttribute).toInt()
        this.insetTop = context.resources.getDimension(insetTopResourceAttribute).toInt()
        this.typeface = Typeface.create(fontFamilyResourceAttribute, Typeface.NORMAL)
        this.letterSpacing = letterSpacingResourceAttribute

        if (displayAttribute == BLOCK_DISPLAY) {
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            this.layoutParams = params
        }

        this.rippleColor = ContextCompat.getColorStateList(context, rippleColorResourceAttribute)
    }

    companion object {
        const val CONTAINED_TYPE = 0
        const val OUTLINED_TYPE = 1
        const val TEXT_TYPE = 2

        const val SMALL_SIZE = 0
        const val LARGE_SIZE = 2

        const val SEMI_SIZE = 0
        const val SEMIX_SIZE = 1
        const val MEDIUM_SIZE = 2

        const val INLINE_DISPLAY = 0
        const val BLOCK_DISPLAY = 1
    }
}
