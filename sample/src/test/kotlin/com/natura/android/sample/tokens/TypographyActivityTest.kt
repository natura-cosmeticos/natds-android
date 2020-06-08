package com.natura.android.sample.tokens

import android.graphics.Color
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.tokens.typography.TypographyActivity
import kotlinx.android.synthetic.main.activity_typography.*
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TypographyActivityTest {

    lateinit var typographyActivityScenario: ActivityScenario<TypographyActivity>

    @Before
    fun setUp() {
        typographyActivityScenario = ActivityScenario.launch(TypographyActivity::class.java)
    }

    @Test
    fun checksHeading1TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.h1Sample.textSize
            var textColor = typographyActivity.h1Sample.currentTextColor

            assertEquals(96.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksHeading2TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.h2Sample.textSize
            var textColor = typographyActivity.h2Sample.currentTextColor

            assertEquals(60.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksHeading3TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.h3Sample.textSize
            var textColor = typographyActivity.h3Sample.currentTextColor

            assertEquals(48.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksHeading4TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.h4Sample.textSize
            var textColor = typographyActivity.h4Sample.currentTextColor

            assertEquals(34.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksHeading5TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.h5Sample.textSize
            var textColor = typographyActivity.h5Sample.currentTextColor

            assertEquals(24.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksHeading6TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.h6Sample.textSize
            var textColor = typographyActivity.h6Sample.currentTextColor

            assertEquals(20.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksSubtitle1TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.subtitle1Sample.textSize
            var textColor = typographyActivity.subtitle1Sample.currentTextColor

            assertEquals(16.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksSubtitle2TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.subtitle2Sample.textSize
            var textColor = typographyActivity.subtitle2Sample.currentTextColor

            assertEquals(14.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksBody1TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.body1Sample.textSize
            var textColor = typographyActivity.body1Sample.currentTextColor

            assertEquals(16.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksBody2TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.body2Sample.textSize
            var textColor = typographyActivity.body2Sample.currentTextColor

            assertEquals(14.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksButtonTextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.buttonSample.textSize
            var textColor = typographyActivity.buttonSample.currentTextColor

            assertEquals(14.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksCaptionTextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.captionSample.textSize
            var textColor = typographyActivity.captionSample.currentTextColor

            assertEquals(12.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }

    @Test
    fun checksOverlineTextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.overlineSample.textSize
            var textColor = typographyActivity.overlineSample.currentTextColor

            assertEquals(12.0F, textSize)
            assertEquals(Color.parseColor("#333333"), textColor)
        }
    }
}
