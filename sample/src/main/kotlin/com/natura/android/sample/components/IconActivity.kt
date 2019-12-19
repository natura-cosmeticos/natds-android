package com.natura.android.sample.components

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.natura.android.sample.R

class IconActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon)

        val iconGrid = findViewById<RecyclerView>(R.id.icon_grid)
        iconGrid.layoutManager = GridLayoutManager(this, 3)

        iconGrid.adapter = IconAdapter(this, recoverListIcons())
    }

    private fun recoverListIcons() = listOf(
        R.string.icon_filled_alert_cancel,
        R.string.icon_filled_alert_check,
        R.string.icon_filled_media_pause,
        R.string.icon_filled_media_play,
        R.string.icon_outlined_action_autofilter,
        R.string.icon_outlined_action_send,
        R.string.icon_outlined_alert_cancel,
        R.string.icon_outlined_alert_check
    )
}