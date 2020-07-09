package com.natura.android.appbar

import android.app.Activity
import android.content.Context
import android.view.Menu
import android.view.MenuItem
import com.natura.android.R

class SetupAppBarImpl{
     fun setLayout(layout: Int) = layout

     fun displayMenuWithBadge(
        activity: Activity,
        menu: Menu?,
        appbarMenu: Int,
        mCount: Int
    ) {
        menu?.let {
            menu ->
            configureOptionsMenu(activity, menu, appbarMenu)
            menu.findItem(R.id.ic_notification)?.let { menuItem ->
                setBadgeConfiguration(activity, mCount, menuItem, activity.getString(R.string.notification_limit_placeholder)) }}
    }

     fun displayMenu(
        activity: Activity,
        menu: Menu?,
        appbarMenu: Int
    ) {
        menu?.let {
            configureOptionsMenu(activity, it, appbarMenu)
            it.findItem(R.id.ic_schedule).let { menuItem ->  menuItem.setIcon(R.drawable.ds_button_primary_enabled)}}
    }

    private fun configureOptionsMenu(activity: Activity, menu: Menu, appbarMenu: Int) {
        activity.menuInflater.inflate(appbarMenu, menu)
    }

     fun displayOptionsMenu() {
        var searchMenuItem: MenuItem
        var profileMenuItem: MenuItem
        var linesMenuItem: MenuItem
    }

     fun updateNotificationBadge(context: Context, menu: Menu?, mCount: Int, icon: Int) {
        menu?.findItem(icon)?.let {
            setBadgeConfiguration(
                context,
                mCount,
                it,
                context.getString(R.string.notification_limit_placeholder)
            )
        }
    }


}