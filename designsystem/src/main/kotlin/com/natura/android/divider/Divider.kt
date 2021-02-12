package com.natura.android.divider

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.getIntOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException
import kotlinx.android.synthetic.main.divider.view.*

class Divider @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var dividerAttributesArray: TypedArray
    private var typeAttribute: Int? = null
    private var backgroundColorResourceAttribute = 0
    private var marginLeftResourceAttribute: Int = 0
    private var marginRightResourceAttribute: Int = 0

    init {

        try {
            View.inflate(context, R.layout.divider, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        dividerAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.DividerLine)

        getTypeAttribute()
        getAttributesFromTheme()
        configureAppearance()
    }

    fun getType(): Int? = typeAttribute

    private fun setAttributes(styleFromTheme: Int) {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.DividerLine, styleFromTheme, 0)
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.DividerLine_colorBackground)
                marginLeftResourceAttribute = this.getResourceIdOrThrow(R.styleable.DividerLine_android_layout_marginLeft)
                marginRightResourceAttribute = this.getResourceIdOrThrow(R.styleable.DividerLine_android_layout_marginRight)
            }
    }

    private fun getAttributesFromTheme() {
        try {
            when (typeAttribute) {
                FULLBLEED -> {
                    setAttributes(R.attr.dividerFullbleed)
                }
                INSET -> {
                    setAttributes(R.attr.dividerInset)
                }
                else -> {
                    setAttributes(R.attr.dividerMiddle)
                }
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

    private fun configureAppearance() {
        this.dividerLine.setBackgroundColor(ContextCompat.getColor(context, backgroundColorResourceAttribute))

        val marginLayoutParams = this.dividerLine.layoutParams as MarginLayoutParams

        marginLayoutParams.setMargins(
            resources.getDimension(marginLeftResourceAttribute).toInt(),
            0,
            resources.getDimension(marginRightResourceAttribute).toInt(),
            0)
        this.dividerLine.layoutParams = marginLayoutParams
    }

    companion object {
        const val FULLBLEED = 0
        const val INSET = 1
        const val MIDDLE = 2
    }
}
