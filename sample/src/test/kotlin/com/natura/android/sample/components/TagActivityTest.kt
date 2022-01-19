package com.natura.android.sample.components

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.sample.R
import com.natura.android.tag.Tag
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TagActivityTest {
    private lateinit var tagScenario: ActivityScenario<TagActivity>

    @Before
    fun setUp() {
        tagScenario = ActivityScenario.launch(TagActivity::class.java)
    }

    @Test
    fun checkTagPrimaryLabelContent() {
        tagScenario.onActivity {
            val primary = it.findViewById<Tag>(R.id.tagPrimary)

            Truth.assertThat(primary.getLabel()).isEqualTo("Center Primary Small")
        }
    }

    @Test
    fun checkTagPrimaryType() {
        tagScenario.onActivity {
            val primary = it.findViewById<Tag>(R.id.tagPrimary)

            Truth.assertThat(primary.getType()).isEqualTo(TYPE_PRIMARY)
        }
    }

    @Test
    fun checkTagPrimaryPosition() {
        tagScenario.onActivity {
            val primary = it.findViewById<Tag>(R.id.tagPrimary)

            Truth.assertThat(primary.getPosition()).isEqualTo(POSITION_CENTER)
        }
    }

    @Test
    fun checkTagAlertLabelContent() {
        tagScenario.onActivity {
            val alert = it.findViewById<Tag>(R.id.tagAlert)

            Truth.assertThat(alert.getLabel()).isEqualTo("Left Alert Standard")
        }
    }

    @Test
    fun checkTagAlertType() {
        tagScenario.onActivity {
            val alert = it.findViewById<Tag>(R.id.tagAlert)

            Truth.assertThat(alert.getType()).isEqualTo(TYPE_ALERT)
        }
    }

    @Test
    fun checkTagAlertPosition() {
        tagScenario.onActivity {
            val alert = it.findViewById<Tag>(R.id.tagAlert)

            Truth.assertThat(alert.getPosition()).isEqualTo(POSITION_LEFT)
        }
    }

    @Test
    fun checkTagSecondaryLabelContent() {
        tagScenario.onActivity {
            val secondary = it.findViewById<Tag>(R.id.tagSecondary)

            Truth.assertThat(secondary.getLabel()).isEqualTo("Center Secondary Standard")
        }
    }

    @Test
    fun checkTagSecondaryType() {
        tagScenario.onActivity {
            val secondary = it.findViewById<Tag>(R.id.tagSecondary)

            Truth.assertThat(secondary.getType()).isEqualTo(TYPE_SECONDARY)
        }
    }

    @Test
    fun checkTagSecondaryPosition() {
        tagScenario.onActivity {
            val secondary = it.findViewById<Tag>(R.id.tagSecondary)

            Truth.assertThat(secondary.getPosition()).isEqualTo(POSITION_CENTER)
        }
    }

    @Test
    fun checkTagSuccessLabelContent() {
        tagScenario.onActivity {
            val success = it.findViewById<Tag>(R.id.tagSuccess)

            Truth.assertThat(success.getLabel()).isEqualTo("Left Success Small")
        }
    }

    @Test
    fun checkTagSuccessType() {
        tagScenario.onActivity {
            val success = it.findViewById<Tag>(R.id.tagSuccess)

            Truth.assertThat(success.getType()).isEqualTo(TYPE_SUCCESS)
        }
    }

    @Test
    fun checkTagSuccessPosition() {
        tagScenario.onActivity {
            val success = it.findViewById<Tag>(R.id.tagSuccess)

            Truth.assertThat(success.getPosition()).isEqualTo(POSITION_LEFT)
        }
    }

    @Test
    fun checkTagWarningLabelContent() {
        tagScenario.onActivity {
            val warning = it.findViewById<Tag>(R.id.tagWarning)

            Truth.assertThat(warning.getLabel()).isEqualTo("Right Warning Small")
        }
    }

    @Test
    fun checkTagWarningType() {
        tagScenario.onActivity {
            val warning = it.findViewById<Tag>(R.id.tagWarning)

            Truth.assertThat(warning.getType()).isEqualTo(TYPE_WARNING)
        }
    }

    @Test
    fun checkTagWarningPosition() {
        tagScenario.onActivity {
            val warning = it.findViewById<Tag>(R.id.tagWarning)

            Truth.assertThat(warning.getPosition()).isEqualTo(POSITION_RIGHT)
        }
    }

    @Test
    fun checkTagLinkLabelContent() {
        tagScenario.onActivity {
            val link = it.findViewById<Tag>(R.id.tagLink)

            Truth.assertThat(link.getLabel()).isEqualTo("Right Link Standard")
        }
    }

    @Test
    fun checkTagLinkType() {
        tagScenario.onActivity {
            val link = it.findViewById<Tag>(R.id.tagLink)

            Truth.assertThat(link.getType()).isEqualTo(TYPE_LINK)
        }
    }

    @Test
    fun checkTagLinkPosition() {
        tagScenario.onActivity {
            val link = it.findViewById<Tag>(R.id.tagLink)

            Truth.assertThat(link.getPosition()).isEqualTo(POSITION_RIGHT)
        }
    }

    companion object {
        const val TYPE_PRIMARY = 0
        const val TYPE_ALERT = 1
        const val TYPE_SECONDARY = 2
        const val TYPE_SUCCESS = 3
        const val TYPE_WARNING = 4
        const val TYPE_LINK = 5

        const val POSITION_CENTER = 0
        const val POSITION_LEFT = 1
        const val POSITION_RIGHT = 2
    }
}
