package com.natura.android.sample.tokens

import androidx.cardview.widget.CardView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.sample.R
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ElevationActivityTest {
    private lateinit var elevationActivityScenario: ActivityScenario<ElevationActivity>

    @Before
    fun setUp() {
        elevationActivityScenario = ActivityScenario.launch(ElevationActivity::class.java)
    }

    @Test
    fun checksElevationNoneSize() {
        elevationActivityScenario.onActivity {
            val elevation = it.findViewById<CardView>(R.id.cardElevationNone).cardElevation.toInt()

            assertEquals(0, elevation)
        }
    }

    @Test
    fun checksElevation1Size() {
        elevationActivityScenario.onActivity {
            val elevation = it.findViewById<CardView>(R.id.cardElevation1).cardElevation.toInt()

            assertEquals(1, elevation)
        }
    }

    @Test
    fun checksElevation2Size() {
        elevationActivityScenario.onActivity {
            val elevation = it.findViewById<CardView>(R.id.cardElevation2).cardElevation.toInt()

            assertEquals(2, elevation)
        }
    }

    @Test
    fun checksElevation3Size() {
        elevationActivityScenario.onActivity {
            val elevation = it.findViewById<CardView>(R.id.cardElevation3).cardElevation.toInt()

            assertEquals(3, elevation)
        }
    }

    @Test
    fun checksElevation4Size() {
        elevationActivityScenario.onActivity {
            val elevation = it.findViewById<CardView>(R.id.cardElevation4).cardElevation.toInt()

            assertEquals(4, elevation)
        }
    }

    @Test
    fun checksElevation5Size() {
        elevationActivityScenario.onActivity {
            val elevation = it.findViewById<CardView>(R.id.cardElevation5).cardElevation.toInt()

            assertEquals(6, elevation)
        }
    }

    @Test
    fun checksElevation6Size() {
        elevationActivityScenario.onActivity {
            val elevation = it.findViewById<CardView>(R.id.cardElevation6).cardElevation.toInt()

            assertEquals(8, elevation)
        }
    }

    @Test
    fun checksElevation7Size() {
        elevationActivityScenario.onActivity {
            val elevation = it.findViewById<CardView>(R.id.cardElevation7).cardElevation.toInt()

            assertEquals(9, elevation)
        }
    }

    @Test
    fun checksElevation8Size() {
        elevationActivityScenario.onActivity {
            val elevation = it.findViewById<CardView>(R.id.cardElevation8).cardElevation.toInt()

            assertEquals(12, elevation)
        }
    }

    @Test
    fun checksElevation9Size() {
        elevationActivityScenario.onActivity {
            val elevation = it.findViewById<CardView>(R.id.cardElevation9).cardElevation.toInt()

            assertEquals(16, elevation)
        }
    }

    @Test
    fun checksElevation10Size() {
        elevationActivityScenario.onActivity {
            val elevation = it.findViewById<CardView>(R.id.cardElevation10).cardElevation.toInt()

            assertEquals(24, elevation)
        }
    }
}
