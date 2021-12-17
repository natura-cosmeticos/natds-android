package com.natura.android.sample.tokens

import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
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
        spacingActivityScenario.onActivity {
            val marginValue = it.findViewById<CardView>(R.id.cardFirstTop).layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(0, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingMicroValue() {
        spacingActivityScenario.onActivity {
            val marginValue = it.findViewById<CardView>(R.id.cardFirstTopMicro).layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(4, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingTinyValue() {
        spacingActivityScenario.onActivity {
            val marginValue = it.findViewById<CardView>(R.id.cardFirstTopTiny).layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(8, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingSmallValue() {
        spacingActivityScenario.onActivity {
            val marginValue = it.findViewById<CardView>(R.id.cardFirstTopSmall).layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(16, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingStandardValue() {
        spacingActivityScenario.onActivity {
            val marginValue = it.findViewById<CardView>(R.id.cardFirstTopStandard).layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(24, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingSemiValue() {
        spacingActivityScenario.onActivity {
            val marginValue = it.findViewById<CardView>(R.id.cardFirstTopSemi).layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(32, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingLargeValue() {
        spacingActivityScenario.onActivity {
            val marginValue = it.findViewById<CardView>(R.id.cardFirstTopLarge).layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(48, marginValue.bottomMargin)
        }
    }

    @Test
    fun checksSpacingXLargeValue() {
        spacingActivityScenario.onActivity {
            val marginValue = it.findViewById<CardView>(R.id.cardFirstTopXLarge).layoutParams as ViewGroup.MarginLayoutParams

            assertEquals(64, marginValue.bottomMargin)
        }
    }
}
