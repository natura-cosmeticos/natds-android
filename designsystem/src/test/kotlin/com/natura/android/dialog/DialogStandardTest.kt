package com.natura.android.dialog

import androidx.appcompat.widget.DialogTitle
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.natura.android.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DialogStandardTest {
    private lateinit var dialog: DialogStandard

    @Before
    fun setUp() {
        dialog = DialogStandard(
            ApplicationProvider.getApplicationContext(),
            "Dialog Title",
            R.layout.test_standard_dialog,
            null,
            "Main Button",
            { },
            "Secondary Button",
            { },
            true)

        dialog.show()
    }

    @Test
    fun checksIfTitleDialogIsAsSet() {
        val alertTitle = dialog.dialog.findViewById<DialogTitle>(R.id.alertTitle)

        assertThat(alertTitle?.text).isEqualTo("Dialog Title")
    }
}
