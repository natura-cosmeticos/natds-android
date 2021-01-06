package com.natura.android.badge

import android.content.Context
import androidx.test.core.app.ApplicationProvider

class BadgeTest {

    private lateinit var badge: Badge
    private lateinit var context: Context

    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }
}
