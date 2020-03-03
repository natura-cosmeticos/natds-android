package com.natura.android.widget

import android.content.Context
import android.os.Build
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.natura.android.R

class TextInputHighlight @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
//TODO: Testar na API 16
    init {
        Build.VERSION_CODES.LOLLIPOP
        LayoutInflater.from(context)
            .inflate(R.layout.ds_input_text_highlight_view, this, true)
    }
}