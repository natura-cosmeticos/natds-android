package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import kotlinx.android.synthetic.main.activity_divider.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DividerActivityFunctionalTest {

    private lateinit var scenario: ActivityScenario<DividerActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(DividerActivity::class.java)
    }

    @Test
    fun checksIfTypeIsFullbleedAtDivider() {
        scenario.onActivity {
            val divider = it.dividerFullbleed
            val type = divider.getType()

            Truth.assertThat(type).isEqualTo(0)
        }
    }

    @Test
    fun checksIfTypeIsInsetAtDivider() {
        scenario.onActivity {
            val divider = it.dividerInset
            val type = divider.getType()

            Truth.assertThat(type).isEqualTo(1)
        }
    }

    @Test
    fun checksIfTypeIsMiddleAtDivider() {
        scenario.onActivity {
            val divider = it.dividerMiddle
            val type = divider.getType()

            Truth.assertThat(type).isEqualTo(2)
        }
    }
}
