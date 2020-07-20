package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import kotlinx.android.synthetic.main.activity_shortcut.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShortcutActivityTest {
    lateinit var shortcutActivityScenario: ActivityScenario<ShortcutActivity>

    @Before
    fun setUp() {
        shortcutActivityScenario = ActivityScenario.launch(ShortcutActivity::class.java)
    }

    @Test
    fun incrementCounterWhenTapAtContainedShortcut() {
        shortcutActivityScenario.onActivity { shortcutActivity ->
            val shortcutContained = shortcutActivity.shortcutContained1
            val counter = shortcutActivity.counter

            shortcutContained.performClick()

            Truth.assertThat(counter.text).isEqualTo("Counter click 1")
        }
    }

    @Test
    fun incrementCounterWhenTapAtOutlinedShortcut() {
        shortcutActivityScenario.onActivity { shortcutActivity ->
            val shortcutOutlined = shortcutActivity.shortcutOutlined1
            val counter = shortcutActivity.counter

            shortcutOutlined.performClick()

            Truth.assertThat(counter.text).isEqualTo("Counter click 1")
        }
    }
}