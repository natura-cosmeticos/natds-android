package com.natura.android.expansionPanel

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.natura.android.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.android.controller.ActivityController

@RunWith(AndroidJUnit4::class)
class ExpansionPanelTest {

    private val activityController: ActivityController<Activity> = Robolectric.buildActivity(Activity::class.java)
    private lateinit var expansionPanel: ExpansionPanel

    @Before
    fun setUp() {
        activityController.get().setTheme(R.style.Theme_Natura_Light)
        expansionPanel = ExpansionPanel(activityController.get())
    }

    @Test
    fun basicLayout() {
        val layout = LayoutInflater.from(activityController.get()).inflate(R.layout.ds_expansion_panel, null) as View

        Truth.assertThat(layout.findViewById(R.id.ds_expansion_panel_container) as View).isNotNull()
        Truth.assertThat(layout.findViewById(R.id.ds_expansion_panel_top) as View).isNotNull()
        Truth.assertThat(layout.findViewById(R.id.ds_expansion_panel_title) as View).isNotNull()
        Truth.assertThat(layout.findViewById(R.id.ds_expansion_panel_icon) as View).isNotNull()
        Truth.assertThat(layout.findViewById(R.id.ds_expansion_panel_content_area) as View).isNotNull()
    }

    @Test
    fun contentNotVisibleByDefault() {
        val content = expansionPanel.findViewById(R.id.ds_expansion_panel_content_area) as ConstraintLayout

        Truth.assertThat(content.visibility).isEqualTo(View.GONE)
        Truth.assertThat(expansionPanel.isExpanded).isFalse()
    }

    @Test
    fun borderlessWhenCollapsed() {
        val expectedBackground = ContextCompat.getDrawable(activityController.get(), R.drawable.ds_expansion_panel_border_collapsed)

        val container = expansionPanel.findViewById(R.id.ds_expansion_panel_container) as View

        container.callOnClick()
        container.callOnClick()

        Truth.assertThat(container.background.constantState).isEqualTo(expectedBackground?.constantState)
    }

    @Test
    fun showContentWhenOnClick() {
        val container = expansionPanel.findViewById(R.id.ds_expansion_panel_container) as View

        container.callOnClick()

        val content = expansionPanel.findViewById(R.id.ds_expansion_panel_content_area) as ConstraintLayout

        Truth.assertThat(content.visibility).isEqualTo(View.VISIBLE)
    }

    @Test
    fun showContentWhenSetExpanded() {
        expansionPanel.isExpanded = true

        val content = expansionPanel.findViewById(R.id.ds_expansion_panel_content_area) as ConstraintLayout

        Truth.assertThat(content.visibility).isEqualTo(View.VISIBLE)
    }

    @Test
    fun invokeListenerWhenOnClick() {
        var isPanelExpanded = false
        expansionPanel.setOnStateChangeListener { isPanelExpanded = it }

        val container = expansionPanel.findViewById(R.id.ds_expansion_panel_container) as View

        container.callOnClick()

        Truth.assertThat(isPanelExpanded).isTrue()
    }

    @Test
    fun withBorderWhenExpanded() {
        val expectedBackground = ContextCompat.getDrawable(activityController.get(), R.drawable.ds_expansion_panel_border_expanded)

        val container = expansionPanel.findViewById(R.id.ds_expansion_panel_container) as View

        container.callOnClick()

        Truth.assertThat(container.background.constantState).isEqualTo(expectedBackground?.constantState)
    }

    @Test
    fun hideContentWhenOnClickAfterBeingExpanded() {
        val container = expansionPanel.findViewById(R.id.ds_expansion_panel_container) as View

        container.callOnClick()
        container.callOnClick()

        val content = expansionPanel.findViewById(R.id.ds_expansion_panel_content_area) as ConstraintLayout

        Truth.assertThat(content.visibility).isEqualTo(View.GONE)
    }

    @Test
    fun hideContentWhenSetCollapsed() {
        expansionPanel.isExpanded = true
        expansionPanel.isExpanded = false

        val content = expansionPanel.findViewById(R.id.ds_expansion_panel_content_area) as ConstraintLayout

        Truth.assertThat(content.visibility).isEqualTo(View.GONE)
    }

    @Test
    fun invokeListenerWhenOnClickAfterBeingExpanded() {
        var isPanelExpanded = false
        expansionPanel.setOnStateChangeListener { isPanelExpanded = it }

        val container = expansionPanel.findViewById(R.id.ds_expansion_panel_container) as View

        container.callOnClick()
        Truth.assertThat(isPanelExpanded).isTrue()

        container.callOnClick()
        Truth.assertThat(isPanelExpanded).isFalse()
    }
}
