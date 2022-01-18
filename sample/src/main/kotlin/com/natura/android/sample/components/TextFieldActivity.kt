package com.natura.android.sample.components

import android.os.Bundle
import android.text.InputType
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme
import com.natura.android.textfield.TextField

class TextFieldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textfield)

        configurePasswordButtonAction()
        configurePasswordNumberButtonAction()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Text Field"
    }

    private fun configurePasswordNumberButtonAction() {
        var passwordMode = true
        val password = findViewById<TextField>(R.id.password_number_item)
        password.setOnIconClickListener {
            if (passwordMode) {
                password.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                password.iconButton = "outlined-action-visibility"
            } else {
                password.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                password.iconButton = "outlined-action-visibilityoff"
            }
            passwordMode = !passwordMode
        }
    }

    private fun configurePasswordButtonAction() {
        var passwordMode = true
        val password = findViewById<TextField>(R.id.password_item)
        password.setOnIconClickListener {
            if (passwordMode) {
                password.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                password.iconButton = "outlined-action-visibility"
            } else {
                password.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                password.iconButton = "outlined-action-visibilityoff"
            }
            passwordMode = !passwordMode
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
