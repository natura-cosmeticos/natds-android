package com.natura.android.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.data.ThemeRepository
import kotlinx.android.synthetic.main.activity_brand_selector.*


class BrandSelectorActivity : AppCompatActivity(), View.OnClickListener  {

    lateinit var themeRepository: ThemeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        themeRepository = ThemeRepository(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brand_selector)

        supportActionBar?.title = "Choose a brand"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setBrandButtonsActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            naturaThemeButton.id -> openSampleBy(R.style.Theme_Natura)
            avonThemeButton.id -> openSampleBy(R.style.Theme_Avon)
            tbsThemeButton.id -> openSampleBy(R.style.Theme_BodyShop)
        }
    }

    private fun setBrandButtonsActions() {
        naturaThemeButton.setOnClickListener(this)
        avonThemeButton.setOnClickListener(this)
        tbsThemeButton.setOnClickListener(this)
    }

    private fun openSampleBy(brandTheme: Int) {
            themeRepository.saveChosenTheme(brandTheme)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
    }
}