package com.natura.android.sample.patterns

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LogoActivityFunctionalTest {
    private lateinit var logoActivity: ActivityScenario<LogoActivity>

    @Before
    fun setUp() {
        logoActivity = ActivityScenario.launch(LogoActivity::class.java)
    }

    @Test
    fun checksIfHorizontalLogoIsThere() {
        onView(withId(R.id.logoHorizontal)).check(matches(isDisplayed()))
    }

    @Test
    fun checksIfVerticalLogoIsThere() {
        onView(withId(R.id.logoVertical)).check(matches(isDisplayed()))
    }
}