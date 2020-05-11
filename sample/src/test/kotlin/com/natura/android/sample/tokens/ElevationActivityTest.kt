package com.natura.android.sample.tokens

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.android.synthetic.main.activity_elevation.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ElevationActivityTest {
    lateinit var elevationActivityScenario: ActivityScenario<ElevationActivity>

    @Before
    fun setUp() {
        elevationActivityScenario = ActivityScenario.launch(ElevationActivity::class.java)
    }

    @Test
    fun checksElevationNoneSize() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevationNone.cardElevation.toInt()

            assertEquals(0, elevation)
        }
    }

    @Test
    fun checksElevation1Size() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevation1.cardElevation.toInt()

            assertEquals(1, elevation)
        }
    }

    @Test
    fun checksElevation2Size() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevation2.cardElevation.toInt()

            assertEquals(2, elevation)
        }
    }

    @Test
    fun checksElevation3Size() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevation3.cardElevation.toInt()

            assertEquals(3, elevation)
        }
    }

    @Test
    fun checksElevation4Size() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevation4.cardElevation.toInt()

            assertEquals(4, elevation)
        }
    }

    @Test
    fun checksElevation5Size() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevation5.cardElevation.toInt()

            assertEquals(5, elevation)
        }
    }

    @Test
    fun checksElevation6Size() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevation6.cardElevation.toInt()

            assertEquals(6, elevation)
        }
    }

    @Test
    fun checksElevation7Size() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevation7.cardElevation.toInt()

            assertEquals(7, elevation)
        }
    }

    @Test
    fun checksElevation8Size() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevation8.cardElevation.toInt()

            assertEquals(8, elevation)
        }
    }

    @Test
    fun checksElevation9Size() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevation9.cardElevation.toInt()

            assertEquals(9, elevation)
        }
    }

    @Test
    fun checksElevation12Size() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevation12.cardElevation.toInt()

            assertEquals(12, elevation)
        }
    }

    @Test
    fun checksElevation16Size() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevation16.cardElevation.toInt()

            assertEquals(16, elevation)
        }
    }

    @Test
    fun checksElevation24Size() {
        elevationActivityScenario.onActivity { elevationActivity ->
            val elevation = elevationActivity.cardElevation24.cardElevation.toInt()

            assertEquals(24, elevation)
        }
    }
}
