package com.natura.android.listitem

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException
import kotlinx.android.synthetic.main.list_item.view.*

class ListItem @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var listItemAttributesArray: TypedArray
    private var itemTouchedAttribute: Boolean = false
    private var selectedAttribute: Boolean = false
    private var dividerAttribute: Int? = null
    private var backgroundColorResourceAttribute: Int = 0

    init {
        try {
            View.inflate(context, R.layout.list_item, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        listItemAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.ListItem)

        getListItemAttributes()
        configureAppearance()
    }

    private fun getListItemAttributes() {
        selectedAttribute = listItemAttributesArray.getBoolean(R.styleable.ListItem_itemSelected, false)
        dividerAttribute = listItemAttributesArray.getInt(R.styleable.ListItem_dividerBottom, Divider.NONE.ordinal)
        itemTouchedAttribute = listItemAttributesArray.getBoolean(R.styleable.ListItem_itemTouched, false)

        listItemAttributesArray.recycle()
    }

    private fun configureAppearance() {
        when (dividerAttribute) {
            Divider.INSET.ordinal -> dividerInset.visibility = View.VISIBLE
            Divider.MIDDLE.ordinal -> dividerMiddle.visibility = View.VISIBLE
            Divider.FULLBLEED.ordinal -> dividerFullBleed.visibility = View.VISIBLE
        }

        if (!itemTouchedAttribute) {
            frameContainerListItem.isEnabled = false
            frameContainerListItem.isFocusable = false
        } else {
            frameContainerListItem.background = resources.getDrawable(R.drawable.list_item_ripple_background, context.theme)
        }

        if (selectedAttribute) {
            frameContainerListItem.isEnabled = false
            frameContainerListItem.isFocusable = false
            frameContainerListItem.background = resources.getDrawable(R.color.list_item_color_background_selected, context.theme)
        }

        frameContainerListItem.setOnClickListener {
            Toast.makeText(context, "Dialog Main Action", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}

enum class Divider {
    NONE, FULLBLEED, INSET, MIDDLE
}
