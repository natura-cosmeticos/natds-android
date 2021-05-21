package com.natura.android.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.components.*
import com.natura.android.sample.patterns.ErrorActivity
import com.natura.android.sample.components.ProgressIndicatorActivity
import com.natura.android.sample.components.IconButtonActivity
import com.natura.android.sample.components.listitem.ListItemActivity
import com.natura.android.sample.patterns.LogoActivity
import com.natura.android.sample.tokens.*
import com.natura.android.sample.tokens.icons.DrawableActivity
import com.natura.android.sample.tokens.icons.IconActivity
import com.natura.android.sample.tokens.TypographyActivity
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

        dialogButton.setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }

        btnExpansionPanel.setOnClickListener {
            startActivity(Intent(this, ExpansionPanelActivity::class.java))
        }

        iconButtonButton.setOnClickListener {
            startActivity(Intent(this, IconButtonActivity::class.java))
        }

        checkboxButton.setOnClickListener {
            startActivity(Intent(this, CheckBoxActivity::class.java))
        }

        shortcutButton.setOnClickListener {
            startActivity(Intent(this, ShortcutActivity::class.java))
        }

        tagButton.setOnClickListener {
            startActivity(Intent(this, TagActivity::class.java))
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

        progressIndicatorButton.setOnClickListener {
            startActivity(Intent(this, ProgressIndicatorActivity::class.java))
        }

        btnErrorDefault.setOnClickListener {
            startActivity(Intent(this, ErrorActivity::class.java))
        }

        logoButton.setOnClickListener {
            startActivity(Intent(this, LogoActivity::class.java))
        }

        btnBadge.setOnClickListener {
            startActivity(Intent(this, BadgeActivity::class.java))
        }

        btnCard.setOnClickListener {
            startActivity(Intent(this, CardActivity::class.java))
        }

        dividerButton.setOnClickListener {
            startActivity(Intent(this, DividerActivity::class.java))
        }

        radioButtonButton.setOnClickListener {
            startActivity(Intent(this, RadioButtonActivity::class.java))
        }

        btnListItem.setOnClickListener {
            startActivity(Intent(this, ListItemActivity::class.java))
        }
    }
}
