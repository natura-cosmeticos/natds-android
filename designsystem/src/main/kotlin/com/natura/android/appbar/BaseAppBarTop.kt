package com.natura.android.appbar

import android.animation.ObjectAnimator
import android.animation.StateListAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.natura.android.R
import com.natura.android.resources.getColorTokenFromTheme

open class BaseAppBarTop(context: Context, attrs: AttributeSet) : Toolbar(context, attrs) {

    private var typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.BaseAppBarTop)

    private var barColor: Int = DEFAULT
        set(value) {
            field = value
            setColor(value)
        }

    private var enabledElevation: Boolean = true
        set(value) {
            field = value
            setElevation()
        }

    init {
        resetProperties()
        getAttributes()
        typedArray.recycle()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        removeParentsElevation()
    }

    private fun resetProperties() {
        title = ""
        contentInsetStartWithNavigation = 0
    }

    private fun getAttributes() {
        enabledElevation = typedArray.getBoolean(R.styleable.BaseAppBarTop_enabledElevation, true)
        barColor = typedArray.getInt(R.styleable.BaseAppBarTop_appBarColor, DEFAULT)
    }

    private fun setColor(color: Int) {
        this.setBackgroundColor(
            when (color) {
                DEFAULT -> getColorTokenFromTheme(context, R.attr.colorSurface)
                PRIMARY -> getColorTokenFromTheme(context, R.attr.colorPrimary)
                INVERSE -> getColorTokenFromTheme(context, R.attr.colorHighEmphasis)
                else -> Color.TRANSPARENT
            }
        )
    }

    private fun setElevation() {
        if (enabledElevation) {
            elevation = getElevationFromTheme(context)
        } else {
            this.elevation = 0F
        }
    }

    private fun getElevationFromTheme(context: Context): Float {
        val typedValue = TypedValue()
        if (context.theme.resolveAttribute(R.attr.elevation02, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, resources.displayMetrics)
                .toFloat()
        }

        return 0f
    }

    private fun removeParentsElevation() {
        if (parent is AppBarLayout) {

            val stateListAnimator = StateListAnimator()
            stateListAnimator.addState(
                IntArray(0),
                ObjectAnimator.ofFloat(this, "elevation", 0.1F)
            )
            (parent as AppBarLayout).stateListAnimator = stateListAnimator
        }
    }

    companion object {
        const val DEFAULT = 0
        const val PRIMARY = 1
        const val NONE = 2
        const val INVERSE = 3
    }
}
