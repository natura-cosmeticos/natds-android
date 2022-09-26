package com.natura.android.alert

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import com.natura.android.card.CardFixture
import org.robolectric.Robolectric

internal class AlertFixture private constructor(
    private var showTitle: Boolean = true,
    private var titleText: String = "",
    private var showIcon: Boolean = true,
    private var iconName: String = "",
    private var type: Int = 0,
    private var color: Int = 2,
    private var context: Context = ApplicationProvider.getApplicationContext()
){

    companion object {
        private const val defaultShowTitle = true
        private const val defaultTitle = "TITLE"
        private const val defaultShowIcon = true
        private const val defaultIconName = ""
        private const val defaultType = 0
        private const val defaultColor = 2
        private var context = ApplicationProvider.getApplicationContext<Context>()

        fun aCard(): AlertFixture {
            context.setTheme(R.style.Theme_Natura_Light)
            return AlertFixture(
                defaultShowTitle,
                defaultTitle,
                defaultShowIcon,
                defaultIconName,
                defaultType,
                defaultColor,
                context)
        }
    }

    fun withEnabledTitle(enabledTitle: Boolean): AlertFixture {
        this.showTitle = enabledTitle
        return this
    }

    fun withTitleText(title: String): AlertFixture {
        this.titleText = title
        return this
    }

    fun withEnabledIcon(enabledIcon: Boolean): AlertFixture {
        this.showIcon = enabledIcon
        return this
    }

    fun withBorder(enabledBorder: Int): AlertFixture {
        this.type = enabledBorder
        return this
    }

    fun build(): Alert {
        val attributes = Robolectric
            .buildAttributeSet()
            .addAttribute(R.attr.show_title, showTitle.toString())
            .addAttribute(R.attr.title_text, titleText)
            .addAttribute(R.attr.show_icon, showIcon.toString())
            .addAttribute(R.attr.iconName, iconName)
            .addAttribute(R.attr.alert_type, type.toString())
            .addAttribute(R.attr.alert_color, color.toString())
            .build()

        return Alert(context, attributes)
    }
}