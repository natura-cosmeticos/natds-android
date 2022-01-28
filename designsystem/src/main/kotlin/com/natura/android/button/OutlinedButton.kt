package com.natura.android.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.core.content.res.*
import com.google.android.material.button.MaterialButton
import com.natura.android.R

class OutlinedButton : MaterialButton {

    private lateinit var buttonAttributesArray: TypedArray
    private var attrs: AttributeSet? = null
    private var sizeAttribute: Int = 0

    private var insetBottomResourceAttribute: Int = 0
    private var insetTopResourceAttribute: Int = 0
    private var minHeightResourceAttribute: Int = 0

    constructor(context: Context, attrs: AttributeSet?) :
        super(context, attrs, R.attr.outlinedButtonSmall) {
            this.attrs = attrs
            init()
        }

    constructor(context: Context) :
        super(context, null, R.attr.outlinedButtonSmall) {
            init()
        }

    private fun init() {
        buttonAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.Button)
        getAttributeValue()
        setComponentStyleBySize()
        configureAppearance()
    }

    private fun getAttributeValue() {
        sizeAttribute = buttonAttributesArray.getInteger(R.styleable.Button_bt_size, SEMIX_SIZE)
    }

    private fun setComponentStyleBySize() {
        return when (sizeAttribute) {
            SEMI_SIZE -> getStyleAttributes(R.attr.outlinedButtonSmall)
            SEMIX_SIZE -> getStyleAttributes(R.attr.outlinedButtonMedium)
            MEDIUM_SIZE -> getStyleAttributes(R.attr.outlinedButtonLarge)
            else -> getStyleAttributes(R.attr.outlinedButtonMedium)
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
                minHeightResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ButtonStyle_android_minHeight)
                insetBottomResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ButtonStyle_android_insetBottom)
                insetTopResourceAttribute =
                    this.getResourceIdOrThrow(R.styleable.ButtonStyle_android_insetTop)
            }
    }

    private fun configureAppearance() {
        this.minHeight = context.resources.getDimension(minHeightResourceAttribute).toInt()
        this.insetBottom = context.resources.getDimension(insetBottomResourceAttribute).toInt()
        this.insetTop = context.resources.getDimension(insetTopResourceAttribute).toInt()
    }

    companion object {
        const val SEMI_SIZE = 0
        const val SEMIX_SIZE = 1
        const val MEDIUM_SIZE = 2
    }
}
