package com.natura.android.alert

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import com.natura.android.R
import com.natura.android.iconButton.IconButton

open class Alert @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    companion object {
        const val CONTAINED = 0

        const val SUCCESS = 0
        const val ERROR = 1
        const val WARNING = 2
        const val INFO = 3
        const val CUSTOM = 4
    }

    private var typedArray: TypedArray
    private val alertTitle by lazy { findViewById<TextView>(R.id.alert_title) }
    private val alertIcon by lazy { findViewById<IconButton>(R.id.alert_icon) }

    private var isTitleVisible: Boolean = true
        set(value) {
            field = value
            changeVisibility(alertTitle, value)
        }

    private var title: String = ""
        set(value) {
            field = value
            alertTitle.text = value
        }

    private var isIconVisible: Boolean = true
        set(value) {
            field = value
            changeVisibility(alertIcon, value)
        }

    private var iconName: String = ""
        set(value) {
            field = value
            alertIcon.setIcon(iconName)
        }

    private var type: Int = CONTAINED
    private var alertColor: Int = INFO
    private var customBackgroundColor: Int? = null
    private var customStrokeColor: Int? = null
    private var customTextColor: Int? = null

    fun getIsTitleVisible(): Boolean = isTitleVisible
    fun getIsIconVisible(): Boolean = isIconVisible
    fun getAlertType(): Int = type

    init {
        this.let {
            View.inflate(context, R.layout.alert, it)
        }
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.Alert)
        getAlertAttributes()
        setAlertBorder()
        configureAlertColor()
        adjustTitleMarginWhenIconIsGone()
        typedArray.recycle()
    }

    @SuppressLint("ResourceAsColor")
    private fun getAlertAttributes() {
        typedArray.apply {
            isTitleVisible = getBoolean(R.styleable.Alert_show_title, true)
            title = getString(R.styleable.Alert_title_text) ?: ""
            isIconVisible = getBoolean(R.styleable.Alert_show_icon, true)
            iconName = getString(R.styleable.Alert_iconName) ?: ""
            type = getInt(R.styleable.Alert_alert_type, CONTAINED)
            customBackgroundColor = getColor(R.styleable.Alert_alert_custom_background_color, R.color.warning)
            customStrokeColor = getColor(R.styleable.Alert_alert_custom_stroke_color, R.color.warning)
            alertColor = getInt(R.styleable.Alert_alert_color, INFO)
        }
    }

    private fun changeVisibility(view: View, isVisible: Boolean) {
        if (isVisible) view.visibility = VISIBLE else view.visibility = GONE
    }

    private fun setAlertBorder() {
        this.cardElevation = 0F
        type.let {
            if (it == CONTAINED)
                this.strokeWidth = 0
            else {
                this.strokeWidth = 1
            }
        }
    }

    private fun adjustTitleMarginWhenIconIsGone() {
        if (!isIconVisible && isTitleVisible) {
            val params = LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            )
            params.setMargins(24, 0, 0, 0)
            alertTitle.layoutParams = params
        }
    }

    private fun parseStringColorToInt(color: String): Int {
        return Color.parseColor(color)
    }

    private fun configureAlertColor() {
        when (alertColor) {
            SUCCESS -> {
                this.strokeColor = parseStringColorToInt("#37B24D")
                this.setCardBackgroundColor(parseStringColorToInt("#D3F9D8"))
            }

            ERROR -> {
                this.strokeColor = parseStringColorToInt("#F03E3E")
                this.setCardBackgroundColor(parseStringColorToInt("#FFE3E3"))
            }

            WARNING -> {
                this.strokeColor = parseStringColorToInt("#F59F00")
                this.setCardBackgroundColor(parseStringColorToInt("#FFF3BF"))
            }

            INFO -> {
                this.strokeColor = parseStringColorToInt("#1C7ED6")
                this.setCardBackgroundColor(parseStringColorToInt("#D0EBFF"))
            }

            CUSTOM -> {
                customStrokeColor?.let {
                    this.strokeColor = it
                }

                customBackgroundColor?.let {
                    this.setCardBackgroundColor(customBackgroundColor!!)
                }
            }
        }
    }
}
