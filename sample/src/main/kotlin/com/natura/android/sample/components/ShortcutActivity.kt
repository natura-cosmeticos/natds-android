package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme
import kotlinx.android.synthetic.main.activity_shortcut.*

class ShortcutActivity : AppCompatActivity() {
    var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shortcut)

        supportActionBar?.title = "Shortcut"
        supportActionBar?.setHomeButtonEnabled(true)

        shortCut2.setOnClickListener {
            Toast.makeText(this, "Teste", Toast.LENGTH_SHORT).show()
        }

        shortCut.setOnClickListener {
            Toast.makeText(this, "Teste 2", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
}
