package com.natura.android.sample.components

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.natura.android.sample.R
import kotlinx.android.synthetic.main.activity_main.view.*


class AppBarActivity : AppCompatActivity() {

    private val toolbarDefault by lazy { findViewById<Toolbar>(R.id.toolbarDefault) }
    private val toolbarPrimary by lazy { findViewById<Toolbar>(R.id.toolbarPrimary) }
    private val toolbarSecondary by lazy { findViewById<Toolbar>(R.id.toolbarSecondary) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_appbar)
        setSupportActionBar(toolbarDefault)

        val styleDefault = findViewById<View>(R.id.style_default)
        styleDefault.setOnClickListener {
            toolbarDefault.visibility = View.VISIBLE
            toolbarPrimary.visibility = View.GONE
            toolbarSecondary.visibility = View.GONE
        }

        val stylePrimary = findViewById<View>(R.id.style_primary)
        stylePrimary.setOnClickListener {
            toolbarDefault.visibility = View.GONE
            toolbarPrimary.visibility = View.VISIBLE
            toolbarSecondary.visibility = View.GONE
            Toast.makeText(this, "toolbar icons disabled", Toast.LENGTH_SHORT).show()
        }

        val styleSecondary = findViewById<View>(R.id.style_secondary)
        styleSecondary.setOnClickListener {
            toolbarDefault.visibility = View.GONE
            toolbarPrimary.visibility = View.GONE
            toolbarSecondary.visibility = View.VISIBLE
            Toast.makeText(this, "toolbar icons disabled", Toast.LENGTH_SHORT).show()
        }

    }

    private var searchMenuItem: MenuItem? = null
    private var profileMenuItem: MenuItem? = null
    private var linesMenuItem: MenuItem? = null

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)
        searchMenuItem = menu?.findItem(R.id.searchMenuBtn)
        profileMenuItem = menu?.findItem(R.id.profileMenuBtn)
        linesMenuItem = menu?.findItem(R.id.linesMenuBtn)

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
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.searchMenuBtn -> updateToolbarMode(false)
            R.id.linesMenuBtn -> Toast.makeText(this, "lines menu clicked", Toast.LENGTH_SHORT).show()
            R.id.profileMenuBtn -> Toast.makeText(this, "profile menu clicked", Toast.LENGTH_SHORT).show()
        }

        return true
    }
}
