package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme
import com.natura.android.shortcut.Shortcut
import kotlinx.android.synthetic.main.activity_shortcut.*


class ShortcutActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shortcut)

        supportActionBar?.title = "Shortcut"
        supportActionBar?.setHomeButtonEnabled(true)

        setClickListener()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }

    private fun setClickListener() {
        for (i in 0 until shortcutContainer.childCount) {
            if (shortcutContainer.getChildAt(i) is Shortcut){
                shortcutContainer.getChildAt(i).setOnClickListener {
                    increaseCount()
                }
            }
        }
    }

    private fun increaseCount() {
        count += 1
        counter.text = "Counter click $count"
    }
}

