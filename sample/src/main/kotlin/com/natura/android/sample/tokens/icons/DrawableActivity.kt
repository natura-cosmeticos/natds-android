package com.natura.android.sample.tokens.icons

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natura.android.sample.R
import com.natura.android.sample.data.IconsRepository
import com.natura.android.sample.setChosenDefaultTheme

class DrawableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon)

        val iconGrid = findViewById<RecyclerView>(R.id.icon_grid)
        iconGrid.layoutManager = GridLayoutManager(this, 2)

        iconGrid.adapter =
            DrawableAdapter(
                this,
                IconsRepository(this).getIconsIdsList(),
                IconsRepository(this).getIconsNamesFromFile()
            )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Icons (drawables)")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
}
