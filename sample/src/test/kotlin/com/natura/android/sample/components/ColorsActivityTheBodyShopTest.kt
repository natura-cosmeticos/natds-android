package com.natura.android.sample.components

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.android.synthetic.main.background_surface_colors.*
import kotlinx.android.synthetic.main.content_colors.*
import kotlinx.android.synthetic.main.feedback_colors.*
import kotlinx.android.synthetic.main.primary_secondary_colors.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ColorsActivityTheBodyShopTest {

    private lateinit var colorsActivityScenario: ActivityScenario<ColorsActivity>

    @Test
    fun checksIfPrimaryColorMatchesWithTheBodyShopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#004236"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#62B3AE"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithTheBodyShopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#001D10"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#2F837F"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithTheBodyShopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#356D60"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#94E5E0"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithTheBodyShopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#A55F53"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#D2AD93"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithTheBodyShopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#73342A"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#A07E65"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryLightColorMatchesWithTheBodyShopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#D98D7F"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryLightColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FFDFC4"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfBackgroundColorMatchesWithTheBodyShopLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorBackgroundContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorBackgroundLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FAFAFA"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfBackgroundColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorBackgroundContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorBackgroundLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#121212"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSurfaceColorMatchesWithTheBodyShopLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSurfaceContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSurfaceLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FFFFFF"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfSurfaceColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSurfaceContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSurfaceLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#333333"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfContentColorsMatchesWithTheBodyShopLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorHighLight = colorsActivity.colorHighLightContainer.background as ColorDrawable
            val colorHighEmphasis = colorsActivity.colorHighEmphasisContainer.background as ColorDrawable
            val colorMediumEmphasis = colorsActivity.colorMediumEmphasisContainer.background as ColorDrawable
            val colorLowEmphasis = colorsActivity.colorLowEmphasisContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#000000"), colorHighLight.color)
            assertEquals(Color.parseColor("#333333"), colorHighEmphasis.color)
            assertEquals(Color.parseColor("#777777"), colorMediumEmphasis.color)
            assertEquals(Color.parseColor("#BBBBBB"), colorLowEmphasis.color)
        }
    }

    @Test
    fun checksIfContentColorsMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorHighLight = colorsActivity.colorHighLightContainer.background as ColorDrawable
            val colorHighEmphasis = colorsActivity.colorHighEmphasisContainer.background as ColorDrawable
            val colorMediumEmphasis = colorsActivity.colorMediumEmphasisContainer.background as ColorDrawable
            val colorLowEmphasis = colorsActivity.colorLowEmphasisContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#FFFFFF"), colorHighLight.color)
            assertEquals(Color.parseColor("#FAFAFA"), colorHighEmphasis.color)
            assertEquals(Color.parseColor("#BBBBBB"), colorMediumEmphasis.color)
            assertEquals(Color.parseColor("#777777"), colorLowEmphasis.color)
        }
    }

    @Test
    fun checksIfFeedbackColorsMatchesWithTheBodyShopLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorSuccess = colorsActivity.colorSuccessContainer.background as ColorDrawable
            val colorWarning = colorsActivity.colorWarningContainer.background as ColorDrawable
            val colorAlert = colorsActivity.colorAlertContainer.background as ColorDrawable
            val colorLink = colorsActivity.colorLinkContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#569A32"), colorSuccess.color)
            assertEquals(Color.parseColor("#FCC433"), colorWarning.color)
            assertEquals(Color.parseColor("#E74627"), colorAlert.color)
            assertEquals(Color.parseColor("#227BBD"), colorLink.color)
        }
    }

    @Test
    fun checksIfFeedbackColorsMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorSuccess = colorsActivity.colorSuccessContainer.background as ColorDrawable
            val colorWarning = colorsActivity.colorWarningContainer.background as ColorDrawable
            val colorAlert = colorsActivity.colorAlertContainer.background as ColorDrawable
            val colorLink = colorsActivity.colorLinkContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#569A32"), colorSuccess.color)
            assertEquals(Color.parseColor("#FCC433"), colorWarning.color)
            assertEquals(Color.parseColor("#E74627"), colorAlert.color)
            assertEquals(Color.parseColor("#227BBD"), colorLink.color)
        }
    }

    private fun launchActivityScenarioWithLightMode() {
        val context: Context = getApplicationContext()

        val avonIntent = Intent(context, ColorsActivity::class.java)
        avonIntent.putExtra("darkMode", false)
        avonIntent.putExtra("currentTab", TBS_TAB)
        colorsActivityScenario = ActivityScenario.launch(avonIntent)
    }

    private fun launchActivityScenarioWithDarkMode() {
        val context: Context = getApplicationContext()

        val avonIntent = Intent(context, ColorsActivity::class.java)
        avonIntent.putExtra("darkMode", true)
        avonIntent.putExtra("currentTab", TBS_TAB)
        colorsActivityScenario = ActivityScenario.launch(avonIntent)
    }

    companion object {
        const val TBS_TAB = 2
    }
}


