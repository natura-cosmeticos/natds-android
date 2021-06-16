package com.natura.android.sample.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultWithNoActionBarTheme

class StandardAppBarTopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultWithNoActionBarTheme()

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_standardappbar_top)

        createListeners()
    }

    private fun createListeners() {
//        shortcutContained.setOnClickListener {
//        }
    }
}
