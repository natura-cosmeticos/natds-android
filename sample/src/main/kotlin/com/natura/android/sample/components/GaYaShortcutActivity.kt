package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.natura.android.iconButton.GaYaIconButton
import com.natura.android.iconButton.GaYaIconButtonColor
import com.natura.android.iconButton.GaYaIconButtonSize
import com.natura.android.iconButton.GaYaIconButtonType
import com.natura.android.sample.R
import com.natura.android.sample.databinding.ActivityGayaShortcutBinding
import com.natura.android.sample.setChosenDefaultTheme
import com.natura.android.shortcut.GaYaShortcut
import com.natura.android.shortcut.GaYaShortcutColor
import com.natura.android.shortcut.GaYaShortcutStyle
import com.natura.android.shortcut.GaYaShortcutType

class GaYaShortcutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGayaShortcutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        binding = ActivityGayaShortcutBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "GaYaShortcut"

        val gayaShortcut = GaYaShortcut(this).apply {
            iconName = "filled_action_love"
            color = GaYaShortcutColor.Secondary.value
            type = GaYaShortcutType.Tonal.value
            label = "Standard"
        }

        val gayaShortcutInline = GaYaShortcut(this).apply {
            iconName = "filled_action_rating"
            color = GaYaShortcutColor.Primary.value
            type = GaYaShortcutType.Outlined.value
            style = GaYaShortcutStyle.Inline.value
            label = "Inline"
        }

        val layoutParamsWithMargin = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            topMargin = resources.getDimensionPixelSize(R.dimen.ds_spacing_standard)
        }

        gayaShortcutInline.layoutParams = layoutParamsWithMargin

        val container: LinearLayout = findViewById(R.id.lnlProgramatically)
        container.addView(gayaShortcut)
        container.addView(gayaShortcutInline)
    }
}