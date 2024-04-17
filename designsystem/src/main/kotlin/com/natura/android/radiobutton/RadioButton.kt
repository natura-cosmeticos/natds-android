package com.natura.android.radiobutton

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatRadioButton
import com.natura.android.R
import com.natura.android.resources.getColorTokenFromTheme

class RadioButton : AppCompatRadioButton {
    constructor(context: Context) : super(context, null, R.attr.radioButtonStyle) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, R.attr.radioButtonStyle) {
        init()
    }

    private var colorChecked = getColorTokenFromTheme(context, R.attr.colorInputComponent)
    private var colorUnchecked = getColorTokenFromTheme(context, R.attr.colorInputComponent)
    private var colorDisabled = getColorTokenFromTheme(context, R.attr.colorContentDisabled)

    private fun init() {
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

        buttonTintList = ColorStateList(states, colors)
    }
}
