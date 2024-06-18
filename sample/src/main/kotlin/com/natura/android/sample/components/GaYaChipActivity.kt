package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.natura.android.chip.GaYaChip
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class GaYaChipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaya_chip)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "GaYaChip"

        val gayaChip = GaYaChip(this)
        gayaChip.setLabel("Criado programaticamente")
        gayaChip.setColor(GaYaChip.SECONDARY)
        gayaChip.setSize(GaYaChip.MEDIUM)
        gayaChip.setHelperLeftType(GaYaChip.ICON_TYPE)
        gayaChip.setHelperLeft(R.drawable.outlined_action_like)
        gayaChip.setHelperRightType(GaYaChip.AVATAR_TYPE)
        gayaChip.setHelperRight(R.mipmap.nat_avatar)

        val container: LinearLayout = findViewById(R.id.lnlProgramatically)
        container.addView(gayaChip)
    }
}