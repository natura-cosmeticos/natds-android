package com.natura.android.expansionPanel

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R

@SuppressLint("CustomViewStyleable")
class ExpansionPanel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val container by lazy { findViewById<CardView>(R.id.ds_expansion_panel_container) }
    private val icon by lazy { findViewById<ImageView>(R.id.ds_expansion_panel_icon) }
    private val contentArea by lazy { findViewById<ConstraintLayout>(R.id.ds_expansion_panel_content_area) }
    private val title by lazy { findViewById<TextView>(R.id.ds_expansion_panel_title) }

    private var onStateChangeListener: (isExpanded: Boolean) -> Unit = {}

    init {
        View.inflate(context, R.layout.ds_expansion_panel, this)

        setupSubtitle(context, attrs)
        setupClickableComponents()
    }

    fun setOnStateChangeListener(listener: (Boolean) -> Unit) {
        onStateChangeListener = listener
    }

    fun isExpanded(): Boolean = contentArea.visibility == View.VISIBLE

    override fun onFinishInflate() {
        super.onFinishInflate()
        moveGivenChildrenToContentArea()
    }

    private fun setupSubtitle(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ds_expansion_panel)
        val titleText = typedArray.getString(R.styleable.ds_expansion_panel_title)

        typedArray.recycle()

        title.text = titleText
    }

    private fun setupClickableComponents() {
        container.setOnClickListener {
            toggleContentArea()
        }

        icon.setOnClickListener {
            toggleContentArea()
        }
    }

    private fun toggleContentArea() {
        if (isExpanded()) {
            hideContentArea()
        } else {
            showContentArea()
        }
    }

    private fun showContentArea() {
        contentArea.visibility = View.VISIBLE
        icon.setImageResource(R.drawable.ds_ic_outlined_navigation_arrowtop)
        container.setBackgroundResource(R.drawable.ds_expansion_panel_border_expanded)

        onStateChangeListener.invoke(true)
    }

    private fun hideContentArea() {
        contentArea.visibility = View.GONE
        icon.setImageResource(R.drawable.ds_ic_outlined_navigation_arrowbottom)
        container.setBackgroundResource(R.drawable.ds_expansion_panel_border_collapsed)

        onStateChangeListener.invoke(false)
    }

    private fun moveGivenChildrenToContentArea() {
        while (haveChildrenToMove()) {
            val child = getNextChild()
            removeView(child)
            contentArea.addView(child)
        }
    }

    private fun haveChildrenToMove(): Boolean = getChildAt(1) != null

    private fun getNextChild(): View? = getChildAt(1)
}
