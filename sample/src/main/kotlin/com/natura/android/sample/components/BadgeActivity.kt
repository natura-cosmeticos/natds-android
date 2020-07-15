package com.natura.android.sample.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.badge.BadgeDrawable
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme
import kotlinx.android.synthetic.main.activity_badge.*

class BadgeActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_badge)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Badge"

        val smallBadge = BadgeDrawable(this, count, imageViewBadged.drawable)

        btnIncrementBadge.setOnClickListener {
            count++
            imageViewBadged.contentDescription = count.toString()
            smallBadge.updateBadgeDrawable(count)
        }
    }
}