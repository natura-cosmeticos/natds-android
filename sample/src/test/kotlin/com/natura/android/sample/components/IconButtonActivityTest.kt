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
    fun `WHEN IconButton is render, it SHOULD have 32dp of width`() {
        activity.onActivity { activity ->
            val iconButtonWidth = activity.iconButtonDefault.width

            Assert.assertEquals(32, iconButtonWidth)
        }
    }

    @Test
    fun `WHEN IconButton is render, it SHOULD have 32dp of height`() {
        activity.onActivity { activity ->
            val iconButtonWidth = activity.iconButtonDefault.height

            Assert.assertEquals(32, iconButtonWidth)
        }
    }
}
