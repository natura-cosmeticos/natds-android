package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.expansionPanel.ExpansionPanel
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class ExpansionPanelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_expansion_panel)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Expansion Panel"

        val expansionPanel = findViewById<ExpansionPanel>(R.id.expansion_panel)
        val currentStateButton = findViewById<Button>(R.id.current_state_button)

        expansionPanel.setOnStateChangeListener { isExpanded ->
            val action = if (isExpanded) "expanded" else "collapsed"

            Toast.makeText(this, "The panel $action.", Toast.LENGTH_SHORT).show()
        }

        currentStateButton.setOnClickListener {
            val state = if (expansionPanel.isExpanded()) "expanded" else "collapsed"

            Toast.makeText(this, "The panel is $state.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
}
