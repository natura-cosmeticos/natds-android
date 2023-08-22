package com.natura.android.button

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContainedButtonTest {

    private lateinit var button: ContainedButton
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    private fun buildContainedButtonWithSemiSize(): ContainedButton {
        return ContainedButtonFixture
            .aContainedButton()
            .withSemiSize()
            .build()
    }

    companion object {
        private const val SEMI_HEIGHT = 32
        private const val SEMIX_HEIGHT = 40
        private const val MEDIUM_HEIGHT = 48

        private const val SEMI_SIZE = 0
        private const val SEMIX_SIZE = 1
        private const val MEDIUM_SIZE = 2
    }
}
