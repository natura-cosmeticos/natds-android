package com.natura.android.sample.tokens
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.natura.android.sample.R
import kotlinx.android.synthetic.main.activity_color.*

class ColorsActivity : AppCompatActivity() {

    private var darkMode = false
    private var currentTab = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        darkMode = intent.getBooleanExtra("darkMode", false)
        currentTab = intent.getIntExtra("currentTab", 0)
        setGlobalTheme(darkMode, currentTab)

        setContentView(R.layout.activity_color)
        setSupportActionBar(colorToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        colorToolBar(darkMode)

        val selectedTab = colorTabs.getTabAt(currentTab)
        selectedTab?.select()

        setTabClickAction()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.colors_toolbar_menu, menu)
        setDarkModeButtonIcon(darkMode, menu?.findItem(R.id.darkThemeButton))
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.darkThemeButton) {
            setDarkModeButtonIcon(darkMode, item)
            darkMode = !darkMode
            restartScreenToApplyTheme(darkMode, currentTab)
        } else {
            onBackPressed()
        }
        return true
    }

    private fun setDarkModeButtonIcon(darkMode: Boolean, menuItem: MenuItem?) {
        if (darkMode) {
            menuItem?.setIcon(R.drawable.ds_ic_outlined_action_lightoff)
        } else {
            menuItem?.setIcon(R.drawable.ds_ic_outlined_action_lighton)
        }
    }

    private fun colorToolBar(darkMode: Boolean) {
        if (darkMode) {
            colorToolbar.background = ColorDrawable(resources.getColor(R.color.darkSurface))
        }
    }

    private fun setTabClickAction() {
        colorTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                restartScreenToApplyTheme(darkMode, tab?.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun restartScreenToApplyTheme(darkMode: Boolean, currentTab: Int? = 0) {
        val intent = Intent(baseContext, ColorsActivity::class.java)
        intent.putExtra("darkMode", darkMode)
        intent.putExtra("currentTab", currentTab)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
        finish()
        overridePendingTransition(0, 0)
    }

    private fun setGlobalTheme(darkMode: Boolean, currentTab: Int) {
        if (darkMode) {
            when (currentTab) {
                0 -> this.theme.applyStyle(R.style.Theme_NaturaDark_NoActionBar, true)
                1 -> this.theme.applyStyle(R.style.Theme_AvonDark_NoActionBar, true)
                else -> this.theme.applyStyle(R.style.Theme_BodyShopDark_NoActionBar, true)
            }
        } else {
            when (currentTab) {
                0 -> this.theme.applyStyle(R.style.Theme_Natura_NoActionBar, true)
                1 -> this.theme.applyStyle(R.style.Theme_Avon_NoActionBar, true)
                else -> this.theme.applyStyle(R.style.Theme_BodyShop_NoActionBar, true)
            }
        }
    }
}
