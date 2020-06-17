package com.natura.android.expansionPanel


import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R

@SuppressLint("CustomViewStyleable")
class ExpansionPanel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val box by lazy { findViewById<LinearLayout>(R.id.ds_expansion_panel_box) }
    private val icon by lazy { findViewById<ImageView>(R.id.ds_expansion_panel_icon) }
    private val contentArea by lazy { findViewById<ConstraintLayout>(R.id.ds_expansion_panel_content_area) }
    private val subtitle by lazy { findViewById<TextView>(R.id.ds_expansion_panel_subtitle) }

    init {
        View.inflate(context, R.layout.ds_expansion_panel, this)

        setupSubtitle(context, attrs)
        setupClickableComponents()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        moveGivenChildrenToContentArea()
    }

    private fun setupSubtitle(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ds_expansion_panel)
        val subtitleText = typedArray.getString(R.styleable.ds_expansion_panel_subtitle)

        typedArray.recycle()

        subtitle.text = subtitleText
    }

    private fun setupClickableComponents() {
        box.setOnClickListener {
            toggleContentArea()
        }

        icon.setOnClickListener {
            toggleContentArea()
        }
    }

    private fun toggleContentArea() {
        startAnimation()

        if (isContentAreaVisible()) {
            hideContentArea()
        } else {
            showContentArea()
        }

        finishAnimation()
    }

    private fun isContentAreaVisible(): Boolean = contentArea.visibility == View.VISIBLE

    private fun showContentArea() {
        contentArea.visibility = View.VISIBLE
        icon.setImageResource(R.drawable.ds_ic_outlined_navigation_arrowtop)
        box.setBackgroundResource(R.drawable.ds_expansion_panel_border_expanded)
    }

    private fun hideContentArea() {
        contentArea.visibility = View.GONE
        icon.setImageResource(R.drawable.ds_ic_outlined_navigation_arrowbottom)
        box.setBackgroundResource(R.drawable.ds_expansion_panel_border_collapsed)
    }

    private fun startAnimation() = TransitionManager.beginDelayedTransition(box, AutoTransition())

    private fun finishAnimation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            TransitionManager.endTransitions(box)
        }
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
