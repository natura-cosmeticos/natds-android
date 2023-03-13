package com.natura.android.sample.components

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.radiobutton.RadioButton
import com.natura.android.sample.R
import com.natura.android.sample.data.ThemeRepository
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.String

@RunWith(AndroidJUnit4::class)
class RadioButtonActivityTest {

    private lateinit var selectionControlActivityScenario: ActivityScenario<RadioButtonActivity>

    @Test
    fun checkRadioButtonPrimaryColorsWhenThemeIsNatura() {
        launchActivityWithNaturaTheme()
        selectionControlActivityScenario.onActivity {
            val colorText = it.findViewById<RadioButton>(R.id.radioPrimary).textColors.defaultColor
            val colorByState = it.findViewById<RadioButton>(R.id.radioPrimary).buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#F4AB34"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonSecondaryColorsWhenThemeIsNatura() {
        launchActivityWithNaturaTheme()
        selectionControlActivityScenario.onActivity {
            val colorText = it.findViewById<RadioButton>(R.id.radioSecondary).textColors.defaultColor
            val colorByState = it.findViewById<RadioButton>(R.id.radioSecondary).buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#FF6B0B"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonPrimaryColorsWhenThemeIsAvon() {
        launchActivityWithAvonTheme()
        selectionControlActivityScenario.onActivity {
            val colorText = it.findViewById<RadioButton>(R.id.radioPrimary).textColors.defaultColor
            val colorByState = it.findViewById<RadioButton>(R.id.radioPrimary).buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            val hexColor = String.format("#%06X", 0xFFFFFF and -2228091)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#6221BD"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonSecondaryColorsWhenThemeIsAvon() {
        launchActivityWithAvonTheme()
        selectionControlActivityScenario.onActivity {
            val colorText = it.findViewById<RadioButton>(R.id.radioSecondary).textColors.defaultColor
            val colorByState = it.findViewById<RadioButton>(R.id.radioSecondary).buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#C2488E"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonPrimaryColorsWhenThemeIsTheBodyShop() {
        launchActivityWithBodyShopTheme()
        selectionControlActivityScenario.onActivity {
            val colorText = it.findViewById<RadioButton>(R.id.radioPrimary).textColors.defaultColor
            val colorByState = it.findViewById<RadioButton>(R.id.radioPrimary).buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#004236"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonSecondaryColorsWhenThemeIsTheBodyShop() {
        launchActivityWithBodyShopTheme()
        selectionControlActivityScenario.onActivity {
            val colorText = it.findViewById<RadioButton>(R.id.radioSecondary).textColors.defaultColor
            val colorByState = it.findViewById<RadioButton>(R.id.radioSecondary).buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#D5CD61"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonPrimaryColorsWhenThemeIsAesop() {
        launchActivityWithAesopTheme()
        selectionControlActivityScenario.onActivity {
            val colorText = it.findViewById<RadioButton>(R.id.radioPrimary).textColors.defaultColor
            val colorByState = it.findViewById<RadioButton>(R.id.radioPrimary).buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#333333"), colorSelected)
        }
    }

    @Test
    fun checkRadioButtonSecondaryColorsWhenThemeIsAesop() {
        launchActivityWithAesopTheme()
        selectionControlActivityScenario.onActivity {
            val colorText = it.findViewById<RadioButton>(R.id.radioSecondary).textColors.defaultColor
            val colorByState = it.findViewById<RadioButton>(R.id.radioSecondary).buttonTintList
            val state = listOf(android.R.attr.state_selected).toIntArray()

            val colorSelected = colorByState?.getColorForState(state, colorByState.defaultColor)

            assertEquals(Color.parseColor("#333333"), colorText)
            assertEquals(Color.parseColor("#A6672B"), colorSelected)
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
