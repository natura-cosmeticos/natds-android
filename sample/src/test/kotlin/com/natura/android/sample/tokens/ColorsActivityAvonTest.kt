package com.natura.android.sample.tokens

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
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ColorsActivityAvonTest {

    private lateinit var colorsActivityScenario: ActivityScenario<ColorsActivity>

    @Test
    fun checksIfPrimaryColorMatchesWithAvonTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#DE0085"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#F091C9"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithAvonTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#A70058"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#BC6198"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithAvonTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FF56B5"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FFC3FC"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithAvonTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#E9E9E9"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#E9E9E9"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithAvonTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#B7B7B7"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#B7B7B7"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryLightColorMatchesWithAvonTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FFFFFF"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryLightColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FFFFFF"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfBackgroundColorMatchesWithAvonLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorBackgroundContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorBackgroundLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FAFAFA"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfBackgroundColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorBackgroundContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorBackgroundLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#121212"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSurfaceColorMatchesWithAvonLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSurfaceContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSurfaceLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FFFFFF"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfSurfaceColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSurfaceContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSurfaceLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#333333"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfContentColorsMatchesWithAvonLightTheme() {
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
    fun checksIfContentColorsMatchesWithAvonDarkTheme() {
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
    fun checksIfFeedbackColorsMatchesWithAvonLightTheme() {
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
    fun checksIfFeedbackColorsMatchesWithAvonDarkTheme() {
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
        avonIntent.putExtra("currentTab",
            AVON_TAB
        )
        colorsActivityScenario = ActivityScenario.launch(avonIntent)
    }

    private fun launchActivityScenarioWithDarkMode() {
        val context: Context = getApplicationContext()

        val avonIntent = Intent(context, ColorsActivity::class.java)
        avonIntent.putExtra("darkMode", true)
        avonIntent.putExtra("currentTab",
            AVON_TAB
        )
        colorsActivityScenario = ActivityScenario.launch(avonIntent)
    }

    companion object {
        const val AVON_TAB = 1
    }
}
