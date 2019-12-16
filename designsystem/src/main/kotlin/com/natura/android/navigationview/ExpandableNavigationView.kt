package com.natura.android.navigationview

import android.content.Context
import android.support.design.widget.NavigationView
import android.util.AttributeSet
import android.view.View
import android.widget.ExpandableListView
import com.natura.android.R
import com.natura.android.menu.MenuView

class ExpandableNavigationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : NavigationView(context, attrs, defStyleAttr) {

    private val navigationMenu: ExpandableListView by lazy { findViewById<ExpandableListView>(R.id.navigation_menu) }
    private lateinit var navigationAdapter: ExpandableNavigationAdapter
    private lateinit var navigationItems: List<NavigationItem>
    private var oldGroupPosition = 0
    private var oldChildPosition = 0
    private var onItemSelected: ((Navigation) -> Unit) = {
        // do nothing by default
    }

    init {
        View.inflate(context, R.layout.ds_expandable_navigation_view, this)
    }

    fun initMenuItems(navigationItems: List<NavigationItem>) {
        this.navigationItems = navigationItems
        navigationAdapter = ExpandableNavigationAdapter(context, navigationItems.toMutableList())
        navigationMenu.setAdapter(navigationAdapter)

        setListener()
    }

    private fun setListener() {
        navigationMenu.setOnChildClickListener { _, _, groupPosition: Int, childPosition: Int, _ ->

            resetMenuSelected(oldGroupPosition, oldChildPosition)
            navigationItems[groupPosition].childItems[childPosition].selected = true
            onItemSelected(navigationItems[groupPosition].childItems[childPosition])

            oldGroupPosition = groupPosition
            oldChildPosition = childPosition

            navigationAdapter.notifyDataSetChanged()
            true
        }

        navigationMenu.setOnGroupExpandListener { groupPosition ->
            menuWhenNoHasSubmenu(groupPosition, MenuView.MenuState.OPEN)
            navigationAdapter.notifyDataSetChanged()
        }

        navigationMenu.setOnGroupCollapseListener { groupPosition ->
            menuWhenNoHasSubmenu(groupPosition, MenuView.MenuState.CLOSE)
            navigationAdapter.notifyDataSetChanged()
        }
    }

    private fun menuWhenNoHasSubmenu(groupPosition: Int, state: MenuView.MenuState) {
        navigationItems[groupPosition].apply {
            if (hasSubMenu) {
                menuState = state
            } else {
                resetMenuSelected(oldGroupPosition, oldChildPosition)
                menuState = MenuView.MenuState.SELECTED
                oldGroupPosition = groupPosition
                onItemSelected(this)
            }
        }
    }

    private fun resetMenuSelected(groupPosition: Int, childPosition: Int) {
        navigationItems[groupPosition].apply {
            if (hasSubMenu) childItems[childPosition].selected = false
            else menuState = MenuView.MenuState.UNSELECTED
        }
    }

    fun setOnItemSelected(func: (Navigation) -> Unit) {
        onItemSelected = func
    }
}
