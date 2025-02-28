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

        supportActionBar?.title = "Escolha uma marca"
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
            binding.conBelezaThemeButton.id -> openSampleBy(CONSULTORIABELEZA)
            binding.naturaV2ThemeButton.id -> openSampleBy(NATURAV2)
            binding.avonV2ThemeButton.id -> openSampleBy(AVONV2)
            binding.naturaV3ThemeButton.id -> openSampleBy(NATURAV3)
            binding.casaestiloThemeButton.id -> openSampleBy(CASAEESTILO)
            binding.casaestiloV2ThemeButton.id -> openSampleBy(CASAEESTILOV2)
            binding.forcavendasThemeButton.id -> openSampleBy(FORCAVENDAS)
            binding.consultoriadebelezav2ThemeButton.id -> openSampleBy(CONSULTORIABELEZAV2)
            binding.forcavendasv2ThemeButton.id -> openSampleBy(FORCAVENDASV2)
            binding.avonV3ThemeButton.id -> openSampleBy(AVONV3)
            else -> openSampleBy(NATURA)
        }
    }

    private fun setBrandButtonsActions() {
        binding.naturaThemeButton.setOnClickListener(this)
        binding.avonThemeButton.setOnClickListener(this)
        binding.conBelezaThemeButton.setOnClickListener(this)
        binding.naturaV2ThemeButton.setOnClickListener(this)
        binding.avonV2ThemeButton.setOnClickListener(this)
        binding.naturaV3ThemeButton.setOnClickListener(this)
        binding.casaestiloThemeButton.setOnClickListener(this)
        binding.casaestiloV2ThemeButton.setOnClickListener(this)
        binding.forcavendasThemeButton.setOnClickListener(this)
        binding.consultoriadebelezav2ThemeButton.setOnClickListener(this)
        binding.forcavendasv2ThemeButton.setOnClickListener(this)
        binding.avonV3ThemeButton.setOnClickListener(this)
    }

    private fun openSampleBy(brandTheme: String) {
        themeRepository.saveChosenTheme(brandTheme)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val NATURA = "natura"
        const val AVON = "avon"
        const val NATURAV2 = "natura_v2"
        const val AVONV2 = "avon_v2"
        const val NATURAV3 = "natura_v3"
        const val CONSULTORIABELEZA = "consultoria"
        const val CASAEESTILO = "casaeestilo"
        const val CASAEESTILOV2 = "casaeestilo_v2"
        const val FORCAVENDAS = "forcadevendas"
        const val FORCAVENDASV2 = "forcadevendas_v2"
        const val CONSULTORIABELEZAV2 = "consultoria_v2"
        const val AVONV3 = "avon_v3"
    }
}
