package com.natura.android.menu

import android.annotation.SuppressLint
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.natura.android.R

@SuppressLint("CustomViewStyleable")
class SubMenuView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val textLabel by lazy { findViewById<AppCompatTextView>(R.id.ds_submenu_label) }
    private val labelContainer by lazy { findViewById<View>(R.id.ds_submenu_view_selected) }

    private val selectedColor: Int

    var label: String? = ""
        set(value) {
            field = value
            textLabel.text = value
        }

    init {
        View.inflate(context, R.layout.ds_submenu_view, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ds_submenu)
        val labelText = typedArray.getString(R.styleable.ds_submenu_submenu_label)
        val labelColor = typedArray.getResourceId(
            R.styleable.ds_submenu_submenu_label_color,
            R.color.colorBrdNatGray
        )
        val labelSize = typedArray.getResourceId(
            R.styleable.ds_submenu_submenu_label_size,
            R.dimen.ds_text_small
        )
        selectedColor = typedArray.getResourceId(
            R.styleable.ds_submenu_submenu_selected_drawable,
            R.drawable.ds_menu_item_selected
        )
        val isSelected = typedArray.getBoolean(R.styleable.ds_submenu_submenu_is_selected, false)
        val isEnabled = typedArray.getBoolean(R.styleable.ds_submenu_submenu_is_enabled, true)

        typedArray.recycle()

        configLabel(labelText, labelColor, labelSize)
        setSelected(isSelected)
        setEnabled(isEnabled)
    }

    private fun configLabel(labelText: String?, labelColor: Int, labelSize: Int) {
        label = labelText
        textLabel.setTextColor(ContextCompat.getColor(context, labelColor))
        textLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(labelSize))
    }

    override fun setSelected(selected: Boolean) {
        super.setSelected(selected)

        labelContainer.apply {
            if (isSelected) setBackgroundResource(selectedColor)
            else setBackgroundResource(0)
        }
    }

    override fun setEnabled(isEnabled: Boolean) {
        super.setEnabled(isEnabled)
        isClickable = !isEnabled
        textLabel.isEnabled = isEnabled
        textLabel.apply {
            if (isEnabled) setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorBrdNatGray
                )
            )
            else setTextColor(ContextCompat.getColor(context, R.color.colorBrdNatGray_48))
        }
    }
}
