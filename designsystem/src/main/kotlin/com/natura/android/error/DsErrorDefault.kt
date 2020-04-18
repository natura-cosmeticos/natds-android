package com.natura.android.error

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R
import com.natura.android.button.DsPrimaryButton

@SuppressLint("CustomViewStyleable")
class DsErrorDefault @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    // TODO mover esta classe para com.natura.android.pattern
    private val erroIcon by lazy { findViewById<AppCompatImageView>(R.id.ds_default_error_icon) }
    private val errorLabel by lazy { findViewById<AppCompatTextView>(R.id.ds_default_error_label) }
    private val errorButton by lazy { findViewById<DsPrimaryButton>(R.id.ds_default_error_button) }

    var listener: (() -> Unit)? = null

    var label: String? = ""
        set(value) {
            field = value
            errorLabel.text = value
        }

    var icon: Int = 0
        set(value) {
            field = value
            erroIcon.setImageResource(icon)
        }

    var labelButton: String? = ""
        set(value) {
            field = value
            errorButton.label = value
        }

    init {
        View.inflate(context, R.layout.ds_default_error, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ds_error_default)
        val labelText = typedArray.getString(R.styleable.ds_error_default_error_label)
        val labelButtonText = typedArray.getString(R.styleable.ds_error_default_error_button_label)
        val iconDrawable = typedArray.getResourceId(R.styleable.ds_error_default_error_icon, 0)

        typedArray.recycle()
        label = labelText
        icon = iconDrawable
        labelButton = labelButtonText

        configListener()
    }

    private fun configListener() {
        errorButton.clickListener = { listener?.invoke() }
    }
}
