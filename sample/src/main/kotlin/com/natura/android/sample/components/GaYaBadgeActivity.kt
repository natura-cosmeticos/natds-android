package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.natura.android.badge.GaYaBadgeColor
import com.natura.android.sample.databinding.ActivityGayaBadgeBinding
import com.natura.android.sample.setChosenDefaultTheme

class GaYaBadgeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGayaBadgeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        binding = ActivityGayaBadgeBinding.inflate(layoutInflater)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "GaYaBadge"

        binding.badgeStandardColorSuccess.color = GaYaBadgeColor.success

        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}