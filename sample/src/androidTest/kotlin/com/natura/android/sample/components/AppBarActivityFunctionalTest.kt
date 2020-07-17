package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppBarActivityFunctionalTest {

    private lateinit var appBarActivityTest: ActivityScenario<AppBarActivity>

    @Before
    fun setup() {
        appBarActivityTest = ActivityScenario.launch(AppBarActivity::class.java)
    }

    @Test
    fun addAndIncrementBadge() {
        onView(withId(R.id.btnIncrement)).perform(click())
        onView(withId(R.id.btnIncrement)).perform(click())

        onView(withId(R.id.appBar)).check(matches(isDisplayed()))
    }

    @Test
    fun showSearchBar() {
        onView(withId(R.id.searchMenuBtn)).perform(click())

        onView(withId(R.id.appBar)).check(matches(isDisplayed()))
    }
}