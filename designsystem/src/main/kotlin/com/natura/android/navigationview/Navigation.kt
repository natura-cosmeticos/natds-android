package com.natura.android.navigationview

import com.natura.android.menu.MenuView

sealed class Navigation(open val id: String)

data class NavigationItem(
    override val id: String,
    val label: String,
    val iconDrawable: Int = 0,
    val selected: Boolean = false,
    val enabled: Boolean = true,
    var hasSubMenu: Boolean = true,
    var menuState: MenuView.MenuState = MenuView.MenuState.NONE,
    val childItems: MutableList<NavigationItemChild> = mutableListOf()
) : Navigation(id)

data class NavigationItemChild(
    override val id: String,
    var label: String,
    var selected: Boolean = false,
    val enabled: Boolean = true
) : Navigation(id)
