package com.natura.android.navigationview

import com.natura.android.menu.MenuView

sealed class Navigation(open val id: String)

data class NavigationItem(
    override val id: String,
    val label: String,
    val iconText: String = "",
    val selected: Boolean = false,
    val enabled: Boolean = true,
    var hasSubMenu: Boolean = true,
    var tagAnalytics: String = "",
    var menuState: MenuView.MenuState = MenuView.MenuState.NONE,
    val childItems: MutableList<NavigationItemChild> = mutableListOf()
) : Navigation(id) {
    fun indexOfChildItemId(childId: String) = childItems.indexOfFirst { it.id == childId }
}

data class NavigationItemChild(
    override val id: String,
    var label: String,
    var selected: Boolean = false,
    val enabled: Boolean = true,
    var tagAnalytics: String = ""
) : Navigation(id)
