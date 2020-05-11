package com.natura.android.sample.tokens

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.android.synthetic.main.activity_size.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SizeActivityTest {

    lateinit var sizeActivityScenario: ActivityScenario<SizeActivity>

    @Before
    fun setUp() {
        sizeActivityScenario = ActivityScenario.launch(SizeActivity::class.java)
    }

    @Test
    fun checksSizeNoneValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeNone.width

            assertEquals(0, cardWith)
        }
    }

    @Test
    fun checksSizeMicroValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeMicro.width

            assertEquals(4, cardWith)
        }
    }

    @Test
    fun checksSizeTinyValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeTiny.width

            assertEquals(8, cardWith)
        }
    }

    @Test
    fun checksSizeSmallValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeSmall.width

            assertEquals(16, cardWith)
        }
    }

    @Test
    fun checksSizeStandardValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeStandard.width

            assertEquals(24, cardWith)
        }
    }

    @Test
    fun checksSizeSemiValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeSemi.width

            assertEquals(32, cardWith)
        }
    }

    @Test
    fun checksSizeSemiXValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeSemiX.width

            assertEquals(40, cardWith)
        }
    }

    @Test
    fun checksSizeMediumValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeMedium.width

            assertEquals(48, cardWith)
        }
    }

    @Test
    fun checksSizeMediumXValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeMediumX.width

            assertEquals(56, cardWith)
        }
    }

    @Test
    fun checksSizeLargeValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeLarge.width

            assertEquals(64, cardWith)
        }
    }

    @Test
    fun checksSizeLargeXValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeLargeX.width

            assertEquals(72, cardWith)
        }
    }

    @Test
    fun checksSizeLargeXXValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeLargeXX.width

            assertEquals(80, cardWith)
        }
    }

    @Test
    fun checksSizeLargeXXXValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeLargeXXX.width

            assertEquals(88, cardWith)
        }
    }

    @Test
    fun checksSizeHugeValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeHuge.width

            assertEquals(96, cardWith)
        }
    }

    @Test
    fun checksSizeHugeXValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeHugeX.width

            assertEquals(128, cardWith)
        }
    }

    @Test
    fun checksSizeHugeXXValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeHugeXX.width

            assertEquals(144, cardWith)
        }
    }

    @Test
    fun checksSizeHugeXXXValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeHugeXXX.width

            assertEquals(192, cardWith)
        }
    }

    @Test
    fun checksSizeVeryHugeValue() {
        sizeActivityScenario.onActivity { sizeActivity ->
            val cardWith = sizeActivity.cardSizeVeryHuge.width

            assertEquals(256, cardWith)
        }
    }
}
