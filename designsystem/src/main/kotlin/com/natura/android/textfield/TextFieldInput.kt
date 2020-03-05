package com.natura.android.textfield

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.text.InputFilter
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.EditorInfo
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

    override fun setEnabled(enabled: Boolean) {
        if (enabled != isEnabled) {
            if (enabled) resetGeneralColor()
            else borderColor = ContextCompat.getColor(context, R.color.colorDisabled)
        }

        super.setEnabled(enabled)
        inputValue?.isEnabled = enabled
        inputIcon?.isEnabled = enabled
    }

    var inputType: Int = EditorInfo.TYPE_TEXT_VARIATION_NORMAL
        set(value) {
            field = value
            inputValue?.inputType = value
        }

    var hint: String? = null
        set(value) {
            field = value
            inputValue.hint = value
        }

    var maxLength: Int = 0
        set(value) {
            field = value

            val fArray = arrayOfNulls<InputFilter>(1)
            fArray[0] = InputFilter.LengthFilter(value)
            inputValue.filters = fArray
        }

    var maxLines: Int = 0
        set(value) {
            field = value
            inputValue.maxLines = value
        }

    var lines: Int = 0
        set(value) {
            field = value
            inputValue.setLines(value)
        }

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

    var error: String? = null
        set(value) {
            field = value
            footer = value
            if (value != null) {
                state = State.ERROR
            } else {
                state = State.NONE
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

        val vinputType = typedArray.getInteger(R.styleable.ds_text_field_input_android_inputType, EditorInfo.TYPE_TEXT_VARIATION_NORMAL)
        val vhint = typedArray.getString(R.styleable.ds_text_field_input_android_hint)
        val vmaxLength = typedArray.getInteger(R.styleable.ds_text_field_input_android_maxLength, Integer.MAX_VALUE)
        val vmaxLines = typedArray.getInteger(R.styleable.ds_text_field_input_android_maxLines, 1)
        val vlines = typedArray.getInteger(R.styleable.ds_text_field_input_android_lines, 1)
        val venabled = typedArray.getBoolean(R.styleable.ds_text_field_input_android_enabled, true)

        val vlabel = typedArray.getString(R.styleable.ds_text_field_input_text_field_label)
        val vtext = typedArray.getString(R.styleable.ds_text_field_input_text_field_text)
        val vicon = typedArray.getString(R.styleable.ds_text_field_input_text_field_icon)
        val vfooter = typedArray.getString(R.styleable.ds_text_field_input_text_field_footer)
        var vstate = typedArray.getInt(R.styleable.ds_text_field_input_text_field_state, 0)

        typedArray.recycle()

        inputType = vinputType
        hint = vhint
        maxLines = vmaxLines
        maxLength = vmaxLength
        lines = vlines
        isEnabled = venabled

        text = vtext
        label = vlabel
        footer = vfooter
        icon = vicon
        state = intToState(vstate)

        inputValue?.setOnFocusChangeListener { v, hasFocus -> onFocusChanged(v, hasFocus)  }
        inputIcon?.setOnClickListener { v -> onFocusChanged(v, true) }
    }

    private fun onFocusChanged(view: View, hasFocus: Boolean) {
        isEnabled?.let {
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
