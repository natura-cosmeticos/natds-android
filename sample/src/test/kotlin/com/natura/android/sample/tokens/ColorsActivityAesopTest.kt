package com.natura.android.sample.tokens

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.data.ThemeRepository
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ColorsActivityAesopTest {

    private lateinit var colorsActivityScenario: ActivityScenario<ColorsActivity>

    @Test
    fun checksIfPrimaryColorMatchesWithAesopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#262625"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryColorMatchesWithAesopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#F1F1F0"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithAesopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#000000"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithAesopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#BEBEBE"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithAesopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#4E4E4D"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithAesopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FFFFFF"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithAesopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#A6662B"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithAesopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#DDCB91"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithAesopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#733B00"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithAesopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#AA9A63"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryLightColorMatchesWithAesopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#DB9457"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryLightColorMatchesWithAesopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FFFEC2"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfBackgroundColorMatchesWithAesopLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorBackgroundContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorBackgroundLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FAFAFA"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfBackgroundColorMatchesWithAesopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorBackgroundContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorBackgroundLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#121212"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSurfaceColorMatchesWithAesopLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSurfaceContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSurfaceLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FFFFFF"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfSurfaceColorMatchesWithAesopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSurfaceContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSurfaceLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#333333"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfContentColorsMatchesWithAesopLightTheme() {
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
    fun checksIfContentColorsMatchesWithAesopDarkTheme() {
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
    fun checksIfFeedbackColorsMatchesWithAesopLightTheme() {
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
    fun checksIfFeedbackColorsMatchesWithAesopDarkTheme() {
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
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("aesop")

        val aesopIntent = Intent(context, ColorsActivity::class.java)
        aesopIntent.putExtra("darkMode", false)

        colorsActivityScenario = ActivityScenario.launch(aesopIntent)
    }

    private fun launchActivityScenarioWithDarkMode() {
        val context: Context = getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("aesop")

        val aesopIntent = Intent(context, ColorsActivity::class.java)
        aesopIntent.putExtra("darkMode", true)

        colorsActivityScenario = ActivityScenario.launch(aesopIntent)
    }
}
