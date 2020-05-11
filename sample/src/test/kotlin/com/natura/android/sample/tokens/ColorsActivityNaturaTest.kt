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
class ColorsActivityNaturaTest {

    private lateinit var colorsActivityScenario: ActivityScenario<ColorsActivity>

    @Test
    fun checksIfPrimaryColorMatchesWithNaturaTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#F4AB34"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryColorMatchesWithNaturaDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#F4AB34"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithNaturaTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#EF8426"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithNaturaDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#EF8426"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithNaturaTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FEFDE8"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithNaturaDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorPrimaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FEFDE8"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithNaturaTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FF6B0B"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithNaturaDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FF6B0B"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithNaturaTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FF5808"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithNaturaDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryDarkContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryDarkCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FF5808"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryLightColorMatchesWithNaturaTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FFF8E1"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryLightColorMatchesWithNaturaDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryLightContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSecondaryLightCodeLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FFF8E1"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfBackgroundColorMatchesWithNaturaLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorBackgroundContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorBackgroundLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FAFAFA"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfBackgroundColorMatchesWithNaturaDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorBackgroundContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorBackgroundLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#121212"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSurfaceColorMatchesWithNaturaLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSurfaceContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSurfaceLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#FFFFFF"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfSurfaceColorMatchesWithNaturaDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSurfaceContainer.background as ColorDrawable
            val colorOnCode = colorsActivity.colorSurfaceLabel.textColors.defaultColor

            assertEquals(Color.parseColor("#333333"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfContentColorsMatchesWithNaturaLightTheme() {
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
    fun checksIfContentColorsMatchesWithNaturaDarkTheme() {
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
    fun checksIfFeedbackColorsMatchesWithNaturaLightTheme() {
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
    fun checksIfFeedbackColorsMatchesWithNaturaDarkTheme() {
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
        colorsActivityScenario = ActivityScenario.launch(ColorsActivity::class.java)
    }

    private fun launchActivityScenarioWithDarkMode() {
        val context: Context = getApplicationContext()

        val avonIntent = Intent(context, ColorsActivity::class.java)
        avonIntent.putExtra("darkMode", true)
        avonIntent.putExtra("currentTab",
            NATURA_TAB
        )
        colorsActivityScenario = ActivityScenario.launch(avonIntent)
    }

    companion object {
        const val NATURA_TAB = 0
    }
}
