package com.natura.android.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R

class ValueTextHighlight @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var descriptionLabel: TextView
    private lateinit var highlightInfoLabel: TextView
    private lateinit var editButton: ImageView

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.ds_input_text_highlight_view, this, true)

        with(context.obtainStyledAttributes(attrs, R.styleable.ds_text_input_highlight)) {
            val description = this.getString(R.styleable.ds_text_input_highlight_description_label)
            val highlight = this.getString(R.styleable.ds_text_input_highlight_highlight_label)
            val isEditMode = this.getBoolean(R.styleable.ds_text_input_highlight_edit_mode, false)

            setupView(description, highlight)
            displayEditButton(isEditMode)

            this.recycle()
        }
    }

    private fun setupView(description: String?, highlight: String?) {
        descriptionLabel = findViewById(R.id.description_label)
        highlightInfoLabel = findViewById(R.id.highlight_label)
        editButton = findViewById(R.id.edit_button)

        description?.let { descriptionLabel.text = it }
        highlight?.let { highlightInfoLabel.text = it }
    }

    fun setDescription(description: String) {
        descriptionLabel.text = description
        descriptionLabel.invalidate()
        descriptionLabel.requestLayout()
    }

    fun setHighlightedInfo(highlightStr: String) {
        highlightInfoLabel.text = highlightStr
        highlightInfoLabel.invalidate()
        highlightInfoLabel.requestLayout()
    }

    fun displayEditButton(shouldDisplay: Boolean) {
        if (shouldDisplay) editButton.visibility = View.VISIBLE
        else editButton.visibility = View.GONE
    }

    fun setEditButtonClickListener(listener: () -> Unit) {
        editButton.setOnClickListener { listener.invoke() }
    }
}
