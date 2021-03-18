package com.natura.android.listitem

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class ListItemFixture private constructor(
    private var touchState: Boolean = false,
    private var divider: Int? = null,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {

    companion object {
        private const val NONE = 0
        private const val FULLBLEED = 1
        private const val INSET = 2
        private const val MIDDLE = 3

        private const val defaultTouchState = true
        private const val defaultDivider = NONE

        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aListItem(): ListItemFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return ListItemFixture(defaultTouchState, defaultDivider, context)
        }
    }

    fun withTouchState(touchState: Boolean): ListItemFixture {
        this.touchState = touchState
        return this
    }

    fun withDividerFullbleed(): ListItemFixture {
        this.divider = ListItemFixture.FULLBLEED
        return this
    }

    fun withDividerInset(): ListItemFixture {
        this.divider = ListItemFixture.INSET
        return this
    }

    fun withDividerMiddle(): ListItemFixture {
        this.divider = ListItemFixture.MIDDLE
        return this
    }

    fun build(): ListItem {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.touchState, touchState.toString())
            .addAttribute(R.attr.dividerBottom, divider.toString())
            .build()

        return ListItem(context, attributes)
    }
}
