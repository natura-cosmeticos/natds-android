package com.natura.android.badge

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.getIntOrThrow
import com.natura.android.R
import com.natura.android.exceptions.MissingThemeException

class Badge @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var badgeAttributeArray: TypedArray
    private var tNumber: Int = 0
    private var tShow: Int = View.INVISIBLE

    val lContainer by lazy { findViewById<ConstraintLayout>(R.id.badgeContainer) }
    val lImage by lazy { findViewById<ImageView>(R.id.badgeImage) }

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
        tNumber = badgeAttributeArray.getInteger(R.styleable.Badge_number, 0)
        tShow = badgeAttributeArray.getInteger(R.styleable.Badge_android_visibility, View.INVISIBLE)

    }

    private fun configureBadge() {
        BadgeDrawable(context, tNumber, lImage.drawable)
        lContainer.visibility = View.VISIBLE
    }
}