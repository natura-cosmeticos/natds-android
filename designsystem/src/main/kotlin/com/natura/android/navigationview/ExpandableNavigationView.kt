package com.natura.android.navigationview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ExpandableListView
import com.google.android.material.navigation.NavigationView
import com.natura.android.R

class ExpandableNavigationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : NavigationView(context, attrs, defStyleAttr) {

    private val navigationMenu: ExpandableListView by lazy { findViewById<ExpandableListView>(R.id.navigation_menu) }
    private lateinit var navigationAdapter: ExpandableNavigationAdapter

    init {
        View.inflate(context, R.layout.ds_expandable_navigation_view, this)
    }

    fun initMenuItems(navigationItems: List<NavigationItem>) {
        navigationAdapter = ExpandableNavigationAdapter(context, navigationItems.toMutableList())
        navigationMenu.setAdapter(navigationAdapter)
    }
}
