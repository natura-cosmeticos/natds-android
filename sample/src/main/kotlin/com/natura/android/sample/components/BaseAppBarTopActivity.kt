package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultWithNoActionBarTheme
import kotlinx.android.synthetic.main.activity_baseappbar_top.*

class BaseAppBarTopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultWithNoActionBarTheme()

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_baseappbar_top)

        setSupportActionBar(appBar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        createListeners()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun createListeners() {
        shortcutContained.setOnClickListener {
        }
    }
}
