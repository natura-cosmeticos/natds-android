package com.natura.android.sample.components

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.natura.android.navigationview.ExpandableNavigationView
import com.natura.android.navigationview.NavigationItem
import com.natura.android.sample.R

class MenuActionTagActivity : AppCompatActivity() {

    private val expandableNavigationMenu: NavigationView by lazy {
        findViewById<NavigationView>(
            R.id.expandable_navigation_menu
        )
    }

    private val drawerLayout: DrawerLayout by lazy { findViewById<DrawerLayout>(R.id.drawer_layout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menu_action_tag)

        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_more)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val item1 = expandableNavigationMenu.menu.add(1, 1, 1, " Item 1")

        item1.setActionView(R.layout.menu_action_tag)
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
