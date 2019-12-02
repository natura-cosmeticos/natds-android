package com.natura.android.sample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.components.ExpandableNavigationViewActivity
import com.natura.android.sample.components.SubmenuActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.btn_submenu).setOnClickListener {
            startActivity(Intent(this, SubmenuActivity::class.java))
        }

        findViewById<Button>(R.id.btn_navigation_drawer).setOnClickListener {
            startActivity(Intent(this, ExpandableNavigationViewActivity::class.java))
        }
    }
}
