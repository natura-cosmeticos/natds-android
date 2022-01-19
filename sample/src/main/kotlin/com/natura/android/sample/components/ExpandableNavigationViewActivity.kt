package com.natura.android.sample.components

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.natura.android.menu.MenuView
import com.natura.android.navigationview.ExpandableNavigationView
import com.natura.android.navigationview.NavigationItem
import com.natura.android.navigationview.NavigationItemChild
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class ExpandableNavigationViewActivity : AppCompatActivity() {

    private val expandableNavigationMenu: ExpandableNavigationView by lazy {
        findViewById(
            R.id.expandable_navigation_menu
        )
    }
    private val drawerLayout: DrawerLayout by lazy { findViewById(R.id.drawer_layout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_expandable_navigation_view)

        supportActionBar?.title = "Navigation Drawer"
        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_more)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val list = listOf(
            NavigationItem(
                id = "item_id_1",
                label = "Item 1",
                childItems = mutableListOf(
                    NavigationItemChild(
                        id = "sub_item_id_1",
                        label = "Item 1 sub 1",
                        enabled = true
                    ),
                    NavigationItemChild(id = "item_id", label = "Item 1 sub 2", enabled = false),
                    NavigationItemChild(id = "item_id", label = "Item 1 sub 3")
                )
            ),
            NavigationItem(
                id = "item_id_2",
                label = "Item 2 (Disabled)",
                menuState = MenuView.MenuState.DISABLE,
                iconText = getString(R.string.icon_filled_brand_naturarosacea),
                childItems = mutableListOf(
                    NavigationItemChild(id = "item_id", label = "Item 2 sub 1", enabled = true),
                    NavigationItemChild(id = "item_id", label = "Item 2 sub 2", enabled = false),
                    NavigationItemChild(id = "item_id", label = "Item 2 sub 3")
                )
            ),
            NavigationItem(
                id = "item_id_3",
                label = "Item 3",
                iconText = "as",
                childItems = mutableListOf(
                    NavigationItemChild(id = "item_id", label = "Item 3 sub 1", enabled = true),
                    NavigationItemChild(id = "item_id", label = "Item 3 sub 2", enabled = false),
                    NavigationItemChild(id = "item_id", label = "Item 3 sub 3")
                )
            ),
            NavigationItem(
                id = "item_id_4",
                label = "Item 4",
                iconText = getString(R.string.icon_filled_brand_naturarosacea),
                childItems = mutableListOf(
                    NavigationItemChild(id = "item_id", label = "Item 4 sub 1"),
                    NavigationItemChild(id = "item_id", label = "Item 4 sub 2"),
                    NavigationItemChild(id = "item_id", label = "Item 4 sub 3")
                )
            ),
            NavigationItem(
                id = "item_id_5",
                label = "Item 5",
                iconText = getString(R.string.icon_filled_brand_naturarosacea),
                hasSubMenu = false
            ),
            NavigationItem(
                id = "item_id_6",
                label = "Item 6 (Low Emphasis)",
                isLowEmphasis = true,
                iconText = getString(R.string.icon_filled_brand_naturarosacea),
                hasSubMenu = false
            )
        )

        expandableNavigationMenu.initMenuItems(list)
        expandableNavigationMenu.selectItemId("item_id_5")

        expandableNavigationMenu.setOnItemSelected {
            Toast.makeText(
                this,
                "Item Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }
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
