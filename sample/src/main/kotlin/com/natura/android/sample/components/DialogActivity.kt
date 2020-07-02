package com.natura.android.sample.components

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.dialog.DialogStandard
import com.natura.android.sample.R
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity : AppCompatActivity() {
    lateinit var dialogStandard: DialogStandard

    override fun onCreate(savedInstanceState: Bundle?) {
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
        dialogStandard = DialogStandard(
            this,
                    "Dialog Standard",
            R.layout.test_standard_dialog,
                    null,
                    "Main Button",
            { Toast.makeText(this, "Dialog is working", Toast.LENGTH_LONG) },
            "Secondary Button",
            { Toast.makeText(this, "Dialog is working", Toast.LENGTH_LONG) },
            true).create()
    }
}
