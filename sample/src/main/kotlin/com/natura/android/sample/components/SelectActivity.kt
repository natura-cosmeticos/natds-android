package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.resources.getColorTokenFromTheme
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

        val arraySpinner = listOf("Placeholder", "Item 1", "Item 2", "Item 3")

        val arrayAdapter = object :
            ArrayAdapter<String>(this, R.layout.custom_spinner_dropdown_item, arraySpinner) {

            override fun isEnabled(position: Int): Boolean {
                return position != 0
            }

            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView =
                    super.getDropDownView(position, convertView, parent) as TextView
                if (position == 0) {
                    view.setTextColor(getColorTokenFromTheme(context, R.attr.colorMediumEmphasis))
                }
                return view
            }
        }

        binding.selectDefault.spinner.adapter = arrayAdapter
        binding.selectDisabled.spinner.adapter = arrayAdapter
        binding.selectMedium.spinner.adapter = arrayAdapter
        binding.selectMediumX.spinner.adapter = arrayAdapter
        binding.selectRequired.spinner.adapter = arrayAdapter
        binding.selectWithError.spinner.adapter = arrayAdapter
        binding.selectWithSuccess.spinner.adapter = arrayAdapter
        binding.selectHelperText.spinner.adapter = arrayAdapter

        binding.selectHelperText.spinner.selectedItem.toString()

        (binding.selectReadOnly.spinner).apply {
            this.adapter = arrayAdapter
            this.setSelection(2)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Select"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
