package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.checkbox.GaYaCheckbox
import com.natura.android.checkbox.GaYaCheckboxState
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class GaYaCheckboxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        val checkboxPrimaryChecked: GaYaCheckbox by lazy { findViewById(R.id.checkboxPrimaryChecked) }
        val checkboxPrimaryIndeterminate: GaYaCheckbox by lazy { findViewById(R.id.checkboxPrimaryIndeterminate) }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaya_checkbox)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "GaYaCheckbox"

        checkboxPrimaryIndeterminate.state = GaYaCheckboxState.INDETERMINATE
        checkboxPrimaryChecked.state = GaYaCheckboxState.CHECKED

        val gaYaCheckbox = GaYaCheckbox(this).apply {
            text = "Adicionado programaticamente"
            isChecked = true
            isEnabled = true
        }

        val gaYaCheckboxAvon = GaYaCheckbox(this, R.style.Theme_Avon_Light_SSOT).apply {
            text = "GaYaCheckbox Avon"
            isChecked = true
            isEnabled = true
        }

        val container: LinearLayout = findViewById(R.id.lnlProgramatically)
        container.addView(gaYaCheckbox)
        container.addView(gaYaCheckboxAvon)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
