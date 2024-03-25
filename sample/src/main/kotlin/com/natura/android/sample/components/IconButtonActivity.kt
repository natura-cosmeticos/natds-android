package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.iconButton.IconButton
import com.natura.android.iconButton.IconButtonColor
import com.natura.android.sample.databinding.ActivityIconButtonBinding
import com.natura.android.sample.setChosenDefaultTheme

class IconButtonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIconButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)

        binding = ActivityIconButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Icon Button"
        setClickListener()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    private fun setClickListener() {
        for (i in 0 until binding.iconButtonActivityContainer.childCount) {
            if (binding.iconButtonActivityContainer.getChildAt(i) is IconButton) {
                binding.iconButtonActivityContainer.getChildAt(i).setOnClickListener {
                }
            }
        }

        binding.iconButtonColorDefault.setButtonColor(IconButtonColor.DEFAULT)
    }
}
