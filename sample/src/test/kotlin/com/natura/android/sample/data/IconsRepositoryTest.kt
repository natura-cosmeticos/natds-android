package com.natura.android.sample.data

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IconsRepositoryTest {

    private lateinit var iconsRepository: IconsRepository

    @Before
    fun setUp() {
        iconsRepository = IconsRepository(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun checksIfIconsListHasTheRightSize() {
        val iconsList = iconsRepository.getIconsNamesFromFile()

        assertEquals(275, iconsList.size)
    }
}
