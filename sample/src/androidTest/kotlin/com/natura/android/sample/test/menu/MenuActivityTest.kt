package com.natura.android.sample.test.menu

import android.view.LayoutInflater
import android.view.View
import androidx.test.annotation.UiThreadTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import com.natura.android.sample.R
import com.natura.android.sample.test.ScreenShotActivityTestBase
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@Ignore
class MenuActivityTest: ScreenShotActivityTestBase() {
    private lateinit var inflater: LayoutInflater

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        inflater = LayoutInflater.from(appContext)
    }

    @Test
    fun verifyMenuWhenIsEnabled() {
        val view: View = inflater.inflate(R.layout.component_menu_enable, null, false)
        checkView(view)
    }

    @Test
    fun verifyMenuWhenIsDisable() {
        val view: View = inflater.inflate(R.layout.component_menu_disable, null, false)
        checkView(view)
    }

    @Test
    fun verifyMenuWhenIsSelected() {
        val view: View = inflater.inflate(R.layout.component_menu_selected, null, false)
        checkView(view)
    }

    @UiThreadTest
    @Test
    fun verifyMenuWhenIsOpened() {
        val view: View = inflater.inflate(R.layout.component_menu_opened, null, false)
        checkView(view)
    }

    private fun checkView(view: View) {
        ViewHelpers.setupView(view)
            .setExactWidthPx(500)
            .setExactHeightPx(50)
            .layout()
        Screenshot.snap(view)
            .record()
    }
}
