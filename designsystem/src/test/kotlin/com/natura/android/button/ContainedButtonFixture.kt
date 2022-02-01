package com.natura.android.button

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class ContainedButtonFixture private constructor(
    private var buttonSize: Int? = null,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {
    companion object {
        private const val SEMI = 0
        private const val SEMIX = 1
        private const val MEDIUM = 2

        private const val defaultType = SEMIX
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aContainedButton(): ContainedButtonFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return ContainedButtonFixture(defaultType, context)
        }

        fun aEmptyButton(): ContainedButtonFixture {
            return aEmptyButton()
        }
    }

    fun withSemiSize(): ContainedButtonFixture {
        this.buttonSize = SEMI
        return this
    }

    fun withSemixSize(): ContainedButtonFixture {
        this.buttonSize = SEMIX
        return this
    }

    fun withMediumSize(): ContainedButtonFixture {
        this.buttonSize = MEDIUM
        return this
    }

    fun build(): ContainedButton {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.bt_size, buttonSize.toString())
            .build()

        return ContainedButton(context, attributes)
    }
}
