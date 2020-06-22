package com.natura.android.menu

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.natura.android.R
import kotlinx.android.synthetic.main.ds_menu_view.view.*
import kotlinx.android.synthetic.main.ds_menu_view_in_layout.view.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric

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
        val icon = layout.menuItemBase.ds_menu_icon

        assertEquals('\uEA6D', icon.text[0])
    }

    @Test
    fun checksLabelValueWhenMenuInflated() {
        val label = layout.menuItemBase.label

        assertEquals("Menu item to test", layout.menuItemBase.label)
    }
}
