package com.natura.android.sample.components

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.natura.android.sample.R

class SelectionControlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val themeId = intent.getIntExtra("theme", 0)
        setTheme(themeId)
        setContentView(R.layout.activity_selection_control)

        findViewById<View>(R.id.naturaThemeBtn).setOnClickListener {
            val intent = Intent(baseContext, SelectionControlActivity::class.java)
            intent.putExtra("theme", R.style.Theme_Natura)
            startActivity(intent)
            finish()
        }

        findViewById<View>(R.id.avonThemeBtn).setOnClickListener {
            val intent = Intent(baseContext, SelectionControlActivity::class.java)
            intent.putExtra("theme", R.style.Theme_Avon)
            startActivity(intent)
            finish()
        }

        findViewById<View>(R.id.bodyShopThemeBtn).setOnClickListener {
            val intent = Intent(baseContext, SelectionControlActivity::class.java)
            intent.putExtra("theme", R.style.Theme_BodyShop)
            startActivity(intent)
            finish()
        }
    }
}