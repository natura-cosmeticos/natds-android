package com.natura.android.sample.components

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.data.ThemeRepository
import kotlinx.android.synthetic.main.activity_checkbox.*
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CheckBoxActivityTest {

    lateinit var checkBoxActivityScenario: ActivityScenario<CheckBoxActivity>

    @Test
    fun checkCheckBoxButtonPrimaryColorsWhenThemeIsNatura() {
        launchActivityWithNaturaTheme()
        checkBoxActivityScenario.onActivity { checkBoxActivity ->
            val colorText = checkBoxActivity.checkboxPrimary.textColors.defaultColor
            val colorByState = checkBoxActivity.checkboxPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#F4AB34"), colorSelected)
        }
    }

    @Test
    fun checkCheckBoxButtonPrimaryColorsWhenThemeIsAvon() {
        launchActivityWithAvonTheme()
        checkBoxActivityScenario.onActivity { checkBoxActivity ->
            val colorText = checkBoxActivity.checkboxPrimary.textColors.defaultColor
            val colorByState = checkBoxActivity.checkboxPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#7F28C4"), colorSelected)
        }
    }

    @Test
    fun checkCheckBoxButtonPrimaryColorsWhenThemeIsTheBodyShop() {
        launchActivityWithBodyShopTheme()
        checkBoxActivityScenario.onActivity { checkBoxActivity ->
            val colorText = checkBoxActivity.checkboxPrimary.textColors.defaultColor
            val colorByState = checkBoxActivity.checkboxPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#004236"), colorSelected)
        }
    }

    @Test
    fun checkCheckBoxButtonPrimaryColorsWhenThemeIsAesop() {
        launchActivityWithAesopTheme()
        checkBoxActivityScenario.onActivity { checkBoxActivity ->
            val colorText = checkBoxActivity.checkboxPrimary.textColors.defaultColor
            val colorByState = checkBoxActivity.checkboxPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#262625"), colorSelected)
        }
    }

    private fun launchActivityWithAvonTheme() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("avon")

        checkBoxActivityScenario = ActivityScenario.launch(Intent(context, CheckBoxActivity::class.java))
    }

    private fun launchActivityWithNaturaTheme() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("natura")

        checkBoxActivityScenario = ActivityScenario.launch(Intent(context, CheckBoxActivity::class.java))
    }

    private fun launchActivityWithAesopTheme() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("aesop")

        checkBoxActivityScenario = ActivityScenario.launch(Intent(context, CheckBoxActivity::class.java))
    }

    private fun launchActivityWithBodyShopTheme() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("bodyshop")

        checkBoxActivityScenario = ActivityScenario.launch(Intent(context, CheckBoxActivity::class.java))
    }
}
