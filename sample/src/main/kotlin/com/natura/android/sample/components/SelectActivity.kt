package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.databinding.ActivitySelectBinding
import com.natura.android.sample.setChosenDefaultTheme

class SelectActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)

        binding = ActivitySelectBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val arraySpinner = listOf("Item 1", "Item 2", "Item 3", "Item 4")
        val arrayAdapter = ArrayAdapter(this, R.layout.custom_spinner_dropdown_item, arraySpinner)

        binding.selectDefault.spinner.adapter = arrayAdapter
        binding.selectDisabled.spinner.adapter = arrayAdapter
        binding.selectMedium.spinner.adapter = arrayAdapter
        binding.selectMediumX.spinner.adapter = arrayAdapter
        binding.selectRequired.spinner.adapter = arrayAdapter
        binding.selectWithError.spinner.adapter = arrayAdapter
        binding.selectWithSuccess.spinner.adapter = arrayAdapter
        binding.selectReadOnly.spinner.adapter = arrayAdapter
        binding.selectHelperText.spinner.adapter = arrayAdapter

        binding.selectHelperText.spinner.selectedItem.toString()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Select"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
