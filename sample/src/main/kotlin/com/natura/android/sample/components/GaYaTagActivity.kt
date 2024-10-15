package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.LinearLayout
import com.natura.android.sample.R
import com.natura.android.sample.databinding.ActivityGayaTagBinding
import com.natura.android.sample.setChosenDefaultTheme
import com.natura.android.switch.GaYaSwitch
import com.natura.android.tag.GaYaTag
import com.natura.android.tag.GaYaTagColor
import com.natura.android.tag.GaYaTagPosition
import com.natura.android.tag.GaYaTagSize

class GaYaTagActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGayaTagBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()
        super.onCreate(savedInstanceState)

        binding = ActivityGayaTagBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.title = "GaYaTag"
        supportActionBar?.setHomeButtonEnabled(true)

        val gayaTag = GaYaTag(this).apply {
            label = "Adicionado programaticamente"
            color = GaYaTagColor.InfoLightest.value
            size = GaYaTagSize.Standard.value
            icon = "outlined_action_calendar"
            position = GaYaTagPosition.Right.value
        }

        val container: LinearLayout = findViewById(R.id.lnlProgramatically)
        container.addView(gayaTag)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}