package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.databinding.ActivityShortcutBinding
import com.natura.android.sample.setChosenDefaultTheme
import com.natura.android.shortcut.Shortcut

class ShortcutActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var binding: ActivityShortcutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()
        super.onCreate(savedInstanceState)

        binding = ActivityShortcutBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.title = "Shortcut"
        supportActionBar?.setHomeButtonEnabled(true)
        setClickListener()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    private fun setClickListener() {
        for (i in 0 until binding.shortcutContainer.childCount) {
            if (binding.shortcutContainer.getChildAt(i) is Shortcut) {
                binding.shortcutContainer.getChildAt(i).setOnClickListener {
                    increaseCount()
                }
            }
        }
    }

    private fun increaseCount() {
        count += 1
        binding.counter.text = "Counter click $count"
    }
}
