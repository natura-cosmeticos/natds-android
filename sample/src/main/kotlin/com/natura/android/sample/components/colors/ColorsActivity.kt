package com.natura.android.sample.components.colors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.natura.android.sample.R
import kotlinx.android.synthetic.main.activity_color.*

class ColorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        val colorsAdapter = ColorsTabAdapter(supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.brandsViewPager)
        viewPager.adapter = colorsAdapter

        val tabs: TabLayout = colorTabs
        tabs.setupWithViewPager(viewPager)
    }
}