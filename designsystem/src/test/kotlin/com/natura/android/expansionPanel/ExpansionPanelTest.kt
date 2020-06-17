package com.natura.android.expansionPanel

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [28])
class ExpansionPanelTest {

    val activityController = Robolectric.buildActivity(Activity::class.java)
    lateinit var expansionPanel: ExpansionPanel

    @Before
    fun setUp() {
        activityController.get().setTheme(R.style.Theme_Natura)
        expansionPanel = ExpansionPanel(activityController.get())
    }

    @Test
    fun basicLayout() {
        val layout = LayoutInflater.from(activityController.get()).inflate(R.layout.ds_expansion_panel, null) as ConstraintLayout

        Truth.assertThat(layout.findViewById(R.id.ds_expansion_panel_box) as View).isNotNull()
        Truth.assertThat(layout.findViewById(R.id.ds_expansion_panel_top) as View).isNotNull()
        Truth.assertThat(layout.findViewById(R.id.ds_expansion_panel_subtitle) as View).isNotNull()
        Truth.assertThat(layout.findViewById(R.id.ds_expansion_panel_icon) as View).isNotNull()
        Truth.assertThat(layout.findViewById(R.id.ds_expansion_panel_content) as View).isNotNull()
    }

    @Test
    fun contentNotVisibleByDefault() {
        val content = expansionPanel.findViewById(R.id.ds_expansion_panel_content) as ConstraintLayout

        Truth.assertThat(content.visibility).isEqualTo(View.GONE)
    }

    @Test
    fun borderlessWhenCollapsed() {
        val expectedBackground = ContextCompat.getDrawable(activityController.get(), R.drawable.ds_expansion_panel_border_collapsed)

        val box = expansionPanel.findViewById(R.id.ds_expansion_panel_box) as LinearLayout

        Truth.assertThat(box.background.constantState).isEqualTo(expectedBackground?.constantState)
    }

    @Test
    fun showContentWhenOnClick() {
        val box = expansionPanel.findViewById(R.id.ds_expansion_panel_box) as LinearLayout

        box.callOnClick()

        val content = expansionPanel.findViewById(R.id.ds_expansion_panel_content) as ConstraintLayout

        Truth.assertThat(content.visibility).isEqualTo(View.VISIBLE)
    }

    @Test
    fun withBorderWhenExpanded() {
        val expectedBackground = ContextCompat.getDrawable(activityController.get(), R.drawable.ds_expansion_panel_border_expanded)

        val box = expansionPanel.findViewById(R.id.ds_expansion_panel_box) as LinearLayout

        box.callOnClick()

        Truth.assertThat(box.background.constantState).isEqualTo(expectedBackground?.constantState)
    }

    @Test
    fun hideContentWhenOnClickAfterBeingExpanded() {
        val box = expansionPanel.findViewById(R.id.ds_expansion_panel_box) as LinearLayout

        box.callOnClick()
        box.callOnClick()

        val content = expansionPanel.findViewById(R.id.ds_expansion_panel_content) as ConstraintLayout

        Truth.assertThat(content.visibility).isEqualTo(View.GONE)
    }

}
