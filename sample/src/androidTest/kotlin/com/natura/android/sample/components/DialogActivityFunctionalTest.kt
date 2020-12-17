package com.natura.android.sample.components

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

@Ignore
@RunWith(AndroidJUnit4::class)
class DialogActivityFunctionalTest {
    private lateinit var dialogActivityScenario: ActivityScenario<DialogActivity>
    private lateinit var decorView: View

    @Before
    fun setup() {
        dialogActivityScenario = ActivityScenario.launch(DialogActivity::class.java).onActivity { decorView = it.window.decorView }
    }

    @Test
    fun shouldShowDialogTitle() {
        onView(withId(R.id.standardDialogButton)).perform(click())

        onView(withText("Title"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowDialogCustomContent() {
        onView(withId(R.id.standardDialogButton)).perform(click())

        onView(withId(R.id.dialogCustomContent))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowDialogMainButton() {
        onView(withId(R.id.standardDialogButton)).perform(click())

        onView(withText("Confirm Button"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowDialogSecondaryButton() {
        onView(withId(R.id.standardDialogButton)).perform(click())

        onView(withText("Close"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowMainButtonActionWhenClickOnIt() {
        onView(withId(R.id.standardDialogButton)).perform(click())

        onView(withText("Confirm Button")).perform(click())

        onView(withText("Dialog Main Action")).inRoot(withDecorView(not(decorView))).check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowSecondaryButtonActionWhenClickOnIt() {
        onView(withId(R.id.standardDialogButton)).perform(click())

        onView(withText("Close")).perform(click())

        onView(withText("Dialog Secondary Action")).inRoot(withDecorView(not(decorView))).check(matches(isDisplayed()))
    }
}
