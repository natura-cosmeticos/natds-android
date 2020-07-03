package com.natura.android.menu

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.natura.android.R
import kotlinx.android.synthetic.main.ds_menu_view_in_layout.view.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.Shadows.shadowOf

@RunWith(AndroidJUnit4::class)
class MenuViewTest {

    private val activityController = Robolectric.buildActivity(Activity::class.java)
    lateinit var layout: LinearLayout

    @Before
    fun setUp() {
        activityController.get().setTheme(R.style.Theme_Natura)
        layout = LayoutInflater.from(activityController.get()).inflate(R.layout.ds_menu_view_in_layout, null) as LinearLayout
    }

    @Test
    fun checksAllMenuLayoutComponents() {
        assertThat(layout.findViewById(R.id.guide_start) as View).isNotNull()
        assertThat(layout.findViewById(R.id.guide_end) as View).isNotNull()
        assertThat(layout.findViewById(R.id.guide_bottom) as View).isNotNull()
        assertThat(layout.findViewById(R.id.guide_top) as View).isNotNull()

        assertThat(layout.findViewById(R.id.ds_menu_arrow) as View).isNotNull()
        assertThat(layout.findViewById(R.id.ds_menu_icon) as View).isNotNull()
        assertThat(layout.findViewById(R.id.ds_menu_label) as View).isNotNull()
        assertThat(layout.findViewById(R.id.ds_menu_view_background) as View).isNotNull()
    }

    @Test
    fun checksIfDefaultIconIsSetWhenIconAttributeIsEmpty() {
        val icon = shadowOf(layout.menuItemBase.findViewById<AppCompatImageView>(R.id.ds_menu_icon).drawable)

        assertEquals(R.drawable.outlined_default_mockup, icon.createdFromResId)
    }

    @Test
    fun checksIfIconDrawableWasSetWhenAttributeIsFilledWithIconName() {
        val icon = shadowOf(layout.menuItemWithIcon.findViewById<AppCompatImageView>(R.id.ds_menu_icon).drawable)

        assertEquals(R.drawable.outlined_action_change, icon.createdFromResId)
    }

    @Test
    fun checksLabelValueWhenMenuInflated() {
        val label = layout.menuItemBase.label

        assertEquals("Menu item to test", label)
    }
}
