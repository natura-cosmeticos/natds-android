package com.natura.android.sample

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.data.ThemeRepository
import com.natura.android.sample.databinding.ActivityBrandSelectorBinding

class BrandSelectorActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var themeRepository: ThemeRepository
    private lateinit var binding: ActivityBrandSelectorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        themeRepository = ThemeRepository(this)

        super.onCreate(savedInstanceState)
        binding = ActivityBrandSelectorBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.title = "Choose a brand"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setBrandButtonsActions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.naturaThemeButton.id -> openSampleBy(NATURA)
            binding.avonThemeButton.id -> openSampleBy(AVON)
            binding.aesopThemeButton.id -> openSampleBy(AESOP)
            binding.conBelezaThemeButton.id -> openSampleBy(CONSULTORIA)
            binding.naturaV2ThemeButton.id -> openSampleBy(NATURAV2)
            binding.avonV2ThemeButton.id -> openSampleBy(AVONV2)
            binding.naturaV3ThemeButton.id -> openSampleBy(NATURAV3)
            else -> openSampleBy(TBS)
        }
    }

    private fun setBrandButtonsActions() {
        binding.naturaThemeButton.setOnClickListener(this)
        binding.avonThemeButton.setOnClickListener(this)
        binding.tbsThemeButton.setOnClickListener(this)
        binding.aesopThemeButton.setOnClickListener(this)
        binding.conBelezaThemeButton.setOnClickListener(this)
        binding.naturaV2ThemeButton.setOnClickListener(this)
        binding.avonV2ThemeButton.setOnClickListener(this)
        binding.naturaV3ThemeButton.setOnClickListener(this)
    }

    private fun openSampleBy(brandTheme: String) {
        themeRepository.saveChosenTheme(brandTheme)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val NATURA = "natura"
        const val AVON = "avon"
        const val TBS = "bodyshop"
        const val AESOP = "aesop"
        const val CONSULTORIA = "consultoria"
        const val NATURAV2 = "natura_v2"
        const val AVONV2 = "avon_v2"
        const val NATURAV3 = "natura_v3"
    }
}
