package com.natura.android.sample.components

import android.view.View
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.button.TextButton
import com.natura.android.counter.Counter
import com.natura.android.sample.R
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CounterActivityTest {

    @Test
    fun verifyInputNumberAfterIncrementByClickingAddButtonOnce() {
        val number = "1"

        ActivityScenario.launch(CounterActivity::class.java).onActivity {
            onView(withId(R.id.counterMedium))
                .perform(clickButtons())

            onView(withId(R.id.counterMedium))
                .check(hasValueInInput(number))
        }
    }

    @Test
    fun verifyInputNumberAfterIncrementByClickingAddButtonTwice() {
        val number = "2"

        ActivityScenario.launch(CounterActivity::class.java).onActivity {
            onView(withId(R.id.counterMedium))
                .perform(clickButtons())
                .perform(clickButtons())

            onView(withId(R.id.counterMedium))
                .check(hasValueInInput(number))
        }
    }

    private fun clickButtons() = object : ViewAction {

        override fun getDescription(): String = "View Action for CounterActivity"

        override fun getConstraints(): Matcher<View> {
            return allOf(
                withEffectiveVisibility(Visibility.VISIBLE),
                isAssignableFrom(Counter::class.java)
            )
        }

        override fun perform(uiController: UiController?, view: View) {
            val addButton = view.findViewById<TextButton>(R.id.ctrAddButton)
            addButton.performClick()
        }
    }

    private fun hasValueInInput(string: String) =
        ViewAssertion { view, noMatchingViewException ->
            noMatchingViewException?.let { throw it }

            if (view !is Counter) {
                throw AssertionError("View is not an instance of TextField")
            }

            val input = view.findViewById<TextView>(R.id.ctrInputValue)

            assertEquals(string, input.text)
        }
}
