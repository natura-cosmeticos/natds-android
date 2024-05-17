package com.natura.android.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.components.ButtonActivity
import com.natura.android.sample.components.DialogActivity
import com.natura.android.sample.components.ExpansionPanelActivity
import com.natura.android.sample.components.IconButtonActivity
import com.natura.android.sample.components.CheckBoxActivity
import com.natura.android.sample.components.ProgressIndicatorActivity
import com.natura.android.sample.components.MenuActivity
import com.natura.android.sample.components.ExpandableNavigationViewActivity
import com.natura.android.sample.components.SubmenuActivity
import com.natura.android.sample.components.ShortcutActivity
import com.natura.android.sample.components.ValueTextHighlightActivity
import com.natura.android.sample.components.TagActivity
import com.natura.android.sample.components.CardActivity
import com.natura.android.sample.components.TextFieldActivity
import com.natura.android.sample.components.CounterActivity
import com.natura.android.sample.components.BadgeActivity
import com.natura.android.sample.components.DividerActivity
import com.natura.android.sample.components.RadioButtonActivity
import com.natura.android.sample.components.SelectActivity
import com.natura.android.sample.components.AvatarActivity
import com.natura.android.sample.components.ChipActivity
import com.natura.android.sample.components.AlertActivity
import com.natura.android.sample.components.GaYaButtonActivity
import com.natura.android.sample.components.SnackbarActivity
import com.natura.android.sample.components.listitem.ListItemActivity
import com.natura.android.sample.databinding.ActivityMainBinding
import com.natura.android.sample.patterns.ErrorActivity
import com.natura.android.sample.patterns.LogoActivity
import com.natura.android.sample.tokens.BorderRadiusActivity
import com.natura.android.sample.tokens.ColorsActivity
import com.natura.android.sample.tokens.ElevationActivity
import com.natura.android.sample.tokens.OpacityActivity
import com.natura.android.sample.tokens.SpacingActivity
import com.natura.android.sample.tokens.SizeActivity
import com.natura.android.sample.tokens.CustomTypographyActivity
import com.natura.android.sample.tokens.TypographyActivity
import com.natura.android.sample.tokens.icons.DrawableActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.title = this.getString(R.string.app_title)
        setButtonsActions()
    }

    private fun setButtonsActions() {
        binding.colorTokensButton.setOnClickListener {
            startActivity(Intent(this, ColorsActivity::class.java))
        }

        binding.borderRadiusButton.setOnClickListener {
            startActivity(Intent(this, BorderRadiusActivity::class.java))
        }

        binding.elevationTokensButton.setOnClickListener {
            startActivity(Intent(this, ElevationActivity::class.java))
        }

        binding.btnIconsDrawables.setOnClickListener {
            startActivity(Intent(this, DrawableActivity::class.java))
        }

        binding.opacityTokensButton.setOnClickListener {
            startActivity(Intent(this, OpacityActivity::class.java))
        }

        binding.btnSpacing.setOnClickListener {
            startActivity(Intent(this, SpacingActivity::class.java))
        }

        binding.sizeButton.setOnClickListener {
            startActivity(Intent(this, SizeActivity::class.java))
        }

        binding.typographyButton.setOnClickListener {
            startActivity(Intent(this, TypographyActivity::class.java))
        }

        binding.btnAppBarTop.setOnClickListener {
            startActivity(Intent(this, AppBarTopAttributesActivity::class.java))
        }

        binding.btnStyleButtons.setOnClickListener {
            startActivity(Intent(this, ButtonActivity::class.java))
        }

        binding.btnStyleGaYaButtons.setOnClickListener {
            startActivity(Intent(this, GaYaButtonActivity::class.java))
        }

        binding.dialogButton.setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }

        binding.btnExpansionPanel.setOnClickListener {
            startActivity(Intent(this, ExpansionPanelActivity::class.java))
        }

        binding.iconButtonButton.setOnClickListener {
            startActivity(Intent(this, IconButtonActivity::class.java))
        }

        binding.checkboxButton.setOnClickListener {
            startActivity(Intent(this, CheckBoxActivity::class.java))
        }

        binding.shortcutButton.setOnClickListener {
            startActivity(Intent(this, ShortcutActivity::class.java))
        }

        binding.tagButton.setOnClickListener {
            startActivity(Intent(this, TagActivity::class.java))
        }

        binding.counterButton.setOnClickListener {
            startActivity(Intent(this, CounterActivity::class.java))
        }

        binding.btnTextfield.setOnClickListener {
            startActivity(Intent(this, TextFieldActivity::class.java))
        }

        binding.btnValueTextHighlight.setOnClickListener {
            startActivity(Intent(this, ValueTextHighlightActivity::class.java))
        }

        binding.btnMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

        binding.btnSubmenu.setOnClickListener {
            startActivity(Intent(this, SubmenuActivity::class.java))
        }

        binding.btnNavigationDrawer.setOnClickListener {
            startActivity(Intent(this, ExpandableNavigationViewActivity::class.java))
        }

        binding.progressIndicatorButton.setOnClickListener {
            startActivity(Intent(this, ProgressIndicatorActivity::class.java))
        }

        binding.btnErrorDefault.setOnClickListener {
            startActivity(Intent(this, ErrorActivity::class.java))
        }

        binding.logoButton.setOnClickListener {
            startActivity(Intent(this, LogoActivity::class.java))
        }

        binding.btnBadge.setOnClickListener {
            startActivity(Intent(this, BadgeActivity::class.java))
        }

        binding.btnCard.setOnClickListener {
            startActivity(Intent(this, CardActivity::class.java))
        }

        binding.dividerButton.setOnClickListener {
            startActivity(Intent(this, DividerActivity::class.java))
        }

        binding.radioButtonButton.setOnClickListener {
            startActivity(Intent(this, RadioButtonActivity::class.java))
        }

        binding.selectButton.setOnClickListener {
            startActivity(Intent(this, SelectActivity::class.java))
        }

        binding.snackbarButton.setOnClickListener {
            startActivity(Intent(this, SnackbarActivity::class.java))
        }

        binding.btnListItem.setOnClickListener {
            startActivity(Intent(this, ListItemActivity::class.java))
        }

        binding.customTypographyButton.setOnClickListener {
            startActivity(Intent(this, CustomTypographyActivity::class.java))
        }

        binding.btnAvatar.setOnClickListener {
            startActivity(Intent(this, AvatarActivity::class.java))
        }

        binding.chipButton.setOnClickListener {
            startActivity(Intent(this, ChipActivity::class.java))
        }

        binding.btnAlert.setOnClickListener {
            startActivity(Intent(this, AlertActivity::class.java))
        }
    }
}
