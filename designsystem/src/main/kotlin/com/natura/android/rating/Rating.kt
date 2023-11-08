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

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Rating,
            0, 0
        ).apply {
            try {
                rate = getInt(R.styleable.Rating_rate, 0)
                variant = Variant.values()[getInt(R.styleable.Rating_variant, 0)]
                hint = getString(R.styleable.Rating_hint) ?: String()
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
                    IconButton(onClick = { rate = i }) {
                        if (i <= rate) {
                            Star(isFilled = true, isEnabled = true)
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
        Column {
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
    }

    @Composable
    fun CounterRating() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Star(isFilled = true, isEnabled = true)
            if (hint.isNotEmpty()) Hint(hint = hint)
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
            modifier = Modifier.size(getThemeDimenForCompose(R.attr.sizeSemi).dp),
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

    enum class Variant {
        INPUT,
        READ_ONLY,
        COUNTER
    }

    companion object {
        const val MAX_RATE = 5
        const val FILLED_STAR_ICON_NAME = "filled_action_rating"
        const val OUTLINED_STAR_ICON_NAME = "outlined_action_rating"
    }
}
