package com.natura.android.checkbox

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox
import com.natura.android.R

class CheckBox @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.checkboxPrimary
) : AppCompatCheckBox(context, attrs, defStyleAttr) {

    private var state = 0
    private lateinit var STATE_INDETERMINATE: IntArray

    init {
        state = UNCHECKED
        updateDrawable()
        setOnCheckedChangeListener { _, _ ->
            state = when (state) {
                UNCHECKED -> CHECKED
                CHECKED -> UNCHECKED
                else -> CHECKED
            }
            updateDrawable()
        }
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

    fun setState(state: Int) {
        this.state = state
        updateDrawable()
    }

    companion object {
        const val UNCHECKED = 0
        const val INDETERMINATE = 1
        const val CHECKED = 2
    }
}
