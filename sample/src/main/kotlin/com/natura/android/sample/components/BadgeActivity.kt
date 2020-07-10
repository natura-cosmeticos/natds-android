package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.icon.BadgeDrawable
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme
import kotlinx.android.synthetic.main.activity_badge.*

class BadgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_badge)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Badge"

        BadgeDrawable(this, 150, imageView.drawable)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
}