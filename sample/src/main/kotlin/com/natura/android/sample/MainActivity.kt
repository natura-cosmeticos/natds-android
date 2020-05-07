package com.natura.android.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.components.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = this.getString(R.string.app_title)
        setButtonsActions()
    }

    private fun setButtonsActions() {
        colorTokensButton.setOnClickListener {
            startActivity(Intent(this, ColorsActivity::class.java))
        }

        borderRadiusButton.setOnClickListener {
            startActivity(Intent(this, BorderRadiusActivity::class.java))
        }

        btnIconsDrawables.setOnClickListener {
            startActivity(Intent(this, DrawableActivity::class.java))
        }

        btnIconsFont.setOnClickListener {
            startActivity(Intent(this, IconActivity::class.java))
        }

        btnSpacing.setOnClickListener {
            startActivity(Intent(this, SpacingActivity::class.java))
        }

        btnAppbar.setOnClickListener {
            startActivity(Intent(this, AppBarActivity::class.java))
        }

        btnStyleButtons.setOnClickListener {
            startActivity(Intent(this, StyleButtonActivity::class.java))
        }

        btnSelection.setOnClickListener {
            startActivity(Intent(this, SelectionControlActivity::class.java))
        }

        btnTextfield.setOnClickListener {
            startActivity(Intent(this, TextFieldActivity::class.java))
        }

        btnValueTextHighlight.setOnClickListener {
            startActivity(Intent(this, ValueTextHighlightActivity::class.java))
        }

        btnMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

        btnSubmenu.setOnClickListener {
            startActivity(Intent(this, SubmenuActivity::class.java))
        }

        btnNavigationDrawer.setOnClickListener {
            startActivity(Intent(this, ExpandableNavigationViewActivity::class.java))
        }

        btnLoader.setOnClickListener {
            startActivity(Intent(this, LoadingActivity::class.java))
        }

        btnErrorDefault.setOnClickListener {
            startActivity(Intent(this, ErrorActivity::class.java))
        }
    }
}
