package com.natura.android.sample.tokens

import androidx.cardview.widget.CardView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
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
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeNone).width

            assertEquals(0, cardWith)
        }
    }

    @Test
    fun checksSizeMicroValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeMicro).width

            assertEquals(4, cardWith)
        }
    }

    @Test
    fun checksSizeTinyValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeTiny).width

            assertEquals(8, cardWith)
        }
    }

    @Test
    fun checksSizeSmallValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeSmall).width

            assertEquals(16, cardWith)
        }
    }

    @Test
    fun checksSizeStandardValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeStandard).width

            assertEquals(24, cardWith)
        }
    }

    @Test
    fun checksSizeSemiValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeSemi).width

            assertEquals(32, cardWith)
        }
    }

    @Test
    fun checksSizeSemiXValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeSemiX).width

            assertEquals(40, cardWith)
        }
    }

    @Test
    fun checksSizeMediumValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeMedium).width

            assertEquals(48, cardWith)
        }
    }

    @Test
    fun checksSizeMediumXValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeMediumX).width

            assertEquals(56, cardWith)
        }
    }

    @Test
    fun checksSizeLargeValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeLarge).width

            assertEquals(64, cardWith)
        }
    }

    @Test
    fun checksSizeLargeXValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeLargeX).width

            assertEquals(72, cardWith)
        }
    }

    @Test
    fun checksSizeLargeXXValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeLargeXX).width

            assertEquals(80, cardWith)
        }
    }

    @Test
    fun checksSizeLargeXXXValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeLargeXXX).width

            assertEquals(88, cardWith)
        }
    }

    @Test
    fun checksSizeHugeValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeHuge).width

            assertEquals(96, cardWith)
        }
    }

    @Test
    fun checksSizeHugeXValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeHugeX).width

            assertEquals(128, cardWith)
        }
    }

    @Test
    fun checksSizeHugeXXValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeHugeXX).width

            assertEquals(144, cardWith)
        }
    }

    @Test
    fun checksSizeHugeXXXValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeHugeXXX).width

            assertEquals(192, cardWith)
        }
    }

    @Test
    fun checksSizeVeryHugeValue() {
        sizeActivityScenario.onActivity {
            val cardWith = it.findViewById<CardView>(R.id.cardSizeVeryHuge).width

            assertEquals(256, cardWith)
        }
    }
}
