package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.badge.BadgeDrawable
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme
import kotlinx.android.synthetic.main.activity_badge.*

const val EXAMPLE_BADGE_COUNT_1 = 1
const val EXAMPLE_BADGE_COUNT_90 = 90
const val EXAMPLE_BADGE_COUNT_100 = 100
class BadgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_badge)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Badge"

        BadgeDrawable(this, EXAMPLE_BADGE_COUNT_1, imageViewSmall.drawable)
        BadgeDrawable(this, EXAMPLE_BADGE_COUNT_90, imageViewNormal.drawable)
        BadgeDrawable(this, EXAMPLE_BADGE_COUNT_100, imageViewBig.drawable)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
}
