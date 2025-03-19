package com.natura.android.resources

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.TypedValue
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

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

fun getStringFromTheme(context: Context, attrId: Int): String {
    val value = TypedValue()
    if (context.theme.resolveAttribute(attrId, value, true)) {
        return value.string.toString()
    } else {
        throw IllegalArgumentException("⚠️ ⚠️ GaYaIssue: Attribute not found or not a boolean")
    }
}

fun getDrawableFromTheme(context: Context, attributeName: Int): Drawable {
    val value = TypedValue()
    context.theme.resolveAttribute(attributeName, value, true)
    val imageResId = value.resourceId
    return ContextCompat.getDrawable(context, imageResId) ?: throw IllegalArgumentException("⚠️ ⚠️ GaYaIssue: Cannot load drawable $imageResId")
}

fun getFontFromTheme(context: Context, fontPrimary: Int, fontFallback: Int): Typeface {
    val output = TypedValue()
    if (context.theme.resolveAttribute(fontPrimary, output, true) && output.resourceId != 0)
        return ResourcesCompat.getFont(context, output.resourceId) ?: Typeface.DEFAULT
    if (context.theme.resolveAttribute(fontFallback, output, true) && output.resourceId != 0)
        return ResourcesCompat.getFont(context, output.resourceId) ?: Typeface.DEFAULT
    return Typeface.DEFAULT
}

enum class BarColors(val value: Int) {
    DEFAULT(0), NONE(1), PRIMARY(2), SECONDARY(3), INVERSE(4)
}
