package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import com.natura.android.radiobutton.GaYaRadiobutton
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class GaYaRadiobuttonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaya_radiobutton)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "GaYaRadiobutton"

        val gaYaRadiobutton = GaYaRadiobutton(this).apply {
            text = "Adicionado programaticamente"
            isChecked = true
            isEnabled = true
        }

        val gaYaRadiobuttonAvon = GaYaRadiobutton(this, R.style.Theme_Avon_Light_SSOT).apply {
            text = "GaYaRadiobutton Avon"
            isChecked = true
            isEnabled = true
        }

        val container: LinearLayout = findViewById(R.id.lnlProgramatically)
        container.addView(gaYaRadiobutton)
        container.addView(gaYaRadiobuttonAvon)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
