package com.natura.android.sample.screenshottests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.natura.android.sample.R
import com.natura.android.sample.components.SelectionControlActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SelectionControlActivityTest : ScreenShotActivityTestBase() {
    @get:Rule
    var activityTestRule = ActivityTestRule(SelectionControlActivity::class.java, false, false)

    @Test
    fun test_Snapshot_WithControls() {
        val activity = activityTestRule.launchActivity(null)

        checkScreenshot(activity, "no_selection")

        performClick(R.id.radioPrimary)
        performClick(R.id.checkboxPrimary)
        checkScreenshot(activity, "radio_and_checkbox_primary_on")

        performClick(R.id.radioSecondary)
        performClick(R.id.checkboxSecondary)
        checkScreenshot(activity, "radio_and_checkbox_secondary_on")
    }
}
