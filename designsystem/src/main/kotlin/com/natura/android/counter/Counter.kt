package com.natura.android.counter

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R

class Counter : ConstraintLayout {

    private var attrs: AttributeSet? = null
    private lateinit var typedArray: TypedArray

    constructor(context: Context) :
        super(context)

    constructor(context: Context, attrs: AttributeSet?) :
        super(context, attrs) {
            this.attrs = attrs
        }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) :
        super(context, attrs, defStyleAttr) {
            this.attrs = attrs
        }

    var label: String? = null
        set(value) {
            field = value
            setTextLabel(value)
        }

    var size: Int = MEDIUM_SIZE
        set(value) {
            field = value
            configureSize()
        }

    var disabled: Int = NONE_DISABLE
        set(value) {
            field = value
            configureDisabled()
        }

    init {

        this.let {
            View.inflate(context, R.layout.counter, it)
        }

        if (attrs != null) {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.Counter)
        }

        getSelectedAttributes()
    }

    private fun getSelectedAttributes() {
        size = typedArray.getInt(R.styleable.Counter_ctr_size, MEDIUM_SIZE)
        disabled = typedArray.getInt(R.styleable.Counter_ctr_disabled, NONE_DISABLE)
        label = typedArray.getString(R.styleable.Counter_ctr_label)
    }

    private fun configureSize() {
    }

    private fun configureDisabled() {
    }

    private fun setTextLabel(label: String?) {
    }

    private fun changeVisibilityByValue(view: View, value: String?) {
        if (value == null || value.isEmpty()) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
        }
    }

    companion object {
        const val SEMIX_SIZE = 0
        const val MEDIUM_SIZE = 1

        const val NONE_DISABLE = 0
        const val SUBTRACT_DISABLE = 1
        const val ADD_DISABLE = 2
        const val ALL_DISABLE = 3
    }
}
