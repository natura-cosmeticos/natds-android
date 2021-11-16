package com.natura.android.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.components.AppBarTopActivity
import kotlinx.android.synthetic.main.activity_appbartop_attributes.*

class AppBarTopAttributesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appbartop_attributes)

        supportActionBar?.title = this.getString(R.string.app_title)
        setButtonsActions()
    }

    private fun setButtonsActions() {

        btnTwoActions.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_APPBARTOP_TWOACTIONS))
        }

        btnTitleCenter.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_APPBARTOP_TITLE_CENTER))
        }

        btnTItleAndThreeActions.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_APPBARTOP_THREE_ACTIONS))
        }

        btnSearch.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_APPBARTOP_SEARCH))
        }

        btnThreeActionsRight.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_APPBARTOP_THREE_ACTIONS_RIGHT))
        }

        btnActionButton.setOnClickListener {
            startActivity(Intent(this, AppBarTopActivity::class.java).putExtra("pattern", PATTERN_APPBARTOP_BUTTON))
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
