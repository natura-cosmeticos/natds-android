package com.natura.android.sample.components

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import com.natura.android.sample.R

class DrawableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon)

        val iconGrid = findViewById<RecyclerView>(R.id.icon_grid)
        iconGrid.layoutManager = GridLayoutManager(this, 2)

        iconGrid.adapter = DrawableAdapter(this, recoverListIds(), recoverListNames())
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Icons (drawables)")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }

    private fun recoverListIds() = listOf(
        R.drawable.ds_ic_filled_action_cancel,
        R.drawable.ds_ic_filled_action_check,
        R.drawable.ds_ic_outlined_action_cancel,
        R.drawable.ds_ic_outlined_action_mic,
        R.drawable.ds_ic_outlined_action_search,
        R.drawable.ds_ic_outlined_finance_transfermoney,
        R.drawable.ds_ic_outlined_navigation_arrowbottom,
        R.drawable.ds_ic_outlined_navigation_arrowleft,
        R.drawable.ds_ic_outlined_navigation_arrowright,
        R.drawable.ds_ic_outlined_navigation_arrowtop,
        R.drawable.ds_ic_outlined_navigation_close,
        R.drawable.ds_ic_outlined_navigation_directionright,
        R.drawable.ds_ic_filled_brand_naturarosacea,
        R.drawable.ds_ic_outlined_finance_money,
        R.drawable.ds_ic_outlined_action_visibility,
        R.drawable.ds_ic_outlined_action_visibilityoff
    )

    private fun recoverListNames() = listOf(
        "ds_ic_filled_action_cancel",
        "ds_ic_filled_action_check",
        "ds_ic_outlined_action_cancel",
        "ds_ic_outlined_action_mic",
        "ds_ic_outlined_action_search",
        "ds_ic_outlined_finance_transfermoney",
        "ds_ic_outlined_navigation_arrowbottom",
        "ds_ic_outlined_navigation_arrowleft",
        "ds_ic_outlined_navigation_arrowright",
        "ds_ic_outlined_navigation_arrowtop",
        "ds_ic_outlined_navigation_close",
        "ds_ic_outlined_navigation_directionright",
        "ds_ic_filled_brand_naturarosacea",
        "ds_ic_outlined_finance_money",
        "ds_ic_outlined_action_visibility",
        "ds_ic_outlined_action_visibilityoff"
    )
}