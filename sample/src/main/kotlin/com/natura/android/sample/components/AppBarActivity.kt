package com.natura.android.sample.components

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.appbar.SetupAppBar
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultWithNoActionBarTheme
import kotlinx.android.synthetic.main.activity_appbar.*
import kotlinx.android.synthetic.main.custom_app_bar.*

class AppBarActivity : AppCompatActivity() {

    private var mMenu: Menu? = null
    private var mCount = 0
    private var setupAppBarImpl = SetupAppBar()

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
                setupAppBarImpl.updateNotificationBadge(mMenu, mCount, R.id.ic_notification)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        mMenu = menu
        setupAppBarImpl.displayMenuWithBadge(
            this,
            menu,
            R.menu.custom_menu,
            mCount,
            R.id.ic_notification
        )

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.ic_schedule -> Toast.makeText(this, "lines menu clicked", Toast.LENGTH_SHORT)
                .show()
            R.id.searchMenuBtn -> updateToolbarMode(false)
            R.id.linesMenuBtn -> Toast.makeText(this, "lines menu clicked", Toast.LENGTH_SHORT)
                .show()
            R.id.profileMenuBtn -> Toast.makeText(this, "profile menu clicked", Toast.LENGTH_SHORT)
                .show()
            else -> onBackPressed()
        }

        return true
    }

    private fun updateToolbarMode(menuMode: Boolean) {
    }

}
