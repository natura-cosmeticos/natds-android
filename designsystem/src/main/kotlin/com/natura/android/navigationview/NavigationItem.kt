package com.natura.android.navigationview

import android.graphics.drawable.Drawable

data class NavigationItem(
    val label: String,
    val iconDrawable: Drawable? = null,
    val selected: Boolean = false,
    val enabled: Boolean = true,
    val childItems: MutableList<NavigationItemChild> = mutableListOf()
)
