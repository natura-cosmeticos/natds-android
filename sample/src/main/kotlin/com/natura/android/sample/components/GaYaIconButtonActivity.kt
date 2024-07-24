package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.natura.android.iconButton.GaYaIconButton
import com.natura.android.iconButton.GaYaIconButtonColor
import com.natura.android.iconButton.GaYaIconButtonSize
import com.natura.android.iconButton.GaYaIconButtonType
import com.natura.android.sample.R
import com.natura.android.sample.databinding.ActivityGayaIconButtonBinding
import com.natura.android.sample.setChosenDefaultTheme

class GaYaIconButtonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGayaIconButtonBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        binding = ActivityGayaIconButtonBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "GaYaIconButton"

        val gayaIconButton = GaYaIconButton(this).apply {
            iconName = "filled_action_love"
            size = GaYaIconButtonSize.Large.value
            color = GaYaIconButtonColor.Secondary.value
            type = GaYaIconButtonType.Tonal.value
        }

        val container: LinearLayout = findViewById(R.id.lnlProgramatically)
        container.addView(gayaIconButton)
    }
}