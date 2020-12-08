package com.natura.android.iconButton

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class IconButtonFixture private constructor(
    private var buttonColor: Int? = null,
    private var size: Int? = null,
    private var enabled: Boolean? = true,
    private var iconPath: String? = null,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {

    companion object {
        private const val DEFAULT = 0
        private const val PRIMARY = 1
        private const val SMALL = 0
        private const val MEDIUM = 1

        private const val buttonColor = DEFAULT
        private const val size = SMALL
        private const val enabled = true
        private const val icon = "outlined_default_mockup"
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aIconButton(): IconButtonFixture {
            context.setTheme(R.style.Theme_Natura)
            return IconButtonFixture(buttonColor, size, enabled, icon, context)
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

    fun withSizeSmall(): IconButtonFixture {
        this.size = SMALL
        return this
    }

    fun withSizeMedium(): IconButtonFixture {
        this.size = MEDIUM
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

    fun withContext(customContext: Context): IconButtonFixture {
        this.context = customContext
        return this
    }

    fun build(): IconButton {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.buttonColor, buttonColor?.toString() ?: 0.toString())
            .addAttribute(R.attr.iconName, iconPath)
            .addAttribute(R.attr.size, size?.toString() ?: 0.toString())
            .addAttribute(android.R.attr.enabled, enabled.toString())
            .build()

        return IconButton(context, attributes)
    }
}
