package com.natura.android.select

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatSpinner
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R
import com.natura.android.databinding.SelectBinding
import com.natura.android.exceptions.LayoutInflateException
import com.natura.android.icon.FontIcon
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getDimenFromTheme

class Select : ConstraintLayout {

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

    var stateLayout = LayoutStates(context)

    private val inputLabel by lazy { findViewById<TextView>(R.id.selectLabel) }

    private val inputBox by lazy { findViewById<LinearLayout>(R.id.selectInputBox) }
    private val inputValue by lazy { findViewById<AppCompatSpinner>(R.id.selectSpinner) }
    private val inputContainerMain by lazy { findViewById<ConstraintLayout>(R.id.selectContainer) }

    private val footerBox by lazy { findViewById<ConstraintLayout>(R.id.footerBox) }
    private val footerValue by lazy { findViewById<TextView>(R.id.selectFooter) }
    private val footerIcon by lazy { findViewById<FontIcon>(R.id.selectFooterIcon) }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        inputLabel?.isEnabled = enabled
        spinner.isEnabled = enabled
        footerIcon?.isEnabled = enabled
        footerValue?.isEnabled = enabled
        inputContainerMain?.isEnabled = enabled

        state = when (enabled) {
            false -> State.NONE
            true -> state
        }

        resetLayoutState()
    }

    private lateinit var typedArray: TypedArray
    private lateinit var binding: SelectBinding

    val spinner: AppCompatSpinner
        get() {
            return inputValue
        }

    var required: Boolean = false

    var size: Int = MEDIUMX
        set(value) {
            field = value
            configureSize()
        }

    var hint: String? = null
        set(value) {
            field = value
            inputValue.prompt = value
        }

    var label: String? = null
        set(value) {
            field = value
            setTextLabel(value)
            changeVisibilityByValue(inputLabel, value)
        }

    var footer: String? = null
        set(value) {
            field = value
            footerValue.text = value
            changeVisibilityByValue(footerBox, value)
        }

    var layoutState = stateLayout.default
        private set(value) {
            field = value
            inputLabel?.setTextColor(value.labelColor)
            (inputBox.background as GradientDrawable).setStroke(
                resources.getDimension(value.borderWidth).toInt(),
                value.borderColor
            )
            footerValue?.setTextColor(value.footerColor)
            (inputBox.background as GradientDrawable).setColor(value.backgroundColor)
            footerIcon?.setTextColor(value.footerColor)
        }

    var state: State = State.NONE
        set(value) {
            field = value
            resetLayoutState()
            if (isEnabled) {
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
            } else {
                setFooterIcon("", View.GONE)
            }
        }

    var error: String? = null
        set(value) {
            field = value
            if (isEnabled) {
                footer = value
                state = if (value != null) {
                    State.ERROR
                } else {
                    State.NONE
                }
            }
        }

    var readOnly: Boolean = false
        set(value) {
            field = value
            configureReadOnly(value)
            resetLayoutState()
        }

    private fun init(context: Context, attrs: AttributeSet? = null) {

        try {
            binding = SelectBinding.inflate(LayoutInflater.from(context), this, true)
        } catch (e: Exception) {
            throw LayoutInflateException()
        }

        if (attrs != null) {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.Select)
        }

        inputValue.isFocusableInTouchMode = true
        inputValue.setOnFocusChangeListener { _, hasFocus -> onFocusChanged(hasFocus) }

        getAttributes()

        typedArray.recycle()
        requestLayout()
    }

    private fun getAttributes() {
        hint = typedArray.getString(R.styleable.Select_android_hint)
        isEnabled = typedArray.getBoolean(R.styleable.Select_android_enabled, true)
        required = typedArray.getBoolean(R.styleable.Select_slc_required, false)
        size = typedArray.getInt(R.styleable.Select_slc_size, MEDIUMX)
        label = typedArray.getString(R.styleable.Select_slc_label)
        footer = typedArray.getString(R.styleable.Select_slc_footer)
        state = intToState(typedArray.getInt(R.styleable.Select_slc_state, 0))
        readOnly = typedArray.getBoolean(R.styleable.Select_slc_readonly, false)
    }

    private fun resetLayoutState() {
        layoutState = if (isEnabled) {
            when (state) {
                State.ERROR -> stateLayout.error
                State.SUCCESS -> stateLayout.success
                else -> {
                    when {
                        readOnly -> stateLayout.readOnly
                        inputContainerMain.isFocused -> stateLayout.focused
                        inputValue.isSelected -> stateLayout.filled
                        else -> stateLayout.default
                    }
                }
            }
        } else {
            stateLayout.disabled
        }
    }

    private fun setFooterIcon(value: String, visibility: Int) {
        footerIcon.text = value
        footerIcon.visibility = visibility
    }

    private fun setTextLabel(label: String?) {
        if (required && !label.isNullOrEmpty()) {
            inputLabel.text = "$label*"
            return
        }
        inputLabel.text = label
    }

    private fun changeVisibilityByValue(view: View, value: String?) {
        if (value == null || value.isEmpty()) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
        }
    }

    private fun onFocusChanged(hasFocus: Boolean) {

        if (hasFocus && !readOnly && isEnabled) {
            layoutState = stateLayout.focused
        } else {
            resetLayoutState()
        }
    }

    private fun configureReadOnly(enabled: Boolean) {
        if (isEnabled) {
            spinner.isClickable = !enabled
            spinner.isFocusableInTouchMode = !enabled
            spinner.isFocusable = !enabled
            spinner.isEnabled = !enabled
        }
    }

    private fun configureSize() {
        val textFieldBoxLayoutParams = inputBox.layoutParams

        when (size) {
            MEDIUM -> {
                textFieldBoxLayoutParams.height =
                    getDimenFromTheme(context, R.attr.sizeMedium).toInt()
                inputBox.setPadding(
                    inputBox.paddingLeft,
                    MEDIUM_PADDING_TOP,
                    inputBox.paddingRight,
                    MEDIUM_PADDING_BOTTOM
                )

                inputValue.dropDownVerticalOffset =
                    getDimenFromTheme(context, R.attr.sizeMedium).toInt()
            }
            else -> {
                textFieldBoxLayoutParams.height =
                    getDimenFromTheme(context, R.attr.sizeMediumX).toInt()
                inputBox.setPadding(
                    inputBox.paddingLeft,
                    MEDIUMX_PADDING_TOP,
                    inputBox.paddingRight,
                    MEDIUMX_PADDING_BOTTOM
                )

                inputValue.dropDownVerticalOffset =
                    getDimenFromTheme(context, R.attr.sizeMediumX).toInt()
            }
        }

        inputBox.layoutParams = textFieldBoxLayoutParams
    }

    private fun intToState(vstate: Int) = when (vstate) {
        1 -> State.SUCCESS
        2 -> State.ERROR
        else -> State.NONE
    }

    enum class State {
        NONE, ERROR, SUCCESS
    }

    companion object {
        const val MEDIUM = 0
        const val MEDIUMX = 1
        const val MEDIUM_PADDING_TOP = 14
        const val MEDIUM_PADDING_BOTTOM = 13
        const val MEDIUMX_PADDING_TOP = 18
        const val MEDIUMX_PADDING_BOTTOM = 17

        private const val SUCCESS_ICON = "EA15"
        private const val ERROR_ICON = "EA13"
    }

    class LayoutStates(val context: Context) {
        private val colorPrimary = getColorTokenFromTheme(context, R.attr.colorPrimary)
        private val colorError = getColorTokenFromTheme(context, R.attr.colorAlert)
        private val colorSuccess = getColorTokenFromTheme(context, R.attr.colorSuccess)
        private val colorLowEmphasis = getColorTokenFromTheme(context, R.attr.colorLowEmphasis)
        private val colorMediumEmphasis =
            getColorTokenFromTheme(context, R.attr.colorMediumEmphasis)
        private val colorHighEmphasis = getColorTokenFromTheme(context, R.attr.colorHighEmphasis)
        private val colorLowEmphasisOpacityDisabledLow =
            getColorTokenFromTheme(context, R.attr.colorLowEmphasisOpacityDisabledLow)
        private val colorHighLightOpacityFull =
            getColorTokenFromTheme(context, R.attr.colorHighLightOpacityFull)

        data class LayoutState(
            val borderWidth: Int,
            val borderColor: Int,
            val labelColor: Int,
            val textColor: Int,
            val footerColor: Int,
            val hintColor: Int,
            val backgroundColor: Int
        )

        val default = LayoutState(
            R.dimen.ds_border_tiny,
            colorLowEmphasis,
            colorMediumEmphasis,
            colorHighEmphasis,
            colorMediumEmphasis,
            colorMediumEmphasis,
            colorHighLightOpacityFull
        )
        val filled = LayoutState(
            R.dimen.ds_border_tiny,
            colorHighEmphasis,
            colorMediumEmphasis,
            colorHighEmphasis,
            colorMediumEmphasis,
            colorMediumEmphasis,
            colorHighLightOpacityFull
        )
        val disabled = LayoutState(
            R.dimen.ds_border_tiny,
            colorLowEmphasis,
            colorLowEmphasis,
            colorLowEmphasis,
            colorLowEmphasis,
            colorLowEmphasis,
            colorHighLightOpacityFull
        )
        val focused = LayoutState(
            R.dimen.ds_border_emphasis,
            colorPrimary,
            colorMediumEmphasis,
            colorHighEmphasis,
            colorMediumEmphasis,
            colorMediumEmphasis,
            colorHighLightOpacityFull
        )
        val error = LayoutState(
            R.dimen.ds_border_emphasis,
            colorError,
            colorError,
            colorHighEmphasis,
            colorError,
            colorMediumEmphasis,
            colorHighLightOpacityFull
        )
        val success = LayoutState(
            R.dimen.ds_border_tiny,
            colorSuccess,
            colorSuccess,
            colorHighEmphasis,
            colorSuccess,
            colorMediumEmphasis,
            colorHighLightOpacityFull
        )

        val readOnly = LayoutState(
            R.dimen.ds_border_tiny,
            colorLowEmphasis,
            colorMediumEmphasis,
            colorHighEmphasis,
            colorMediumEmphasis,
            colorMediumEmphasis,
            colorLowEmphasisOpacityDisabledLow
        )
    }
}
