package com.natura.android.menu

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.natura.android.R

@SuppressLint("CustomViewStyleable")
class SubMenuView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val textLabel by lazy { findViewById<AppCompatTextView>(R.id.ds_submenu_label) }
    private val labelContainer by lazy { findViewById<View>(R.id.ds_submenu_view_selected) }

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
        val selectedDrawable = typedArray.getResourceId(
            R.styleable.ds_submenu_submenu_selected_drawable,
            R.drawable.ds_menu_item_selected
        )
        val isSelected = typedArray.getBoolean(R.styleable.ds_submenu_submenu_is_selected, false)
        val isEnabled = typedArray.getBoolean(R.styleable.ds_submenu_submenu_is_enabled, true)

        typedArray.recycle()

        configLabel(labelText, labelColor, labelSize)
        configSelected(isSelected, selectedDrawable)
        setEnable(isEnabled)
    }

    private fun configLabel(labelText: String?, labelColor: Int, labelSize: Int) {
        textLabel.text = labelText
        textLabel.setTextColor(ContextCompat.getColor(context, labelColor))
        textLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(labelSize))
    }

    private fun configSelected(isSelected: Boolean, selectedColor: Int) {
        labelContainer.apply {
            if (isSelected) setBackgroundResource(selectedColor)
            else setBackgroundResource(0)
        }
    }

    private fun setEnable(isEnabled: Boolean) {
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
