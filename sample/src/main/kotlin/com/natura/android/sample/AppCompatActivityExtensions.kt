package com.natura.android.sample

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.data.ThemeRepository

fun AppCompatActivity.setContentViewWithBrand(layout: Int) {
    setContentViewWithBrand(layout, R.style.Theme_Natura, R.style.Theme_Avon, R.style.Theme_BodyShop)
}

fun AppCompatActivity.setChosenTheme() {
    val themeRepository = ThemeRepository(this)
    setTheme(themeRepository.getChosenTheme())
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
