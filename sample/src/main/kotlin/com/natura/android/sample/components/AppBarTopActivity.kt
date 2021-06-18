package com.natura.android.sample.components

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultWithNoActionBarTheme
import kotlinx.android.synthetic.main.appbartop_button_action.*
import kotlinx.android.synthetic.main.appbartop_search.*
import kotlinx.android.synthetic.main.appbartop_shortcut_action.*
import kotlinx.android.synthetic.main.appbartop_threeactions.*
import kotlinx.android.synthetic.main.appbartop_title_center.*
import kotlinx.android.synthetic.main.appbartop_title_long.*
import kotlinx.android.synthetic.main.appbartop_twoactions.*

class AppBarTopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultWithNoActionBarTheme()

        super.onCreate(savedInstanceState)

        val pattern = intent.getIntExtra("pattern", PATTERN_APPBARTOP_TWOACTIONS)

        setContentView(R.layout.activity_appbar_top)

        when (pattern) {
            PATTERN_APPBARTOP_TWOACTIONS -> appBarTopWithTwoActions.visibility = View.VISIBLE
            PATTERN_APPBARTOP_TITLE_CENTER -> appBarTopWithTitleCenter.visibility = View.VISIBLE
            PATTERN_APPBARTOP_THREE_ACTIONS -> appBarTopWithTitleLong.visibility = View.VISIBLE
            PATTERN_APPBARTOP_SEARCH -> appBarTopWithSearch.visibility = View.VISIBLE
            PATTERN_APPBARTOP_THREE_ACTIONS_RIGHT -> appBarTopWithThreeActions.visibility = View.VISIBLE
            PATTERN_APPBARTOP_SHORTCUT -> appBarTopWithShortcutAction.visibility = View.VISIBLE
            PATTERN_APPBARTOP_BUTTON -> appBarTopWithButtonAction.visibility = View.VISIBLE
        }
    }

    companion object {
        private const val PATTERN_APPBARTOP_TWOACTIONS = 1
        private const val PATTERN_APPBARTOP_TITLE_CENTER = 2
        private const val PATTERN_APPBARTOP_THREE_ACTIONS = 3
        private const val PATTERN_APPBARTOP_SEARCH = 4
        private const val PATTERN_APPBARTOP_THREE_ACTIONS_RIGHT = 5
        private const val PATTERN_APPBARTOP_SHORTCUT = 6
        private const val PATTERN_APPBARTOP_BUTTON = 7
    }
}
