package com.natura.android.sample.patterns

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.natura.android.error.DsErrorDefault
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class ErrorActivity : AppCompatActivity() {

    private val errorButton by lazy { findViewById<DsErrorDefault>(R.id.error_default) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        errorButton.listener = {
            val snackbar = Snackbar
                .make(errorButton, "RECARREGANDO", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Error Pattern"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
