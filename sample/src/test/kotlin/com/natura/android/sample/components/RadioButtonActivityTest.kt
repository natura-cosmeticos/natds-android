package com.natura.android.sample.components

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.data.ThemeRepository
import kotlinx.android.synthetic.main.activity_radiobutton.*
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RadioButtonActivityTest {

    lateinit var selectionControlActivityScenario: ActivityScenario<RadioButtonActivity>

    @Test
    fun checkRadioButtonPrimaryColorsWhenThemeIsNatura() {
        launchActivityWithNaturaTheme()
        selectionControlActivityScenario.onActivity { radioButtonActivity ->
            val colorText = radioButtonActivity.radioPrimary.textColors.defaultColor
            val colorByState = radioButtonActivity.radioPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#F4AB34"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonSecondaryColorsWhenThemeIsNatura() {
        launchActivityWithNaturaTheme()
        selectionControlActivityScenario.onActivity { radioButtonActivity ->
            val colorText = radioButtonActivity.radioSecondary.textColors.defaultColor
            val colorByState = radioButtonActivity.radioSecondary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#FF6B0B"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonPrimaryColorsWhenThemeIsAvon() {
        launchActivityWithAvonTheme()
        selectionControlActivityScenario.onActivity { radioButtonActivity ->
            val colorText = radioButtonActivity.radioPrimary.textColors.defaultColor
            val colorByState = radioButtonActivity.radioPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#DE0085"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonSecondaryColorsWhenThemeIsAvon() {
        launchActivityWithAvonTheme()
        selectionControlActivityScenario.onActivity { radioButtonActivity ->
            val colorText = radioButtonActivity.radioSecondary.textColors.defaultColor
            val colorByState = radioButtonActivity.radioSecondary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#E9E9E9"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonPrimaryColorsWhenThemeIsTheBodyShop() {
        launchActivityWithBodyShopTheme()
        selectionControlActivityScenario.onActivity { radioButtonActivity ->
            val colorText = radioButtonActivity.radioPrimary.textColors.defaultColor
            val colorByState = radioButtonActivity.radioPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#004236"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonSecondaryColorsWhenThemeIsTheBodyShop() {
        launchActivityWithBodyShopTheme()
        selectionControlActivityScenario.onActivity { radioButtonActivity ->
            val colorText = radioButtonActivity.radioSecondary.textColors.defaultColor
            val colorByState = radioButtonActivity.radioSecondary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#D6CE4B"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonPrimaryColorsWhenThemeIsAesop() {
        launchActivityWithAesopTheme()
        selectionControlActivityScenario.onActivity { radioButtonActivity ->
            val colorText = radioButtonActivity.radioPrimary.textColors.defaultColor
            val colorByState = radioButtonActivity.radioPrimary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#262625"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonSecondaryColorsWhenThemeIsAesop() {
        launchActivityWithAesopTheme()
        selectionControlActivityScenario.onActivity { radioButtonActivity ->
            val colorText = radioButtonActivity.radioSecondary.textColors.defaultColor
            val colorByState = radioButtonActivity.radioSecondary.buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#A6662B"), colorSelected)
        }
    }

    private fun launchActivityWithAvonTheme() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("avon")

        selectionControlActivityScenario = ActivityScenario.launch(Intent(context, RadioButtonActivity::class.java))
    }

    private fun launchActivityWithNaturaTheme() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("natura")

        selectionControlActivityScenario = ActivityScenario.launch(Intent(context, RadioButtonActivity::class.java))
    }

    private fun launchActivityWithBodyShopTheme() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("bodyshop")

        selectionControlActivityScenario = ActivityScenario.launch(Intent(context, RadioButtonActivity::class.java))
    }

    private fun launchActivityWithAesopTheme() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("aesop")

        selectionControlActivityScenario = ActivityScenario.launch(Intent(context, RadioButtonActivity::class.java))
    }
}
