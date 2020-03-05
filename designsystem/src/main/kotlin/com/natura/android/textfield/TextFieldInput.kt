package com.natura.android.textfield

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
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

    enum class State {
        NONE, ERROR, SUCCESS
    }

    private val SUCCESS_ICON = "EA1A"
    private val ERROR_ICON = "EA13"

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

    var borderColor: Int = 0
        private set(value) {
            field = value
            (inputBox.background as GradientDrawable).setStroke(resources.getDimensionPixelSize(R.dimen.ds_border), value)
        }

    var state: State = State.NONE
        set(value) {
            field = value
            resetGeneralColor()
            when (value) {
                State.ERROR -> {
                    setFooterIcon(ERROR_ICON, View.VISIBLE)
                }
                State.SUCCESS -> {
                    setFooterIcon(SUCCESS_ICON, View.VISIBLE)
                }
                else -> {
                    setFooterIcon("", View.GONE)
                }
            }
        }

    private fun resetGeneralColor() {
        var color =
            when (state) {
                State.ERROR -> R.color.colorBrdNatRed
                State.SUCCESS -> R.color.colorBrdNatGreen
                else -> R.color.colorHighEmphasis_48
            }

        setGeneralColor(color)
    }

    private fun setGeneralColor(id: Int) {
        val color = ContextCompat.getColor(context, id)

        borderColor = color
        inputLabel.setTextColor(color)
        footerValue.setTextColor(color)
        footerIcon.setTextColor(color)
    }

    private fun setFooterIcon(value: String, visibility: Int) {
        footerIcon.text = value
        footerIcon.visibility = visibility
    }

    private fun changeVisibilityByValue(view: View, value: String?) {
        if (value == null || value.isEmpty()) view.visibility = View.GONE
        else view.visibility = View.VISIBLE
    }

    private fun intToState(vstate: Int)= when(vstate) {
            1 -> State.SUCCESS
            2 -> State.ERROR
            else -> State.NONE
        }

    init {
        View.inflate(context, R.layout.ds_text_field_input, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ds_text_field_input)

        val vlabel = typedArray.getString(R.styleable.ds_text_field_input_text_field_label)
        val vtext = typedArray.getString(R.styleable.ds_text_field_input_text_field_text)
        val vicon = typedArray.getString(R.styleable.ds_text_field_input_text_field_icon)
        val vfooter = typedArray.getString(R.styleable.ds_text_field_input_text_field_footer)
        var vstate = typedArray.getInt(R.styleable.ds_text_field_input_text_field_state, 0)

        typedArray.recycle()

        text = vtext
        label = vlabel
        footer = vfooter
        icon = vicon
        state = intToState(vstate)

        inputValue?.setOnFocusChangeListener { v, hasFocus -> onFocusChanged(v, hasFocus)  }
        inputIcon?.setOnClickListener { v -> onFocusChanged(v, true) }
    }

    private fun onFocusChanged(view: View, hasFocus: Boolean) {
        if (isEnabled) {
            if (hasFocus) {
                borderColor =  ContextCompat.getColor(context, R.color.colorBrdNatOrange)
            } else {
                resetGeneralColor()
            }
        }
    }

    fun setOnIconClickListener(l: OnClickListener?) {
        inputIcon?.setOnClickListener(l)
    }
}
