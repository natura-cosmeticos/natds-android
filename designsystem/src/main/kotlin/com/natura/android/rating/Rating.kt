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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    @Composable
    override fun Content() {
        Column {
            Row {
                var rating by remember { mutableStateOf(0) }
                for (i in 1..MAX_RATING) {
                    IconButton(onClick = { rating = i }) {
                        if (i <= rating) {
                            Star(isFilled = true)
                        } else {
                            Star(isFilled = false)
                        }
                    }
                }
            }
            Text(
                text = "Placeholder",
                style = natdsTypography.caption,
                color = getThemeColorForCompose(attrColorId = R.attr.colorMediumEmphasis)
            )
        }
    }

    @Composable
    fun Star(isFilled: Boolean) {
        val iconName = if (isFilled) FILLED_STAR_ICON_NAME else OUTLINED_STAR_ICON_NAME
        val attrColorId = if (isFilled) R.attr.colorPrimary else R.attr.colorMediumEmphasis

        Icon(
            imageVector = ImageVector.vectorResource(
                getIconResourceIdFromName(context, iconName)
            ),
            modifier = Modifier.size(getThemeDimenForCompose(R.attr.sizeSemi).dp),
            contentDescription = null,
            tint = getThemeColorForCompose(attrColorId = attrColorId)
        )
    }

    companion object {
        const val MAX_RATING = 5
        const val FILLED_STAR_ICON_NAME = "filled_action_rating"
        const val OUTLINED_STAR_ICON_NAME = "outlined_action_rating"
    }
}
