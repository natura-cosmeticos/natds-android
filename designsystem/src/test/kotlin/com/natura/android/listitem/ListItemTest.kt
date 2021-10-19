package com.natura.android.listitem

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListItemTest {
    private lateinit var listItem: ListItem
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checksIfListItemWithDividerFullbleedWasSet() {
        listItem = buildListItemWithDividerFullbleed()

        val divider = listItem.getDivider()

        Truth.assertThat(divider).isEqualTo(1)
    }

    @Test
    fun checksIfListItemWithDividerInsetWasSet() {
        listItem = buildListItemWithDividerInset()

        val divider = listItem.getDivider()

        Truth.assertThat(divider).isEqualTo(2)
    }

    @Test
    fun checksIfListItemWithDividerMiddleWasSet() {
        listItem = buildListItemWithDividerMiddle()

        val divider = listItem.getDivider()

        Truth.assertThat(divider).isEqualTo(3)
    }

    @Test
    fun checksIfItemTouchedIsTrue() {
        listItem = buildListItemWithTouchStateTrue()

        val touchState = listItem.getTouchState()

        Truth.assertThat(touchState).isTrue()
    }

    @Test
    fun checksIfItemTouchedIsFalse() {
        listItem = buildListItemWithTouchStateFalse()

        val touchState = listItem.getTouchState()

        Truth.assertThat(touchState).isFalse()
    }

    @Test
    fun checksIfSelectableIsTrue() {
        listItem = buildListItemWithSelectableTrue()

        val selectableState = listItem.getSelectableState()

        Truth.assertThat(selectableState).isTrue()
    }

    @Test
    fun checksIfSelectableIsFalse() {
        listItem = buildListItemWithSelectableFalse()

        val selectableState = listItem.getSelectableState()

        Truth.assertThat(selectableState).isFalse()
    }

    private fun buildListItemWithDividerFullbleed(): ListItem {
        return ListItemFixture
            .aListItem()
            .withDividerFullbleed()
            .build()
    }

    private fun buildListItemWithDividerInset(): ListItem {
        return ListItemFixture
            .aListItem()
            .withDividerInset()
            .build()
    }

    private fun buildListItemWithDividerMiddle(): ListItem {
        return ListItemFixture
            .aListItem()
            .withDividerMiddle()
            .build()
    }

    private fun buildListItemWithTouchStateTrue(): ListItem {
        return ListItemFixture
            .aListItem()
            .withTouchState(true)
            .build()
    }

    private fun buildListItemWithTouchStateFalse(): ListItem {
        return ListItemFixture
            .aListItem()
            .withTouchState(false)
            .build()
    }

    private fun buildListItemWithSelectableTrue(): ListItem {
        return ListItemFixture
            .aListItem()
            .withSelectableState(true)
            .build()
    }

    private fun buildListItemWithSelectableFalse(): ListItem {
        return ListItemFixture
            .aListItem()
            .withSelectableState(false)
            .build()
    }
}
