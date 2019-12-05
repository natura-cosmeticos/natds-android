package com.natura.android.navigationview

data class NavigationItemChild(
    var label: String,
    var selected: Boolean = false,
    val enabled: Boolean = true
)
