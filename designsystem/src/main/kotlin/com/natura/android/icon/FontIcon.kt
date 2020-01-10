package com.natura.android.icon

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

class FontIcon @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val natDsFontPath = "fonts/natds_icons.ttf"

    init {
        typeface = Typeface.createFromAsset(context.assets, natDsFontPath)
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        if (text.isNullOrBlank()) {
            super.setText(text, type)
        } else {
            try {
                super.setText(text.toString().toIcon(), type)
            } catch (e: Exception) {
                super.setText("", type)
            }
        }
    }
}

private fun String.toIcon() = String(Character.toChars(Integer.parseInt(this, 16)))
