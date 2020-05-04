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
        colorsActivityScenario = ActivityScenario.launch(ColorsActivity::class.java)
        colorsActivityScenario.onActivity { colorsActivity ->
            val colorCode = colorsActivity.colorPrimaryContainer.background as ColorDrawable

            assertEquals(Color.parseColor("#F4AB34"), colorCode.color)
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
