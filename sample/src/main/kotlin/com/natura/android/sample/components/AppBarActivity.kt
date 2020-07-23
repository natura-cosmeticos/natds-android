package com.natura.android.sample.components

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.natura.android.badge.BadgeDrawable
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultWithNoActionBarTheme
import kotlinx.android.synthetic.main.activity_appbar.*
import kotlinx.android.synthetic.main.custom_app_bar.*

class AppBarActivity : AppCompatActivity() {

    private var searchMenuItem: MenuItem? = null
    private var profileMenuItem: MenuItem? = null
    private var linesMenuItem: MenuItem? = null
    private var notificationMenuItem: MenuItem? = null

    private var mMenu: Menu? = null
    private var mCount = 0
    private lateinit var badgeDrawable: BadgeDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultWithNoActionBarTheme()

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_appbar)
        setSupportActionBar(toolBarTop)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "App Bar Top"

        btnIncrement.apply {
            setOnClickListener {
                mCount++
                textViewExample.text = mCount.toString()
                badgeDrawable.updateBadgeDrawable(mCount)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        mMenu = menu

        menuInflater.inflate(R.menu.appbar_menu, menu)
        searchMenuItem = menu?.findItem(R.id.searchMenuBtn)
        profileMenuItem = menu?.findItem(R.id.profileMenuBtn)
        linesMenuItem = menu?.findItem(R.id.linesMenuBtn)
        notificationMenuItem = menu?.findItem(R.id.ic_notification)

        menu?.findItem(R.id.ic_notification)?.let { menuItem ->
            badgeDrawable = BadgeDrawable(
                this,
                mCount,
                menuItem.icon
            )
        }

        (searchMenuItem?.actionView as? SearchView)?.let {
            setupSearchView(it)
        }

        searchMenuItem?.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(menuItem: MenuItem): Boolean {
                updateToolbarMode(false)
                return true
            }

            override fun onMenuItemActionCollapse(menuItem: MenuItem): Boolean {
                updateToolbarMode(true)
                return true
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.searchMenuBtn -> updateToolbarMode(false)
            R.id.linesMenuBtn -> Toast.makeText(this, "lines menu clicked", Toast.LENGTH_SHORT).show()
            R.id.profileMenuBtn -> Toast.makeText(this, "profile menu clicked", Toast.LENGTH_SHORT).show()
            else -> onBackPressed()
        }

        return true
    }

    private fun setupSearchView(searchView: SearchView) {
        searchView.queryHint = "Search..."
        // Get the SearchView and set the searchable configuration
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setIconifiedByDefault(false)
    }

    private fun updateToolbarMode(menuMode: Boolean) {
        searchMenuItem?.isVisible = menuMode
        profileMenuItem?.isVisible = menuMode
        linesMenuItem?.isVisible = menuMode
        notificationMenuItem?.isVisible = menuMode
    }
}
