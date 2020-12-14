package com.natura.android.badge

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException

class Badge @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var badgeAttributeArray: TypedArray
    private var tNumber: Int = 0
    private var tVisibility: Int = View.INVISIBLE

    private val lContainer by lazy { findViewById<ConstraintLayout>(R.id.badgeContainer) }
    private val lImage by lazy { findViewById<ImageView>(R.id.badgeImage) }

    var number: Int = 0
        get() = tNumber
        set(value) {
            field = value
            tNumber = value
        }
    var isVisible: Boolean = true
        get() = tVisibility == 0
        set(value) {
            tVisibility = if(value) {
                View.VISIBLE
            } else {
                View.INVISIBLE
            }
            field = value
        }

    init {
        try {
            View.inflate(context, R.layout.badge, this)
        } catch (e: Exception) {
            throw (MissingThemeException())
        }

        badgeAttributeArray = context.obtainStyledAttributes(attrs, R.styleable.Badge)

        getAttributes()
        configureBadge()

        badgeAttributeArray.recycle()
    }

    private fun getAttributes() {
        tNumber = badgeAttributeArray.getInteger(R.styleable.Badge_badgeNumber, 0)
        tVisibility = badgeAttributeArray.getInteger(R.styleable.Badge_badgeVisibility, View.INVISIBLE)

    }

    private fun configureBadge() {
        BadgeDrawable(context, tNumber, lImage.drawable)
        lContainer.visibility = tVisibility
    }
}