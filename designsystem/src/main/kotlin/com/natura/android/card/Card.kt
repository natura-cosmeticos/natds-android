package com.natura.android.card

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.core.content.res.getResourceIdOrThrow
import com.google.android.material.card.MaterialCardView
import com.natura.android.R

/**
 * The card is a container with rounded corners and shadow based on its elevation, which is based on the CardView component.
 * It involves a layout and can be used to group static content, or it can also be used for each item in a ListView or RecyclerView.
 * The visibility of the radius and elevation attributes are configurable,
 * so that when enabledRadius or enabledElevation are false values, the Card will not have these characteristics.
 * Card is available at version 5.4.0 of NatDS Android.
 *
 * ```
 * <com.natura.android.card.Card
        android:id="@+id/card"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:enabledRadius="true"
        app:enabledElevation="true">

</com.natura.android.card.Card>
 *```
 */

class Card @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private var cardAttributesArray: TypedArray
    private var elevationAttribute: Boolean = false
    private var radiusAttribute: Boolean = false
    private var backgroundColorResourceAttribute: Int = 0
    private var radiusResourceAttribute: Int = 0
    private var paddingResourceAttribute: Int = 0
    private var elevationResourceAttribute: Int = 0

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
        } else {
            this.radius = resources.getDimension(radiusResourceAttribute)
        }

        if (!elevationAttribute) {
            this.elevation = 0F
        } else {
            this.elevation = resources.getDimension(elevationResourceAttribute)
        }
    }
}
