package com.natura.android.sample.components

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import com.natura.android.sample.R

class AppBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_appbar)

        val toolbarButton = findViewById<View>(R.id.toolbar_button)
        toolbarButton.setOnClickListener {
            Toast.makeText(this, "button cliked", Toast.LENGTH_SHORT).show()
        }
        val toolbarSeach = findViewById<View>(R.id.toolbar_search)
        toolbarSeach.setOnClickListener {
            Toast.makeText(this, "search icon cliked", Toast.LENGTH_SHORT).show()
        }
        val toolbarProfile = findViewById<View>(R.id.toolbar_profile)
        toolbarProfile.setOnClickListener {
            Toast.makeText(this, "profile icon cliked", Toast.LENGTH_SHORT).show()
        }
        val toolbarLine = findViewById<View>(R.id.toolbar_lines)
        toolbarLine.setOnClickListener {
            Toast.makeText(this, "selectedalllines icon cliked", Toast.LENGTH_SHORT).show()
        }

        val toolbarDefault = findViewById<Toolbar>(R.id.toolbarDefault)
        val toolbarPrimary = findViewById<Toolbar>(R.id.toolbarPrimary)
        val toolbarSecondary = findViewById<Toolbar>(R.id.toolbarSecondary)
        val styleDefault = findViewById<View>(R.id.style_default)
        styleDefault.setOnClickListener {
            toolbarDefault.visibility = View.VISIBLE
            toolbarPrimary.visibility = View.GONE
            toolbarSecondary.visibility = View.GONE
        }

        val stylePrimary = findViewById<View>(R.id.style_primary)
        stylePrimary.setOnClickListener {
            toolbarDefault.visibility = View.GONE
            toolbarPrimary.visibility = View.VISIBLE
            toolbarSecondary.visibility = View.GONE
        }

        val styleSecondary = findViewById<View>(R.id.style_secondary)
        styleSecondary.setOnClickListener {
            toolbarDefault.visibility = View.GONE
            toolbarPrimary.visibility = View.GONE
            toolbarSecondary.visibility = View.VISIBLE
        }

    }
}