package com.natura.android.listitem

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException
import kotlinx.android.synthetic.main.list_item.view.*

class ListItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var listItemAttributesArray: TypedArray
    private var touchStateAttribute: Boolean = false
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

    fun setDivider(dividerType: Int) {
        dividerAttribute = dividerType
        showDivider()
    }

    fun setTouchState(enableTouch: Boolean) {
        touchStateAttribute = enableTouch
        enableTouchState()
    }

    fun enableSelectedState() {
        this.background = resources.getDrawable(R.color.list_item_color_background_selected, context.theme)
    }

    fun getDivider(): Int? {
        return dividerAttribute
    }

    fun getTouchState(): Boolean = touchStateAttribute

    private fun getListItemAttributes() {
        dividerAttribute = listItemAttributesArray.getInt(R.styleable.ListItem_dividerBottom, Divider.NONE.ordinal)
        touchStateAttribute = listItemAttributesArray.getBoolean(R.styleable.ListItem_touchState, true)

        listItemAttributesArray.recycle()
    }

    private fun enableTouchState() {
        if (!touchStateAttribute) {
            this.isEnabled = false
            this.isFocusable = false
            return
        }

        this.background = resources.getDrawable(R.drawable.list_item_ripple_background, context.theme)
        this.isFocusable = true
        this.isClickable = true
        this.isEnabled = true
    }

    private fun showDivider() {

        when (dividerAttribute) {
            Divider.INSET.ordinal -> dividerInset.visibility = View.VISIBLE
            Divider.MIDDLE.ordinal -> dividerMiddle.visibility = View.VISIBLE
            Divider.FULLBLEED.ordinal -> dividerFullBleed.visibility = View.VISIBLE
        }

        val params = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = Gravity.BOTTOM
        }

        dividerInset.layoutParams = params
        dividerMiddle.layoutParams = params
        dividerFullBleed.layoutParams = params
    }

    private fun configureAppearance() {
        enableTouchState()
        showDivider()
    }

    private fun configureListener() {

        this.setOnClickListener {
            if (!isViewSelected) {
                enableSelectedState()
                isViewSelected = true
            } else {
                enableTouchState()
                isViewSelected = false
            }
            clickListener()
        }
    }
}

enum class Divider {
    NONE, FULLBLEED, INSET, MIDDLE
}
