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
            val elevation = elevationActivity.cardElevationNone.elevation

            assertEquals(0.0, elevation)
        }
    }
}