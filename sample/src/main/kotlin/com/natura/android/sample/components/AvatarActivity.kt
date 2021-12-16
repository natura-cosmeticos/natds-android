package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.databinding.ActivityAvatarBinding
import com.natura.android.sample.setChosenDefaultTheme

class AvatarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAvatarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)

        binding = ActivityAvatarBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.largexxxAvatarWithLabel.label = "Nayara Azevedo"
        binding.largexxxAvatarWithIcon.icon = R.drawable.outlined_action_like

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Avatar"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
