package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
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
        dialogActivityScenario.onActivity { dialogActivity ->
            val buttonDialogStandard = dialogActivity.standardDialogButton
            buttonDialogStandard.performClick()

            val dialogDisplayed = ShadowAlertDialog.getLatestDialog()

            Truth.assertThat(dialogDisplayed.isShowing).isTrue()
        }
    }

    @Test
    fun dialogAlertButtonStartsDialogAlert() {
        dialogActivityScenario.onActivity { dialogActivity ->
            val buttonDialogAlert = dialogActivity.alertDialogButton
            buttonDialogAlert.performClick()

            val dialogDisplayed = ShadowAlertDialog.getLatestDialog()

            Truth.assertThat(dialogDisplayed.isShowing).isTrue()
        }
    }
}
