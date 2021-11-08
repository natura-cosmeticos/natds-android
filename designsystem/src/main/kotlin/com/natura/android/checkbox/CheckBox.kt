package com.natura.android.checkbox

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox
import com.natura.android.R

class CheckBox : AppCompatCheckBox {
    constructor(context: Context) :
        super(context, null, R.attr.checkboxPrimary) {
            init()
        }
    constructor(context: Context, attrs: AttributeSet?) :
        super(context, attrs, R.attr.checkboxPrimary) {
            init()
        }

    var state = UNCHECKED
        get() = field
        set(value) {
            field = value
            refreshDrawableState()
            updateDrawable()
        }

    private lateinit var STATE_INDETERMINATE: IntArray

    private fun init() {
        updateDrawable()
    }

    private fun updateDrawable() {
        var btnDrawable = R.drawable.checkbox_status_indeterminate
        btnDrawable = when (state) {
            INDETERMINATE -> R.drawable.checkbox_status_indeterminate
            UNCHECKED -> R.drawable.checkbox_status_unchecked
            CHECKED -> R.drawable.checkbox_status_checked
            else -> R.drawable.checkbox_status_unchecked
        }
        setButtonDrawable(btnDrawable)
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        STATE_INDETERMINATE = intArrayOf(R.attr.state_indeterminate)
        val drawableState = super.onCreateDrawableState(extraSpace + 1)
        mergeDrawableStates(drawableState, STATE_INDETERMINATE)
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
