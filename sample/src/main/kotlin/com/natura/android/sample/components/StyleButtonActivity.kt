package com.natura.android.sample.components

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.natura.android.sample.R
import com.natura.android.sample.setContentViewWithBrand

class StyleButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentViewWithBrand(R.layout.activity_styled_button)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Button"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
}