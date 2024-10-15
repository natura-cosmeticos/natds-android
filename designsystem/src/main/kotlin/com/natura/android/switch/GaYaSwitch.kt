package com.natura.android.switch

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.SwitchCompat
import com.natura.android.R
import com.natura.android.resources.getColorTokenFromTheme

class GaYaSwitch : SwitchCompat {

    constructor(context: Context) : super(context, null, R.attr.switchStyle) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(
        context,
        attrs,
        R.attr.switchStyle
    ) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    constructor(context: Context, themeResId: Int) : super(
        ContextThemeWrapper(context, themeResId),
        null,
        R.attr.switchStyle
    ) {
        init()
    }

    private val colorCheckedThumb by lazy {
        getColorTokenFromTheme(
            context,
            R.attr.colorInputComponent
        )
    }
    private val colorUncheckedThumb by lazy { getColorTokenFromTheme(context, R.attr.colorSurface) }
    private val colorDisabledThumb by lazy {
        getColorTokenFromTheme(
            context,
            R.attr.colorNeutral400
        )
    }

    private val colorCheckedTrack by lazy {
        adjustAlpha(
            getColorTokenFromTheme(
                context,
                R.attr.colorInputComponent
            )
        )
    }
    private val colorUncheckedTrack by lazy {
        adjustAlpha(
            getColorTokenFromTheme(
                context,
                R.attr.colorNeutral900
            )
        )
    }
    private val colorDisabledTrack by lazy {
        adjustAlpha(
            getColorTokenFromTheme(
                context,
                R.attr.colorNeutral900
            )
        )
    }

    private val thumbColorStateList by lazy {
        val states = arrayOf(
            intArrayOf(
                android.R.attr.state_checked,
                -android.R.attr.state_enabled
            ),
            intArrayOf(
                -android.R.attr.state_checked,
                -android.R.attr.state_enabled
            ),
            intArrayOf(android.R.attr.state_checked),
            intArrayOf(-android.R.attr.state_checked)
        )

        val colors = intArrayOf(
            colorDisabledThumb,
            colorDisabledThumb,
            colorCheckedThumb,
            colorUncheckedThumb
        )

        ColorStateList(states, colors)
    }

    private val trackColorStateList by lazy {
        val states = arrayOf(
            intArrayOf(
                android.R.attr.state_checked,
                -android.R.attr.state_enabled
            ),
            intArrayOf(
                -android.R.attr.state_checked,
                -android.R.attr.state_enabled
            ),
            intArrayOf(android.R.attr.state_checked),
            intArrayOf(-android.R.attr.state_checked)
        )

        val colors = intArrayOf(
            colorDisabledTrack,
            colorDisabledTrack,
            colorCheckedTrack,
            colorUncheckedTrack
        )

        ColorStateList(states, colors)
    }

    private fun init() {
        thumbTintList = thumbColorStateList
        trackTintList = trackColorStateList
    }

    private fun adjustAlpha(color: Int): Int {
        val alpha = Math.round(Color.alpha(color) * 0.48f)
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)
        return Color.argb(alpha, red, green, blue)
    }
}
