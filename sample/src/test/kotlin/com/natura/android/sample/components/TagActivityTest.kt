package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import kotlinx.android.synthetic.main.activity_tag.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TagActivityTest {
    lateinit var tagScenario: ActivityScenario<TagActivity>

    @Before
    fun setUp() {
        tagScenario = ActivityScenario.launch(TagActivity::class.java)
    }

    @Test
    fun checkTagAlertLabelContent() {
        tagScenario.onActivity { activity ->
            val alert = activity.tagAlert

            Truth.assertThat(alert.getLabel()).isEqualTo("Alert")
        }
    }

    @Test
    fun checkTagAlertType() {
        tagScenario.onActivity { activity ->
            val alert = activity.tagAlert

            Truth.assertThat(alert.getType()).isEqualTo(TYPE_ALERT)
        }
    }

    @Test
    fun checkTagPrimaryLabelContent() {
        tagScenario.onActivity { activity ->
            val primary = activity.tagPrimary

            Truth.assertThat(primary.getLabel()).isEqualTo("Primary")
        }
    }

    @Test
    fun checkTagPrimaryType() {
        tagScenario.onActivity { activity ->
            val primary = activity.tagPrimary

            Truth.assertThat(primary.getType()).isEqualTo(TYPE_PRIMARY)
        }
    }

    companion object {
        const val TYPE_PRIMARY = 0
        const val TYPE_ALERT = 1
    }
}
