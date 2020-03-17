package com.natura.android.button

import android.annotation.SuppressLint
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.View
import com.natura.android.R
import com.natura.android.icon.FontIcon

@SuppressLint("CustomViewStyleable")
class DsPrimaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    // TODO remover esta classe pois android.support.design.button.MaterialButton ja atende
    private val buttonLabel by lazy { findViewById<AppCompatTextView>(R.id.button_primary_text) }
    private val buttonIconLeft by lazy { findViewById<FontIcon>(R.id.button_primary_icon_left) }
    private val buttonIconRight by lazy { findViewById<FontIcon>(R.id.button_primary_icon_right) }
    private val buttonMainContent by lazy { findViewById<ConstraintLayout>(R.id.primary_button_main) }

    var label: String? = ""
        set(value) {
            field = value
            buttonLabel.text = value
        }

    var iconLeft: String? = ""
        set(value) {
            field = value
            buttonIconLeft.text = value
        }

    var iconRight: String? = ""
        set(value) {
            field = value
            buttonIconRight.text = value
        }

    var clickListener: (() -> Unit)? = null

    init {
        View.inflate(context, R.layout.ds_primary_button, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ds_primary_button)
        val labelText = typedArray.getString(R.styleable.ds_primary_button_button_label)
        val iconLeftText = typedArray.getString(R.styleable.ds_primary_button_button_icon_left)
        val iconRightText = typedArray.getString(R.styleable.ds_primary_button_button_icon_right)
        val enabled = typedArray.getBoolean(R.styleable.ds_primary_button_button_enabled, true)

        typedArray.recycle()

        label = labelText
        iconLeft = iconLeftText
        iconRight = iconRightText
        isEnabled = enabled

        buttonMainContent.setOnClickListener {
            clickListener?.invoke()
        }
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        buttonMainContent.isEnabled = enabled
        isClickable = !enabled
        if (isEnabled) {
            buttonLabel.setTextColor(ContextCompat.getColor(context, R.color.colorBrdNatGray))
        } else {
            buttonLabel.setTextColor(ContextCompat.getColor(context, R.color.colorBrdNatGray_48))
        }
    }
}
