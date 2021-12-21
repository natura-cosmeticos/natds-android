package com.natura.android.sample.components

import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.sample.R
import com.natura.android.shortcut.Shortcut
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
        shortcutActivityScenario.onActivity {
            val shortcutContained = it.findViewById<Shortcut>(R.id.firstShortcutContained)
            val counter = it.findViewById<TextView>(R.id.counter)

            shortcutContained.performClick()

            Truth.assertThat(counter.text).isEqualTo("Counter click 1")
        }
    }

    @Test
    fun incrementCounterWhenTapAtOutlinedShortcut() {
        shortcutActivityScenario.onActivity {
            val shortcutOutlined = it.findViewById<Shortcut>(R.id.firstShorcutOutlined)
            val counter = it.findViewById<TextView>(R.id.counter)

            shortcutOutlined.performClick()

            Truth.assertThat(counter.text).isEqualTo("Counter click 1")
        }
    }
}
