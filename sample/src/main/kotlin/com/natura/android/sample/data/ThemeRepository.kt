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
        return when (sharedPreferences.getString("theme", "natura")) {
            "natura" -> R.style.Theme_Natura_Light
            "avon" -> R.style.Theme_Avon_Light
            "consultoria" -> R.style.Theme_ConsultoriaDeBeleza_Light
            "natura_v2" -> R.style.Theme_Natura_v2_Light
            "avon_v2" -> R.style.Theme_Avon_v2_Light
            "natura_v3" -> R.style.Theme_Natura_v3_Light
            "casaeestilo" -> R.style.Theme_CasaEestilo_Light
            "casaeestilo_v2" -> R.style.Theme_CasaEestilo_v2_Light
            "forcadevendas" -> R.style.Theme_ForcaDeVendas_Light
            "consultoria_v2" -> R.style.Theme_ConsultoriaDeBeleza_v2_Light
            "forcadevendas_v2" -> R.style.Theme_ForcaDeVendas_v2_Light
            "avon_v3" -> R.style.Theme_Avon_v3_Light
            else -> R.style.Theme_TheBodyShop_Light
        }
    }

    fun getChosenDarkTheme(): Int {
        return when (sharedPreferences.getString("theme", "natura")) {
            "natura" -> R.style.Theme_Natura_Dark
            "avon" -> R.style.Theme_Avon_Dark
            "consultoria" -> R.style.Theme_ConsultoriaDeBeleza_Dark
            "natura_v2" -> R.style.Theme_Natura_v2_Dark
            "avon_v2" -> R.style.Theme_Avon_v2_Dark
            "natura_v3" -> R.style.Theme_Natura_v3_Dark
            "casaeestilo" -> R.style.Theme_CasaEestilo_Dark
            "casaeestilo_v2" -> R.style.Theme_CasaEestilo_v2_Dark
            "forcadevendas" -> R.style.Theme_ForcaDeVendas_Dark
            "consultoria_v2" -> R.style.Theme_ConsultoriaDeBeleza_v2_Dark
            "forcadevendas_v2" -> R.style.Theme_ForcaDeVendas_v2_Dark
            "avon_v3" -> R.style.Theme_Avon_v3_Dark
            else -> R.style.Theme_TheBodyShop_Dark
        }
    }

    fun getChosenThemeWithNoActionBar(): Int {
        return when (sharedPreferences.getString("theme", "natura")) {
            "natura" -> R.style.Theme_Natura_Light_NoActionBar
            "avon" -> R.style.Theme_Avon_Light_NoActionBar
            "consultoria" -> R.style.Theme_ConsultoriaDeBeleza_Light_NoActionBar
            "natura_v2" -> R.style.Theme_Natura_v2_Light_NoActionBar
            "avon_v2" -> R.style.Theme_Avon_v2_Light_NoActionBar
            "natura_v3" -> R.style.Theme_Natura_v3_Light_NoActionBar
            "casaeestilo" -> R.style.Theme_CasaEestilo_Light_NoActionBar
            "casaeestilo_v2" -> R.style.Theme_CasaEestilo_v2_Light_NoActionBar
            "forcadevendas" -> R.style.Theme_ForcaDeVendas_Light_NoActionBar
            "consultoria_v2" -> R.style.Theme_ConsultoriaDeBeleza_v2_Light_NoActionBar
            "forcadevendas_v2" -> R.style.Theme_ForcaDeVendas_v2_Light_NoActionBar
            "avon_v3" -> R.style.Theme_Avon_v3_Light_NoActionBar
            else -> R.style.Theme_TheBodyShop_Light_NoActionBar
        }
    }

    fun getChosenDarkThemeWithNoActionBar(): Int {
        return when (sharedPreferences.getString("theme", "natura")) {
            "natura" -> R.style.Theme_Natura_Dark_NoActionBar
            "avon" -> R.style.Theme_Avon_Dark_NoActionBar
            "consultoria" -> R.style.Theme_ConsultoriaDeBeleza_Dark_NoActionBar
            "natura_v2" -> R.style.Theme_Natura_v2_Dark_NoActionBar
            "avon_v2" -> R.style.Theme_Avon_v2_Dark_NoActionBar
            "natura_v3" -> R.style.Theme_Natura_v3_Dark_NoActionBar
            "casaeestilo" -> R.style.Theme_CasaEestilo_Dark_NoActionBar
            "casaeestilo_v2" -> R.style.Theme_CasaEestilo_v2_Dark_NoActionBar
            "forcadevendas" -> R.style.Theme_ForcaDeVendas_Dark_NoActionBar
            "consultoria_v2" -> R.style.Theme_ConsultoriaDeBeleza_v2_Dark_NoActionBar
            "forcadevendas_v2" -> R.style.Theme_ForcaDeVendas_v2_Dark_NoActionBar
            "avon_v3" -> R.style.Theme_Avon_v3_Dark_NoActionBar
            else -> R.style.Theme_TheBodyShop_Dark_NoActionBar
        }
    }
}
