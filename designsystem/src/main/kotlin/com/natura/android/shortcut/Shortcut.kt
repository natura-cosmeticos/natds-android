package com.natura.android.shortcut

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.getIntOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import androidx.core.content.res.getStringOrThrow
import androidx.core.graphics.drawable.DrawableCompat
import com.natura.android.R
import com.natura.android.extensions.setAppearance

class Shortcut @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    themeAttr: Int? = null
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var labelAttribute: String?
    private var typeAttribute = 0
    private var backgroundColorResourceAttribute = 0
    private var iconColorResourceAttribute = 0
    private var labelTextAppearanceResourceAttribute = 0
    private var iconResourceAttribute = 0

    private val labelContainer by lazy { findViewById<TextView>(R.id.shortCutLabel) }
    private val backgroundContainer by lazy { findViewById<LinearLayout>(R.id.shortcutBackground) }
    private val iconContainer by lazy { findViewById<ImageView>(R.id.shortCutIcon) }


    init {
        View.inflate(context, R.layout.short_cut, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.shortCut)
        labelAttribute = typedArray.getStringOrThrow(R.styleable.shortCut_shortcutLabel)
        iconResourceAttribute = typedArray.getResourceIdOrThrow(R.styleable.shortCut_shortcutIcon)
        typeAttribute = typedArray.getIntOrThrow(R.styleable.shortCut_shortcutType)

        themeAttr?.apply {
            context.setTheme(this)
        }

        if(typeAttribute == CONTAINED) {
            context
                .theme
                .obtainStyledAttributes(
                    attrs,
                    R.styleable.shortCut,
                    R.attr.shortcutContained,
                    0
                )
                .apply {
                    backgroundColorResourceAttribute =
                        this.getResourceIdOrThrow(R.styleable.shortCut_shortcutBackgroundColor)
                    iconColorResourceAttribute =
                        this.getResourceIdOrThrow(R.styleable.shortCut_shortcutIconColor)
                    labelTextAppearanceResourceAttribute =
                        this.getResourceIdOrThrow(R.styleable.shortCut_shortcutLabelAppearance)
                }
        } else {
            context
                .theme
                .obtainStyledAttributes(attrs, R.styleable.shortCut, R.attr.shortcutOutlined, 0)
                .apply {
                    backgroundColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.shortCut_shortcutBackgroundColor)
                    iconColorResourceAttribute = this.getResourceIdOrThrow(R.styleable.shortCut_shortcutIconColor)
                    labelTextAppearanceResourceAttribute = this.getResourceIdOrThrow(R.styleable.shortCut_shortcutLabelAppearance)
                }
        }

        configureShortCutByType(typeAttribute)

        typedArray.recycle()
    }

    fun setLabel(text: String?) {
        labelContainer.text = text
        labelContainer.setAppearance(labelTextAppearanceResourceAttribute)
    }

    fun setIcon(icon: Int) {
        val iconDrawable = context.getDrawable(icon)
        iconContainer.setImageResource(icon)
        iconContainer.setColorFilter(ContextCompat.getColor(context, iconColorResourceAttribute), android.graphics.PorterDuff.Mode.SRC_IN)
    }

    private fun configureShortCutByType(type: Int) {
        when (typeAttribute) {
            CONTAINED -> configureContainedShortCut()
            OUTLINED -> configureOutlinedShortCut()
        }
    }

    private fun configureOutlinedShortCut() {
        setLabel(labelAttribute)
        setIcon(iconResourceAttribute)
        setBackgroundOutlined()
    }

    private fun configureContainedShortCut() {
        setLabel(labelAttribute)
        setIcon(iconResourceAttribute)
        setBackgroundContained()
    }

    private fun setBackgroundContained() {
        val background = resources.getDrawable(R.drawable.shortcut_background, null)
        val backgroundWrap = DrawableCompat.wrap(background).mutate()
        DrawableCompat.setTint(backgroundWrap, ContextCompat.getColor(context, backgroundColorResourceAttribute))

        backgroundContainer.background = background
    }

    private fun setBackgroundOutlined() {
        val background = resources.getDrawable(R.drawable.shortcut_background, null) as GradientDrawable
        background.setColor(ContextCompat.getColor(context, backgroundColorResourceAttribute))
        background.setStroke(1, ContextCompat.getColor(context, iconColorResourceAttribute))

        backgroundContainer.background = background
    }

    companion object {
        const val OUTLINED = 0
        const val CONTAINED = 1
    }
}


