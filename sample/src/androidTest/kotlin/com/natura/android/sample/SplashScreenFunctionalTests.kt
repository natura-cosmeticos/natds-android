package com.natura.android.sample

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SplashScreenFunctionalTests {
    @Before
    fun setup() {
        ActivityScenario.launch(SplashActivity::class.java)
    }

    @Test
    fun shouldOpenBorderRadiusScreenWhenTapOnItButton() {
        onView(withText("NATDS"))
            .check(matches(isDisplayed()))

        onView(withText("Natura Design System"))
            .check(matches(isDisplayed()))

        onView(withId(R.id.naturaCoLogo))
            .check(matches(isDisplayed()))
    }
}
