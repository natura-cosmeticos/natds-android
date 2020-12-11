package com.natura.android.resources

import android.content.Context
import com.natura.android.R
import com.natura.android.resources.ResourcesConstants.DRAWABLE_NOT_FOUND

fun getIconResourceIdFromName(context: Context, iconName: String): Int {
    var drawableId = context.resources.getIdentifier(iconName.replace("-", "_"), "drawable", context.packageName)

    if (drawableId == DRAWABLE_NOT_FOUND) {
        drawableId = R.drawable.default_icon_outlined_default_mockup
    }
    return drawableId
}

object ResourcesConstants {
    const val DRAWABLE_NOT_FOUND = 0
}
