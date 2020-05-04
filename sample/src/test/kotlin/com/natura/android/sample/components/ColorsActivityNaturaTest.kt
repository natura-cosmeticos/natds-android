package com.natura.android.sample.components

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.android.synthetic.main.primary_secondary_colors.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ColorsActivityNaturaTest {
    lateinit var colorsActivityScenario: ActivityScenario<ColorsActivity>
    lateinit var context: Context

    @Before
    fun setUp() {
        context = getApplicationContext()
        colorsActivityScenario = ActivityScenario.launch(ColorsActivity::class.java)
    }

    @Test
    fun checksIfPrimaryColorMatchesWithNaturaTheme() {
        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#F4AB34"), colorCode.color)
        }
    }

    @Test
    fun checksIfPrimaryDarkColorMatchesWithNaturaTheme() {
        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryDarkContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#EF8426"), colorCode.color)
        }
    }

    @Test
    fun checksIfPrimaryLightColorMatchesWithNaturaTheme() {
        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryLightContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#FEFDE8"), colorCode.color)
        }
    }

    @Test
    fun checksIfSecondaryColorMatchesWithNaturaTheme() {
        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#FF6B0B"), colorCode.color)
        }
    }

    @Test
    fun checksIfSecondaryDarkColorMatchesWithNaturaTheme() {
        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryDarkContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#FF5808"), colorCode.color)
        }
    }

    @Test
    fun checksIfSecondaryyLightColorMatchesWithNaturaTheme() {
        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorSecondaryLightContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#FFF8E1"), colorCode.color)
        }
    }


    @Test
    fun checksIfLightPrimaryColorMatchesWithAvonTheme() {
        val avonIntent = Intent(context, ColorsActivity::class.java)
        avonIntent.putExtra("darkMode", false)
        avonIntent.putExtra("currentTab", 1)
        colorsActivityScenario = ActivityScenario.launch(avonIntent)

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#DE0085"), colorCode.color)
        }
    }

    @Test
    fun checksIfLightPrimaryColorMatchesWithTBSTheme() {
        val avonIntent = Intent(context, ColorsActivity::class.java)
        avonIntent.putExtra("darkMode", false)
        avonIntent.putExtra("currentTab", 2)
        colorsActivityScenario = ActivityScenario.launch(avonIntent)

        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#004236"), colorCode.color)
        }
    }
}
