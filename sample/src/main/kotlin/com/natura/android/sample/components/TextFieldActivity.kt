package com.natura.android.sample.components

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
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

        val disabled = findViewById<TextFieldInput>(R.id.disabled_item)
        val switchDisabledItem = findViewById<View>(R.id.switch_disabled_item)
        switchDisabledItem.setOnClickListener(View.OnClickListener {
            if (disabled.isEnabled) {
                disabled.isEnabled = false
                disabled.footer = "now is disabled again"
            } else {
                disabled.isEnabled = true
                disabled.footer = "now is enabled"
            }
        })

        var password_mode = true
        val password = findViewById<TextFieldInput>(R.id.password_item)
        password.setOnIconClickListener(View.OnClickListener {
            if (password_mode) {
                password.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                password.icon = "EA38"
            } else {
                password.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                password.icon = "EA37"
            }
            password_mode = !password_mode
        })

    }
}
