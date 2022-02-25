package com.natura.android.counter

import android.content.Context
import android.content.res.TypedArray
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R
import com.natura.android.databinding.CounterBinding
import com.natura.android.exceptions.LayoutInflateException
import com.natura.android.resources.getDimenFromTheme

class Counter : ConstraintLayout {

    private lateinit var typedArray: TypedArray
    private lateinit var binding: CounterBinding

    private val vibrator: Vibrator by lazy { context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator }

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

    var inputValue: Int = MIN_LIMIT
        set(value) {
            field = value
            updateValue(inputValue)
        }

    var label: String? = null
        set(value) {
            field = value
            setTextLabel(value)
            changeLabelVisibility(value)
        }

    var addDescription: String? = null
        set(value) {
            field = value
            setAddAccessibilityDescription(value)
        }

    var subtractDescription: String? = null
        set(value) {
            field = value
            setSubtractAccessibilityDescription(value)
        }

    var size: Int = MEDIUM_SIZE
        set(value) {
            field = value
            configureSize()
        }

    var disabled: Int = NONE_DISABLE
        set(value) {
            field = value
            configureDisabled()
        }

    private fun init(context: Context, attrs: AttributeSet? = null) {

        try {
            binding = CounterBinding.inflate(LayoutInflater.from(context), this, true)
        } catch (e: Exception) {
            throw (LayoutInflateException())
        }

        if (attrs != null) {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.Counter)
        }

        getSelectedAttributes()

        typedArray.recycle()
        requestLayout()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding.ctrInputValue.text = inputValue.toString()
        createListeners()
    }

    fun updateValue(value: Int) {
        binding.ctrInputValue.text = value.toString()
    }

    private fun createListeners() {
        binding.ctrAddButton.setOnClickListener {
            vibrate()
            incrementValue()
            updateValue(inputValue)
        }
        binding.ctrSubtractButton.setOnClickListener {
            vibrate()
            decrementValue()
            updateValue(inputValue)
        }
    }

    private fun incrementValue() {
        if (inputValue < MAX_LIMIT) {
            inputValue += 1
        }
    }

    private fun decrementValue() {
        if (inputValue > MIN_LIMIT) {
            inputValue -= 1
        }
    }

    private fun getSelectedAttributes() {
        size = typedArray.getInt(R.styleable.Counter_ctr_size, MEDIUM_SIZE)
        disabled = typedArray.getInt(R.styleable.Counter_ctr_disabled, NONE_DISABLE)
        label = typedArray.getString(R.styleable.Counter_ctr_label)
        addDescription = typedArray.getString(R.styleable.Counter_ctr_add_description)
        subtractDescription = typedArray.getString(R.styleable.Counter_ctr_subtract_description)
    }

    private fun configureSize() {
        when (size) {
            SEMIX_SIZE -> {
                setDimensions(R.attr.sizeSemiX, R.attr.sizeSemi, R.attr.sizeSemi, R.attr.sizeSemiX)
            }
            MEDIUM_SIZE -> {
                setDimensions(R.attr.sizeMedium, R.attr.sizeSemiX, R.attr.sizeSemiX, R.attr.sizeSemiX)
            }
            else -> {
                setDimensions(R.attr.sizeMedium, R.attr.sizeSemiX, R.attr.sizeSemiX, R.attr.sizeSemiX)
            }
        }
    }

    private fun setDimensions(viewGroupDimenAttr: Int, subtractDimenAttr: Int, addButtonDimenAttr: Int, editTextDimenAttr: Int) {
        val subtractButtonLayoutParams = binding.ctrSubtractButton.layoutParams
        val addButtonLayoutParams = binding.ctrAddButton.layoutParams
        val inputLayoutParams = binding.ctrInputValue.layoutParams
        val viewGroup = binding.ctrBox.layoutParams

        viewGroup.height = getDimenFromTheme(context, viewGroupDimenAttr).toInt()

        subtractButtonLayoutParams.width = getDimenFromTheme(context, subtractDimenAttr).toInt()
        addButtonLayoutParams.width = getDimenFromTheme(context, addButtonDimenAttr).toInt()
        inputLayoutParams.width = getDimenFromTheme(context, editTextDimenAttr).toInt()

        binding.ctrSubtractButton.layoutParams = subtractButtonLayoutParams
        binding.ctrAddButton.layoutParams = addButtonLayoutParams
        binding.ctrInputValue.layoutParams = inputLayoutParams
        binding.ctrBox.layoutParams = viewGroup
    }

    private fun configureDisabled() {
        when (disabled) {
            SUBTRACT_DISABLE -> {
                binding.ctrSubtractButton.isEnabled = false
                binding.ctrAddButton.isEnabled = true
            }
            ADD_DISABLE -> {
                binding.ctrSubtractButton.isEnabled = true
                binding.ctrAddButton.isEnabled = false
            }
            ALL_DISABLE -> {
                binding.ctrSubtractButton.isEnabled = false
                binding.ctrAddButton.isEnabled = false
            }
            NONE_DISABLE -> {
                binding.ctrSubtractButton.isEnabled = true
                binding.ctrAddButton.isEnabled = true
            }
            else -> {
                binding.ctrSubtractButton.isEnabled = true
                binding.ctrAddButton.isEnabled = true
            }
        }
    }

    private fun setTextLabel(label: String?) {
        binding.ctrLabel.text = label
    }

    private fun setAddAccessibilityDescription(description: String?) {
        binding.ctrAddButton.contentDescription = description
    }

    private fun setSubtractAccessibilityDescription(description: String?) {
        binding.ctrSubtractButton.contentDescription = description
    }

    private fun changeLabelVisibility(value: String?) {
        if (value == null || value.isEmpty()) {
            binding.ctrLabel.visibility = View.GONE
        } else {
            binding.ctrLabel.visibility = View.VISIBLE
        }
    }

    private fun vibrate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(20, -1))
        } else {
            vibrator.vibrate(20)
        }
    }

    companion object {
        const val SEMIX_SIZE = 0
        const val MEDIUM_SIZE = 1

        const val NONE_DISABLE = 0
        const val SUBTRACT_DISABLE = 1
        const val ADD_DISABLE = 2
        const val ALL_DISABLE = 3

        private const val MAX_LIMIT = 99
        private const val MIN_LIMIT = 0
    }
}
