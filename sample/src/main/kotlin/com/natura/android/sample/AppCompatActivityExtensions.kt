package com.natura.android.sample

import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.data.ThemeRepository

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
