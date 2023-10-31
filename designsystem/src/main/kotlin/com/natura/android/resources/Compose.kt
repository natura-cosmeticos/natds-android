package com.natura.android.resources

import android.util.TypedValue
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.natura.android.R

val natdsTypography: Typography
    @Composable
    get() = Typography(
        caption = TextStyle(
            fontFamily = robotoFamily,
            color = getThemeColorForCompose(R.attr.colorHighEmphasis),
            fontSize = getThemeDimenForCompose(R.attr.captionFontSize).sp,
            fontWeight = FontWeight.Normal,
            lineHeight = getThemeDimenForCompose(R.attr.captionLineHeight).sp,
            letterSpacing = getThemeDimenForCompose(R.attr.captionLetterSpacing).sp
        )
    )

val robotoFamily = FontFamily(
    Font(R.font.roboto_regular, weight = FontWeight.Normal),
    Font(R.font.roboto_medium, weight = FontWeight.Medium)
)

@Composable
fun getThemeColorForCompose(attrColorId: Int): Color {
    TypedValue().let { outValue ->
        LocalContext.current.theme.resolveAttribute(attrColorId, outValue, true)
        return Color(outValue.data)
    }
}

@Composable
fun getThemeDimenForCompose(attrDimenId: Int): Float {
    TypedValue().let { outValue ->
        LocalContext.current.theme.resolveAttribute(attrDimenId, outValue, true)
        return when (outValue.type) {
            TypedValue.TYPE_DIMENSION -> TypedValue.complexToFloat(outValue.data)
            TypedValue.TYPE_FLOAT -> outValue.float
            else -> {
                0.0f
            }
        }
    }
}