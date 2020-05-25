package com.natura.android.sample

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.data.ThemeRepository

fun AppCompatActivity.setContentViewWithBrand(layout: Int) {
    setContentViewWithBrand(layout, R.style.Theme_Natura, R.style.Theme_Avon, R.style.Theme_BodyShop)
}

fun AppCompatActivity.getChosenBrand(): String {
    return ThemeRepository(this.applicationContext).getChosenBrand() ?: "natura"
}

fun AppCompatActivity.setChosenDefaultTheme() {
    val themeRepository = ThemeRepository(this.applicationContext)
    setTheme(themeRepository.getChosenTheme())
}

fun AppCompatActivity.setChosenDefaultWithNoActionBarTheme() {
    val themeRepository = ThemeRepository(this.applicationContext)
    setTheme(themeRepository.getChosenThemeWithNoActionBar())
}

fun AppCompatActivity.setChosenDarkTheme() {
    val themeRepository = ThemeRepository(this.applicationContext)
    setTheme(themeRepository.getChosenDarkTheme())
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
