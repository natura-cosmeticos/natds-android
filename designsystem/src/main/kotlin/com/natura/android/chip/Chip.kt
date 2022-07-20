package com.natura.android.chip

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

class Chip : ConstraintLayout {

    constructor(context: Context) :
        super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) :
        super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) :
        super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet? = null) {
        requestLayout()
    }
}