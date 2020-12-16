package com.natura.android.sample.screenshottests

import android.view.LayoutInflater
import android.view.View
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import com.natura.android.sample.R
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
@Ignore
@RunWith(AndroidJUnit4::class)
class SubmenuActivityTest {
    private lateinit var inflater: LayoutInflater

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        inflater = LayoutInflater.from(appContext)
    }

    @Test
    fun verifySubmenuWhenIsEnabled() {
        val view: View = inflater.inflate(R.layout.component_submenu_enable, null, false)
        checkView(view)
    }

    @Test
    fun verifySubmenuWhenIsDisable() {
        val view: View = inflater.inflate(R.layout.component_submenu_disable, null, false)
        checkView(view)
    }

    @Test
    fun verifySubmenuWhenIsSelected() {
        val view: View = inflater.inflate(R.layout.component_submenu_selected, null, false)
        checkView(view)
    }

    private fun checkView(view: View) {
        ViewHelpers.setupView(view)
            .setExactWidthPx(500)
            .setExactHeightPx(150)
            .layout()
        Screenshot.snap(view)
            .record()
    }
}
