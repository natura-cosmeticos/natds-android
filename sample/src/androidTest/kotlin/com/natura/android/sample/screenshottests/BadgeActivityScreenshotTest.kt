package com.natura.android.sample.screenshottests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.natura.android.sample.components.BadgeActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BadgeActivityScreenshotTest : ScreenShotActivityTestBase() {
    @get:Rule
    var activityTestRule = ActivityTestRule(BadgeActivity::class.java, false, false)

    @Before
    fun before() {
        InstrumentationRegistry.getInstrumentation().uiAutomation
    }

    @Test
    fun test_Snapshot_WithControls() {
        val activity = activityTestRule.launchActivity(null)

        checkScreenshot(activity, "badge")
    }
}
