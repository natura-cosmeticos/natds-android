package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.databinding.ActivityChipBinding
import com.natura.android.sample.setChosenDefaultTheme

class ChipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChipBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)

        binding = ActivityChipBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Chip"

        binding.chipAction.getChildAt(0).setOnClickListener {
            increaseCount()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    private fun increaseCount() {
        count += 1
        binding.chipCounter.text = "Counter click $count"
    }
}
