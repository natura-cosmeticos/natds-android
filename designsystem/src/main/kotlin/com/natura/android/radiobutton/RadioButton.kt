package com.natura.android.radiobutton

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatRadioButton
import com.natura.android.R

class RadioButton : AppCompatRadioButton {
    constructor(context: Context) :
        super(context, null, R.attr.radioButtonStyle)
    constructor(context: Context, attrs: AttributeSet?) :
        super(context, attrs, R.attr.radioButtonStyle)
}
