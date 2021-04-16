package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.android.synthetic.main.activity_icon_button.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class IconButtonActivityTest {
    lateinit var activity: ActivityScenario<IconButtonActivity>

    @Before
    fun setUp() {
        activity = ActivityScenario.launch(IconButtonActivity::class.java)
    }

    @Test
    fun `WHEN IconButton with Size Semi is render, it SHOULD have 40dp of width including padding`() {
        activity.onActivity { activity ->
            val iconButtonWidth = activity.iconButtonSizeSemi.width

            Assert.assertEquals(40, iconButtonWidth)
        }
    }

    @Test
    fun `WHEN IconButton with Size Semi is render, it SHOULD have 40dp of height including padding`() {
        activity.onActivity { activity ->
            val iconButtonHeight = activity.iconButtonSizeSemi.height

            Assert.assertEquals(40, iconButtonHeight)
        }
    }

    @Test
    fun `WHEN IconButton with Size Semix is render, it SHOULD have 48dp of width including padding`() {
        activity.onActivity { activity ->
            val iconButtonWidth = activity.iconButtonSizeSemix.width

            Assert.assertEquals(48, iconButtonWidth)
        }
    }

    @Test
    fun `WHEN IconButton with Size Semix is render, it SHOULD have 48dp of height including padding`() {
        activity.onActivity { activity ->
            val iconButtonHeight = activity.iconButtonSizeSemix.height

            Assert.assertEquals(48, iconButtonHeight)
        }
    }

    @Test
    fun `WHEN IconButton with Size Medium is render, it SHOULD have 56dp of width including padding`() {
        activity.onActivity { activity ->
            val iconButtonWidth = activity.iconButtonSizeMedium.width

            Assert.assertEquals(56, iconButtonWidth)
        }
    }

    @Test
    fun `WHEN IconButton with Size Medium is render, it SHOULD have 56dp of height including padding`() {
        activity.onActivity { activity ->
            val iconButtonHeight = activity.iconButtonSizeMedium.height

            Assert.assertEquals(56, iconButtonHeight)
        }
    }
}
