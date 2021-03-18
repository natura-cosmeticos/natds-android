package com.natura.android.sample.components.listitem

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class ListItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item)

        val list = findViewById<RecyclerView>(R.id.list)

        list.layoutManager = LinearLayoutManager(this)

        list.adapter =
            ListItemAdapter(
                this,
                getAttributesList()
            )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("List Item")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    private fun getAttributesList(): List<String> {
        return listOf(
            "Onclick false",
            "Onclick true",
            "Selected cell",
            "Divider inset",
            "Divider middle",
            "Divider fullbleed")
    }
}
