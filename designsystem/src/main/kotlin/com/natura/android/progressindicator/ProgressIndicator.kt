package com.natura.android.progressindicator

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.ProgressBar
import androidx.core.content.res.getResourceIdOrThrow
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException

class ProgressIndicator @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null
) : ProgressBar(context) {

    private var progressIndicatorAttributesArray: TypedArray
    private var sizeAttribute: Int = 0
    private var layerAttribute: Boolean = false
    private var backgroundColorResourceAttribute: Int = 0
    private var widthResourceAttribute: Int = 0
    private var heightResourceAttribute: Int = 0

    init {
        progressIndicatorAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.ProgressIndicator)

        getProgressIndicatorAttributes()
        getAttributesFromTheme()
        configureAppearance()
    }

    fun getSize(): Int? = sizeAttribute

    fun getLayer(): Boolean? = layerAttribute

    private fun getProgressIndicatorAttributes() {
        sizeAttribute = progressIndicatorAttributesArray.getInt(R.styleable.ProgressIndicator_size, MEDIUM)
        layerAttribute = progressIndicatorAttributesArray.getBoolean(R.styleable.ProgressIndicator_layer, false)

        progressIndicatorAttributesArray.recycle()
    }

    private fun setAttributes(styleFromTheme: Int) {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.ProgressIndicator, styleFromTheme, 0)
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.ProgressIndicator_colorBackground)
                widthResourceAttribute = this.getResourceIdOrThrow(R.styleable.ProgressIndicator_customWidth)
                heightResourceAttribute = this.getResourceIdOrThrow(R.styleable.ProgressIndicator_customHeight)
            }
    }

    private fun getAttributesFromTheme() {
        try {
            when (sizeAttribute) {
                STANDARD -> {
                    setAttributes(R.attr.progressIndicatorStandard)
                }
                SEMI -> {
                    setAttributes(R.attr.progressIndicatorSemi)
                }
                MEDIUM -> {
                    setAttributes(R.attr.progressIndicatorMedium)
                }
                else -> {
                    setAttributes(R.attr.progressIndicatorLarge)
                }
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun configureAppearance() {
        if (layerAttribute) {
            this.background =
                context.resources.getDrawable(R.drawable.progress_indicator_layer, context.theme)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(resources.getDimension(widthResourceAttribute).toInt(), resources.getDimension(heightResourceAttribute).toInt())
    }

    companion object {
        const val STANDARD = 0
        const val SEMI = 1
        const val MEDIUM = 2
        const val LARGE = 3
    }
}
