package com.natura.android.extensions

import android.content.Context
import android.content.res.Resources
import com.natura.android.R
import com.natura.android.extensions.ResourcesConstants.DRAWABLE_NOT_FOUND
import com.natura.android.shortcut.Shortcut

fun Resources.getIconResourceIdFromName(context: Context, iconName: String): Int {
    var drawableId = context.resources.getIdentifier(iconName.replace("-", "_"), "drawable", context.packageName)

    if (drawableId == DRAWABLE_NOT_FOUND) {
        drawableId = R.drawable.default_icon_outlined_default_mockup
    }
    return drawableId
}

object ResourcesConstants {
   const val DRAWABLE_NOT_FOUND = 0
}

