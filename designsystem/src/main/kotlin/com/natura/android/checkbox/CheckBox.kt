package com.natura.android.checkbox

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox
import com.natura.android.R
import com.natura.android.resources.getColorTokenFromTheme

class CheckBox : AppCompatCheckBox {
    constructor(context: Context) : super(context, null, R.attr.checkboxStyleSecondary) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, R.attr.checkboxStyleSecondary) {
        init()
    }

    var state = UNCHECKED
        set(value) {
            field = value
            refreshDrawableState()
            updateDrawable()
        }

    private lateinit var indeterminateState: IntArray
    private var colorChecked = getColorTokenFromTheme(context, R.attr.colorInputComponent)
    private var colorUnchecked = getColorTokenFromTheme(context, R.attr.colorInputComponent)
    private var colorIndeterminate = getColorTokenFromTheme(context, R.attr.colorInputComponent)
    private var colorDisabled = getColorTokenFromTheme(context, R.attr.colorContentDisabled)

    private fun init() {
        val states = arrayOf(
            intArrayOf(android.R.attr.state_checked, -android.R.attr.state_enabled),
            intArrayOf(-android.R.attr.state_checked, -android.R.attr.state_enabled),
            intArrayOf(android.R.attr.state_checked),
            intArrayOf(-android.R.attr.state_checked),
            intArrayOf(R.attr.state_indeterminate)
        )

        val colors = intArrayOf(
            colorDisabled,
            colorDisabled,
            colorChecked,
            colorUnchecked,
            colorIndeterminate
        )

        buttonTintList = ColorStateList(states, colors)
        updateDrawable()
    }

    private fun updateDrawable() {
        val btnDrawable: Int = when (state) {
            INDETERMINATE -> R.drawable.checkbox_status_indeterminate
            UNCHECKED -> R.drawable.checkbox_status_unchecked
            CHECKED -> R.drawable.checkbox_status_checked
            else -> R.drawable.checkbox_status_unchecked
        }
        setButtonDrawable(btnDrawable)
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        indeterminateState = intArrayOf(R.attr.state_indeterminate)
        val drawableState = super.onCreateDrawableState(extraSpace + 1)
        mergeDrawableStates(drawableState, indeterminateState)
        return drawableState
    }

    override fun setChecked(checked: Boolean) {
        this.state = when (checked) {
            true -> CHECKED
            else -> UNCHECKED
        }
        super.setChecked(checked)
    }

    companion object {
        const val UNCHECKED = 0
        const val INDETERMINATE = 1
        const val CHECKED = 2
    }
}
