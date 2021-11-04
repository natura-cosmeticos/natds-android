package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.checkbox.CheckBox
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class CheckBoxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        val checkboxPrimaryChecked: CheckBox by lazy { findViewById<CheckBox>(R.id.checkboxPrimaryChecked) }
        val checkboxPrimaryDisabled: CheckBox by lazy { findViewById<CheckBox>(R.id.checkboxPrimaryDisabled) }
        val checkboxPrimaryIndeterminate: CheckBox by lazy { findViewById<CheckBox>(R.id.checkboxPrimaryIndeterminate) }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "CheckBox"

        checkboxPrimaryIndeterminate.setState(CheckBox.INDETERMINATE)
        checkboxPrimaryChecked.setState(CheckBox.CHECKED)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
