package com.natura.android.sample.components

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ValueTextHighlightActivityTest {

    @Before
    fun setup() {
        ActivityScenario.launch(ValueTextHighlightActivity::class.java)
    }

    @Test
    fun shouldDisplayInitialViewValues() {
        onView(matchHighlightChild(
            childId = R.id.description_label,
            parentId = R.id.highlightInitOnXml)
        )
            .check(matches(withText("Description on Xml")))

        onView(matchHighlightChild(
            childId = R.id.highlight_label,
            parentId = R.id.highlightInitOnXml)
        )
            .check(matches(withText("R\$ 11,02")))

        onView(matchHighlightChild(
            childId = R.id.edit_button,
            parentId = R.id.highlightInitOnXml)
        )
            .check(matches(not(isDisplayed())))

        onView(matchHighlightChild(
            childId = R.id.highlight_label,
            parentId = R.id.highlightInitViaCode)
        )
            .check(matches(withText("\$ 00.00")))

        onView(matchHighlightChild(
            childId = R.id.description_label,
            parentId = R.id.highlightInitViaCode)
        )
            .check(matches(withText("Add description via code")))

        onView(matchHighlightChild(
            childId = R.id.edit_button,
            parentId = R.id.highlightInitViaCode)
        )
            .check(matches(isDisplayed()))
    }

    private fun matchHighlightChild(childId: Int, parentId: Int): Matcher<View>? {
        return allOf(
            withId(childId),
            withParent(withId(parentId))
        )
    }
}
