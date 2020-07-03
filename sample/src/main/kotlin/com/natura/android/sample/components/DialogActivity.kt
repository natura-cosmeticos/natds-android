package com.natura.android.sample.components

import android.content.DialogInterface
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.dialog.DialogStandard
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme
import com.natura.android.textfield.TextField
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity : AppCompatActivity() {
    lateinit var dialogStandard: DialogStandard

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        supportActionBar?.title = "Dialog"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        createDialog()

        standardDialogButton.setOnClickListener {
            dialogStandard.show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }

    private fun createDialog() {

        val textfield = TextField(this)

        val clickListener = DialogInterface.OnClickListener { _, _ -> Toast.makeText(this, "Dialog is working", Toast.LENGTH_LONG).show() }

        dialogStandard = DialogStandard(
            this,
            "Dialog Standard Super Big Title To Check It's Behavior. Two lines are great! What about three or more?",
            "Main Button",
            clickListener,
            "Mini",
            clickListener,
            R.layout.test_standard_dialog).create()
    }
}
