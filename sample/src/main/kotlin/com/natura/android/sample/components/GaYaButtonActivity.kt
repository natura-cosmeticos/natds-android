package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import com.natura.android.button.GaYaButton
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultTheme

class GaYaButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaya_button)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "GaYaButton"

        val gayaButton = GaYaButton(this)
        gayaButton.setBtnSize(GaYaButton.MEDIUM_SIZE)
        gayaButton.setBtnColor(GaYaButton.PRIMARY)
        gayaButton.setBtnType(GaYaButton.FILLED)
        gayaButton.setBtnIcon("outlined_product_childish")
        gayaButton.setBtnIconPosition(GaYaButton.START)
        gayaButton.setText("Criado programaticamente")

        val container: LinearLayout = findViewById(R.id.lnlProgramatically)
        container.addView(gayaButton)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
