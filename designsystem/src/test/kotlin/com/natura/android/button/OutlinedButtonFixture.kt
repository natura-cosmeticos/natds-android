package com.natura.android.button

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class OutlinedButtonFixture private constructor(
    private var buttonSize: Int? = null,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {
    companion object {
        private const val SEMI = 0
        private const val SEMIX = 1
        private const val MEDIUM = 2

        private const val defaultType = SEMIX
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aOutlinedButton(): OutlinedButtonFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return OutlinedButtonFixture(defaultType, context)
        }

        fun aEmptyButton(): OutlinedButtonFixture {
            return aEmptyButton()
        }
    }

    fun withSemiSize(): OutlinedButtonFixture {
        this.buttonSize = SEMI
        return this
    }

    fun withSemixSize(): OutlinedButtonFixture {
        this.buttonSize = SEMIX
        return this
    }

    fun withMediumSize(): OutlinedButtonFixture {
        this.buttonSize = MEDIUM
        return this
    }

    fun build(): OutlinedButton {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.bt_size, buttonSize.toString())
            .build()

        return OutlinedButton(context, attributes)
    }
}
