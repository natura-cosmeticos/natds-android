package com.natura.android.sample.tokens

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.setChosenTheme
import kotlinx.android.synthetic.main.activity_spacing.*

class SpacingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spacing)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Spacing"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
}
