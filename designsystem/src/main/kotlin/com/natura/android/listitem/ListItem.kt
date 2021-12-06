package com.natura.android.listitem

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException

class ListItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var listItemAttributesArray: TypedArray
    private var touchStateAttribute: Boolean = false
    private var selectableAttribute: Boolean = false
    private var dividerAttribute: Int? = null
    private var isViewSelected: Boolean = false
    var clickListener: () -> Unit = { }

    init {
        try {
            View.inflate(context, R.layout.list_item, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        listItemAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.ListItem)

        getListItemAttributes()
        configureAppearance()
        configureListener()
    }

    fun setDividerMiddle() {
        dividerAttribute = Divider.MIDDLE.value
        showDivider()
    }

    fun setDividerInset() {
        dividerAttribute = Divider.INSET.value
        showDivider()
    }

    fun setDividerFullbleed() {
        dividerAttribute = Divider.FULLBLEED.value
        showDivider()
    }

    fun setTouchStateTrue() {
        touchStateAttribute = true
        enableTouchState()
    }

    fun setTouchStateFalse() {
        touchStateAttribute = false
        enableTouchState()
    }

    fun setSelectableStateTrue() {
        selectableAttribute = true
        allowTouch(true)
    }

    fun setSelectableStateFalse() {
        selectableAttribute = false
        allowTouch(true)
    }

    fun enableSelectedState() {
        this.background = resources.getDrawable(R.color.list_item_color_background_selected, context.theme)
        isViewSelected = true
    }

    fun getDivider(): Int? {
        return dividerAttribute
    }

    fun getTouchState(): Boolean = touchStateAttribute

    fun getSelectableState(): Boolean = selectableAttribute

    private fun getListItemAttributes() {
        dividerAttribute = listItemAttributesArray.getInt(R.styleable.ListItem_dividerBottom, Divider.NONE.value)
        touchStateAttribute = listItemAttributesArray.getBoolean(R.styleable.ListItem_touchState, false)
        selectableAttribute = listItemAttributesArray.getBoolean(R.styleable.ListItem_selectableState, false)

        listItemAttributesArray.recycle()
    }

    private fun enableTouchState() {
        if (!touchStateAttribute) {
            allowTouch(false)
            return
        }

        this.background = resources.getDrawable(R.drawable.list_item_ripple_background, context.theme)
        allowTouch(true)
    }

    private fun enableSelectableState() {
        if (selectableAttribute) {
            setSelectableStateTrue()
        }
    }

    private fun showDivider() {
        View.inflate(context, R.layout.list_item_dividers, this)
//
//        when (dividerAttribute) {
//            Divider.INSET.value -> dividerInset.visibility = View.VISIBLE
//            Divider.MIDDLE.value -> dividerMiddle.visibility = View.VISIBLE
//            Divider.FULLBLEED.value -> dividerFullBleed.visibility = View.VISIBLE
//        }
    }

    private fun configureAppearance() {
        enableTouchState()
        enableSelectableState()
        showDivider()
        requestLayout()
    }

    private fun allowTouch(allowTouch: Boolean) {
        this.isFocusable = allowTouch
        this.isClickable = allowTouch
        this.isEnabled = allowTouch
    }

    private fun configureListener() {

        this.setOnClickListener {
            if (selectableAttribute) {
                isViewSelected = when (isViewSelected) {
                    false -> {
                        enableSelectedState()
                        true
                    }
                    true -> {
                        this.background = null
                        false
                    }
                }
            }
            clickListener()
        }
    }
}

enum class Divider(val value: Int) {
    NONE(0),
    FULLBLEED(1),
    INSET(2),
    MIDDLE(3)
}
