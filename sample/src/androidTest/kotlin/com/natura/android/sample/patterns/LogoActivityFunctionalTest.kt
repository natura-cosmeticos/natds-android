package com.natura.android.sample.patterns

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
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
    fun checksIfLogoModelALogoIsThere() {
        onView(withId(R.id.logoModelA))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }

    @Test
    fun checksIfLogoModelBLogoIsThere() {
        onView(withId(R.id.logoModelB))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }

    @Test
    fun checksIfLogoWithSizeMediumIsThere() {
        onView(withId(R.id.logoSizeMedium))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }

    @Test
    fun checksIfLogoWithSizeMediumXIsThere() {
        onView(withId(R.id.logoSizeMediumX))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }

    @Test
    fun checksIfLogoWithSizeLargeIsThere() {
        onView(withId(R.id.logoSizeLarge))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }

    @Test
    fun checksIfLogoWithSizeLargeXIsThere() {
        onView(withId(R.id.logoSizeLargeX))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }

    @Test
    fun checksIfLogoWithSizeLargeXXIsThere() {
        onView(withId(R.id.logoSizeLargeXX))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }

    @Test
    fun checksIfLogoWithSizeLargeXXXIsThere() {
        onView(withId(R.id.logoSizeLargeXXX))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }

    @Test
    fun checksIfLogoWithSizeHugeThere() {
        onView(withId(R.id.logoSizeHuge))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }

    @Test
    fun checksIfLogoWithSizeHugeXThere() {
        onView(withId(R.id.logoSizeHugeX))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }

    @Test
    fun checksIfLogoWithSizeHugeXXThere() {
        onView(withId(R.id.logoSizeHugeXX))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }

    @Test
    fun checksIfLogoWithSizeHugeXXXThere() {
        onView(withId(R.id.logoSizeHugeXXX))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }

    @Test
    fun checksIfLogoWithSizeVeryHugeThere() {
        onView(withId(R.id.logoSizeVeryHuge))
            .perform(ViewActions.scrollTo())
            .check(matches(isDisplayed()))
    }
}
