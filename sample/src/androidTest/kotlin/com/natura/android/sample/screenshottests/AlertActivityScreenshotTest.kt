package com.natura.android.sample.screenshottests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.natura.android.sample.components.AlertActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AlertActivityScreenshotTest : ScreenShotActivityTestBase() {
    @get:Rule
    var activityTestRule = ActivityTestRule(AlertActivity::class.java, false, false)

    @Test
    fun test_Snapshot_WithControls() {
        val activity = activityTestRule.launchActivity(null)

        checkScreenshot(activity, "alert")
    }
}
