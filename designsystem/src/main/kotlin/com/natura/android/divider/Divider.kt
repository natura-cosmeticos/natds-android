package com.natura.android.divider

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.getIntOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException

class Divider @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var dividerAttributesArray: TypedArray
    private var typeAttribute: Int? = null
    private var backgroundColorResourceAttribute = 0
    private var heightResourceAttribute = 0
    private var marginLeftResourceAttribute: Int = 0
    private var marginRightResourceAttribute: Int = 0

    init {
        dividerAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.DividerLine)

        getTypeAttribute()
        getAttributesFromTheme()
        configureAppearance()
    }

    private fun setAttributes(styleFromTheme: Int) {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.DividerLine, styleFromTheme, 0)
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.DividerLine_colorBackground)
                heightResourceAttribute = this.getResourceIdOrThrow(R.styleable.DividerLine_height)
                marginLeftResourceAttribute = this.getResourceIdOrThrow(R.styleable.DividerLine_marginLeft)
                marginRightResourceAttribute = this.getResourceIdOrThrow(R.styleable.DividerLine_android_layout_marginRight)
            }
    }

    private fun getAttributesFromTheme() {
        try {
            if (typeAttribute == FULLBLEED) {
                setAttributes(R.attr.dividerFullbleed)
            } else if (typeAttribute == INSET) {
                setAttributes(R.attr.dividerInset)
            } else {
                setAttributes(R.attr.dividerMiddle)
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun getTypeAttribute() {
        try {
            typeAttribute = dividerAttributesArray.getIntOrThrow(R.styleable.DividerLine_dividerType)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing divider required argument. You MUST set the divider type.", e))
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val parentWidth = MeasureSpec.getSize(widthMeasureSpec)
        val parentHeight = resources.getDimension(heightResourceAttribute).toInt()
        setMeasuredDimension(MeasureSpec.makeMeasureSpec(parentWidth, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(parentHeight, MeasureSpec.EXACTLY))
    }

    private fun configureAppearance() {
        this.setBackgroundColor(ContextCompat.getColor(context, backgroundColorResourceAttribute))

        val layoutParams = ViewGroup.MarginLayoutParams(110, 0)

        layoutParams.setMargins(
            resources.getDimension(marginLeftResourceAttribute).toInt(),
            0,
            resources.getDimension(marginRightResourceAttribute).toInt(),
            0)
        this.layoutParams = layoutParams
    }

    companion object {
        const val FULLBLEED = 0
        const val INSET = 1
        const val MIDDLE = 2
    }
}
