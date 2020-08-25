package com.natura.android.sample.components

import android.text.InputType
import android.view.View
import android.widget.EditText
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
import com.natura.android.textfield.TextField
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.Matcher
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TextFieldActivityTest {

    @Test
    fun `Should save state after orientation change when component has id`() {
        val string = "This is the message"

        ActivityScenario.launch(TextFieldActivity::class.java).onActivity {
            onView(withId(R.id.text_item))
                .perform(typeValueInTextField(string))

            it.recreate()

            onView(withId(R.id.text_item))
                .check(hasValueInTextField(string))
        }
    }

    @Test
    fun `Should not save state after orientation change when component doesn't have id`() {
        ActivityScenario.launch(TextFieldActivity::class.java).onActivity {
            onView(
                allOf(
                    hasDescendant(withInputType(InputType.TYPE_CLASS_NUMBER)),
                    instanceOf(TextField::class.java)
                )
            ).perform(typeValueInTextField("222"))

            it.recreate()

            onView(
                allOf(
                    hasDescendant(withInputType(InputType.TYPE_CLASS_NUMBER)),
                    instanceOf(TextField::class.java)
                )
            ).check(hasValueInTextField(""))
        }
    }

    private fun typeValueInTextField(string: String) = object : ViewAction {

        override fun getDescription(): String = string

        override fun getConstraints(): Matcher<View> {
            return allOf(
                withEffectiveVisibility(Visibility.VISIBLE),
                isAssignableFrom(TextField::class.java)
            )
        }

        override fun perform(uiController: UiController?, view: View?) {
            val editText = (view as TextField).findViewById<EditText>(R.id.text_field_input_value)
            editText.setText(string)
        }
    }

    private fun hasValueInTextField(string: String) =
        ViewAssertion { view, noMatchingViewException ->
            noMatchingViewException?.let { throw it }

            if (view !is TextField) {
                throw AssertionError("View is not an instance of TextField")
            }

            assertEquals(string, view.editTextView.text.toString())
        }
}