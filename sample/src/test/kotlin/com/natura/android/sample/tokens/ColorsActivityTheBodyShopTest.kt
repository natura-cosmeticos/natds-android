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
class ColorsActivityTheBodyShopTest {

    private lateinit var colorsActivityScenario: ActivityScenario<ColorsActivity>

    @Test
    fun checksIfPrimaryColorMatchesWithTheBodyShopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorPrimaryContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorPrimaryCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#004236"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorPrimaryContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorPrimaryCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#004236"), colorCode.color)
            //assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithTheBodyShopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorPrimaryDarkContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorPrimaryDarkCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#00372D"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorPrimaryDarkContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorPrimaryDarkCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#00372D"), colorCode.color)
            //assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithTheBodyShopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorPrimaryLightContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorPrimaryLightCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#2B6258"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorPrimaryLightContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorPrimaryLightCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#2B6258"), colorCode.color)
            //assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithTheBodyShopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSecondaryContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSecondaryLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#D5CD61"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSecondaryContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSecondaryLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#D5CD61"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithTheBodyShopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSecondaryDarkContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSecondaryDarkCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#B3AC51"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSecondaryDarkContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSecondaryDarkCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#B3AC51"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryLightColorMatchesWithTheBodyShopTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSecondaryLightContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSecondaryLightCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#DCD57A"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfSecondaryLightColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSecondaryLightContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSecondaryLightCodeLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#DCD57A"), colorCode.color)
            assertEquals(Color.parseColor("#000000"), colorOnCode)
        }
    }

    @Test
    fun checksIfBackgroundColorMatchesWithTheBodyShopLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorBackgroundContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorBackgroundLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#FAFAFA"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfBackgroundColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorBackgroundContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorBackgroundLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#121212"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfSurfaceColorMatchesWithTheBodyShopLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSurfaceContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSurfaceLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#FFFFFF"), colorCode.color)
            assertEquals(Color.parseColor("#333333"), colorOnCode)
        }
    }

    @Test
    fun checksIfSurfaceColorMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorCode = it.findViewById<ConstraintLayout>(R.id.colorSurfaceContainer).background as ColorDrawable
            val colorOnCode = it.findViewById<TextView>(R.id.colorSurfaceLabel).textColors.defaultColor

            assertEquals(Color.parseColor("#333333"), colorCode.color)
            assertEquals(Color.parseColor("#FFFFFF"), colorOnCode)
        }
    }

    @Test
    fun checksIfContentColorsMatchesWithTheBodyShopLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorHighLight = it.findViewById<ConstraintLayout>(R.id.colorHighLightContainer).background as ColorDrawable
            val colorHighEmphasis = it.findViewById<ConstraintLayout>(R.id.colorHighEmphasisContainer).background as ColorDrawable
            val colorMediumEmphasis = it.findViewById<ConstraintLayout>(R.id.colorMediumEmphasisContainer).background as ColorDrawable
            val colorLowEmphasis = it.findViewById<ConstraintLayout>(R.id.colorLowEmphasisContainer).background as ColorDrawable

            assertEquals(Color.parseColor("#000000"), colorHighLight.color)
            assertEquals(Color.parseColor("#333333"), colorHighEmphasis.color)
            assertEquals(Color.parseColor("#777777"), colorMediumEmphasis.color)
            assertEquals(Color.parseColor("#BBBBBB"), colorLowEmphasis.color)
        }
    }

    @Test
    fun checksIfContentColorsMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorHighLight = it.findViewById<ConstraintLayout>(R.id.colorHighLightContainer).background as ColorDrawable
            val colorHighEmphasis = it.findViewById<ConstraintLayout>(R.id.colorHighEmphasisContainer).background as ColorDrawable
            val colorMediumEmphasis = it.findViewById<ConstraintLayout>(R.id.colorMediumEmphasisContainer).background as ColorDrawable
            val colorLowEmphasis = it.findViewById<ConstraintLayout>(R.id.colorLowEmphasisContainer).background as ColorDrawable

            assertEquals(Color.parseColor("#FFFFFF"), colorHighLight.color)
            assertEquals(Color.parseColor("#FAFAFA"), colorHighEmphasis.color)
            assertEquals(Color.parseColor("#BBBBBB"), colorMediumEmphasis.color)
            assertEquals(Color.parseColor("#777777"), colorLowEmphasis.color)
        }
    }

    @Test
    fun checksIfFeedbackColorsMatchesWithTheBodyShopLightTheme() {
        launchActivityScenarioWithLightMode()

        colorsActivityScenario.onActivity {
            val colorSuccess = it.findViewById<ConstraintLayout>(R.id.colorSuccessContainer).background as ColorDrawable
            val colorWarning = it.findViewById<ConstraintLayout>(R.id.colorWarningContainer).background as ColorDrawable
            val colorAlert = it.findViewById<ConstraintLayout>(R.id.colorAlertContainer).background as ColorDrawable
            val colorLink = it.findViewById<ConstraintLayout>(R.id.colorLinkContainer).background as ColorDrawable

            assertEquals(Color.parseColor("#569A32"), colorSuccess.color)
            assertEquals(Color.parseColor("#FCC433"), colorWarning.color)
            assertEquals(Color.parseColor("#E74627"), colorAlert.color)
            assertEquals(Color.parseColor("#227BBD"), colorLink.color)
        }
    }

    @Test
    fun checksIfFeedbackColorsMatchesWithTheBodyShopDarkTheme() {
        launchActivityScenarioWithDarkMode()

        colorsActivityScenario.onActivity {
            val colorSuccess = it.findViewById<ConstraintLayout>(R.id.colorSuccessContainer).background as ColorDrawable
            val colorWarning = it.findViewById<ConstraintLayout>(R.id.colorWarningContainer).background as ColorDrawable
            val colorAlert = it.findViewById<ConstraintLayout>(R.id.colorAlertContainer).background as ColorDrawable
            val colorLink = it.findViewById<ConstraintLayout>(R.id.colorLinkContainer).background as ColorDrawable

            assertEquals(Color.parseColor("#BCDEA2"), colorSuccess.color)
            //assertEquals(Color.parseColor("#FCC433"), colorWarning.color)
            assertEquals(Color.parseColor("#E74627"), colorAlert.color)
            assertEquals(Color.parseColor("#227BBD"), colorLink.color)
        }
    }

    private fun launchActivityScenarioWithLightMode() {
        val context: Context = getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("bodyshop")

        val intent = Intent(context, ColorsActivity::class.java)
        intent.putExtra("darkMode", false)

        colorsActivityScenario = ActivityScenario.launch(intent)
    }

    private fun launchActivityScenarioWithDarkMode() {
        val context: Context = getApplicationContext()
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme("bodyshop")

        val intent = Intent(context, ColorsActivity::class.java)
        intent.putExtra("darkMode", true)

        colorsActivityScenario = ActivityScenario.launch(intent)
    }
}
