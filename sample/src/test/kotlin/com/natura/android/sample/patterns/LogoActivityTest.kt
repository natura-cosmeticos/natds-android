package com.natura.android.sample.patterns

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.logo.Logo
import com.natura.android.sample.R
import com.natura.android.sample.data.ThemeRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows.shadowOf

@RunWith(AndroidJUnit4::class)
class LogoActivityTest {
    private lateinit var logoActivity: ActivityScenario<LogoActivity>
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksNaturaALogoResource() {
        launchActivityWithBrandTheme(NATURA, false)

        logoActivity.onActivity {
            val logo = it.findViewById<Logo>(R.id.logoModelA).getImageView()
            val logoShadow = shadowOf(logo)

            assertEquals(R.drawable.natura_a_official, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksNaturaADarkLogoResource() {
        launchActivityWithBrandTheme(NATURA, true)

        logoActivity.onActivity {
            val logo = it.findViewById<Logo>(R.id.logoModelA).getImageView()
            val logoShadow = shadowOf(logo)

            assertEquals(R.drawable.natura_a_official_dark, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksNaturaBLogoResource() {
        launchActivityWithBrandTheme(NATURA, false)

        logoActivity.onActivity {
            val logo = it.findViewById<Logo>(R.id.logoModelB).getImageView()
            val logoShadow = shadowOf(logo)

            assertEquals(R.drawable.natura_b_official, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksNaturaBDarkLogoResource() {
        launchActivityWithBrandTheme(NATURA, true)

        logoActivity.onActivity {
            val logo = it.findViewById<Logo>(R.id.logoModelB).getImageView()
            val logoShadow = shadowOf(logo)

            assertEquals(R.drawable.natura_b_official_dark, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksAvonALogoResource() {
        launchActivityWithBrandTheme(AVON, false)

        logoActivity.onActivity {
            val logo = it.findViewById<Logo>(R.id.logoModelA).getImageView()
            val logoShadow = shadowOf(logo)

            assertEquals(R.drawable.avon_a_official, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksAvonADarkLogoResource() {
        launchActivityWithBrandTheme(AVON, true)

        logoActivity.onActivity {
            val logo = it.findViewById<Logo>(R.id.logoModelA).getImageView()
            val logoShadow = shadowOf(logo)

            assertEquals(R.drawable.avon_a_official_dark, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksAesopALogoResource() {
        launchActivityWithBrandTheme(AESOP, false)

        logoActivity.onActivity {
            val logo = it.findViewById<Logo>(R.id.logoModelA).getImageView()
            val logoShadow = shadowOf(logo)

            assertEquals(R.drawable.aesop_a_official, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksAesopADarkLogoResource() {
        launchActivityWithBrandTheme(AESOP, true)

        logoActivity.onActivity {
            val logo = it.findViewById<Logo>(R.id.logoModelA).getImageView()
            val logoShadow = shadowOf(logo)

            assertEquals(R.drawable.aesop_a_official_dark, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksTbsALogoResource() {
        launchActivityWithBrandTheme(TBS, false)

        logoActivity.onActivity {
            val logo = it.findViewById<Logo>(R.id.logoModelA).getImageView()
            val logoShadow = shadowOf(logo)

            assertEquals(R.drawable.thebodyshop_a_official, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksTbsADarkLogoResource() {
        launchActivityWithBrandTheme(TBS, true)

        logoActivity.onActivity {
            val logo = it.findViewById<Logo>(R.id.logoModelA).getImageView()
            val logoShadow = shadowOf(logo)

            assertEquals(R.drawable.thebodyshop_a_official_dark, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksTbsBLogoResource() {
        launchActivityWithBrandTheme(TBS, false)

        logoActivity.onActivity {
            val logo = it.findViewById<Logo>(R.id.logoModelB).getImageView()
            val logoShadow = shadowOf(logo)

            assertEquals(R.drawable.thebodyshop_b_official, logoShadow.createdFromResId)
        }
    }

    @Test
    fun checksTbsBDarkLogoResource() {
        launchActivityWithBrandTheme(TBS, true)

        logoActivity.onActivity {
            val logo = it.findViewById<Logo>(R.id.logoModelB).getImageView()
            val logoShadow = shadowOf(logo)

            assertEquals(R.drawable.thebodyshop_b_official_dark, logoShadow.createdFromResId)
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
        const val AESOP = "aesop"
    }
}
