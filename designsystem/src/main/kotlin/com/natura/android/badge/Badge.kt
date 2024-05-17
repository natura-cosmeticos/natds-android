package com.natura.android.badge

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException
import com.natura.android.resources.getColorTokenFromTheme

/**
 * The Badge is a screen element used to signal the user’s points of attention.
 * Represents dynamic information such as number of notifications unread with
 * some styles matching Nat DS appearance.
 * This component can be used to create another component that supports a badge.
 * Badge supports only numbers and it is possible to configure its visibility if the number shown is bigger than 0.
 * If number is 0 the badge will not be visible.
 * A Badge component is a [ViewGroup](https://developer.android.com/reference/android/view/ViewGroup)
 * that renders a [BadgeDrawable].
 * Badge is available like a GroupView at version 4.2.0 of NatDS Android.
 *
 * ```
 * <com.natura.android.badge.Badge
 *      android:id="@+id/badge"
 *      android:layout_width="wrap_content"
 *      android:layout_height="wrap_content"
 *      app:badgeNumber="12" />
 *```
 */

private const val TIME_LOOP_PULSE = 400L

class Badge @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var badgeAttributeArray: TypedArray
    private var attrNumber: Int = 0
    private var attrVisibility: Boolean = true
    private var isFontWeight: Boolean = false
    private var limit: Int = UNLIMITED
    private var variant: Int = STANDARD
    private var attrColor: BadgeColor = BadgeColor.colorPrimary

    private val imageContainer by lazy { findViewById<ImageView>(R.id.badgeImage) }
    private val badgeRipple by lazy { findViewById<ImageView>(R.id.badgeRipple) }
    private val badgeDot by lazy { findViewById<ImageView>(R.id.badgeDot) }
    private lateinit var badgeDrawable: BadgeDrawable

    var number: Int = 0
        get() = attrNumber
        set(value) {
            field = value
            if (variant == STANDARD) {
                attrNumber = value
                badgeDrawable.updateBadgeDrawable(value)
            }
        }

    var color: BadgeColor = BadgeColor.colorPrimary
        get() = attrColor
        set(value) {
            field = value
            if (variant == STANDARD || variant == DOT) {
                attrColor = value
                badgeDrawable.updateColorBadgeDrawable(value)
            }
        }

    var isVisible: Boolean = true
        get() = attrVisibility
        set(value) {
            attrVisibility = value
            field = value
            configureVisibility()
        }

    init {
        try {
            View.inflate(context, R.layout.badge, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        badgeAttributeArray = context.obtainStyledAttributes(attrs, R.styleable.Badge)

        getAttributes()
        handlerVariant()
        configureVisibility()

        badgeAttributeArray.recycle()
    }

    private fun updateDrawable() {
        if (::badgeDrawable.isInitialized) {
            badgeDrawable.updateBadgeDrawable(number)
            badgeDrawable.updateColorBadgeDrawable(color)
            imageContainer.setImageDrawable(badgeDrawable)
        }
    }

    private fun getAttributes() {
        attrNumber = badgeAttributeArray.getInteger(R.styleable.Badge_badgeNumber, 0)
        attrVisibility = badgeAttributeArray.getBoolean(R.styleable.Badge_badgeVisibility, true)
        variant = badgeAttributeArray.getInt(R.styleable.Badge_badgeVariant, STANDARD)
        attrColor = BadgeColor.fromInt(badgeAttributeArray.getInt(R.styleable.Badge_badgeColor, BadgeColor.colorPrimary.value))
        limit = badgeAttributeArray.getInt(R.styleable.Badge_badgeLimitNumber, UNLIMITED)
        isFontWeight = badgeAttributeArray.getBoolean(R.styleable.Badge_isFontWeight, false)
    }

    private fun createBadgeDrawable() {
        imageContainer.visibility = View.VISIBLE
        updateDrawable()
        badgeDrawable = BadgeDrawable(context, attrNumber, imageContainer.drawable, variant, attrColor, limit, isFontWeight)
    }

    private fun handlerVariant() {
        if (variant == PULSE) {
            createBadgePulse()
        } else {
            createBadgeDrawable()
        }
    }

    private fun createBadgePulse() {
        badgeRipple.visibility = View.VISIBLE
        badgeDot.visibility = View.VISIBLE

        badgeDot.drawable.setTint(getColorTokenFromTheme(context, getPulseColorByAttr()))
        badgeRipple.drawable.setTint(getColorTokenFromTheme(context, getPulseColorByAttr()))

        initializeAnimators()
    }

    private fun configureVisibility() {
        this.visibility = if (attrVisibility) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }

    private fun initializeAnimators() {
        val pulseAnimation: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            badgeRipple,
            PropertyValuesHolder.ofFloat("scaleX", 0.5f),
            PropertyValuesHolder.ofFloat("scaleY", 0.5f),
            PropertyValuesHolder.ofFloat("alpha", 0.48f, 0.24f, 0.12f)
        )
        pulseAnimation.duration = TIME_LOOP_PULSE

        pulseAnimation.repeatCount = ObjectAnimator.INFINITE
        pulseAnimation.repeatMode = ObjectAnimator.REVERSE
        pulseAnimation.start()
    }

    private fun getPulseColorByAttr(): Int {
        return when (color) {
            BadgeColor.colorPrimary -> R.attr.badgeColorPrimaryBackground
            BadgeColor.colorSecondary -> R.attr.badgeColorSecondaryBackground
            BadgeColor.colorSuccess -> R.attr.badgeColorSuccessBackground
            BadgeColor.colorAlert -> R.attr.badgeColorAlertBackground
        }
    }

    fun getFontWeightOption(): Boolean {
        return isFontWeight
    }

    companion object {
        const val STANDARD = 0
        const val DOT = 1
        const val PULSE = 2

        const val ALERT = 0
        const val PRIMARY = 1
        const val SECONDARY = 2
        const val SUCCESS = 3

        const val NINE = 0
        const val NINETY_NINE = 1
        const val UNLIMITED = 2
    }
}

enum class BadgeColor(val value: Int) {
    colorAlert(0),
    colorPrimary(1),
    colorSecondary(2),
    colorSuccess(3);

    companion object {
        fun fromInt(value: Int) = values().firstOrNull { it.value == value } ?: colorPrimary
    }
}