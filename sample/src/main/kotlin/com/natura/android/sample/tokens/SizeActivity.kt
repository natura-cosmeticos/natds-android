package com.natura.android.sample.tokens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.natura.android.sample.R
import com.natura.android.sample.setChosenTheme

class SizeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_size)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Size"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
}
