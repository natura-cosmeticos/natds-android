package com.natura.android.sample.components

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.setContentViewWithBrand

class StyleButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentViewWithBrand(R.layout.activity_styled_button)
    }
}