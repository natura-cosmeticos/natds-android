package com.natura.android.sample

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityFunctionalTests {
    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun shouldOpenColorScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.colorTokensButton)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.colorTokensButton)).perform(click())

        onView(ViewMatchers.withText("Color")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenSpacingScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.btnSpacing)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.btnSpacing)).perform(click())

        onView(ViewMatchers.withText("Spacing")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenIconDrawableScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.btnIconsDrawables)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.btnIconsDrawables)).perform(click())

        onView(ViewMatchers.withText("Icons (drawables)")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenIconFontsScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.btnIconsFont)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.btnIconsFont)).perform(click())

        onView(ViewMatchers.withText("Icons (fonts)")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenSizeScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.sizeButton)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.sizeButton)).perform(click())

        onView(ViewMatchers.withText("Size")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenButtonScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.btnStyleButtons)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.btnStyleButtons)).perform(click())

        onView(ViewMatchers.withText("Button")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenSelectionControlScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.btnSelection)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.btnSelection)).perform(click())

        onView(ViewMatchers.withText("Selection Control")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenTextFieldScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.btnTextfield)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.btnTextfield)).perform(click())

        onView(ViewMatchers.withText("Text Field")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenValueTextHighlightScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.btnValueTextHighlight)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.btnValueTextHighlight)).perform(click())

        onView(ViewMatchers.withText("Value Text Highlight")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenMenuScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.btnMenu)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.btnMenu)).perform(click())

        onView(ViewMatchers.withText("Menu Pattern")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenSubmenuScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.btnSubmenu)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.btnSubmenu)).perform(click())

        onView(ViewMatchers.withText("Submenu Pattern")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenLoadingScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.btnLoader)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.btnLoader)).perform(click())

        onView(ViewMatchers.withText("Loading Pattern")).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldOpenErrorScreenWhenTapOnItButton() {
        onView(ViewMatchers.withId(R.id.btnErrorDefault)).perform(scrollTo())
        onView(ViewMatchers.withId(R.id.btnErrorDefault)).perform(click())

        onView(ViewMatchers.withText("Error Pattern")).check(matches(ViewMatchers.isDisplayed()))
    }
}
