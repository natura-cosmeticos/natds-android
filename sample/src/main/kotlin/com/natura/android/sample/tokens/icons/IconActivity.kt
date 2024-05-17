package com.natura.android.sample.tokens.icons

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class IconActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon)

        val iconGrid = findViewById<RecyclerView>(R.id.icon_grid)
        iconGrid.layoutManager = GridLayoutManager(this, 3)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Icons (fonts)"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
