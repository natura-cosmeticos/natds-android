package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
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

        val expansionPanel1 = findViewById<ExpansionPanel>(R.id.first_expansion_panel)
        val expansionPanel2 = findViewById<ExpansionPanel>(R.id.second_expansion_panel)

        listOf(expansionPanel1, expansionPanel2).toggleVisibility()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }

    private fun List<ExpansionPanel>.toggleVisibility() {
        forEach { expansionPanel ->
            expansionPanel.setOnStateChangeListener { isOpen ->
                if (isOpen) {
                    filter {
                        it != expansionPanel && it.isExpanded
                    }.map { otherExpansionPanel ->
                        otherExpansionPanel.isExpanded = false
                    }
                }
            }
        }
    }
}
