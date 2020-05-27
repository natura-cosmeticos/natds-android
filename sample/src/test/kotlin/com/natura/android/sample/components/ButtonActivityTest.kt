package com.natura.android.sample.components

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.android.synthetic.main.activity_button.*
import kotlinx.android.synthetic.main.activity_selection_control.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ButtonActivityTest {

    lateinit var buttonActivity: ActivityScenario<ButtonActivity>

    @Before
    fun setUp() {
        buttonActivity = ActivityScenario.launch(ButtonActivity::class.java)
    }

    @Test
    fun checkStylesAppliedToContainedButton() {
        buttonActivity.onActivity { buttonActivity ->
            val buttonContained = buttonActivity.containedButton
            val state = listOf(android.R.attr.state_enabled).toIntArray()
            val colorLabelDefault = buttonContained.textColors.defaultColor


            val backgroundDrawable = buttonContained.backgroundTintList?.getColorForState(state, colorLabelDefault)


            val colorLabelDisabled = buttonContained.textColors.getColorForState(state, colorLabelDefault)

            Assert.assertEquals(Color.parseColor("#333333"), backgroundDrawable)
        }
    }
}