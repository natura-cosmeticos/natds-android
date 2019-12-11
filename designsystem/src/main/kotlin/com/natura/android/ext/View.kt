package com.natura.android.ext

import android.view.View

fun View.setVisibilityFromBoolean(isVisible: Boolean, invisibleValue: Int = View.GONE) {
    visibility = if (isVisible) View.VISIBLE else invisibleValue
}
