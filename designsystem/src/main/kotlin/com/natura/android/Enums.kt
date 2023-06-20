package com.natura.android

enum class Theme(val themeId: Int) {
    AESOP_LIGHT(R.style.Theme_Aesop_Light_NoActionBar),
    AESOP_DARK(R.style.Theme_Aesop_Dark_NoActionBar),
    AVON_LIGHT(R.style.Theme_Avon_Light_NoActionBar),
    AVON_DARK(R.style.Theme_Avon_Dark_NoActionBar),
    AVON_V2_LIGHT(R.style.Theme_Avon_v2_Light_NoActionBar),
    AVON_V2_DARK(R.style.Theme_Avon_v2_Dark_NoActionBar),
    CASAESTILO_LIGHT(R.style.Theme_CasaEestilo_Light_SSOT),
    CASAESTILO_DARK(R.style.Theme_CasaEestilo_Dark_SSOT),
    CONSULTORIABELEZA_LIGHT(R.style.Theme_ConsultoriaDeBeleza_Light_NoActionBar),
    CONSULTORIABELEZA_DARK(R.style.Theme_Avon_Dark_NoActionBar),
    NATURA_LIGHT(R.style.Theme_Natura_Light_NoActionBar),
    NATURA_DARK(R.style.Theme_Natura_Light_NoActionBar),
    NATURA_V2_LIGHT(R.style.Theme_Natura_v2_Light_NoActionBar),
    NATURA_V2_DARK(R.style.Theme_Natura_v2_Light_NoActionBar),
    THE_BODY_SHOP_LIGHT(R.style.Theme_Natura_Light_NoActionBar),
    THE_BODY_SHOP_DARK(R.style.Theme_Natura_Light_NoActionBar);

//    <attr name="customTheme" format="enum">
//        <enum name="aesopDark" value="0" />
//        <enum name="aesopLight" value="1" />
//        <enum name="avonDark" value="2" />
//        <enum name="avonLight" value="3" />
//        <enum name="avonV2Dark" value="4" />
//        <enum name="avonV2Light" value="5" />
//        <enum name="casaEstiloDark" value="6" />
//        <enum name="casaEstiloLight" value="7" />
//        <enum name="consultoriaBelezaDark" value="8" />
//        <enum name="consultoriaBelezaLight" value="9" />
//        <enum name="naturaDark" value="10" />
//        <enum name="naturaLight" value="11" />
//        <enum name="naturaV2Dark" value="12" />
//        <enum name="naturaV2Light" value="13" />
//        <enum name="theBodyShopDark" value="14" />
//        <enum name="theBodyShopLight" value="15" />
//    </attr>

    companion object {
        fun fromId(id: Int): Theme? {
            for (theme in values()) {
                if (theme.ordinal == id) {
                    return theme
                }
            }
            return null
        }
    }
}