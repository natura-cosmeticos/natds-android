package com.natura.android.progressindicator

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.ProgressBar
import androidx.core.content.res.getResourceIdOrThrow
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException

/**
 * The progress indicator is a component that informs users about the status
 * of ongoing processes, such as loading an application, submitting a form, or saving updates.
 * Depending on the preference of the sizes, it can be separated into three types:
 * It is available in three sizes: standard, semi, medium and large.
 * There is also the option of adding a layer behind, setting true or false for the layer attribute.
 *
 * Progress Indicator update is available at version 5.4.0 of NatDS Android.
 *
 * ```
<com.natura.android.progressindicator.ProgressIndicator
 android:id="@+id/ds_loading"
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:visibility="visible"
 app:size="large"
 app:layer="true"/>
 *```
 */

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
        sizeAttribute = progressIndicatorAttributesArray.getInt(R.styleable.ProgressIndicator_pgid_size, Size.MEDIUM.value)
        layerAttribute = progressIndicatorAttributesArray.getBoolean(R.styleable.ProgressIndicator_pgid_layer, false)

        progressIndicatorAttributesArray.recycle()
    }

    private fun setAttributes(styleFromTheme: Int) {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.ProgressIndicator, styleFromTheme, 0)
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.ProgressIndicator_colorBackground)
                widthResourceAttribute = this.getResourceIdOrThrow(R.styleable.ProgressIndicator_pgid_width)
                heightResourceAttribute = this.getResourceIdOrThrow(R.styleable.ProgressIndicator_pgid_height)
            }
    }

    private fun getAttributesFromTheme() {
        try {
            when (sizeAttribute) {
                Size.STANDARD.value -> {
                    setAttributes(R.attr.progressIndicatorStandard)
                }
                Size.SEMI.value -> {
                    setAttributes(R.attr.progressIndicatorSemi)
                }
                Size.MEDIUM.value -> {
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
}

enum class Size(val value: Int) {
    STANDARD(0),
    SEMI(1),
    MEDIUM(2),
    LARGE(3)
}
