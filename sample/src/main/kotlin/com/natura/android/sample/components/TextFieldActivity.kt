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

        val mutable_item = findViewById<TextFieldInput>(R.id.mutable_item)
        val switchDisabledItem = findViewById<View>(R.id.switch_item_disabled)
        switchDisabledItem.setOnClickListener {
            if (mutable_item.isEnabled) {
                mutable_item.isEnabled = false
                mutable_item.footer = "now is disabled again"
            } else {
                mutable_item.isEnabled = true
                mutable_item.footer = "now is enabled"
            }
        }

        val switchErroredItem = findViewById<View>(R.id.switch_item_errored)
        switchErroredItem.setOnClickListener {
            if (mutable_item.state == TextFieldInput.State.ERROR) {
                mutable_item.error = null
            } else {
                mutable_item.error = "error message"
            }
        }

        val switchSucceedItem = findViewById<View>(R.id.switch_item_succeed)
        switchSucceedItem.setOnClickListener {
            if (mutable_item.state == TextFieldInput.State.SUCCESS) {
                mutable_item.footer = ""
                mutable_item.state = TextFieldInput.State.NONE
            } else {
                mutable_item.footer = "success message"
                mutable_item.state = TextFieldInput.State.SUCCESS
            }
        }

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
