package com.natura.android.button

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class TextButtonFixture private constructor(
    private var buttonSize: Int? = null,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {
    companion object {
        private const val SEMI = 0
        private const val SEMIX = 1
        private const val MEDIUM = 2

        private const val defaultType = SEMIX
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aTextButton(): TextButtonFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return TextButtonFixture(defaultType, context)
        }

        fun aEmptyButton(): TextButtonFixture {
            return aEmptyButton()
        }
    }

    fun withSemiSize(): TextButtonFixture {
        this.buttonSize = SEMI
        return this
    }

    fun withSemixSize(): TextButtonFixture {
        this.buttonSize = SEMIX
        return this
    }

    fun withMediumSize(): TextButtonFixture {
        this.buttonSize = MEDIUM
        return this
    }

    fun build(): TextButton {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.bt_size, buttonSize.toString())
            .build()

        return TextButton(context, attributes)
    }
}
