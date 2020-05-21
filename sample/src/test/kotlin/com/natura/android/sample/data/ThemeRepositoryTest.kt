package com.natura.android.sample.data

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ThemeRepositoryTest {

    private lateinit var themeRepository: ThemeRepository
    private var context = ApplicationProvider.getApplicationContext<Context>()

    @Before
    fun setUp() {
        themeRepository = ThemeRepository(context)
    }

    @After
    fun tearDown() {
        themeRepository.sharedPreferences.edit().clear()
    }

    @Test
    fun saveAndRecoverSelectedBrand() {
        themeRepository.saveChosenTheme("BodyShop")

        val savedTheme = themeRepository.getChosenBrand()

        assertEquals("BodyShop", savedTheme)
    }

    @Test
    fun saveAndRecoverDefaultThemeAtSharedPreferences() {
        themeRepository.saveChosenTheme("BodyShop")

        val savedTheme = themeRepository.getChosenTheme()

        assertEquals(R.style.Theme_BodyShop, savedTheme)
    }

    @Test
    fun saveAndRecoverDefaultThemeNoActionBarAtSharedPreferences() {
        themeRepository.saveChosenTheme("natura")

        val savedTheme = themeRepository.getChosenThemeWithNoActionBar()

        assertEquals(R.style.Theme_Natura_NoActionBar, savedTheme)
    }

    @Test
    fun saveAndRecoverDarkThemeAtSharedPreferences() {
        themeRepository.saveChosenTheme("avon")

        val savedTheme = themeRepository.getChosenDarkTheme()

        assertEquals(R.style.Theme_AvonDark, savedTheme)
    }

    @Test
    fun saveAndRecoverDarkThemeNoActionBarAtSharedPreferences() {
        themeRepository.saveChosenTheme("natura")

        val savedTheme = themeRepository.getChosenDarkThemeWithNoActionBar()

        assertEquals(R.style.Theme_NaturaDark_NoActionBar, savedTheme)
    }
}
