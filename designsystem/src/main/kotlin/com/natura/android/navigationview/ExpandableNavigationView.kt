package com.natura.android.navigationview

import android.content.Context
import android.support.design.widget.NavigationView
import android.util.AttributeSet
import android.view.View
import android.widget.ExpandableListView
import com.natura.android.R

class ExpandableNavigationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : NavigationView(context, attrs, defStyleAttr), ExpandableListView.OnChildClickListener {

    private val navigationMenu: ExpandableListView by lazy { findViewById<ExpandableListView>(R.id.navigation_menu) }
    private lateinit var navigationAdapter: ExpandableNavigationAdapter
    private lateinit var navigationItems: List<NavigationItem>
    private var oldGroupPosition = 0
    private var oldChildPosition = 0

    init {
        View.inflate(context, R.layout.ds_expandable_navigation_view, this)
    }

    fun initMenuItems(navigationItems: List<NavigationItem>) {
        this.navigationItems = navigationItems
        navigationAdapter = ExpandableNavigationAdapter(context, navigationItems.toMutableList())
        navigationMenu.setAdapter(navigationAdapter)

        navigationMenu.setOnChildClickListener(this)
    }

    override fun onChildClick(
        parent: ExpandableListView?,
        v: View?,
        groupPosition: Int,
        childPosition: Int,
        id: Long
    ): Boolean {

        navigationItems[oldGroupPosition].childItems[oldChildPosition].selected = false
        navigationItems[groupPosition].childItems[childPosition].selected = true
        oldGroupPosition = groupPosition
        oldChildPosition = childPosition
        navigationAdapter.notifyDataSetChanged()
        return true
    }
}
