package com.natura.android.sample.data

import android.content.Context
import android.content.SharedPreferences
import com.natura.android.sample.R

class ThemeRepository(context: Context) {

    private val appContext = context.applicationContext

    val sharedPreferences: SharedPreferences
        get() {
            return appContext.getSharedPreferences("themes", Context.MODE_PRIVATE)
        }

    fun saveChosenTheme(themeId: Int) {
        sharedPreferences
            .edit()
            .putInt("theme", themeId)
            .apply()
    }

    fun getChosenTheme(): Int = sharedPreferences.getInt("theme", R.style.Theme_Natura)
}
