package com.natura.android.resources

import android.content.Context
import android.util.TypedValue

fun getColorTokenFromTheme(context: Context, attrColorId: Int): Int {
    val value = TypedValue()
    context.theme.resolveAttribute(attrColorId, value, true)
    return value.data
}

fun getDimenFromTheme(context: Context, attributeName: Int): Float {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(attributeName, typedValue, true)
    return typedValue.getDimension(context.resources.displayMetrics)
}