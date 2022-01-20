package com.natura.android.sample.components

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.databinding.ActivityAppbarTopBinding
import com.natura.android.sample.databinding.AppbartopButtonActionBinding
import com.natura.android.sample.databinding.AppbartopSearchBinding
import com.natura.android.sample.databinding.AppbartopThreeactionsBinding
import com.natura.android.sample.databinding.AppbartopTitleCenterBinding
import com.natura.android.sample.databinding.AppbartopTitleLongBinding
import com.natura.android.sample.databinding.AppbartopTwoactionsBinding
import com.natura.android.sample.setChosenDefaultWithNoActionBarTheme

class AppBarTopActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppbarTopBinding
    private lateinit var layoutButtonActionBinding: AppbartopButtonActionBinding
    private lateinit var layoutSearchBinding: AppbartopSearchBinding
    private lateinit var layoutThreeActionsBinding: AppbartopThreeactionsBinding
    private lateinit var layoutTitleCenterBinding: AppbartopTitleCenterBinding
    private lateinit var layoutTitleLongBinding: AppbartopTitleLongBinding
    private lateinit var layoutTwoActionsBinding: AppbartopTwoactionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultWithNoActionBarTheme()

        super.onCreate(savedInstanceState)

        binding = ActivityAppbarTopBinding.inflate(layoutInflater)

        layoutButtonActionBinding = binding.appbartopButtonAction
        layoutSearchBinding = binding.appbartopSearch
        layoutThreeActionsBinding = binding.appbartopThreeactions
        layoutTitleCenterBinding = binding.appbartopTitleCenter
        layoutTwoActionsBinding = binding.appbartopTwoactions
        layoutTitleLongBinding = binding.appbartopTitleLong

        val pattern = intent.getIntExtra("pattern", PATTERN_APPBARTOP_TWOACTIONS)

        setContentView(binding.root)

        setSupportActionBar(layoutThreeActionsBinding.appBarWithThreeActions.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        createListeners()

        when (pattern) {
            PATTERN_APPBARTOP_TWOACTIONS -> layoutTwoActionsBinding.root.visibility = View.VISIBLE
            PATTERN_APPBARTOP_TITLE_CENTER -> layoutTitleCenterBinding.root.visibility = View.VISIBLE
            PATTERN_APPBARTOP_THREE_ACTIONS -> layoutTitleLongBinding.root.visibility = View.VISIBLE
            PATTERN_APPBARTOP_SEARCH -> layoutSearchBinding.root.visibility = View.VISIBLE
            PATTERN_APPBARTOP_THREE_ACTIONS_RIGHT -> layoutThreeActionsBinding.root.visibility = View.VISIBLE
            PATTERN_APPBARTOP_BUTTON -> layoutButtonActionBinding.root.visibility = View.VISIBLE
        }
    }

    private fun createListeners() {

        layoutButtonActionBinding.apply {
            buttonActionViewIconButtonActionRight.setOnClickListener {}
            buttonActionViewOutlinedButtonActionRight.setOnClickListener {}
        }

        layoutSearchBinding.apply {
            searchViewIconButtonActionRight.setOnClickListener {}
            searchViewIconButtonActionLeft.setOnClickListener {}
        }

        layoutThreeActionsBinding.apply {
            threeActionsViewIconButtonActionLeft.setOnClickListener {}
            threeActionsViewFirstIconButtonActionRight.setOnClickListener {}
            threeActionsViewSecondIconButtonActionRight.setOnClickListener {}
            threeActionsViewThirdIconButtonActionRight.setOnClickListener {}
        }

        layoutTitleCenterBinding.apply {
            titleCenterViewIconButtonActionLeft.setOnClickListener {}
            titleCenterViewIconButtonActionRight.setOnClickListener {}
        }

        layoutTitleLongBinding.apply {
            titleLongViewIconButtonActionLeft.setOnClickListener {}
            titleLongViewFirstIconButtonActionRight.setOnClickListener {}
            titleLongViewSecondIconButtonActionRight.setOnClickListener {}
            titleLongViewThirdIconButtonActionRight.setOnClickListener {}
        }

        layoutTwoActionsBinding.apply {
            twoActionsViewFirstIconButtonActionRight.setOnClickListener {}
            twoActionsViewSecondIconButtonActionRight.setOnClickListener {}
            twoActionsViewIconButtonActionLeft.setOnClickListener {}
        }
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
