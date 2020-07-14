package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExpansionPanelActivityTest {

    @Before
    fun setup() {
        ActivityScenario.launch(ExpansionPanelActivity::class.java)
    }

    @Test
    fun shouldRenderSubtitle() {
        onView(allOf(
            withId(R.id.ds_expansion_panel_title),
            isDescendantOfA(withId(R.id.first_expansion_panel))
        )).check(matches(withText("Expansion Panel 1")))
    }

    @Test
    fun shouldRenderCollapsed() {
        onView(allOf(
            withId(R.id.ds_expansion_panel_content_area),
            isDescendantOfA(withId(R.id.first_expansion_panel))
        )).check(matches(not(isDisplayed())))

        onView(allOf(
            withId(R.id.ds_expansion_panel_content_area),
            isDescendantOfA(withId(R.id.second_expansion_panel))
        )).check(matches(not(isDisplayed())))
    }

    @Test
    fun shouldExpandContent() {
        onView(allOf(
            withId(R.id.ds_expansion_panel_container),
            isDescendantOfA(withId(R.id.first_expansion_panel))
        )).perform(click())

        onView(allOf(
            withId(R.id.ds_expansion_panel_content_area),
            isDescendantOfA(withId(R.id.first_expansion_panel))
        )).check(matches(isDisplayed()))
    }

    @Test
    fun shouldRenderGivenComponentsInsideContainer() {
        onView(allOf(
            withId(R.id.ds_expansion_panel_container),
            isDescendantOfA(withId(R.id.first_expansion_panel))
        )).perform(click())

        onView(allOf(
            withId(R.id.circle_example),
            withParent(withId(R.id.ds_expansion_panel_content_area)),
            isDescendantOfA(withId(R.id.first_expansion_panel))
        )).check(matches(isDisplayed()))

        onView(allOf(
            withId(R.id.text_example),
            withParent(withId(R.id.ds_expansion_panel_content_area)),
            isDescendantOfA(withId(R.id.first_expansion_panel))
        )).check(matches(isDisplayed()))
    }

    @Test
    fun shouldRenderCollapseWhenClickedOnExpandedContent() {
        onView(allOf(
            withId(R.id.ds_expansion_panel_container),
            isDescendantOfA(withId(R.id.first_expansion_panel))
        )).perform(click()).perform(click())

        onView(allOf(
            withId(R.id.ds_expansion_panel_content_area),
            isDescendantOfA(withId(R.id.first_expansion_panel))
        )).check(matches(not(isDisplayed())))
    }
}
