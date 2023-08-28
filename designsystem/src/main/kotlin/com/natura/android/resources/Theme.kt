package com.natura.android.resources

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.TypedValue
import androidx.core.content.ContextCompat

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

fun getDrawableFromTheme(context: Context, attributeName: Int): Drawable {
    val value = TypedValue()
    context.theme.resolveAttribute(attributeName, value, true)
    val imageResId = value.resourceId
    return ContextCompat.getDrawable(context, imageResId) ?: throw IllegalArgumentException("Cannot load drawable $imageResId")
}

enum class BarColors(val value: Int) {
    DEFAULT(0), NONE(1), PRIMARY(2), SECONDARY(3), INVERSE(4)
}
