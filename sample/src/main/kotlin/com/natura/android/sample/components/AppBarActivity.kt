package com.natura.android.sample.components

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultWithNoActionBarTheme
import kotlinx.android.synthetic.main.activity_appbar.*

class AppBarActivity : AppCompatActivity() {

    private var mCount = 0

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
                tvExample.text = mCount.toString()
                appBar.updateNotificationBadge(mCount)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        appBar.displayMenuWithBadge(menu, R.id.ic_notification, mCount)
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
