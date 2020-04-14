package com.natura.android.sample.components

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.natura.android.error.DsErrorDefault
import com.natura.android.sample.R

class ErrorActivity : AppCompatActivity() {

    private val errorButton by lazy { findViewById<DsErrorDefault>(R.id.error_default) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        errorButton.listener = {
            val snackbar = Snackbar
                .make(errorButton, "RECARREGANDO", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Error Pattern")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
}
