package com.natura.android.sample.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.natura.android.sample.components.ButtonActivity
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
@Ignore
@RunWith(AndroidJUnit4::class)
class ButtonActivityScreenshotTest : ScreenShotActivityTestBase() {
    @get:Rule
    var activityTestRule = ActivityTestRule(ButtonActivity::class.java, false, false)

    @Test
    fun test_Snapshot_WithControls() {
        val activity = activityTestRule.launchActivity(null)

        checkScreenshot(activity, "buttons")
    }
}
