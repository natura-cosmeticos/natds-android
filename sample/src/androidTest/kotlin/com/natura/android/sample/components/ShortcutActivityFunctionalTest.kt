package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import kotlinx.android.synthetic.main.activity_shortcut.*
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
            val shortcut = it.shortcutContained1
            val ellipsis = shortcut.labelContainer.layout.getEllipsisCount(0)

            Truth.assertThat(ellipsis > 0).isTrue()
        }
    }

    @Test
    fun checksEllipsisAtShortcutOutlinedLabel() {
        scenario.onActivity {
            val shortcut = it.shortcutOutlined1
            val ellipsis = shortcut.labelContainer.layout.getEllipsisCount(0)

            Truth.assertThat(ellipsis > 0).isTrue()
        }
    }
}