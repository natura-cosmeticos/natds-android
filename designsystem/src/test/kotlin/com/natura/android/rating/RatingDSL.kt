package com.natura.android.rating

import android.content.Context
import android.util.AttributeSet
import androidx.test.core.app.ApplicationProvider
import com.natura.android.R
import org.robolectric.Robolectric
import org.robolectric.android.AttributeSetBuilder

object RatingDSL {

    fun rating(attrs: AttributeSet): Rating {
        val context: Context = ApplicationProvider.getApplicationContext()
        context.setTheme(R.style.Theme_Natura_Light)
        return Rating(context, attrs)
    }

    fun ratingAttributes(block: AttributeSetBuilder.() -> Unit): AttributeSet =
        Robolectric.buildAttributeSet().apply(block).build()

    fun AttributeSetBuilder.variant(variant: Rating.Variant) =
        addAttribute(R.attr.variant, variant.toString().lowercase())

    fun AttributeSetBuilder.rate(rate: Int) =
        addAttribute(R.attr.rate, rate.toString())

    fun AttributeSetBuilder.hint(hint: String) =
        addAttribute(R.attr.hint, hint)

    fun AttributeSetBuilder.size(size: Rating.Size) =
        addAttribute(R.attr.size, size.toString().lowercase())

    fun AttributeSetBuilder.align(align: Rating.Align) =
        addAttribute(R.attr.align, align.toString().lowercase())

    fun AttributeSetBuilder.isEnabled(isEnabled: Boolean) =
        addAttribute(android.R.attr.enabled, isEnabled.toString())

}

