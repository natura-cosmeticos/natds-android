package com.natura.android.sample.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultWithNoActionBarTheme
import kotlinx.android.synthetic.main.activity_appbar.*

class BaseAppBarTopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultWithNoActionBarTheme()

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_appbar)

        setSupportActionBar(appBar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        createListeners()
    }

    private fun createListeners() {
        shortcutContained.setOnClickListener {
        }
    }
}
