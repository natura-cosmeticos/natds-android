package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
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
        onView(withId(R.id.ds_expansion_panel_title)).check(matches(withText("Expansion Panel")))
    }

    @Test
    fun shouldRenderCollapsed() {
        onView(withId(R.id.ds_expansion_panel_content_area)).check(matches(not(isDisplayed())))
    }

    @Test
    fun shouldExpandContent() {
        onView(withId(R.id.ds_expansion_panel_container)).perform(click())
        onView(withId(R.id.ds_expansion_panel_content_area)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldDisplayToastWhenExpandingContent() {
        onView(withId(R.id.ds_expansion_panel_container)).perform(click())

        onView(withId(R.id.last_action_text)).check(matches(withText("The panel expanded.")))
    }

    @Test
    fun shouldRenderGivenComponentsInsideContainer() {
        onView(withId(R.id.ds_expansion_panel_container)).perform(click())
        onView(allOf(withId(R.id.circle_example), withParent(withId(R.id.ds_expansion_panel_content_area))))
            .check(matches(isDisplayed()))
        onView(allOf(withId(R.id.text_example), withParent(withId(R.id.ds_expansion_panel_content_area))))
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldRenderCollapseWhenClickedOnExpandedContent() {
        onView(withId(R.id.ds_expansion_panel_container)).perform(click()).perform(click())
        onView(withId(R.id.ds_expansion_panel_content_area)).check(matches(not(isDisplayed())))
    }

    @Test
    fun shouldDisplayToastWhenCollapsingContent() {
        onView(withId(R.id.ds_expansion_panel_container))
            .perform(click())
            .perform(click())

        onView(withId(R.id.last_action_text)).check(matches(withText("The panel collapsed.")))
    }

    @Test
    fun shouldDisplayCollapsedWhenClickingButtonOnLaunch() {
        onView(withId(R.id.current_state_button)).perform(click())

        onView(withId(R.id.current_state_text)).check(matches(withText("The panel is collapsed.")))
    }

    @Test
    fun shouldDisplayStateWhenClickingButtonWithExpandedPanel() {
        onView(withId(R.id.ds_expansion_panel_container)).perform(click())
        onView(withId(R.id.current_state_button)).perform(click())

        onView(withId(R.id.current_state_text)).check(matches(withText("The panel is expanded.")))
    }

    @Test
    fun shouldDisplayStateWhenClickingButtonWithCollapsedPanel() {
        onView(withId(R.id.ds_expansion_panel_container))
            .perform(click())
            .perform(click())
        onView(withId(R.id.current_state_button)).perform(click())

        onView(withId(R.id.current_state_text)).check(matches(withText("The panel is collapsed.")))
    }
}
