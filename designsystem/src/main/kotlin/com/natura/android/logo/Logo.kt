package com.natura.android.logo

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatImageView
import com.natura.android.R
import com.natura.android.resources.getColorTokenFromTheme
import com.natura.android.resources.getDimenFromTheme
import com.natura.android.resources.getDrawableFromTheme

class Logo @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null
) : AppCompatImageView(context) {

    private var typedArray: TypedArray

    enum class Model {
        A, B
    }

    enum class Color(@AttrRes val attribute: Int) {
        NEUTRAL(0),
        PRIMARY(R.attr.colorPrimary),
        SECONDARY(R.attr.colorSecondary),
        HIGHLIGHT(R.attr.colorHighlight),
        SURFACE(R.attr.colorSurface)
    }

    enum class Size(@AttrRes val attribute: Int) {
        MEDIUM(R.attr.sizeMedium),
        MEDIUMX(R.attr.sizeMediumX),
        LARGE(R.attr.sizeLarge),
        LARGEX(R.attr.sizeLargeX),
        LARGEXX(R.attr.sizeLargeXX),
        LARGEXXX(R.attr.sizeLargeXXX),
        HUGE(R.attr.sizeHuge),
        HUGEX(R.attr.sizeHugeX),
        HUGEXX(R.attr.sizeHugeXX),
        HUGEXXX(R.attr.sizeHugeXXX),
        VERYHUGE(R.attr.sizeVeryHuge)
    }

    var model: Model = Model.A
        set(value) {
            field = value
        }

    var color: Color = Color.NEUTRAL
        set(value) {
            field = value
        }

    var size: Size = Size.VERYHUGE
        set(value) {
            field = value
        }

    init {
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.Logo)

        getAttributes()
        setDrawableResource()

        if (color != Color.NEUTRAL) {
            setColor()
        }

        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val drawable = drawable

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)

        val width = getDimenFromTheme(context, size.attribute).toInt()
        val drawableWidth = drawable.intrinsicWidth
        val drawableHeight = drawable.intrinsicHeight
        val aspectRadio = drawableHeight.toFloat() / drawableWidth
        var height = (width * aspectRadio).toInt()

        if (height > width) {
            height = width
        }
        setMeasuredDimension(width, height)
    }

    private fun getAttributes() {
        color = intToColor(typedArray.getInt(R.styleable.Logo_customColor, 0))
        size = intToSize(typedArray.getInt(R.styleable.Logo_customSize, 0))
        model = intToModel(typedArray.getInt(R.styleable.Logo_model, 0))
    }

    private fun setDrawableResource() {

        val drawableAttr = if (color == Color.NEUTRAL) {
            when (model) {
                Model.A -> R.attr.assetBrandNeutralA
                else -> R.attr.assetBrandNeutralB
            }
        } else {
            when (model) {
                Model.A -> R.attr.assetBrandCustomA
                else -> R.attr.assetBrandCustomB
            }
        }

        this.setImageDrawable(getDrawableFromTheme(context, drawableAttr))
    }

    private fun setColor() {
        this.setColorFilter(getColorTokenFromTheme(context, color.attribute))
    }

    private fun intToColor(color: Int) = when (color) {
        0 -> Color.NEUTRAL
        1 -> Color.PRIMARY
        2 -> Color.SECONDARY
        3 -> Color.HIGHLIGHT
        else -> Color.SURFACE
    }

    private fun intToModel(model: Int) = when (model) {
        0 -> Model.A
        else -> Model.B
    }

    private fun intToSize(size: Int) = when (size) {
        0 -> Size.MEDIUM
        1 -> Size.MEDIUMX
        2 -> Size.LARGE
        3 -> Size.LARGEX
        4 -> Size.LARGEXX
        5 -> Size.LARGEXXX
        6 -> Size.HUGE
        7 -> Size.HUGEX
        8 -> Size.HUGEXX
        9 -> Size.HUGEXXX
        else -> Size.VERYHUGE
    }
}
