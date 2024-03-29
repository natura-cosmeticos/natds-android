package com.natura.android.tag

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric

internal class TagFixture private constructor(
    private var type: Int? = 0,
    private var size: Int? = 0,
    private var position: Int? = 0,
    private var label: String? = null,
    private var icon: Int? = null,
    private var backgroundColor: Int? = 0,
    private var labelColor: Int? = 0,
    private var context: Context = ApplicationProvider.getApplicationContext()
) {

    companion object {
        private const val PRIMARY = 0
        private const val ALERT = 1
        private const val SECONDARY = 2
        private const val SUCCESS = 3
        private const val WARNING = 4
        private const val LINK = 5
        private const val CUSTOM = 6

        private const val SMALL = 0
        private const val STANDARD = 1

        private const val CENTER = 0
        private const val LEFT = 1
        private const val RIGHT = 2

        private const val defaultType = PRIMARY
        private const val defaultSize = SMALL
        private const val defaultPosition = CENTER
        private const val defaultLabel = "tag label"

        private val defaultIcon = null
        private const val defaultBackgroundColor = 1
        private const val defaultLabelColor = 1
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aTag(): TagFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return TagFixture(
                defaultType,
                defaultSize,
                defaultPosition,
                defaultLabel,
                defaultIcon,
                defaultBackgroundColor,
                defaultLabelColor,
                context
            )
        }

        fun aEmptyTag(): TagFixture {
            return TagFixture()
        }
    }

    fun withSizeSmall(): TagFixture {
        this.size = SMALL
        return this
    }

    fun withSizeStandard(): TagFixture {
        this.size = STANDARD
        return this
    }

    fun withPositionCenter(): TagFixture {
        this.position = CENTER
        return this
    }

    fun withPositionLeft(): TagFixture {
        this.position = LEFT
        return this
    }

    fun withPositionRight(): TagFixture {
        this.position = RIGHT
        return this
    }

    fun withTypePrimary(): TagFixture {
        this.type = PRIMARY
        return this
    }

    fun withTypeAlert(): TagFixture {
        this.type = ALERT
        return this
    }

    fun withTypeSecondary(): TagFixture {
        this.type = SECONDARY
        return this
    }

    fun withTypeSuccess(): TagFixture {
        this.type = SUCCESS
        return this
    }

    fun withTypeWarning(): TagFixture {
        this.type = WARNING
        return this
    }

    fun withTypeLink(): TagFixture {
        this.type = LINK
        return this
    }

    fun withTypeCustom(): TagFixture {
        this.type = CUSTOM
        this.backgroundColor = 3
        this.labelColor = 3
        return this
    }

    fun withLabel(label: String): TagFixture {
        this.label = label
        return this
    }

    fun withIcon(icon: Int?): TagFixture {
        this.icon = icon
        return this
    }

    fun withCustomBackgroundColor(color: Int): TagFixture {
        this.backgroundColor = color
        return this
    }

    fun withCustomLabelColor(color: Int): TagFixture {
        this.labelColor = color
        return this
    }

    fun withContext(customContext: Context): TagFixture {
        this.context = customContext
        return this
    }

    fun build(): Tag {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.tag_type, type.toString())
            .addAttribute(R.attr.tag_background_color, backgroundColor.toString())
            .addAttribute(R.attr.textLabel, label)
            .addAttribute(R.attr.tag_size, size.toString())
            .addAttribute(R.attr.tag_icon, icon.toString())
            .addAttribute(R.attr.tag_label_color, labelColor.toString())
            .addAttribute(R.attr.tag_position, position.toString())
            .build()

        return Tag(context, attributes)
    }
}
