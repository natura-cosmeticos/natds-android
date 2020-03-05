package com.natura.android.textfield

import android.annotation.SuppressLint
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.natura.android.R
import com.natura.android.icon.FontIcon


@SuppressLint("CustomViewStyleable")
class TextFieldInput @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val inputLabel by lazy { findViewById<TextView>(R.id.text_field_input_label) }

    private val inputBox by lazy { findViewById<LinearLayout>(R.id.text_field_input_box) }
    private val inputValue by lazy { findViewById<EditText>(R.id.text_field_input_value) }
    private val inputIcon by lazy { findViewById<FontIcon>(R.id.text_field_input_icon) }

    private val footerBox by lazy { findViewById<LinearLayout>(R.id.text_field_input_footer_box) }
    private val footerValue by lazy { findViewById<TextView>(R.id.text_field_input_footer) }
    private val footerIcon by lazy { findViewById<FontIcon>(R.id.text_field_input_footer_icon) }

    var text: String? = null
        set(value) {
            field = value
            inputValue.setText(value)
        }

    var icon: String? = null
        set(value) {
            field = value
            inputIcon.setText(value)
            changeVisibilityByValue(inputIcon, value)
        }

    var label: String? = null
        set(value) {
            field = value
            inputLabel.text = value
            changeVisibilityByValue(inputLabel, value)
        }

    var footer: String? = null
        set(value) {
            field = value
            footerValue.text = value
            changeVisibilityByValue(footerBox, value)
        }


    private fun changeVisibilityByValue(view: View, value: String?) {
        if (value == null || value.isEmpty()) view.visibility = View.GONE
        else view.visibility = View.VISIBLE
    }

    init {
        View.inflate(context, R.layout.ds_text_field_input, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ds_text_field_input)

        val vlabel = typedArray.getString(R.styleable.ds_text_field_input_text_field_label)
        val vtext = typedArray.getString(R.styleable.ds_text_field_input_text_field_text)
        val vicon = typedArray.getString(R.styleable.ds_text_field_input_text_field_icon)
        val vfooter = typedArray.getString(R.styleable.ds_text_field_input_text_field_footer)

        typedArray.recycle()

        text = vtext
        label = vlabel
        footer = vfooter
        icon = vicon
    }
}
