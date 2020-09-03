package com.natura.android.sample.tokens
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.getChosenBrand
import com.natura.android.sample.setChosenDarkTheme
import com.natura.android.sample.setChosenDefaultTheme

class ColorsActivity : AppCompatActivity() {

    private var darkMode = false
    private var currentTab = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        darkMode = intent.getBooleanExtra("darkMode", false)
        setGlobalTheme(darkMode)

        setContentView(R.layout.activity_color)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Colors ${getChosenBrand().toUpperCase()}"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.colors_toolbar_menu, menu)
        setDarkModeButtonIcon(darkMode, menu?.findItem(R.id.darkThemeButton))
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == R.id.darkThemeButton) {
            setDarkModeButtonIcon(darkMode, item)
            darkMode = !darkMode
            restartScreenToApplyTheme(darkMode)
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

    private fun restartScreenToApplyTheme(darkMode: Boolean) {
        val intent = Intent(baseContext, ColorsActivity::class.java)
        intent.putExtra("darkMode", darkMode)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
        finish()
        overridePendingTransition(0, 0)
    }

    private fun setGlobalTheme(darkMode: Boolean) {
        if (darkMode) {
            setChosenDarkTheme()
        } else {
            setChosenDefaultTheme()
        }
    }
}
