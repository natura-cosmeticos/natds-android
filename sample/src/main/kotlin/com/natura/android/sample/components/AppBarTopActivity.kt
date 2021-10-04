package com.natura.android.sample.components

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.natura.android.iconButton.IconButton
import com.natura.android.sample.R
import com.natura.android.sample.setChosenDefaultWithNoActionBarTheme
import kotlinx.android.synthetic.main.appbartop_button_action.view.*

class AppBarTopActivity : AppCompatActivity() {

    private val appBarTopWithTwoActions by lazy { findViewById<ConstraintLayout>(R.id.appBarTopWithTwoActions) }
    private val appBarTopWithTitleCenter by lazy { findViewById<ConstraintLayout>(R.id.appBarTopWithTitleCenter) }
    private val appBarTopWithTitleLong by lazy { findViewById<ConstraintLayout>(R.id.appBarTopWithTitleLong) }
    private val appBarTopWithSearch by lazy { findViewById<ConstraintLayout>(R.id.appBarTopWithSearch) }
    private val appBarTopWithThreeActions by lazy { findViewById<ConstraintLayout>(R.id.appBarTopWithThreeActions) }
    private val appBarTopWithButtonAction by lazy { findViewById<ConstraintLayout>(R.id.appBarTopWithButtonAction) }

    private val buttonActionViewIconButtonActionRight by lazy { findViewById<IconButton>(R.id.buttonActionViewIconButtonActionRight) }
    private val buttonActionViewOutlinedButtonActionRight by lazy { findViewById<Button>(R.id.buttonActionViewOutlinedButtonActionRight) }

    private val searchViewIconButtonActionRight by lazy { findViewById<IconButton>(R.id.searchViewIconButtonActionRight) }
    private val searchViewIconButtonActionLeft by lazy { findViewById<IconButton>(R.id.searchViewIconButtonActionLeft) }

    private val threeActionsViewIconButtonActionLeft by lazy { findViewById<IconButton>(R.id.threeActionsViewIconButtonActionLeft) }
    private val threeActionsViewFirstIconButtonActionRight by lazy { findViewById<IconButton>(R.id.threeActionsViewFirstIconButtonActionRight) }
    private val threeActionsViewSecondIconButtonActionRight by lazy { findViewById<IconButton>(R.id.threeActionsViewSecondIconButtonActionRight) }
    private val threeActionsViewThirdIconButtonActionRight by lazy { findViewById<IconButton>(R.id.threeActionsViewThirdIconButtonActionRight) }

    private val titleCenterViewIconButtonActionLeft by lazy { findViewById<IconButton>(R.id.titleCenterViewIconButtonActionLeft) }
    private val titleCenterViewIconButtonActionRight by lazy { findViewById<IconButton>(R.id.titleCenterViewIconButtonActionRight) }

    private val titleLongViewIconButtonActionLeft by lazy { findViewById<IconButton>(R.id.titleLongViewIconButtonActionLeft) }
    private val titleLongViewFirstIconButtonActionRight by lazy { findViewById<IconButton>(R.id.titleLongViewFirstIconButtonActionRight) }
    private val titleLongViewSecondIconButtonActionRight by lazy { findViewById<IconButton>(R.id.titleLongViewSecondIconButtonActionRight) }
    private val titleLongViewThirdIconButtonActionRight by lazy { findViewById<IconButton>(R.id.titleLongViewThirdIconButtonActionRight) }

    private val twoActionsViewFirstIconButtonActionRight by lazy { findViewById<IconButton>(R.id.twoActionsViewFirstIconButtonActionRight) }
    private val twoActionsViewSecondIconButtonActionRight by lazy { findViewById<IconButton>(R.id.twoActionsViewSecondIconButtonActionRight) }
    private val twoActionsViewIconButtonActionLeft by lazy { findViewById<IconButton>(R.id.twoActionsViewIconButtonActionLeft) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultWithNoActionBarTheme()

        super.onCreate(savedInstanceState)

        val pattern = intent.getIntExtra("pattern", PATTERN_APPBARTOP_TWOACTIONS)

        setContentView(R.layout.activity_appbar_top)

        createListeners()

        when (pattern) {
            PATTERN_APPBARTOP_TWOACTIONS -> appBarTopWithTwoActions.visibility = View.VISIBLE
            PATTERN_APPBARTOP_TITLE_CENTER -> appBarTopWithTitleCenter.visibility = View.VISIBLE
            PATTERN_APPBARTOP_THREE_ACTIONS -> appBarTopWithTitleLong.visibility = View.VISIBLE
            PATTERN_APPBARTOP_SEARCH -> appBarTopWithSearch.visibility = View.VISIBLE
            PATTERN_APPBARTOP_THREE_ACTIONS_RIGHT -> appBarTopWithThreeActions.visibility = View.VISIBLE
            PATTERN_APPBARTOP_BUTTON -> appBarTopWithButtonAction.visibility = View.VISIBLE
        }
    }

    private fun createListeners() {

        buttonActionViewIconButtonActionRight.setOnClickListener {}
        buttonActionViewOutlinedButtonActionRight.setOnClickListener {}

        searchViewIconButtonActionRight.setOnClickListener {}
        searchViewIconButtonActionLeft.setOnClickListener {}

        threeActionsViewIconButtonActionLeft.setOnClickListener {}
        threeActionsViewFirstIconButtonActionRight.setOnClickListener {}
        threeActionsViewSecondIconButtonActionRight.setOnClickListener {}
        threeActionsViewThirdIconButtonActionRight.setOnClickListener {}

        titleCenterViewIconButtonActionLeft.setOnClickListener {}
        titleCenterViewIconButtonActionRight.setOnClickListener {}

        titleLongViewIconButtonActionLeft.setOnClickListener {}
        titleLongViewFirstIconButtonActionRight.setOnClickListener {}
        titleLongViewSecondIconButtonActionRight.setOnClickListener {}
        titleLongViewThirdIconButtonActionRight.setOnClickListener {}

        twoActionsViewFirstIconButtonActionRight.setOnClickListener {}
        twoActionsViewSecondIconButtonActionRight.setOnClickListener {}

        twoActionsViewIconButtonActionLeft.setOnClickListener {}
    }

    companion object {
        private const val PATTERN_APPBARTOP_TWOACTIONS = 1
        private const val PATTERN_APPBARTOP_TITLE_CENTER = 2
        private const val PATTERN_APPBARTOP_THREE_ACTIONS = 3
        private const val PATTERN_APPBARTOP_SEARCH = 4
        private const val PATTERN_APPBARTOP_THREE_ACTIONS_RIGHT = 5
        private const val PATTERN_APPBARTOP_BUTTON = 6
    }
}
