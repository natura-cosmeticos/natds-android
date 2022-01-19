package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.iconButton.IconButton
import com.natura.android.sample.R
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class IconButtonActivityTest {
    private lateinit var activity: ActivityScenario<IconButtonActivity>

    @Before
    fun setUp() {
        activity = ActivityScenario.launch(IconButtonActivity::class.java)
    }

    @Test
    fun `WHEN IconButton with Size Semi is render, it SHOULD have 40dp of width including padding`() {
        activity.onActivity {
            val iconButtonWidth = it.findViewById<IconButton>(R.id.iconButtonSizeSemi).width

            Assert.assertEquals(40, iconButtonWidth)
        }
    }

    @Test
    fun `WHEN IconButton with Size Semi is render, it SHOULD have 40dp of height including padding`() {
        activity.onActivity {
            val iconButtonHeight = it.findViewById<IconButton>(R.id.iconButtonSizeSemi).height

            Assert.assertEquals(40, iconButtonHeight)
        }
    }

    @Test
    fun `WHEN IconButton with Size Semix is render, it SHOULD have 48dp of width including padding`() {
        activity.onActivity {
            val iconButtonWidth = it.findViewById<IconButton>(R.id.iconButtonSizeSemix).width

            Assert.assertEquals(48, iconButtonWidth)
        }
    }

    @Test
    fun `WHEN IconButton with Size Semix is render, it SHOULD have 48dp of height including padding`() {
        activity.onActivity {
            val iconButtonHeight = it.findViewById<IconButton>(R.id.iconButtonSizeSemix).height

            Assert.assertEquals(48, iconButtonHeight)
        }
    }

    @Test
    fun `WHEN IconButton with Size Medium is render, it SHOULD have 56dp of width including padding`() {
        activity.onActivity {
            val iconButtonWidth = it.findViewById<IconButton>(R.id.iconButtonSizeMedium).width

            Assert.assertEquals(56, iconButtonWidth)
        }
    }

    @Test
    fun `WHEN IconButton with Size Medium is render, it SHOULD have 56dp of height including padding`() {
        activity.onActivity {
            val iconButtonHeight = it.findViewById<IconButton>(R.id.iconButtonSizeMedium).height

            Assert.assertEquals(56, iconButtonHeight)
        }
    }
}
