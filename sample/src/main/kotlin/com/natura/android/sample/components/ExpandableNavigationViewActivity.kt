package com.natura.android.sample.components

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.natura.android.navigationview.ExpandableNavigationView
import com.natura.android.navigationview.NavigationItem
import com.natura.android.navigationview.NavigationItemChild
import com.natura.android.sample.R

class ExpandableNavigationViewActivity :
    AppCompatActivity() {

    private val expandableNavigationMenu: ExpandableNavigationView by lazy {
        findViewById<ExpandableNavigationView>(
            R.id.expandable_navigation_menu
        )
    }
    private val drawerLayout: DrawerLayout by lazy { findViewById<DrawerLayout>(R.id.drawer_layout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_expandable_navigation_view)

        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_more)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val list = listOf(
            NavigationItem(
                label = "Item 1",
                iconDrawable = R.drawable.ic_home,
                childItems = mutableListOf(
                    NavigationItemChild("Item 1 sub 1", enabled = true),
                    NavigationItemChild("Item 1 sub 2", enabled = false),
                    NavigationItemChild("Item 1 sub 3")
                )
            ),
            NavigationItem(
                label = "Item 2",
                iconDrawable = R.drawable.ic_home,
                childItems = mutableListOf(
                    NavigationItemChild("Item 2 sub 1", enabled = true),
                    NavigationItemChild("Item 2 sub 2", enabled = false),
                    NavigationItemChild("Item 2 sub 3")
                )
            ),
            NavigationItem(
                label = "Item 3",
                iconDrawable = R.drawable.ic_home,
                childItems = mutableListOf(
                    NavigationItemChild("Item 3 sub 1", enabled = true),
                    NavigationItemChild("Item 3 sub 2", enabled = false),
                    NavigationItemChild("Item 3 sub 3")
                )
            ),
            NavigationItem(
                label = "Item 4",
                iconDrawable = R.drawable.ic_home,
                childItems = mutableListOf(
                    NavigationItemChild("Item 4 sub 1"),
                    NavigationItemChild("Item 4 sub 2"),
                    NavigationItemChild("Item 4 sub 3")
                )
            )
        )

        expandableNavigationMenu.initMenuItems(list)

        drawerLayout.setScrimColor(ContextCompat.getColor(this, R.color.colorBrdNatOrange))

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}