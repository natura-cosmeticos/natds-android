package com.natura.android.sample.test.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import com.natura.android.sample.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MenuActionTagTest {

    private lateinit var inflater: LayoutInflater

    @Before
    fun setup() {
        val appContext = ApplicationProvider.getApplicationContext<Context>()
        inflater = LayoutInflater.from(appContext)
    }

    @Test
    fun verifyActionTagIsCorrectlyConfigured() {
        val view: View = inflater.inflate(R.layout.menu_action_tag, null, false)
        checkView(view)
    }

    private fun checkView(view: View) {
        ViewHelpers.setupView(view)
            .setExactWidthPx(150)
            .setExactHeightPx(83)
            .layout()

        Screenshot.snap(view)
            .record()
    }
}