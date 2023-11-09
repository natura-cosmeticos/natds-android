package com.natura.android.rating

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.natura.android.R
import com.natura.android.resources.getIconResourceIdFromName
import com.natura.android.resources.getThemeColorForCompose
import com.natura.android.resources.getThemeDimenForCompose
import com.natura.android.resources.natdsTypography

class Rating @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {

    var rate by mutableStateOf(0)
        private set
    var variant by mutableStateOf(Variant.INPUT)
        private set
    var hint by mutableStateOf(String())
        private set
    var size by mutableStateOf(Size.SMALL)
        private set
    var align by mutableStateOf(Align.LEFT)
        private set

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Rating,
            0, 0
        ).apply {
            try {
                rate = getInt(R.styleable.Rating_rate, 0)
                variant = Variant.fromIndex(getInt(R.styleable.Rating_variant, 0))
                hint = getString(R.styleable.Rating_hint) ?: String()
                size = variant.isValidSizeOrDefault(
                    Size.fromIndex(getInt(R.styleable.Rating_size, 0))
                )
                align = Align.fromIndex(getInt(R.styleable.Rating_align, 0))
                isEnabled = getBoolean(R.styleable.Rating_android_enabled, true)
            } finally {
                recycle()
            }
        }
    }

    @Composable
    override fun Content() {
        when (variant) {
            Variant.INPUT -> InputRating()
            Variant.READ_ONLY -> ReadOnlyRating()
            Variant.COUNTER -> CounterRating()
        }
    }

    @Composable
    fun InputRating() {
        Column {
            Row {
                for (i in 1..MAX_RATE) {
                    IconButton(onClick = { rate = i }, enabled = isEnabled) {
                        if (i <= rate) {
                            Star(isFilled = true, isEnabled = isEnabled)
                        } else {
                            Star(isFilled = false, isEnabled = false)
                        }
                    }
                }
            }
            if (hint.isNotEmpty()) Hint(hint = hint)
        }
    }

    @Composable
    fun ReadOnlyRating() {
        Row {
            for (i in 1..MAX_RATE) {
                if (i <= rate) {
                    Star(isFilled = true, isEnabled = true)
                } else {
                    Star(isFilled = true, isEnabled = false)
                }
            }
        }
    }

    @Composable
    fun CounterRating() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (align == Align.LEFT) {
                Star(isFilled = true, isEnabled = true)
                Hint(hint = hint)
            } else {
                Hint(hint = hint)
                Star(isFilled = true, isEnabled = true)
            }
        }
    }

    @Composable
    fun Star(isFilled: Boolean, isEnabled: Boolean) {
        val iconName = if (isFilled) FILLED_STAR_ICON_NAME else OUTLINED_STAR_ICON_NAME
        val attrColorId = if (isEnabled) R.attr.colorPrimary else R.attr.colorMediumEmphasis

        Icon(
            imageVector = ImageVector.vectorResource(
                getIconResourceIdFromName(context, iconName)
            ),
            modifier = Modifier.size(getThemeDimenForCompose(size.attrResId).dp),
            contentDescription = null,
            tint = getThemeColorForCompose(attrColorId = attrColorId)
        )
    }

    @Composable
    fun Hint(hint: String) {
        Text(
            text = hint,
            style = natdsTypography.caption,
            color = getThemeColorForCompose(attrColorId = R.attr.colorMediumEmphasis)
        )
    }


    enum class Variant(private val variantSizes: List<Size>) {
        INPUT(listOf(Size.SEMI, Size.SEMI_X, Size.MEDIUM)),
        READ_ONLY(listOf(Size.SMALL, Size.STANDARD, Size.SEMI, Size.SEMI_X)),
        COUNTER(listOf(Size.SMALL, Size.STANDARD, Size.SEMI, Size.SEMI_X));

        fun isValidSizeOrDefault(size: Size): Size {
            return if (variantSizes.contains(size)) {
                size
            } else {
                variantSizes.first()
            }
        }

        companion object {
            fun fromIndex(variantIndex: Int) = values()[variantIndex]
        }
    }

    enum class Size(val attrResId: Int) {
        SMALL(R.attr.sizeSmall),
        STANDARD(R.attr.sizeStandard),
        SEMI(R.attr.sizeSemi),
        SEMI_X(R.attr.sizeSemiX),
        MEDIUM(R.attr.sizeMedium);

        companion object {
            fun fromIndex(sizeIndex: Int) = values()[sizeIndex]
        }
    }

    enum class Align {
        LEFT,
        RIGHT;

        companion object {
            fun fromIndex(alignIndex: Int) = values()[alignIndex]
        }
    }

    companion object {
        const val MAX_RATE = 5
        const val FILLED_STAR_ICON_NAME = "filled_action_rating"
        const val OUTLINED_STAR_ICON_NAME = "outlined_action_rating"
    }
}
