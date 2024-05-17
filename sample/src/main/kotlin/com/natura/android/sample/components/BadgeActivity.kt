package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.badge.Badge
import com.natura.android.badge.BadgeColor
import com.natura.android.sample.R
import com.natura.android.sample.databinding.ActivityAppbarTopBinding
import com.natura.android.sample.databinding.ActivityBadgeBinding
import com.natura.android.sample.setChosenDefaultTheme

class BadgeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBadgeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        binding = ActivityBadgeBinding.inflate(layoutInflater)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Badge"

        binding.badgeStandardColorSuccess.color = BadgeColor.colorSuccess

        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
