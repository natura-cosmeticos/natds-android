package com.natura.android.sample.components.colors
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.natura.android.sample.R
import kotlinx.android.synthetic.main.activity_color.*

class ColorsActivity : AppCompatActivity() {

    var darkMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        setSupportActionBar(colorToolbar)

        brandsViewPager.adapter = ColorsTabAdapter(darkMode, supportFragmentManager)

        colorTabs.setupWithViewPager(brandsViewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.colors_toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.darkThemeButton) {
            if(darkMode) {
                item.setIcon(R.drawable.ds_ic_outlined_action_lighton)
                brandsViewPager.adapter = ColorsTabAdapter(false, supportFragmentManager)
                supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.lightBackground)))
                colorTabs.background = ColorDrawable(resources.getColor(R.color.lightBackground))
                darkMode = false
            } else {
                val iconLightOff = resources.getDrawable(R.drawable.ds_ic_outlined_action_lightoff)
                item.setIcon(iconLightOff)
                brandsViewPager.adapter = ColorsTabAdapter(true, supportFragmentManager)
                supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.darkBackground)))
                colorTabs.background = ColorDrawable(resources.getColor(R.color.darkBackground))
                darkMode = true
            }
        } else {
            onBackPressed()
        }
        return true
    }
}
