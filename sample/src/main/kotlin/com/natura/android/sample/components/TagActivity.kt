package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.databinding.ActivityTagBinding
import com.natura.android.sample.setChosenDefaultTheme

class TagActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTagBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        supportActionBar?.title = "Tag"
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
