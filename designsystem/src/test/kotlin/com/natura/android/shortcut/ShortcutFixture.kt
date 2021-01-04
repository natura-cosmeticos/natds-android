package com.natura.android.shortcut

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class ShortcutFixture private constructor(
    private var type: Int? = null,
    private var label: String? = null,
    private var iconName: String? = null,
    private var notify: Int = 0,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {

    companion object {
        private const val OUTLINED = 0
        private const val CONTAINED = 1

        private const val defaultType = OUTLINED
        private const val defaultLabel = "shortcut label"
        private const val defaultIcon = "outlined-default-mockup"
        private const val defaultNotify = 10
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aShortcut(): ShortcutFixture {
            context.setTheme(R.style.Theme_Natura)
            return ShortcutFixture(defaultType, defaultLabel, defaultIcon, defaultNotify, context)
        }

        fun aEmptyShortcut(): ShortcutFixture {
            return ShortcutFixture()
        }
    }

    fun withTypeContained(): ShortcutFixture {
        this.type = CONTAINED
        return this
    }

    fun withTypeOutlined(): ShortcutFixture {
        this.type = OUTLINED
        return this
    }

    fun withLabel(label: String): ShortcutFixture {
        this.label = label
        return this
    }

    fun withIcon(icon: String): ShortcutFixture {
        this.iconName = icon
        return this
    }

    fun withNotify(notify: Int): ShortcutFixture {
        this.notify = notify
        return this
    }

    fun build(): Shortcut {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.type, type.toString())
            .addAttribute(R.attr.iconName, iconName)
            .addAttribute(R.attr.textLabel, label)
            .addAttribute(R.attr.notify, notify.toString())
            .build()

        return Shortcut(context, attributes)
    }
}
