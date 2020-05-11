package com.natura.android.sample.components

import android.view.ViewGroup
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.tokens.SpacingActivity
import kotlinx.android.synthetic.main.activity_spacing.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SpacingActivityTest {

    private lateinit var spacingActivityScenario: ActivityScenario<SpacingActivity>

    @Before
    fun setUp() {
        spacingActivityScenario = ActivityScenario.launch(SpacingActivity::class.java)
    }

    @Test
    fun checksSpacingNoneValue() {
        spacingActivityScenario.onActivity { spacingActivity ->
            val marginValue = spacingActivity.cardFirstTop.layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(0, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingMicroValue() {
        spacingActivityScenario.onActivity { spacingActivity ->
            val marginValue = spacingActivity.cardFirstTopMicro.layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(4, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingTinyValue() {
        spacingActivityScenario.onActivity { spacingActivity ->
            val marginValue = spacingActivity.cardFirstTopTiny.layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(8, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingSmallValue() {
        spacingActivityScenario.onActivity { spacingActivity ->
            val marginValue = spacingActivity.cardFirstTopSmall.layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(16, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingStandardValue() {
        spacingActivityScenario.onActivity { spacingActivity ->
            val marginValue = spacingActivity.cardFirstTopStandard.layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(24, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingSemiValue() {
        spacingActivityScenario.onActivity { spacingActivity ->
            val marginValue = spacingActivity.cardFirstTopSemi.layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(32, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingLargeValue() {
        spacingActivityScenario.onActivity { spacingActivity ->
            val marginValue = spacingActivity.cardFirstTopLarge.layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(48, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingXLargeValue() {
        spacingActivityScenario.onActivity { spacingActivity ->
            val marginValue = spacingActivity.cardFirstTopXLarge.layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(64, marginValue.bottomMargin)
        }
    }
}
