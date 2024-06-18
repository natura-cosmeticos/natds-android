package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import com.natura.android.chip.GaYaChip
import com.natura.android.sample.R
import com.natura.android.sample.databinding.ActivityChipBinding
import com.natura.android.sample.databinding.ActivityGayaChipBinding
import com.natura.android.sample.setChosenDefaultTheme

class GaYaChipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGayaChipBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        binding = ActivityGayaChipBinding.inflate(layoutInflater)

        setContentView(binding.root)

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

        binding.chipAction.getChildAt(0).setOnClickListener {
            increaseCount()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    private fun increaseCount() {
        count += 1
        binding.chipCounter.text = "Counter click $count"
    }
}