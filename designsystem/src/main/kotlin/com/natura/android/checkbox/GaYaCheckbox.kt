package com.natura.android.checkbox

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatCheckBox
import com.natura.android.R
import com.natura.android.resources.getColorTokenFromTheme

class GaYaCheckbox : AppCompatCheckBox {

    constructor(context: Context) : super(context, null, R.attr.checkboxStyleSecondary) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(
        context,
        attrs,
        R.attr.checkboxStyleSecondary
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
        R.attr.checkboxStyleSecondary
    ) {
        init()
    }

    private fun init() {
        val colorChecked = getColorTokenFromTheme(context, R.attr.colorInputComponent)
        val colorUnchecked = getColorTokenFromTheme(context, R.attr.colorInputComponent)
        val colorIndeterminate = getColorTokenFromTheme(context, R.attr.colorInputComponent)
        val colorDisabled = getColorTokenFromTheme(context, R.attr.colorContentDisabled)

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

    var state = GaYaCheckboxState.UNCHECKED
        set(value) {
            field = value
            refreshDrawableState()
            updateDrawable()
        }

    private lateinit var indeterminateState: IntArray

    private var onStateChangedListener: ((GaYaCheckboxState) -> Unit)? = null

    fun setOnStateChangedListener(listener: (GaYaCheckboxState) -> Unit) {
        onStateChangedListener = listener
    }

    private fun updateDrawable() {
        val btnDrawable = when (state) {
            GaYaCheckboxState.INDETERMINATE -> R.drawable.checkbox_status_indeterminate
            GaYaCheckboxState.UNCHECKED -> R.drawable.checkbox_status_unchecked
            GaYaCheckboxState.CHECKED -> R.drawable.checkbox_status_checked
        }
        setButtonDrawable(btnDrawable)
        onStateChangedListener?.invoke(state)
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        indeterminateState = intArrayOf(R.attr.state_indeterminate)
        val drawableState = super.onCreateDrawableState(extraSpace + 1)
        mergeDrawableStates(drawableState, indeterminateState)
        return drawableState
    }

    override fun setChecked(checked: Boolean) {
        this.state = when (checked) {
            true -> GaYaCheckboxState.CHECKED
            else -> GaYaCheckboxState.UNCHECKED
        }
        super.setChecked(checked)
    }
}

enum class GaYaCheckboxState {
    UNCHECKED, CHECKED, INDETERMINATE
}
