package com.natura.android.card

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.core.content.res.getResourceIdOrThrow
import com.google.android.material.card.MaterialCardView
import com.natura.android.R

class Card @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private var elevationAttribute: Boolean = false
    private var radiusAttribute: Boolean = false
    private var cardAttributesArray: TypedArray
    private var backgroundColorResourceAttribute = 0
    private var radiusResourceAttribute = 0
    private var paddingResourceAttribute = 0
    private var elevationResourceAttribute = 0

    init {

        cardAttributesArray = context.obtainStyledAttributes(attrs, R.styleable.Card)

        getCardAttributes()
        configureLayout()
    }

    fun getEnabledRadius(): Boolean = radiusAttribute

    fun getEnabledElevation(): Boolean = elevationAttribute

    private fun getCardAttributes() {
        radiusAttribute = cardAttributesArray.getBoolean(R.styleable.Card_enabledRadius, true)
        elevationAttribute = cardAttributesArray.getBoolean(R.styleable.Card_enabledElevation, true)

        cardAttributesArray.recycle()
    }

    private fun configureLayout() {
        context
            .theme
            .obtainStyledAttributes(attrs, R.styleable.Card, R.attr.card, 0)
            .apply {
                backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.Card_colorBackground)
                elevationResourceAttribute = this.getResourceIdOrThrow(R.styleable.Card_customElevation)
                paddingResourceAttribute = this.getResourceIdOrThrow(R.styleable.Card_customPadding)
                radiusResourceAttribute = this.getResourceIdOrThrow(R.styleable.Card_customRadius)
            }

        this.setCardBackgroundColor(ContextCompat.getColor(context, backgroundColorResourceAttribute))

        this.setContentPadding(
            resources.getDimensionPixelOffset(paddingResourceAttribute),
            resources.getDimensionPixelOffset(paddingResourceAttribute),
            resources.getDimensionPixelOffset(paddingResourceAttribute),
            resources.getDimensionPixelOffset(paddingResourceAttribute))

        if (!radiusAttribute) {
            this.radius = 0F
            return
        }

        if (!elevationAttribute) {
            this.elevation = 0F
            return
        }

        this.radius = resources.getDimension(radiusResourceAttribute)
        this.elevation = resources.getDimension(elevationResourceAttribute)
    }
}
