package com.natura.android.appbar

import android.content.Context
import android.graphics.drawable.LayerDrawable
import android.util.TypedValue
import android.view.MenuItem
import com.natura.android.R

fun getColorFromTheme(context: Context, attrColorId: Int): Int{
    val value = TypedValue()
    context.theme.resolveAttribute(attrColorId, value, true)
    return value.data
}

fun setAppbarConfig(
    context: Context,
    count: Int,
    menuItem: MenuItem,
    notificationLimitPlaceholder: String
){
    val icon = menuItem.icon as LayerDrawable
    val badgeDrawable: BadgeDrawable
    val reuse = icon.findDrawableByLayerId(R.id.ic_group_notification_count)

    badgeDrawable = if (reuse != null && reuse is BadgeDrawable) {
        reuse
    } else {
        BadgeDrawable(context, notificationLimitPlaceholder)
    }
    badgeDrawable.updateBadgeDrawable(count)
    icon.mutate()
    icon.setDrawableByLayerId(R.id.ic_group_notification_count, badgeDrawable)
}


