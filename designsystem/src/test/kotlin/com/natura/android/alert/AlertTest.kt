package com.natura.android.alert

import android.content.Context
import android.widget.TextView
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.natura.android.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AlertTest {
    private lateinit var alert: Alert
    private lateinit var context: Context
    private val title = "Alert Title"

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checkIfTitleEnabledIsTrue() {
        alert = buildAlertWithTitleEnabled()

        val isTitleVisible = alert.getIsTitleVisible()

        assertThat(isTitleVisible).isTrue()
    }

    @Test
    fun checkIfTitleTextIsSet() {
        alert = buildAlertWithTitleText()

        val alertTitle = alert.findViewById<TextView>(R.id.alert_title)

        assertThat(alertTitle.text).isEqualTo(title)
    }

    @Test
    fun checkIfTitleEnabledIsFalse() {
        alert = buildAlertWithTitleDisabled()

        val isTitleVisible = alert.getIsTitleVisible()

        assertThat(isTitleVisible).isFalse()
    }

    @Test
    fun checkIfIconEnabledIsTrue() {
        alert = buildAlertWithIconEnabled()

        val isIconVisible = alert.getIsIconVisible()

        assertThat(isIconVisible).isTrue()
    }

    @Test
    fun checkIfIconEnabledIsFalse() {
        alert = buildAlertWithIconDisabled()

        val isIconVisible = alert.getIsIconVisible()

        assertThat(isIconVisible).isFalse()
    }

    @Test
    fun checkIfBorderIsContained() {
        alert = buildAlertContained()

        val alertType = alert.getAlertType()

        assertThat(alertType).isEqualTo(0)
    }

    @Test
    fun checkIfBorderIsOutlined() {
        alert = buildAlertOutlined()

        val alertType = alert.getAlertType()

        assertThat(alertType).isEqualTo(1)
    }

    private fun buildAlertWithTitleEnabled(): Alert {
        return AlertFixture
            .aCard()
            .withEnabledTitle(true)
            .build()
    }

    private fun buildAlertWithTitleText(): Alert {
        return AlertFixture
            .aCard()
            .withTitleText(title)
            .build()
    }

    private fun buildAlertWithTitleDisabled(): Alert {
        return AlertFixture
            .aCard()
            .withEnabledTitle(false)
            .build()
    }

    private fun buildAlertWithIconEnabled(): Alert {
        return AlertFixture
            .aCard()
            .withEnabledIcon(true)
            .build()
    }

    private fun buildAlertWithIconDisabled(): Alert {
        return AlertFixture
            .aCard()
            .withEnabledIcon(false)
            .build()
    }

    private fun buildAlertContained(): Alert {
        return AlertFixture
            .aCard()
            .withBorder(0)
            .build()
    }

    private fun buildAlertOutlined(): Alert {
        return AlertFixture
            .aCard()
            .withBorder(1)
            .build()
    }
}