package com.natura.android.sample.tokens

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
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

            assertEquals(96.0F, textSize)
        }
    }

    @Test
    fun checksHeading2TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.h2Sample.textSize

            assertEquals(60.0F, textSize)
        }
    }

    @Test
    fun checksHeading3TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.h3Sample.textSize

            assertEquals(48.0F, textSize)
        }
    }

    @Test
    fun checksHeading4TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.h4Sample.textSize

            assertEquals(34.0F, textSize)
        }
    }

    @Test
    fun checksHeading5TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.h5Sample.textSize

            assertEquals(24.0F, textSize)
        }
    }

    @Test
    fun checksHeading6TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.h6Sample.textSize

            assertEquals(20.0F, textSize)
        }
    }

    @Test
    fun checksSubtitle1TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.subtitle1Sample.textSize

            assertEquals(16.0F, textSize)
        }
    }

    @Test
    fun checksSubtitle2TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.subtitle2Sample.textSize

            assertEquals(14.0F, textSize)
        }
    }

    @Test
    fun checksBody1TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.body1Sample.textSize

            assertEquals(16.0F, textSize)
        }
    }

    @Test
    fun checksBody2TextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.body2Sample.textSize

            assertEquals(14.0F, textSize)
        }
    }

    @Test
    fun checksButtonTextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.buttonSample.textSize

            assertEquals(14.0F, textSize)
        }
    }

    @Test
    fun checksCaptionTextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.captionSample.textSize

            assertEquals(12.0F, textSize)
        }
    }

    @Test
    fun checksOverlineTextSize() {
        typographyActivityScenario.onActivity { typographyActivity ->
            var textSize = typographyActivity.overlineSample.textSize

            assertEquals(12.0F, textSize)
        }
    }
}
