package com.natura.android.navigationview

import com.natura.android.menu.MenuView

data class NavigationItem(
    val label: String,
    val iconDrawable: Int = 0,
    val selected: Boolean = false,
    val enabled: Boolean = true,
    var hasSubMenu: Boolean = true,
    var menuState: MenuView.MenuState = MenuView.MenuState.NONE,
    val childItems: MutableList<NavigationItemChild> = mutableListOf()
)
