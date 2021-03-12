package com.natura.android.checkbox

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox
import com.natura.android.R

class CheckBox @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.checkboxPrimary
) : AppCompatCheckBox(context, attrs, defStyleAttr)
