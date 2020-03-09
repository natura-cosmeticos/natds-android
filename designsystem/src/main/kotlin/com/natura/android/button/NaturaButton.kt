package com.natura.android.button

import android.content.Context
import android.support.design.button.MaterialButton
import android.util.AttributeSet

class NaturaButton : MaterialButton {

    constructor(context: Context): super(context)

    constructor(context: Context,
                attrs: AttributeSet): super(context, attrs)

    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    ) : super(context, attrs, defStyleAttr)
}