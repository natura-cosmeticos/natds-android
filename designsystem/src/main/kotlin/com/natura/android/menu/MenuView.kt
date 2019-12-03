package com.natura.android.menu

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.natura.android.R
import com.natura.android.ext.setVisibilityFromBoolean

@SuppressLint("CustomViewStyleable")
class MenuView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val textLabel by lazy { findViewById<AppCompatTextView>(R.id.ds_menu_label) }
    private val labelContainer by lazy { findViewById<View>(R.id.ds_menu_view_background) }
    private val iconMenu by lazy { findViewById<AppCompatImageView>(R.id.ds_menu_icon) }
    private val iconArrowMenu by lazy { findViewById<AppCompatImageView>(R.id.ds_menu_arrow) }

    private var selectedDrawable: Int
    private var openedDrawable: Int

    init {
        View.inflate(context, R.layout.ds_menu_view, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ds_menu)
        val labelText = typedArray.getString(R.styleable.ds_menu_menu_label)
        val labelColor = typedArray.getResourceId(
            R.styleable.ds_menu_menu_label_color,
            R.color.colorBrdNatGray
        )
        val labelSize = typedArray.getResourceId(
            R.styleable.ds_menu_menu_label_size,
            R.dimen.ds_text_small
        )
        selectedDrawable = typedArray.getResourceId(
            R.styleable.ds_menu_menu_selected_drawable,
            R.drawable.ds_menu_item_selected
        )

        val iconDrawable = typedArray.getResourceId(
            R.styleable.ds_menu_menu_icon,
            0
        )

        openedDrawable = typedArray.getResourceId(
            R.styleable.ds_menu_menu_opened_drawable,
            R.drawable.ds_menu_item_opened
        )

        val isSelected = typedArray.getBoolean(R.styleable.ds_menu_menu_is_selected, false)
        val isEnabled = typedArray.getBoolean(R.styleable.ds_menu_menu_is_enabled, true)
        val isOpened = typedArray.getBoolean(R.styleable.ds_menu_menu_is_opened, false)

        typedArray.recycle()

        configLabel(labelText, labelColor, labelSize)
        configIcon(iconDrawable)

        if (isOpened) configOpened(isOpened)
        else configSelected(isSelected)
        setEnable(isEnabled)
    }

    private fun configIcon(icon: Int) {
        iconMenu.setImageResource(icon)
    }

    private fun configLabel(labelText: String?, labelColor: Int, labelSize: Int) {
        setLabel(labelText)
        textLabel.setTextColor(ContextCompat.getColor(context, labelColor))
        textLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(labelSize))
    }

    fun setLabel(labelText: String?) {
        textLabel.text = labelText
    }

    fun configSelected(isSelected: Boolean) {
        changeBackground(isSelected, selectedDrawable)
        iconArrowMenu.setVisibilityFromBoolean(!isSelected, View.INVISIBLE)
    }

    fun configOpened(isOpened: Boolean) {
        changeBackground(isOpened, openedDrawable)
        iconArrowMenu.rotation = 180f
    }

    private fun changeBackground(changeBackground: Boolean, selectedColor: Int) {
        labelContainer.apply {
            if (changeBackground) setBackgroundResource(selectedColor)
            else setBackgroundResource(0)
        }
    }

    private fun setEnable(isEnabled: Boolean) {
        if (isEnabled) {
            textLabel.setTextColor(getColor(R.color.colorBrdNatGray))
            setColorFilter(iconMenu, R.color.colorBrdNatGray)
            setColorFilter(iconArrowMenu, R.color.colorBrdNatGray)
        } else {
            textLabel.setTextColor(getColor(R.color.colorBrdNatGray_48))
            setColorFilter(iconMenu, R.color.colorBrdNatGray_48)
            setColorFilter(iconArrowMenu, R.color.colorBrdNatGray_48)
        }
    }

    private fun setColorFilter(imageView: AppCompatImageView, color: Int) {
        imageView.setColorFilter(
            getColor(color),
            PorterDuff.Mode.SRC_IN
        )
    }

    private fun getColor(color: Int) = ContextCompat.getColor(context, color)
}
