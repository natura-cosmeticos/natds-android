package com.natura.android.appbartop

import android.animation.ObjectAnimator
import android.animation.StateListAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.resources.getColorTokenFromTheme

open class BaseAppBarTop(context: Context, attrs: AttributeSet) : AppBarLayout(context, attrs) {

    private var typedArray: TypedArray

    var barColor: Int = DEFAULT
        set(value) {
            field = value
            setColor(value)
        }

    var enabledElevation: Boolean = true
        set(value) {
            field = value
            setElevation(value)
        }

    var scrollable: Boolean = false
        set(value) {
            field = value
            handleScroll(value)
        }

    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }

    init {

        try {
            View.inflate(context, R.layout.base_appbar_top, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        typedArray = context.obtainStyledAttributes(attrs, R.styleable.BaseAppBarTop)

        initialConfigurations()
        getAttributes()
        typedArray.recycle()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        resetProperties()
        moveGivenChildrenToToolbarArea()
        removeParentsElevation()
    }

    private fun resetProperties() {
        toolbar.title = ""
        toolbar.navigationIcon = null
    }

    private fun initialConfigurations() {
        toolbar.contentInsetStartWithNavigation = 0
        clipToPadding = false
        clipChildren = false
    }

    private fun getAttributes() {
        enabledElevation = typedArray.getBoolean(R.styleable.BaseAppBarTop_enabledElevation, true)
        barColor = typedArray.getInt(R.styleable.BaseAppBarTop_appBarColor, DEFAULT)
        scrollable = typedArray.getBoolean(R.styleable.BaseAppBarTop_scrollable, false)
    }

    private fun setColor(color: Int) {
        setBackgroundColor(Color.TRANSPARENT)

        toolbar.setBackgroundColor(
            when (color) {
                DEFAULT -> getColorTokenFromTheme(context, R.attr.colorSurface)
                PRIMARY -> getColorTokenFromTheme(context, R.attr.colorPrimary)
                INVERSE -> getColorTokenFromTheme(context, R.attr.colorHighEmphasis)
                else -> Color.TRANSPARENT
            }
        )
    }

    private fun setElevation(enabledElevation: Boolean) {
        if (enabledElevation) {
            toolbar.elevation = getElevationFromTheme(context)
        } else {
            toolbar.elevation = 0F
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
        val stListAnimator = StateListAnimator()
        stListAnimator.addState(
            IntArray(0),
            ObjectAnimator.ofFloat(this, "elevation", 0.1F)
        )
        stateListAnimator = stListAnimator
    }

    private fun moveGivenChildrenToToolbarArea() {
        while (haveChildrenToMove()) {
            val child = getNextChild()
            removeView(child)
            toolbar.addView(child)
        }
    }

    private fun handleScroll(scrollable: Boolean) {
        val params = toolbar.layoutParams as LayoutParams
        params.scrollFlags = when (scrollable) {
            true -> (LayoutParams.SCROLL_FLAG_SCROLL)
            false -> (LayoutParams.SCROLL_FLAG_NO_SCROLL)
        }
    }

    private fun haveChildrenToMove(): Boolean = getChildAt(1) != null

    private fun getNextChild(): View? = getChildAt(1)

    companion object {
        const val DEFAULT = 0
        const val PRIMARY = 1
        const val NONE = 2
        const val INVERSE = 3
    }
}
