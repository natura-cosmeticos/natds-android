package com.natura.android.radiobutton

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatRadioButton
import com.natura.android.R
import com.natura.android.resources.getColorTokenFromTheme

class GaYaRadiobutton : AppCompatRadioButton {

    constructor(context: Context) : super(context, null, R.attr.radioButtonStyle) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(
        context,
        attrs,
        R.attr.radioButtonStyle
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
        R.attr.radioButtonStyle
    ) {
        init()
    }

    private val colorChecked by lazy { getColorTokenFromTheme(context, R.attr.colorInputComponent) }
    private val colorUnchecked by lazy {
        getColorTokenFromTheme(
            context,
            R.attr.colorInputComponent
        )
    }
    private val colorDisabled by lazy {
        getColorTokenFromTheme(
            context,
            R.attr.colorContentDisabled
        )
    }

    private val colorStateList by lazy {
        val states = arrayOf(
            intArrayOf(android.R.attr.state_checked, -android.R.attr.state_enabled),
            intArrayOf(-android.R.attr.state_checked, -android.R.attr.state_enabled),
            intArrayOf(android.R.attr.state_checked),
            intArrayOf(-android.R.attr.state_checked)
        )

        val colors = intArrayOf(
            colorDisabled,
            colorDisabled,
            colorChecked,
            colorUnchecked
        )

        ColorStateList(states, colors)
    }

    private fun init() {
        buttonTintList = colorStateList
    }
}
