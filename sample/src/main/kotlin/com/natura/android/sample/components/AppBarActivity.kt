package com.natura.android.sample.components

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultWithNoActionBarTheme
import kotlinx.android.synthetic.main.activity_appbar.*

class AppBarActivity : AppCompatActivity() {

    private var mCount = 0
    private var searchMenuItem: MenuItem? = null
    private var notificationMenuItem: MenuItem? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultWithNoActionBarTheme()

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_appbar)
        setSupportActionBar(appBar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appBar.showLogo()

        btnIncrement.apply {
            setOnClickListener {
                mCount++
                appBar.updateBadgeValue(mCount)
                textViewExample.text = mCount.toString()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)

        searchMenuItem = menu?.findItem(R.id.searchMenuBtn)
        notificationMenuItem = menu?.findItem(R.id.ic_notification)
        notificationMenuItem?.let {
            appBar.addMenuIconBadge(it.icon, mCount)
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
            R.id.ic_notification -> Toast.makeText(this, "notifications menu clicked", Toast.LENGTH_SHORT).show()
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
        notificationMenuItem?.isVisible = menuMode
    }
}
