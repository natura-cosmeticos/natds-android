package com.natura.android.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.natura.android.sample.components.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_textfield).setOnClickListener {
            startActivity(Intent(this, TextFieldActivity::class.java))
        }

        findViewById<Button>(R.id.btn_submenu).setOnClickListener {
            startActivity(Intent(this, SubmenuActivity::class.java))
        }

        findViewById<Button>(R.id.btn_navigation_drawer).setOnClickListener {
            startActivity(Intent(this, ExpandableNavigationViewActivity::class.java))
        }

        findViewById<Button>(R.id.btn_menu).setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

        findViewById<Button>(R.id.btn_icons).setOnClickListener {
            startActivity(Intent(this, IconActivity::class.java))
        }

        findViewById<Button>(R.id.btn_loading).setOnClickListener {
            startActivity(Intent(this, LoadingActivity::class.java))
        }

        findViewById<Button>(R.id.btn_button_primary).setOnClickListener {
            startActivity(Intent(this, ButtonPrimaryActivity::class.java))
        }

        findViewById<Button>(R.id.btn_error_default).setOnClickListener {
            startActivity(Intent(this, ErrorActivity::class.java))
        }

        findViewById<Button>(R.id.btn_input_text_highlight).setOnClickListener {
            startActivity(Intent(this, TextInputHighlightActivity::class.java))
        }
    }
}

