package com.natura.android.sample.screenshottests

import android.app.Activity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.facebook.testing.screenshot.Screenshot

abstract class ScreenShotActivityTestBase {

    private val prefix = this.javaClass.name + "."

    fun checkScreenshot(activity: Activity, name: String) {
        Screenshot.snapActivity(activity).setName(prefix + name).record()
    }

    fun performClick(id: Int) {
        Espresso.onView(ViewMatchers.withId(id)).perform(ViewActions.click())
    }
}
