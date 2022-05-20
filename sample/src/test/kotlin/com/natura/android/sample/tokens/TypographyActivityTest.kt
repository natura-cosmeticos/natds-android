package com.natura.android.sample.tokens

import android.graphics.Color
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TypographyActivityTest {

    private lateinit var typographyActivityScenario: ActivityScenario<TypographyActivity>

    @Before
    fun setUp() {
        typographyActivityScenario = ActivityScenario.launch(TypographyActivity::class.java)
    }

    @Test
    fun checksHeading1TextSize() {
        typographyActivityScenario.onActivity {
            val textSize = it.findViewById<TextView>(R.id.h1Sample).textSize
            val textColor = it.findViewById<TextView>(R.id.h1Sample).currentTextColor

            assertEquals(96.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksHeading2TextSize() {
        typographyActivityScenario.onActivity {
            val textSize = it.findViewById<TextView>(R.id.h2Sample).textSize
            val textColor = it.findViewById<TextView>(R.id.h2Sample).currentTextColor

            assertEquals(60.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksHeading3TextSize() {
        typographyActivityScenario.onActivity {
            val textSize = it.findViewById<TextView>(R.id.h3Sample).textSize
            val textColor = it.findViewById<TextView>(R.id.h3Sample).currentTextColor

            assertEquals(48.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksHeading4TextSize() {
        typographyActivityScenario.onActivity {
            val textSize = it.findViewById<TextView>(R.id.h4Sample).textSize
            val textColor = it.findViewById<TextView>(R.id.h4Sample).currentTextColor

            assertEquals(34.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksHeading5TextSize() {
        typographyActivityScenario.onActivity {
            val textSize = it.findViewById<TextView>(R.id.h5Sample).textSize
            val textColor = it.findViewById<TextView>(R.id.h5Sample).currentTextColor

            assertEquals(24.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksHeading6TextSize() {
        typographyActivityScenario.onActivity {
            val textSize = it.findViewById<TextView>(R.id.h6Sample).textSize
            val textColor = it.findViewById<TextView>(R.id.h6Sample).currentTextColor

            assertEquals(20.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksSubtitle1TextSize() {
        typographyActivityScenario.onActivity {
            val textSize = it.findViewById<TextView>(R.id.subtitle1Sample).textSize
            val textColor = it.findViewById<TextView>(R.id.subtitle1Sample).currentTextColor

            assertEquals(16.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksSubtitle2TextSize() {
        typographyActivityScenario.onActivity {
            val textSize = it.findViewById<TextView>(R.id.subtitle2Sample).textSize
            val textColor = it.findViewById<TextView>(R.id.subtitle2Sample).currentTextColor

            assertEquals(14.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksBody1TextSize() {
        typographyActivityScenario.onActivity {
            val textSize = it.findViewById<TextView>(R.id.body1Sample).textSize
            val textColor = it.findViewById<TextView>(R.id.body1Sample).currentTextColor

            assertEquals(16.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksBody2TextSize() {
        typographyActivityScenario.onActivity {
            val textSize = it.findViewById<TextView>(R.id.body2Sample).textSize
            val textColor = it.findViewById<TextView>(R.id.body2Sample).currentTextColor

            assertEquals(14.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksCaptionTextSize() {
        typographyActivityScenario.onActivity {
            val textSize = it.findViewById<TextView>(R.id.captionSample).textSize
            val textColor = it.findViewById<TextView>(R.id.captionSample).currentTextColor

            assertEquals(12.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksOverlineTextSize() {
        typographyActivityScenario.onActivity {
            val textSize = it.findViewById<TextView>(R.id.overlineSample).textSize
            val textColor = it.findViewById<TextView>(R.id.overlineSample).currentTextColor

            assertEquals(12.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }
}
