package com.natura.android.iconButton

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class IconButtonFixture private constructor(
    private var buttonColor: Int? = null,
    private var enabled: Boolean? = true,
    private var iconPath: String? = null,
    private var notify: Int = 0,
    private var buttonSize: Int = 0,
    private var buttonStyle: Int = 0,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {
    companion object {
        private const val DEFAULT = 0
        private const val PRIMARY = 1
        private const val LIGHT = 2

        private const val SEMI = 0
        private const val SEMIX = 1
        private const val MEDIUM = 2

        private const val INHERIT = 0
        private const val FLOATING = 1
        private const val OVERLAY = 2

        private const val buttonColor = DEFAULT
        private const val buttonSize = SEMI
        private const val buttonStyle = INHERIT

        private const val enabled = true
        private const val icon = "outlined_default_mockup"
        private const val notify = 0
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aIconButton(): IconButtonFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return IconButtonFixture(buttonColor, enabled, icon, notify, buttonSize, buttonStyle, context)
        }

        fun aEmptyIconButton(): IconButtonFixture {
            return IconButtonFixture()
        }
    }

    fun withColorDefault(): IconButtonFixture {
        this.buttonColor = DEFAULT
        return this
    }

    fun withColorPrimary(): IconButtonFixture {
        this.buttonColor = PRIMARY
        return this
    }

    fun withColorLight(): IconButtonFixture {
        this.buttonColor = LIGHT
        return this
    }

    fun withDisabled(): IconButtonFixture {
        this.enabled = false
        return this
    }

    fun withIcon(icon: String): IconButtonFixture {
        this.iconPath = icon
        return this
    }

    fun withNotification(value: Int): IconButtonFixture {
        this.notify = value
        return this
    }

    fun withSizeSemi(): IconButtonFixture {
        this.buttonSize = SEMI
        return this
    }

    fun withSizeSemiX(): IconButtonFixture {
        this.buttonSize = SEMIX
        return this
    }

    fun withSizeMedium(): IconButtonFixture {
        this.buttonSize = MEDIUM
        return this
    }

    fun withStyleInherit(): IconButtonFixture {
        this.buttonStyle = INHERIT
        return this
    }

    fun withStyleFloating(): IconButtonFixture {
        this.buttonStyle = FLOATING
        return this
    }

    fun withStyleOverlay(): IconButtonFixture {
        this.buttonStyle = OVERLAY
        return this
    }

    fun build(): IconButton {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.buttonColor, buttonColor?.toString() ?: 0.toString())
            .addAttribute(R.attr.sizeButton, buttonSize.toString())
            .addAttribute(R.attr.styleButton, buttonStyle.toString())
            .addAttribute(R.attr.iconName, iconPath)
            .addAttribute(R.attr.notify, notify.toString())
            .addAttribute(android.R.attr.enabled, enabled.toString())
            .build()

        return IconButton(context, attributes)
    }
}
