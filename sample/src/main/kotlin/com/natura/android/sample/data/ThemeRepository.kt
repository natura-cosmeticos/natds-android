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

    fun saveChosenTheme(brandName: String) {
        sharedPreferences
            .edit()
            .putString("theme", brandName)
            .apply()
    }

    fun getChosenBrand() = sharedPreferences.getString("theme", "natura")

    fun getChosenTheme(): Int {
        val chosenBrand = sharedPreferences.getString("theme", "natura")

        return when (chosenBrand) {
            "natura" -> R.style.Theme_Natura
            "avon" -> R.style.Theme_Avon
            else -> R.style.Theme_BodyShop
        }
    }

    fun getChosenDarkTheme(): Int {
        val chosenBrand = sharedPreferences.getString("theme", "natura")

        return when (chosenBrand) {
            "natura" -> R.style.Theme_NaturaDark
            "avon" -> R.style.Theme_AvonDark
            else -> R.style.Theme_BodyShopDark
        }
    }

    fun getChosenThemeWithNoActionBar(): Int {
        val chosenBrand = sharedPreferences.getString("theme", "natura")

        return when (chosenBrand) {
            "natura" -> R.style.Theme_Natura_NoActionBar
            "avon" -> R.style.Theme_Avon_NoActionBar
            else -> R.style.Theme_BodyShop_NoActionBar
        }
    }

    fun getChosenDarkThemeWithNoActionBar(): Int {
        val chosenBrand = sharedPreferences.getString("theme", "natura")

        return when (chosenBrand) {
            "natura" -> R.style.Theme_NaturaDark_NoActionBar
            "avon" -> R.style.Theme_AvonDark_NoActionBar
            else -> R.style.Theme_BodyShopDark_NoActionBar
        }
    }
}
