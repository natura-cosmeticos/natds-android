package com.natura.android.sample.components.colors
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.natura.android.sample.R
import com.natura.android.sample.setContentViewWithBrand
import kotlinx.android.synthetic.main.activity_color.*

class ColorsActivity : AppCompatActivity() {

    var darkMode = false
    var currentTab = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        darkMode = intent.getBooleanExtra("darkMode", false)
        currentTab = intent.getIntExtra("currentTab", 0)
        setGlobalTheme(darkMode, currentTab)

        setContentView(R.layout.activity_color)
        setSupportActionBar(colorToolbar)

        brandsViewPager.adapter = ColorsTabAdapter(darkMode, supportFragmentManager)
        brandsViewPager.currentItem = currentTab
        colorTabs.setupWithViewPager(brandsViewPager)
        if(darkMode) {
            colorToolbar.background = ColorDrawable(resources.getColor(R.color.darkSurface))
        }
        setTabClickAction()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.colors_toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.darkThemeButton) {
            darkMode = !darkMode
            currentTab = brandsViewPager.currentItem
            val intent = Intent(baseContext, this.javaClass)
            intent.putExtra("darkMode", darkMode)
            intent.putExtra("currentTab", currentTab)
            startActivity(intent)
        } else {
            onBackPressed()
        }
        return true
    }

    private fun setTabClickAction() {
        colorTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val intent = Intent(baseContext, ColorsActivity::class.java)
                intent.putExtra("darkMode", darkMode)
                intent.putExtra("currentTab", tab?.position)
                startActivity(intent)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }


    private fun setGlobalTheme(darkMode: Boolean, currentTab: Int) {
        if(darkMode) {
            when(currentTab) {
                0 -> this.theme.applyStyle(R.style.Theme_NaturaDark_NoActionBar, true)
                1 -> this.theme.applyStyle(R.style.Theme_AvonDark_NoActionBar, true)
                else -> this.theme.applyStyle(R.style.Theme_BodyShopDark_NoActionBar, true)
            }
        } else {
            when(currentTab) {
                0 -> this.theme.applyStyle(R.style.Theme_Natura_NoActionBar, true)
                1 -> this.theme.applyStyle(R.style.Theme_Avon_NoActionBar, true)
                else -> this.theme.applyStyle(R.style.Theme_BodyShop_NoActionBar, true)
            }
        }

    }

}
