package com.natura.android.appbartop

import android.content.Context
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class StandardAppBarTopFixture private constructor(
    private var appBarColor: Int = DEFAULT,
    private var enabledElevation: Boolean = true,
    private var actionRight: Boolean = false,
    private var actionLeft: Boolean = false,
    private var mediaHeight: Int = WRAP_CONTENT,
    private var mediaWidth: Int = WRAP_CONTENT,
    private var proeminentContent: Boolean = false,
    private var scrollable: Boolean = false,
    private var contentType: Int = TEXT,
    private var contentPosition: Int = CENTER,
    private var contentText: String = "",
    private var context: Context = ApplicationProvider.getApplicationContext()
) {

    companion object {
        private const val DEFAULT = 0
        private const val PRIMARY = 1
        private const val NONE = 2
        private const val INVERSE = 3

        private const val TEXT = 0
        private const val MEDIA = 1
        private const val SEARCH = 2

        private const val LEFT = 0
        private const val CENTER = 1

        private const val defaultAppBarColor = DEFAULT
        private const val defaultEnabledElevation = true
        private const val defaultActionRight = false
        private const val defaultActionLeft = true
        private const val defaultMediaHeight = WRAP_CONTENT
        private const val defaultMediaWidth = WRAP_CONTENT
        private const val defaultScrollable = true
        private const val defaultProeminentContent = true
        private const val defaultContentPosition = CENTER
        private const val defaultContentType = TEXT
        private const val defaultContentText = ""
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aStandardAppBarTop(): StandardAppBarTopFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return StandardAppBarTopFixture(
                defaultAppBarColor,
                defaultEnabledElevation,
                defaultActionRight,
                defaultActionLeft,
                defaultMediaHeight,
                defaultMediaWidth,
                defaultScrollable,
                defaultProeminentContent,
                defaultContentPosition,
                defaultContentType,
                defaultContentText,
                context
            )
        }
    }

    fun withDefaultAppBarColor(): StandardAppBarTopFixture {
        this.appBarColor = DEFAULT
        return this
    }

    fun withPrimaryAppBarColor(): StandardAppBarTopFixture {
        this.appBarColor = PRIMARY
        return this
    }

    fun withNoneAppBarColor(): StandardAppBarTopFixture {
        this.appBarColor = NONE
        return this
    }

    fun withInverseAppBarColor(): StandardAppBarTopFixture {
        this.appBarColor = INVERSE
        return this
    }

    fun withTextContentType(): StandardAppBarTopFixture {
        this.contentType = TEXT
        return this
    }

    fun withMediaContentType(): StandardAppBarTopFixture {
        this.contentType = MEDIA
        return this
    }

    fun withSearchContentType(): StandardAppBarTopFixture {
        this.contentType = SEARCH
        return this
    }

    fun withLeftContentPosition(): StandardAppBarTopFixture {
        this.contentPosition = LEFT
        return this
    }

    fun withCenterContentPosition(): StandardAppBarTopFixture {
        this.contentPosition = CENTER
        return this
    }

    fun withEnabledElevation(enabledElevation: Boolean): StandardAppBarTopFixture {
        this.enabledElevation = enabledElevation
        return this
    }

    fun withActionRight(actionRight: Boolean): StandardAppBarTopFixture {
        this.actionRight = actionRight
        return this
    }

    fun withActionLeft(actionLeft: Boolean): StandardAppBarTopFixture {
        this.actionLeft = actionLeft
        return this
    }

    fun withProeminentContent(proeminentContent: Boolean): StandardAppBarTopFixture {
        this.proeminentContent = proeminentContent
        return this
    }

    fun withScrollable(scrollable: Boolean): StandardAppBarTopFixture {
        this.scrollable = scrollable
        return this
    }

    fun withContentText(text: String): StandardAppBarTopFixture {
        this.contentText = text
        return this
    }

    fun withMediaHeight(height: Int): StandardAppBarTopFixture {
        this.mediaHeight = height
        return this
    }

    fun withMediaWidth(width: Int): StandardAppBarTopFixture {
        this.mediaWidth = width
        return this
    }

    fun build(): StandardAppBarTop {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.enabledElevation, enabledElevation.toString())
            .addAttribute(R.attr.appBarColor, appBarColor.toString())
            .addAttribute(R.attr.contentType, contentType.toString())
            .addAttribute(R.attr.contentPosition, contentPosition.toString())
            .addAttribute(R.attr.contentText, contentText)
            .addAttribute(R.attr.scrollable, scrollable.toString())
            .addAttribute(R.attr.proeminentContent, proeminentContent.toString())
            .addAttribute(R.attr.actionRight, actionRight.toString())
            .addAttribute(R.attr.actionLeft, actionLeft.toString())
            .addAttribute(R.attr.mediaHeight, mediaHeight.toString())
            .addAttribute(R.attr.mediaWidth, mediaWidth.toString())
            .build()

        return StandardAppBarTop(context, attributes)
    }
}
