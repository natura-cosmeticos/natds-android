package com.natura.android.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.natura.android.sample.components.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setTitle("Natura Design System")

        // tokens
        findViewById<Button>(R.id.btn_icons_font).setOnClickListener {
            startActivity(Intent(this, IconActivity::class.java))
        }

        findViewById<Button>(R.id.btn_icons_drawables).setOnClickListener {
            startActivity(Intent(this, DrawableActivity::class.java))
        }

        // components
        findViewById<Button>(R.id.btn_textfield).setOnClickListener {
            startActivity(Intent(this, TextFieldActivity::class.java))
        }

        findViewById<Button>(R.id.btn_input_text_highlight).setOnClickListener {
            startActivity(Intent(this, ValueTextHighlightActivity::class.java))
        }

        findViewById<Button>(R.id.btn_style_buttons).setOnClickListener {
            startActivity(Intent(this, StyleButtonActivity::class.java))
        }

        // patterns
        findViewById<Button>(R.id.btn_submenu).setOnClickListener {
            startActivity(Intent(this, SubmenuActivity::class.java))
        }

        findViewById<Button>(R.id.btn_navigation_drawer).setOnClickListener {
            startActivity(Intent(this, ExpandableNavigationViewActivity::class.java))
        }

        findViewById<Button>(R.id.btn_menu).setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

        findViewById<Button>(R.id.btn_loading).setOnClickListener {
            startActivity(Intent(this, LoadingActivity::class.java))
        }

        findViewById<Button>(R.id.btn_error_default).setOnClickListener {
            startActivity(Intent(this, ErrorActivity::class.java))
        }
    }
}

fun AppCompatActivity.setContentViewWithBrand(layout: Int) {
    setContentViewWithBrand(layout, R.style.Theme_Natura, R.style.Theme_Avon, R.style.Theme_BodyShop)
}
fun AppCompatActivity.setContentViewWithBrand(layout: Int, themeNatura: Int, themeAvon: Int, themeBodyShop: Int) {
    val themeId = intent.getIntExtra("theme", 0)
    setTheme(themeId)
    setContentView(layout)

    findViewById<View>(R.id.naturaThemeBtn).setOnClickListener {
        val intent = Intent(baseContext, this.javaClass)
        intent.putExtra("theme", themeNatura)
        startActivity(intent)
        finish()
    }

    findViewById<View>(R.id.avonThemeBtn).setOnClickListener {
        val intent = Intent(baseContext, this.javaClass)
        intent.putExtra("theme", themeAvon)
        startActivity(intent)
        finish()
    }

    findViewById<View>(R.id.bodyShopThemeBtn).setOnClickListener {
        val intent = Intent(baseContext, this.javaClass)
        intent.putExtra("theme", themeBodyShop)
        startActivity(intent)
        finish()
    }
}

