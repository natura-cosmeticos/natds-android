package com.natura.android.navigationview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.natura.android.R
import com.natura.android.menu.MenuView
import com.natura.android.menu.SubMenuView

class ExpandableNavigationAdapter(
    private val context: Context,
    private val navigationItems: MutableList<NavigationItem>
) : BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int) = navigationItems[groupPosition]

    override fun isChildSelectable(groupPosition: Int, childPosition: Int) = true

    override fun hasStableIds() = true

    override fun getChildrenCount(groupPosition: Int) =
        navigationItems[groupPosition].childItems.size

    override fun getChild(groupPosition: Int, childPosition: Int) =
        navigationItems[groupPosition].childItems[childPosition]

    override fun getGroupId(groupPosition: Int) = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int) = childPosition.toLong()

    override fun getGroupCount() = navigationItems.size

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val parentView = convertView
            ?: LayoutInflater.from(context).inflate(R.layout.ds_submenu_item, null)

        val childView = parentView.findViewById<SubMenuView>(R.id.child_item)
        navigationItems[groupPosition].childItems[childPosition].let { item ->
            childView.apply {
                label = item.label
                isLowEmphasis = item.isLowEmphasis
                isEnabled = item.enabled
                isSelected = item.selected
            }
        }

        return parentView
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val parentView = LayoutInflater.from(context).inflate(R.layout.ds_menu_item, null)

        val groupView = parentView.findViewById<MenuView>(R.id.menu_item)
        navigationItems[groupPosition].let { item ->
            groupView.apply {
                label = item.label
                icon = item.iconText
                isLowEmphasis = item.isLowEmphasis
                showArrow(item.hasSubMenu)
                configStateMenu(item.menuState)
                showTag(item.showTag)
                tagLabel = item.tagLabel
            }
        }

        return parentView
    }
}
