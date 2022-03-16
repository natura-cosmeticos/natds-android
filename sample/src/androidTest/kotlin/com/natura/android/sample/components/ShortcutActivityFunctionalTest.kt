package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.sample.R
import com.natura.android.shortcut.Shortcut
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShortcutActivityFunctionalTest {

    private lateinit var scenario: ActivityScenario<ShortcutActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(ShortcutActivity::class.java)
    }

    @Test
    fun checksEllipsisAtShortcutContainedLabel() {
        scenario.onActivity {
            val shortcut = it.findViewById<Shortcut>(R.id.shortcutWithBreakLine)
            val ellipsis = shortcut.labelContainer.layout.getEllipsisCount(1)

            Truth.assertThat(ellipsis > 0).isTrue()
        }
    }

    @Test
    fun checksNoLabelAtShorcutContained() {
        scenario.onActivity {
            val shortcut = it.findViewById<Shortcut>(R.id.shortcutWithNoLabel)
            val label = shortcut.labelContainer.layout.text

            Truth.assertThat(label).isEqualTo("")
        }
    }
}
