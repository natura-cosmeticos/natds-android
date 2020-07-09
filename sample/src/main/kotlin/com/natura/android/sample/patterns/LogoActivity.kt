package com.natura.android.sample.patterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDarkTheme
import com.natura.android.sample.setChosenDefaultTheme

class LogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        supportActionBar?.title = "Logo Pattern"
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }

    private fun setTheme() {
        val darkMode = intent.getBooleanExtra("darkMode", false)

        if (darkMode) {
            setChosenDarkTheme()
        } else {
            setChosenDefaultTheme()
        }
    }
}
