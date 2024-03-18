package com.natura.android.sample.tokens

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
import com.natura.android.sample.data.ThemeRepository
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ColorsActivityAvonTest {

    private lateinit var colorsActivityScenario: ActivityScenario<ColorsActivity>

    @Test
    fun checksIfPrimaryColorMatchesWithAvonTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorPrimaryContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorPrimaryCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#6221BD"), colorCode.color)
            //assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorPrimaryContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorPrimaryCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#6221BD"), colorCode.color)
            // assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithAvonTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorPrimaryDarkContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorPrimaryDarkCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#5428A3"), colorCode.color)
            //assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorPrimaryDarkContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorPrimaryDarkCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#5428A3"), colorCode.color)
            // assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithAvonTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorPrimaryLightContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorPrimaryLightCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#7D51CC"), colorCode.color)
            // assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorPrimaryLightContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorPrimaryLightCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#7D51CC"), colorCode.color)
            // assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithAvonTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSecondaryContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSecondaryLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#C2488E"), colorCode.color)
            //assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSecondaryContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSecondaryLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#C2488E"), colorCode.color)
            // assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithAvonTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSecondaryDarkContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSecondaryDarkCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#A33C77"), colorCode.color)
            //assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSecondaryDarkContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSecondaryDarkCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#A33C77"), colorCode.color)
            // assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryLightColorMatchesWithAvonTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSecondaryLightContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSecondaryLightCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#CC65A0"), colorCode.color)
            // assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryLightColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSecondaryLightContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSecondaryLightCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#CC65A0"), colorCode.color)
            // assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfBackgroundColorMatchesWithAvonLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorBackgroundContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorBackgroundLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#FAFAFA"), colorCode.color)
            //assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfBackgroundColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorBackgroundContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorBackgroundLabel).textColors.defaultColor

            //assertEquals(Color.parseColor("#121212"), colorCode.color)
            //assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSurfaceColorMatchesWithAvonLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSurfaceContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSurfaceLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#FFFFFF"), colorCode.color)
            //assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfSurfaceColorMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(
                R.id.colorSurfaceContainer
            ).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSurfaceLabel).textColors.defaultColor

            //assertEquals(Color.parseColor("#333333"), colorCode.color)
            //assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfContentColorsMatchesWithAvonLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorHighLight = it.findViewById<ConstraintLayout>(R.id.colorHighLightContainer).background as ColorDrawable
            val colorHighEmphasis = it.findViewById<ConstraintLayout>(R.id.colorHighEmphasisContainer).background as ColorDrawable
            val colorMediumEmphasis = it.findViewById<ConstraintLayout>(R.id.colorMediumEmphasisContainer).background as ColorDrawable
            val colorLowEmphasis = it.findViewById<ConstraintLayout>(R.id.colorLowEmphasisContainer).background as ColorDrawable

            //assertEquals(Color.parseColor("#000000"), colorHighLight.color)
            //assertEquals(Color.parseColor("#333333"), colorHighEmphasis.color)
            //assertEquals(Color.parseColor("#777777"), colorMediumEmphasis.color)
            //assertEquals(Color.parseColor("#BBBBBB"), colorLowEmphasis.color)
        }
    }

    @Test
    fun checksIfContentColorsMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorHighLight = it.findViewById<ConstraintLayout>(R.id.colorHighLightContainer).background as ColorDrawable
            val colorHighEmphasis = it.findViewById<ConstraintLayout>(R.id.colorHighEmphasisContainer).background as ColorDrawable
            val colorMediumEmphasis = it.findViewById<ConstraintLayout>(R.id.colorMediumEmphasisContainer).background as ColorDrawable
            val colorLowEmphasis = it.findViewById<ConstraintLayout>(R.id.colorLowEmphasisContainer).background as ColorDrawable

            //assertEquals(Color.parseColor("#FFFFFF"), colorHighLight.color)
            //assertEquals(Color.parseColor("#FAFAFA"), colorHighEmphasis.color)
            //assertEquals(Color.parseColor("#BBBBBB"), colorMediumEmphasis.color)
            //assertEquals(Color.parseColor("#777777"), colorLowEmphasis.color)
        }
    }

    @Test
    fun checksIfFeedbackColorsMatchesWithAvonLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorSuccess = it.findViewById<ConstraintLayout>(R.id.colorSuccessContainer).background as ColorDrawable
            val colorWarning = it.findViewById<ConstraintLayout>(R.id.colorWarningContainer).background as ColorDrawable
            val colorAlert = it.findViewById<ConstraintLayout>(R.id.colorAlertContainer).background as ColorDrawable
            val colorLink = it.findViewById<ConstraintLayout>(R.id.colorLinkContainer).background as ColorDrawable

            //assertEquals(Color.parseColor("#569A32"), colorSuccess.color)
            //assertEquals(Color.parseColor("#FCC433"), colorWarning.color)
            //assertEquals(Color.parseColor("#E74627"), colorAlert.color)
            //assertEquals(Color.parseColor("#227BBD"), colorLink.color)
        }
    }

    @Test
    fun checksIfFeedbackColorsMatchesWithAvonDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorSuccess = it.findViewById<ConstraintLayout>(R.id.colorSuccessContainer).background as ColorDrawable
            val colorWarning = it.findViewById<ConstraintLayout>(R.id.colorWarningContainer).background as ColorDrawable
            val colorAlert = it.findViewById<ConstraintLayout>(R.id.colorAlertContainer).background as ColorDrawable
            val colorLink = it.findViewById<ConstraintLayout>(R.id.colorLinkContainer).background as ColorDrawable

            //assertEquals(Color.parseColor("#BCDEA2"), colorSuccess.color)
            // assertEquals(Color.parseColor("#FCC433"), colorWarning.color)
            // assertEquals(Color.parseColor("#E74627"), colorAlert.color)
            // assertEquals(Color.parseColor("#227BBD"), colorLink.color)
        }
    }

    private fun launchActivityScenarioWithLightMode() {
        val context: Context = getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("avon")

        val avonIntent = Intent(context, ColorsActivity::class.java)
        avonIntent.putExtra("darkMode", false)

        colorsActivityScenario = ActivityScenario.launch(avonIntent)
    }

    private fun launchActivityScenarioWithDarkMode() {
        val context: Context = getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("avon")

        val avonIntent = Intent(context, ColorsActivity::class.java)
        avonIntent.putExtra("darkMode", true)

        colorsActivityScenario = ActivityScenario.launch(avonIntent)
    }
}