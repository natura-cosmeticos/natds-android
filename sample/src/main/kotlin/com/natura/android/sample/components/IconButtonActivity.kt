package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.iconButton.IconButton
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme
import kotlinx.android.synthetic.main.activity_icon_button.*

class IconButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon_button)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Icon Button"
        setClickListener()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    private fun setClickListener() {
        for (i in 0 until iconButtonActivityContainer.childCount) {
            if (iconButtonActivityContainer.getChildAt(i) is IconButton) {
                iconButtonActivityContainer.getChildAt(i).setOnClickListener {
                }
            }
        }
    }
}
