package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class GaYaButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaya_button)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "GaYaButton"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}