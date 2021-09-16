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
import com.natura.android.resources.getColorTokenFromTheme

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

    var isLowEmphasis: Boolean = false
        set(value) {
            field = value
            setLabelColorLowEmphasis(value)
        }

    init {
        View.inflate(context, R.layout.ds_submenu_view, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ds_submenu)
        val labelText = typedArray.getString(R.styleable.ds_submenu_submenu_label)
        var labelColor = typedArray.getResourceId(
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
        val isLowEmphasis = typedArray.getBoolean(R.styleable.ds_menu_menu_color_lowemphasis, false)

        typedArray.recycle()

        if (isLowEmphasis) {
            labelColor = typedArray.getResourceId(
                R.styleable.ds_menu_menu_label_color,
                R.color.colorLowEmphasis
            )
        }

        configLabel(labelText, labelColor, labelSize)
        setSelected(isSelected)
        setEnabled(isEnabled)
    }

    private fun configLabel(labelText: String?, labelColor: Int, labelSize: Int) {
        label = labelText
        textLabel.setTextColor(ContextCompat.getColor(context, labelColor))
        textLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(labelSize))
    }

    private fun setLabelColorLowEmphasis(isLowEmphasis: Boolean) {
        if (isLowEmphasis) {
            textLabel.setTextColor(getColorTokenFromTheme(context, R.attr.colorLowEmphasis))
        }
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
