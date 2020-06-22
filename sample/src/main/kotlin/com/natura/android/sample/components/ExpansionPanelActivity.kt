package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class ExpansionPanelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_expansion_panel)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Expansion Panel"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
}
