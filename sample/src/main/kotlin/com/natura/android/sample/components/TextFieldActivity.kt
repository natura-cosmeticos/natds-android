package com.natura.android.sample.components

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.natura.android.sample.R
import com.natura.android.textfield.TextFieldInput

class TextFieldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textfield)

        val clickable = findViewById<TextFieldInput>(R.id.clickable_item)
        clickable.setOnIconClickListener(View.OnClickListener {
            clickable.text = ""
            clickable.requestFocus()
        })
    }
}
