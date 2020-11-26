package com.natura.android.sample.patterns

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
import com.natura.android.sample.data.ThemeRepository
import kotlinx.android.synthetic.main.activity_logo.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows.shadowOf

@RunWith(AndroidJUnit4::class)
class LogoActivityTest {
    lateinit var logoActivity: ActivityScenario<LogoActivity>
    lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksNaturaLightLogoHorizontalResource() {
        launchActivityWithBrandTheme(NATURA, false)

        logoActivity.onActivity { logoActivity ->
            val logo = logoActivity.logoHorizontal
            val logoShadow = shadowOf(logo.drawable)

            assertEquals(R.drawable.natura_horizontal, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksNaturaDarkLogoHorizontalResource() {
        launchActivityWithBrandTheme(NATURA, true)

        logoActivity.onActivity { logoActivity ->
            val logo = logoActivity.logoHorizontal
            val logoShadow = shadowOf(logo.drawable)

            assertEquals(R.drawable.natura_horizontal_dark, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksNaturaLightLogoVerticalResource() {
        launchActivityWithBrandTheme(NATURA, false)

        logoActivity.onActivity { logoActivity ->
            val logo = logoActivity.logoVertical
            val logoShadow = shadowOf(logo.drawable)

            assertEquals(R.drawable.natura_vertical, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksNaturaDarkLogoVerticalResource() {
        launchActivityWithBrandTheme(NATURA, true)

        logoActivity.onActivity { logoActivity ->
            val logo = logoActivity.logoVertical
            val logoShadow = shadowOf(logo.drawable)

            assertEquals(R.drawable.natura_vertical_dark, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksAvonLightLogoHorizontalResource() {
        launchActivityWithBrandTheme(AVON, false)

        logoActivity.onActivity { logoActivity ->
            val logo = logoActivity.logoHorizontal
            val logoShadow = shadowOf(logo.drawable)

            assertEquals(R.drawable.avon_horizontal, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksAvonDarkLogoHorizontalResource() {
        launchActivityWithBrandTheme(AVON, true)

        logoActivity.onActivity { logoActivity ->
            val logo = logoActivity.logoHorizontal
            val logoShadow = shadowOf(logo.drawable)

            assertEquals(R.drawable.avon_horizontal_dark, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksAvonLightLogoVerticalResource() {
        launchActivityWithBrandTheme(AVON, false)

        logoActivity.onActivity { logoActivity ->
            val logo = logoActivity.logoVertical
            val logoShadow = shadowOf(logo.drawable)

            assertEquals(R.drawable.default_icon_outlined_action_cancel, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksAvonDarkLogoVerticalResource() {
        launchActivityWithBrandTheme(AVON, true)

        logoActivity.onActivity { logoActivity ->
            val logo = logoActivity.logoVertical
            val logoShadow = shadowOf(logo.drawable)

            assertEquals(R.drawable.default_icon_outlined_action_cancel, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksTbsLightLogoHorizontalResource() {
        launchActivityWithBrandTheme(TBS, false)

        logoActivity.onActivity { logoActivity ->
            val logo = logoActivity.logoHorizontal
            val logoShadow = shadowOf(logo.drawable)

            assertEquals(R.drawable.tbs_horizontal, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksTbsDarkLogoHorizontalResource() {
        launchActivityWithBrandTheme(TBS, true)

        logoActivity.onActivity { logoActivity ->
            val logo = logoActivity.logoHorizontal
            val logoShadow = shadowOf(logo.drawable)

            assertEquals(R.drawable.tbs_horizontal_dark, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksTbsLightLogoVerticalResource() {
        launchActivityWithBrandTheme(TBS, false)

        logoActivity.onActivity { logoActivity ->
            val logo = logoActivity.logoVertical
            val logoShadow = shadowOf(logo.drawable)

            assertEquals(R.drawable.tbs_vertical, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksTbsDarkLogoVerticalResource() {
        launchActivityWithBrandTheme(TBS, true)

        logoActivity.onActivity { logoActivity ->
            val logo = logoActivity.logoVertical
            val logoShadow = shadowOf(logo.drawable)

            assertEquals(R.drawable.tbs_vertical_dark, logoShadow.createdFromResId)
        }
    }

    private fun launchActivityWithBrandTheme(brand: String, isDarkMode: Boolean) {
        val themeRepository = ThemeRepository(context)
        themeRepository.saveChosenTheme(brand)

        val intent = Intent(context, LogoActivity::class.java)
        intent.putExtra("darkMode", isDarkMode)

        logoActivity = ActivityScenario.launch(intent)
    }

    companion object {
        const val NATURA = "natura"
        const val AVON = "avon"
        const val TBS = "tbs"
    }
}
