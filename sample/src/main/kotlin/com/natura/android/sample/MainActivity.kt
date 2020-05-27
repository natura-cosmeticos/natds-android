package com.natura.android.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.components.AppBarActivity
import com.natura.android.sample.components.ErrorActivity
import com.natura.android.sample.components.ExpandableNavigationViewActivity
import com.natura.android.sample.components.LoadingActivity
import com.natura.android.sample.components.MenuActivity
import com.natura.android.sample.components.SelectionControlActivity
import com.natura.android.sample.components.ButtonActivity
import com.natura.android.sample.components.SubmenuActivity
import com.natura.android.sample.components.TextFieldActivity
import com.natura.android.sample.components.ValueTextHighlightActivity
import com.natura.android.sample.tokens.*
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

        elevationTokensButton.setOnClickListener {
            startActivity(Intent(this, ElevationActivity::class.java))
        }

        btnIconsDrawables.setOnClickListener {
            startActivity(Intent(this, DrawableActivity::class.java))
        }

        btnIconsFont.setOnClickListener {
            startActivity(Intent(this, IconActivity::class.java))
        }

        opacityTokensButton.setOnClickListener {
            startActivity(Intent(this, OpacityActivity::class.java))
        }

        btnSpacing.setOnClickListener {
            startActivity(Intent(this, SpacingActivity::class.java))
        }

        sizeButton.setOnClickListener {
            startActivity(Intent(this, SizeActivity::class.java))
        }

        typographyButton.setOnClickListener {
            startActivity(Intent(this, TypographyActivity::class.java))
        }

        btnAppbar.setOnClickListener {
            startActivity(Intent(this, AppBarActivity::class.java))
        }

        btnStyleButtons.setOnClickListener {
            startActivity(Intent(this, ButtonActivity::class.java))
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
