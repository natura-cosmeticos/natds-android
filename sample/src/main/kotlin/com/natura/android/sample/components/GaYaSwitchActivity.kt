package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import com.natura.android.radiobutton.GaYaRadiobutton
import com.natura.android.sample.R
import com.natura.android.sample.databinding.ActivityGayaSwitchBinding
import com.natura.android.sample.setChosenDefaultTheme
import com.natura.android.switch.GaYaSwitch

class GaYaSwitchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGayaSwitchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        binding = ActivityGayaSwitchBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "GaYaSwitch"

        val gaYaSwitch = GaYaSwitch(this).apply {
            isChecked = true
            isEnabled = true
        }

        val gaYaSwitchAvon = GaYaSwitch(this, R.style.Theme_Avon_Light_SSOT).apply {
            isChecked = true
            isEnabled = true
        }

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = Gravity.START
        }

        gaYaSwitch.layoutParams = layoutParams

        val container: LinearLayout = findViewById(R.id.lnlProgramatically)
        container.addView(gaYaSwitch)

    }
}