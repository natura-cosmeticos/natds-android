package com.natura.android.menu

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PorterDuff
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.natura.android.R
import com.natura.android.ext.setVisibilityFromBoolean
import com.natura.android.icon.FontIcon

@SuppressLint("CustomViewStyleable")
class MenuView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    enum class MenuState { NONE, OPEN, CLOSE, SELECTED, UNSELECTED, DISABLE }

    companion object {
        const val ROTATION_ARROW_MENU_OPEN = 180f
        const val ROTATION_ARROW_MENU_CLOSED = 0f
    }

    private val textLabel by lazy { findViewById<AppCompatTextView>(R.id.ds_menu_label) }
    private val labelContainer by lazy { findViewById<View>(R.id.ds_menu_view_background) }
    private val iconMenu by lazy { findViewById<FontIcon>(R.id.ds_menu_icon) }
    private val iconArrowMenu by lazy { findViewById<AppCompatImageView>(R.id.ds_menu_arrow) }

    private var selectedDrawable: Int
    private var openedDrawable: Int
    var label: String? = ""
        set(value) {
            field = value
            textLabel.text = value
        }

    var icon: String? = ""
        set(value) {
            field = value
            iconMenu.text = value
            iconMenu.setVisibilityFromBoolean(iconMenu.text.toString().isNotBlank())
        }

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

        val iconText = typedArray.getString(R.styleable.ds_menu_menu_icon)

        openedDrawable = typedArray.getResourceId(
            R.styleable.ds_menu_menu_opened_drawable,
            R.drawable.ds_menu_item_opened
        )

        val selected = typedArray.getBoolean(R.styleable.ds_menu_menu_is_selected, false)
        val enabled = typedArray.getBoolean(R.styleable.ds_menu_menu_is_enabled, true)
        val isOpened = typedArray.getBoolean(R.styleable.ds_menu_menu_is_opened, false)

        typedArray.recycle()

        configLabel(labelText, labelColor, labelSize)
        icon = iconText

        if (isOpened) {
            configOpened(isOpened)
        } else {
            isSelected = selected
            showArrow(false)
        }

        isEnabled = enabled
    }

    private fun configLabel(labelText: String?, labelColor: Int, labelSize: Int) {
        label = labelText
        textLabel.setTextColor(ContextCompat.getColor(context, labelColor))
        textLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(labelSize))
    }

    private fun configOpened(isOpened: Boolean) {
        changeBackground(isOpened, openedDrawable)
        if (isOpened) iconArrowMenu.animate().rotation(ROTATION_ARROW_MENU_OPEN).start()
        else iconArrowMenu.animate().rotation(ROTATION_ARROW_MENU_CLOSED).start()
    }

    override fun setSelected(isSelected: Boolean) {
        super.setSelected(isSelected)
        changeBackground(isSelected, selectedDrawable)
    }

    private fun changeBackground(changeBackground: Boolean, selectedColor: Int) {
        labelContainer.apply {
            if (changeBackground) setBackgroundResource(selectedColor)
            else setBackgroundResource(0)
        }
    }

    fun configStateMenu(menuState: MenuState) {
        when (menuState) {
            MenuState.NONE,
            MenuState.CLOSE -> configOpened(false)
            MenuState.OPEN -> configOpened(true)
            MenuState.SELECTED -> isSelected = true
            MenuState.UNSELECTED -> isSelected = false
            MenuState.DISABLE -> isEnabled = false
        }
    }

    fun showArrow(hasSubMenu: Boolean) {
        iconArrowMenu.setVisibilityFromBoolean(hasSubMenu, View.INVISIBLE)
    }

    override fun setEnabled(isEnabled: Boolean) {
        super.setEnabled(isEnabled)
        isClickable = !isEnabled
        textLabel.isEnabled = isEnabled
        if (isEnabled) {
            textLabel.setTextColor(getColor(R.color.colorBrdNatGray))
            iconMenu.setTextColor(getColor(R.color.colorBrdNatGray))
            setColorFilter(iconArrowMenu, R.color.colorBrdNatGray)
        } else {
            textLabel.setTextColor(getColor(R.color.colorBrdNatGray_48))
            iconMenu.setTextColor(getColor(R.color.colorBrdNatGray_48))
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
