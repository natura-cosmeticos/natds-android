package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShortcutActivityTest {
    lateinit var shortcutActivityScenario: ActivityScenario<ShortcutActivity>

    @Before
    fun setUp() {
        shortcutActivityScenario = ActivityScenario.launch(ShortcutActivity::class.java)
    }


}