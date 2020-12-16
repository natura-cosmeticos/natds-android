package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.badge.Badge
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class BadgeActivity : AppCompatActivity() {
    private val incrementBadgeButton by lazy { findViewById<Button>(R.id.incrementBadgeButton) }
    private val badgeToIncrement by lazy { findViewById<Badge>(R.id.badgeToIncrement) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_badge)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Badge"

        incrementBadgeButton.setOnClickListener {
            incrementBadge(badgeToIncrement)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    private fun incrementBadge(badge: Badge) {
        badge.number += 1
    }
}
