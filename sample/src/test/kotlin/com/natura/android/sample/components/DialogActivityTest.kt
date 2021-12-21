package com.natura.android.sample.components

import android.widget.Button
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.sample.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.shadows.ShadowAlertDialog

@RunWith(AndroidJUnit4::class)
class DialogActivityTest {

    lateinit var dialogActivityScenario: ActivityScenario<DialogActivity>

    @Before
    fun setUp() {
        dialogActivityScenario = ActivityScenario.launch(DialogActivity::class.java)
    }

    @Test
    fun dialogStandardButtonStartsDialogStandard() {
        dialogActivityScenario.onActivity {
            val buttonDialogStandard = it.findViewById<Button>(R.id.standardDialogButton)
            buttonDialogStandard.performClick()

            val dialogDisplayed = ShadowAlertDialog.getLatestDialog()

            Truth.assertThat(dialogDisplayed.isShowing).isTrue()
        }
    }

    @Test
    fun dialogAlertButtonStartsDialogAlert() {
        dialogActivityScenario.onActivity {
            val buttonDialogAlert = it.findViewById<Button>(R.id.alertDialogButton)
            buttonDialogAlert.performClick()

            val dialogDisplayed = ShadowAlertDialog.getLatestDialog()

            Truth.assertThat(dialogDisplayed.isShowing).isTrue()
        }
    }
}
