package com.natura.android.counter

import android.content.Context
import android.content.res.TypedArray
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.InputFilter
import android.text.Spanned
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

    private var initialValue = 0

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

    var label: String? = null
        set(value) {
            field = value
            setTextLabel(value)
            changeLabelVisibility(value)
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
        setNumberLimits()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        fun updateValue(value: Int) {
            binding.ctrInputValue.text = value.toString()
        }

        binding.ctrInputValue.text = initialValue.toString()
        binding.ctrAddButton.setOnClickListener {
            vibrate()
            initialValue += 1
            updateValue(initialValue)
        }
        binding.ctrSubtractButton.setOnClickListener {
            vibrate()
            initialValue -= 1
            updateValue(initialValue)
        }
    }

    private fun getSelectedAttributes() {
        size = typedArray.getInt(R.styleable.Counter_ctr_size, MEDIUM_SIZE)
        disabled = typedArray.getInt(R.styleable.Counter_ctr_disabled, NONE_DISABLE)
        label = typedArray.getString(R.styleable.Counter_ctr_label)
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
        val editTextLayoutParams = binding.ctrInputValue.layoutParams
        val viewGroup = binding.ctrBox.layoutParams

        viewGroup.height = getDimenFromTheme(context, viewGroupDimenAttr).toInt()

        subtractButtonLayoutParams.width = getDimenFromTheme(context, subtractDimenAttr).toInt()
        addButtonLayoutParams.width = getDimenFromTheme(context, addButtonDimenAttr).toInt()
        editTextLayoutParams.width = getDimenFromTheme(context, editTextDimenAttr).toInt()
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

    private fun changeLabelVisibility(value: String?) {
        if (value == null || value.isEmpty()) {
            binding.ctrLabel.visibility = View.GONE
        } else {
            binding.ctrLabel.visibility = View.VISIBLE
        }
    }

    private fun setNumberLimits() {
        binding.ctrInputValue.filters = arrayOf<InputFilter>(MinMaxFilter(0, 99))
    }

    private fun vibrate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(20, -1))
        } else {
            vibrator.vibrate(20)
        }
    }

    // Custom class to define min and max for the Edit Text
    inner class MinMaxFilter() : InputFilter {
        private var minValue: Int = 0
        private var maxValue: Int = 0

        constructor(minValue: Int, maxValue: Int) : this() {
            this.minValue = minValue
            this.maxValue = maxValue
        }

        override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned, dStart: Int, dEnd: Int): CharSequence? {
            try {
                val input = Integer.parseInt(dest.toString() + source.toString())
                if (isInRange(minValue, maxValue, input)) {
                    return null
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
            return ""
        }

        private fun isInRange(minValue: Int, maxValue: Int, value: Int): Boolean {
            return if (maxValue > minValue) value in minValue..maxValue else value in maxValue..minValue
        }
    }

    companion object {
        const val SEMIX_SIZE = 0
        const val MEDIUM_SIZE = 1

        const val NONE_DISABLE = 0
        const val SUBTRACT_DISABLE = 1
        const val ADD_DISABLE = 2
        const val ALL_DISABLE = 3
    }
}
