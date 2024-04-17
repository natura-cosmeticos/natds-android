package com.natura.android.sample.screenshottests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.natura.android.sample.R
import com.natura.android.sample.components.RadioButtonActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RadioButtonActivityTest : ScreenShotActivityTestBase() {
    @get:Rule
    var activityTestRule = ActivityTestRule(RadioButtonActivity::class.java, false, false)

    @Before
    fun before() {
        InstrumentationRegistry.getInstrumentation().uiAutomation
    }

    @Test
    fun test_Snapshot_WithControls() {
        val activity = activityTestRule.launchActivity(null)

        //checkScreenshot(activity, "no_selection")

        performClick(R.id.radioPrimary)
        //checkScreenshot(activity, "radio_primary_on")
    }
}
