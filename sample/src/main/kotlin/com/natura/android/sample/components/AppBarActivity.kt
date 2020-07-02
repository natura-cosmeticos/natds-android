package com.natura.android.sample.components

import android.app.SearchManager
import android.content.Context
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.natura.android.appbar.CountDrawable
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultWithNoActionBarTheme
import kotlinx.android.synthetic.main.activity_appbar.*

class AppBarActivity : AppCompatActivity() {

    private var searchMenuItem: MenuItem? = null
    private var profileMenuItem: MenuItem? = null
    private var linesMenuItem: MenuItem? = null

    lateinit var myMenu: Menu

    private var mCount = 4

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

                tvExample.text = mCount.toString()

                updateNotificationBadge(myMenu)

            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menu != null) {
            myMenu = menu
        }
        menuInflater.inflate(R.menu.custom_menu, menu)
        //o parametro count pode vir de um livedata?
        if (menu != null) {
            updateNotificationBadge(menu)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.ic_schedule -> Toast.makeText(this, "lines menu clicked", Toast.LENGTH_SHORT)
                .show()
//            R.id.searchMenuBtn -> updateToolbarMode(false)
//            R.id.linesMenuBtn -> Toast.makeText(this, "lines menu clicked", Toast.LENGTH_SHORT).show()
//            R.id.profileMenuBtn -> Toast.makeText(this, "profile menu clicked", Toast.LENGTH_SHORT).show()
            else -> onBackPressed()
        }

        return true
    }

    private fun updateNotificationBadge(menu: Menu) {
        menu.findItem(R.id.ic_group)?.let { setCount(this@AppBarActivity, mCount.toString(), it) }
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

    private fun setCount(
        context: Context,
        count: String,
        menuItem: MenuItem
    ) {

        val icon = menuItem.icon as LayerDrawable
        val countDrawable: CountDrawable
        val reuse =
            icon.findDrawableByLayerId(R.id.ic_group_count)

        countDrawable = if (reuse != null && reuse is CountDrawable) {
            reuse
        } else {
            CountDrawable(context)
        }
        countDrawable.setCount(count)
        icon.mutate()
        icon.setDrawableByLayerId(R.id.ic_group_count, countDrawable)
    }

}
