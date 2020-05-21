package com.natura.android.sample.tokens

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.setChosenTheme
import kotlinx.android.synthetic.main.activity_spacing.*

class TypographyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_typography)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Typography"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
}
