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
    private var selectedItemId: String? = null
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
            navigationItems[groupPosition].childItems[childPosition].apply {
                selectItem()
                onItemSelected(this)
            }

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
                selectItem()
                onItemSelected(this)
                oldGroupPosition = groupPosition
            }
        }
    }

    private fun resetMenuSelected(groupPosition: Int = oldGroupPosition, childPosition: Int = oldChildPosition) {
        navigationItems[groupPosition].apply {
            if (hasSubMenu) childItems[childPosition].selected = false
            else menuState = MenuView.MenuState.UNSELECTED
        }
    }

    private fun NavigationItemChild.selectItem() {
        resetMenuSelected(oldGroupPosition, oldChildPosition)
        selected = true
        selectedItemId = id
    }

    private fun NavigationItem.selectItem() {
        resetMenuSelected(oldGroupPosition, oldChildPosition)
        menuState = MenuView.MenuState.SELECTED
        selectedItemId = id
    }

    fun selectItemId(itemId: String) {
        if(selectedItemId != itemId && navigationItems.isNotEmpty()) {
            resetMenuSelected()

            var childIndex = NOT_FOUND_INDEX
            val groupIndex = navigationItems.indexOfFirst { item ->
                item.id == itemId || item.indexOfChildItemId(itemId).also { childIndex = it } != NOT_FOUND_INDEX
            }

            if(childIndex == NOT_FOUND_INDEX) {
                navigationItems.getOrNull(groupIndex)?.selectItem()
            } else {
                navigationItems.getOrNull(groupIndex)?.childItems?.getOrNull(childIndex)?.selectItem()
            }
            oldGroupPosition = groupIndex
            oldChildPosition = childIndex

            navigationAdapter.notifyDataSetChanged()
        }
    }

    fun setOnItemSelected(func: (Navigation) -> Unit) {
        onItemSelected = func
    }

    companion object {
        private const val NOT_FOUND_INDEX = -1
    }
}
