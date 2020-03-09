package com.natura.android.sample.components

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.widget.TextInputHighlight

class TextInputHighlightActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input_highlight)

        val inputHighlight = findViewById<TextInputHighlight>(R.id.highlightInitViaCode)
        inputHighlight.setDescription("Add description via code")
        inputHighlight.setHighlightedInfo("$ 00.00")
    }
}
