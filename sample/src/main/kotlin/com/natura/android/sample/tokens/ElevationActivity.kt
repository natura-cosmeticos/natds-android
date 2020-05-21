package com.natura.android.sample.tokens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.natura.android.sample.R
import com.natura.android.sample.setChosenTheme

class ElevationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elevation)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Elevation"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
}
