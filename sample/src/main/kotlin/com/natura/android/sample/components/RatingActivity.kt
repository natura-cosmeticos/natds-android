package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.databinding.ActivityRatingBinding
import com.natura.android.sample.setChosenDefaultTheme

class RatingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRatingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)

        binding = ActivityRatingBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Rating"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
