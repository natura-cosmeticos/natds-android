package com.natura.android.listitem

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.res.ResourcesCompat
import com.natura.android.R
import com.natura.android.divider.Divider
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
        dividerAttribute = DividerTypes.MIDDLE.value
        showDivider()
    }

    fun setDividerInset() {
        dividerAttribute = DividerTypes.INSET.value
        showDivider()
    }

    fun setDividerFullbleed() {
        dividerAttribute = DividerTypes.FULLBLEED.value
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
        this.background = ResourcesCompat.getDrawable(context.resources, R.color.list_item_color_background_selected, context.theme)
        isViewSelected = true
    }

    fun getDivider(): Int? {
        return dividerAttribute
    }

    fun getTouchState(): Boolean = touchStateAttribute

    fun getSelectableState(): Boolean = selectableAttribute

    private fun getListItemAttributes() {
        dividerAttribute = listItemAttributesArray.getInt(R.styleable.ListItem_dividerBottom, DividerTypes.NONE.value)
        touchStateAttribute = listItemAttributesArray.getBoolean(R.styleable.ListItem_touchState, false)
        selectableAttribute = listItemAttributesArray.getBoolean(R.styleable.ListItem_selectableState, false)

        listItemAttributesArray.recycle()
    }

    private fun enableTouchState() {
        if (!touchStateAttribute) {
            allowTouch(false)
            return
        }

        this.background = ResourcesCompat.getDrawable(context.resources, R.drawable.list_item_ripple_background, context.theme)
        allowTouch(true)
    }

    private fun enableSelectableState() {
        if (selectableAttribute) {
            setSelectableStateTrue()
        }
    }

    private fun showDivider() {
        val listItemDividers = View.inflate(context, R.layout.list_item_dividers, this)

        when (dividerAttribute) {
            DividerTypes.INSET.value -> listItemDividers.findViewById<Divider>(R.id.dividerInset).visibility = View.VISIBLE
            DividerTypes.MIDDLE.value -> listItemDividers.findViewById<Divider>(R.id.dividerMiddle).visibility = View.VISIBLE
            DividerTypes.FULLBLEED.value -> listItemDividers.findViewById<Divider>(R.id.dividerFullBleed).visibility = View.VISIBLE
        }
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

enum class DividerTypes(val value: Int) {
    NONE(0),
    FULLBLEED(1),
    INSET(2),
    MIDDLE(3)
}
