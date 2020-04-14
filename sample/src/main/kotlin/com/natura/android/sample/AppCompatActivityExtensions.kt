package com.natura.android.sample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.View

fun AppCompatActivity.setContentViewWithBrand(layout: Int) {
    setContentViewWithBrand(layout, R.style.Theme_Natura, R.style.Theme_Avon, R.style.Theme_BodyShop)
}

private fun AppCompatActivity.setContentViewWithBrand(layout: Int, themeNatura: Int, themeAvon: Int, themeBodyShop: Int) {
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
