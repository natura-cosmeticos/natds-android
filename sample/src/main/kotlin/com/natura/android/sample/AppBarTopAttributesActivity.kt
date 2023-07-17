package com.natura.android.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.components.AppBarTopActivity
import com.natura.android.sample.databinding.ActivityAppbartopAttributesBinding

class AppBarTopAttributesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppbartopAttributesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppbartopAttributesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = this.getString(R.string.app_title)
        setButtonsActions()
    }

    private fun setButtonsActions() {

        binding.btnTwoActions.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_APPBARTOP_TWOACTIONS))
        }

        binding.btnTitleCenter.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_APPBARTOP_TITLE_CENTER))
        }

        binding.btnTItleAndThreeActions.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_APPBARTOP_THREE_ACTIONS))
        }

        binding.btnSearch.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_APPBARTOP_SEARCH))
        }

        binding.btnThreeActionsRight.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_APPBARTOP_THREE_ACTIONS_RIGHT))
        }

        binding.btnActionButton.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_APPBARTOP_BUTTON))
        }

        binding.btnColorDefault.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_COLOR_DEFAULT))
        }

        binding.btnColorNone.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_COLOR_NONE))
        }

        binding.btnColorPrimary.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_COLOR_PRIMARY))
        }

        binding.btnColorSecondary.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_COLOR_SECONDARY))
        }
        binding.btnColorInverse.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_COLOR_INVERSE))
        }
    }

    companion object {
        private const val PATTERN_APPBARTOP_TWOACTIONS = 1
        private const val PATTERN_APPBARTOP_TITLE_CENTER = 2
        private const val PATTERN_APPBARTOP_THREE_ACTIONS = 3
        private const val PATTERN_APPBARTOP_SEARCH = 4
        private const val PATTERN_APPBARTOP_THREE_ACTIONS_RIGHT = 5
        private const val PATTERN_APPBARTOP_BUTTON = 6
        private const val PATTERN_COLOR_DEFAULT = 7
        private const val PATTERN_COLOR_NONE = 8
        private const val PATTERN_COLOR_PRIMARY = 9
        private const val PATTERN_COLOR_SECONDARY = 10
        private const val PATTERN_COLOR_INVERSE = 11
    }
}
