package com.natura.android.sample.components

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.data.ThemeRepository
import kotlinx.android.synthetic.main.activity_selection_control.*
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SelectionControlActivityTest {

    lateinit var selectionControlActivityScenario: ActivityScenario<SelectionControlActivity>

    @Test
    fun checkRadioButtonPrimaryColorsWhenThemeIsNatura() {
        launchActivityWithNaturaTheme()
        selectionControlActivityScenario.onActivity { selectionControlActivity ->
            val colorText = selectionControlActivity.radioPrimary.textColors.defaultColor
            val colorByState = selectionControlActivity.radioPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#F4AB34"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonSecondaryColorsWhenThemeIsNatura() {
        launchActivityWithNaturaTheme()
        selectionControlActivityScenario.onActivity { selectionControlActivity ->
            val colorText = selectionControlActivity.radioSecondary.textColors.defaultColor
            val colorByState = selectionControlActivity.radioSecondary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#FF6B0B"), colorSelected)
        }
    }

    @Test
    fun checkCheckBoxButtonPrimaryColorsWhenThemeIsNatura() {
        launchActivityWithNaturaTheme()
        selectionControlActivityScenario.onActivity { selectionControlActivity ->
            val colorText = selectionControlActivity.checkboxPrimary.textColors.defaultColor
            val colorByState = selectionControlActivity.checkboxPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#F4AB34"), colorSelected)
        }
    }

    @Test
    fun checkCheckBoxButtonSecondaryColorsWhenThemeIsNatura() {
        launchActivityWithNaturaTheme()
        selectionControlActivityScenario.onActivity { selectionControlActivity ->
            val colorText = selectionControlActivity.checkboxSecondary.textColors.defaultColor
            val colorByState = selectionControlActivity.checkboxSecondary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#FF6B0B"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonPrimaryColorsWhenThemeIsAvon() {
        launchActivityWithAvonTheme()
        selectionControlActivityScenario.onActivity { selectionControlActivity ->
            val colorText = selectionControlActivity.radioPrimary.textColors.defaultColor
            val colorByState = selectionControlActivity.radioPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#DE0085"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonSecondaryColorsWhenThemeIsAvon() {
        launchActivityWithAvonTheme()
        selectionControlActivityScenario.onActivity { selectionControlActivity ->
            val colorText = selectionControlActivity.radioSecondary.textColors.defaultColor
            val colorByState = selectionControlActivity.radioSecondary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#E9E9E9"), colorSelected)
        }
    }

    @Test
    fun checkCheckBoxButtonPrimaryColorsWhenThemeIsAvon() {
        launchActivityWithAvonTheme()
        selectionControlActivityScenario.onActivity { selectionControlActivity ->
            val colorText = selectionControlActivity.checkboxPrimary.textColors.defaultColor
            val colorByState = selectionControlActivity.checkboxPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#DE0085"), colorSelected)
        }
    }

    @Test
    fun checkCheckBoxButtonSecondaryColorsWhenThemeIsAvon() {
        launchActivityWithAvonTheme()
        selectionControlActivityScenario.onActivity { selectionControlActivity ->
            val colorText = selectionControlActivity.checkboxSecondary.textColors.defaultColor
            val colorByState = selectionControlActivity.checkboxSecondary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#E9E9E9"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonPrimaryColorsWhenThemeIsTheBodyShop() {
        launchActivityWithBodyShopTheme()
        selectionControlActivityScenario.onActivity { selectionControlActivity ->
            val colorText = selectionControlActivity.radioPrimary.textColors.defaultColor
            val colorByState = selectionControlActivity.radioPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#004236"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonSecondaryColorsWhenThemeIsTheBodyShop() {
        launchActivityWithBodyShopTheme()
        selectionControlActivityScenario.onActivity { selectionControlActivity ->
            val colorText = selectionControlActivity.radioSecondary.textColors.defaultColor
            val colorByState = selectionControlActivity.radioSecondary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#A55F53"), colorSelected)
        }
    }

    @Test
    fun checkCheckBoxButtonPrimaryColorsWhenThemeIsTheBodyShop() {
        launchActivityWithBodyShopTheme()
        selectionControlActivityScenario.onActivity { selectionControlActivity ->
            val colorText = selectionControlActivity.checkboxPrimary.textColors.defaultColor
            val colorByState = selectionControlActivity.checkboxPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#004236"), colorSelected)
        }
    }

    @Test
    fun checkCheckBoxButtonSecondaryColorsWhenThemeIsTheBodyShop() {
        launchActivityWithBodyShopTheme()
        selectionControlActivityScenario.onActivity { selectionControlActivity ->
            val colorText = selectionControlActivity.checkboxSecondary.textColors.defaultColor
            val colorByState = selectionControlActivity.checkboxSecondary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#A55F53"), colorSelected)
        }
    }

    private fun launchActivityWithAvonTheme() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("avon")

        selectionControlActivityScenario = ActivityScenario.launch(Intent(context, SelectionControlActivity::class.java))
    }

    private fun launchActivityWithNaturaTheme() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("natura")

        selectionControlActivityScenario = ActivityScenario.launch(Intent(context, SelectionControlActivity::class.java))
    }

    private fun launchActivityWithBodyShopTheme() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("bodyshop")

        selectionControlActivityScenario = ActivityScenario.launch(Intent(context, SelectionControlActivity::class.java))
    }
}
