package com.natura.android.badge

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException

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

class Badge @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var badgeAttributeArray: TypedArray
    private var attrNumber: Int = 0
    private var attrVisibility: Boolean = true

    private val imageContainer by lazy { findViewById<ImageView>(R.id.badgeImage) }
    private lateinit var badgeDrawable: BadgeDrawable

    var number: Int = 0
        /**
         * Specifies the number showed by badge
         * When 0, badge is not visible, when bigger than 99, badge
         * show 99+
         * @return a integer with current number
         * */
        get() = attrNumber
        /**
         * Change the number showed by badge
         * When 0, badge is not visible, when bigger than 99, badge
         * show 99+
         * @param [number] to be showed by badge
         * */
        set(value) {
            field = value
            attrNumber = value
            badgeDrawable.updateBadgeDrawable(value)
        }

    var isVisible: Boolean = true
        /**
         * Specifies badge visibility.
         * @return true if badge is visible, false if is not
         * */
        get() = attrVisibility
        /**
         * Set badge visibility.
         * @param [isVisible] as true to set badge as visible, false to not
         * */
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
        createBadgeDrawable()
        configureVisibility()

        badgeAttributeArray.recycle()
    }

    private fun getAttributes() {
        attrNumber = badgeAttributeArray.getInteger(R.styleable.Badge_badgeNumber, 0)
        attrVisibility = badgeAttributeArray.getBoolean(R.styleable.Badge_badgeVisibility, true)

    }

    private fun createBadgeDrawable() {
        badgeDrawable = BadgeDrawable(context, attrNumber, imageContainer.drawable)
    }

    private fun configureVisibility() {
        this.visibility = if(attrVisibility) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }
}