package com.natura.android.divider

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
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
    private var typeAttribute: Int = 0
    private var backgroundColorResourceAttribute: Int = 0
    private var heightResourceAttribute: Int = 0
    private var marginLeftResourceAttribute: Int = 0
    private var marginReightResourceAttribute: Int = 0

    init {
        dividerAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.Divider)

        getTypeAttribute()
        getAttributesFromTheme()
    }

    private fun getAttributesFromTheme() {
        try {
            if (typeAttribute == FULLBLEED) {
                setFullbleedTypeAttributes()
            } else if (typeAttribute == INSET) {
                setInsetTypeAttributes()
            } else {
                setMiddleTypeAttributes()
            }
        } catch (e: Exception) {
            throw (MissingThemeException())
        }
    }

    private fun setFullbleedTypeAttributes() {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.Divider, R.attr.dividerFullBleed, 0)
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Divider_colorBackground)
                heightResourceAttribute = this.getResourceIdOrThrow(R.styleable.Divider_android_layout_height)
                marginLeftResourceAttribute = this.getResourceIdOrThrow(R.styleable.Divider_android_layout_marginLeft)
                marginReightResourceAttribute = this.getResourceIdOrThrow(R.styleable.Divider_android_layout_marginRight)
            }
    }

    private fun setInsetTypeAttributes() {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.Divider, R.attr.dividerInset, 0)
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Divider_colorBackground)
                heightResourceAttribute = this.getResourceIdOrThrow(R.styleable.Divider_android_layout_height)
                marginLeftResourceAttribute = this.getResourceIdOrThrow(R.styleable.Divider_android_layout_marginLeft)
                marginReightResourceAttribute = this.getResourceIdOrThrow(R.styleable.Divider_android_layout_marginRight)
            }
    }

    private fun setMiddleTypeAttributes() {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.Divider, R.attr.dividerMiddle, 0)
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Divider_colorBackground)
                heightResourceAttribute = this.getResourceIdOrThrow(R.styleable.Divider_android_layout_height)
                marginLeftResourceAttribute = this.getResourceIdOrThrow(R.styleable.Divider_android_layout_marginLeft)
                marginReightResourceAttribute = this.getResourceIdOrThrow(R.styleable.Divider_android_layout_marginRight)
            }
    }

    private fun getTypeAttribute() {
        try {
            typeAttribute = dividerAttributesArray.getIntOrThrow(R.styleable.Divider_type)
        } catch (e: Exception) {
            throw (IllegalArgumentException("⚠️ ⚠️ Missing divider required argument. You MUST set the divider type.", e))
        }
    }

    companion object {
        const val FULLBLEED = 0
        const val INSET = 1
        const val MIDDLE = 2
    }
}
