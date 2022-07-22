package com.natura.android.chip

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChipTest {

    private lateinit var chip: Chip
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun checkIfChipSizeIsSemi() {
        chip = buildChipWithSemiSize()

        val size = chip.size

        Truth.assertThat(size).isEqualTo(0)
    }

    @Test
    fun checkIfChipSizeIsSemiX() {
        chip = buildChipWithSemiXSize()

        val size = chip.size

        Truth.assertThat(size).isEqualTo(1)
    }

    @Test
    fun checkIfChipSizeIsMedium() {
        chip = buildChipWithMediumSize()

        val size = chip.size

        Truth.assertThat(size).isEqualTo(2)
    }

    @Test
    fun checkIfChipSizeHasNeutralColor() {
        chip = buildChipWithNeutralColor()

        val size = chip.getColorValue()

        Truth.assertThat(size).isEqualTo(0)
    }

    @Test
    fun checkIfChipSizeHasPrimaryColor() {
        chip = buildChipWithPrimaryColor()

        val size = chip.getColorValue()

        Truth.assertThat(size).isEqualTo(1)
    }

    @Test
    fun checkIfChipSizeHasSecondaryColor() {
        chip = buildChipWithSecondaryColor()

        val color = chip.getColorValue()

        Truth.assertThat(color).isEqualTo(2)
    }

    @Test
    fun checkIfHelperRightAvatarWasSet() {
        chip = buildChipWithHelperRightAvatar()

        val helperType = chip.getHelperRightTypeValue()

        Truth.assertThat(helperType).isEqualTo(2)
    }

    @Test
    fun checkIfHelperLeftAvatarWasSet() {
        chip = buildChipWithHelperLeftAvatar()

        val helperType = chip.getHelperLeftTypeValue()

        Truth.assertThat(helperType).isEqualTo(2)
    }

    @Test
    fun checkIfHelperRightIconWasSet() {
        chip = buildChipWithHelperRightIcon()

        val helperType = chip.getHelperRightTypeValue()

        Truth.assertThat(helperType).isEqualTo(1)
    }

    @Test
    fun checkIfHelperLeftIconWasSet() {
        chip = buildChipWithHelperLeftIcon()

        val helperType = chip.getHelperLeftTypeValue()

        Truth.assertThat(helperType).isEqualTo(1)
    }

    @Test
    fun checkIfChipIsDisabled() {
        chip = buildChipDisabled()

        val disabled = chip.getIsComponentEnabledValue()

        Truth.assertThat(disabled).isEqualTo(false)
    }

    @Test
    fun checkIfChipIsEnabled() {
        chip = buildChipEnabled()

        val enabled = chip.getIsComponentEnabledValue()

        Truth.assertThat(enabled).isEqualTo(true)
    }

    @Test
    fun checkIfChipIsSelected() {
        chip = buildChipSelectedTrue()

        val selected = chip.getIsComponentSelectedValue()

        Truth.assertThat(selected).isEqualTo(true)
    }

    @Test
    fun checkIfChipIsNotSelected() {
        chip = buildChipSelectedFalse()

        val selected = chip.getIsComponentSelectedValue()

        Truth.assertThat(selected).isEqualTo(false)
    }

    @Test
    fun checkIfChipHasAction() {
        chip = buildChipWithActionTrue()

        val action = chip.getHasActionValue()

        Truth.assertThat(action).isEqualTo(true)
    }

    @Test
    fun checkIfChipDontHaveAction() {
        chip = buildChipWithActionFalse()

        val action = chip.getHasActionValue()

        Truth.assertThat(action).isEqualTo(false)
    }

    private fun buildChipWithSemiSize(): Chip {
        return ChipFixture
            .aChip()
            .withSemiSize()
            .build()
    }

    private fun buildChipWithSemiXSize(): Chip {
        return ChipFixture
            .aChip()
            .withSemiXSize()
            .build()
    }

    private fun buildChipWithMediumSize(): Chip {
        return ChipFixture
            .aChip()
            .withMediumSize()
            .build()
    }

    private fun buildChipWithPrimaryColor(): Chip {
        return ChipFixture
            .aChip()
            .withColorPrimary()
            .build()
    }

    private fun buildChipWithSecondaryColor(): Chip {
        return ChipFixture
            .aChip()
            .withColorSecondary()
            .build()
    }

    private fun buildChipWithNeutralColor(): Chip {
        return ChipFixture
            .aChip()
            .withColorNeutral()
            .build()
    }

    private fun buildChipWithHelperRightAvatar(): Chip {
        return ChipFixture
            .aChip()
            .withHelperRightTypeAvatar()
            .withHelperRight()
            .build()
    }

    private fun buildChipWithHelperRightIcon(): Chip {
        return ChipFixture
            .aChip()
            .withHelperRightTypeIcon()
            .withHelperRight()
            .build()
    }

    private fun buildChipWithHelperLeftAvatar(): Chip {
        return ChipFixture
            .aChip()
            .withHelperLeftTypeAvatar()
            .withHelperLeft()
            .build()
    }

    private fun buildChipWithHelperLeftIcon(): Chip {
        return ChipFixture
            .aChip()
            .withHelperLeftTypeIcon()
            .withHelperLeft()
            .build()
    }

    private fun buildChipDisabled(): Chip {
        return ChipFixture
            .aChip()
            .withComponentDisabled()
            .build()
    }

    private fun buildChipEnabled(): Chip {
        return ChipFixture
            .aChip()
            .withComponentEnabled()
            .build()
    }

    private fun buildChipWithActionTrue(): Chip {
        return ChipFixture
            .aChip()
            .withHasActionTrue()
            .build()
    }

    private fun buildChipWithActionFalse(): Chip {
        return ChipFixture
            .aChip()
            .withHasActionFalse()
            .build()
    }

    private fun buildChipSelectedTrue(): Chip {
        return ChipFixture
            .aChip()
            .withIsComponentSelectedTrue()
            .build()
    }

    private fun buildChipSelectedFalse(): Chip {
        return ChipFixture
            .aChip()
            .withIsComponentSelectedFalse()
            .build()
    }
}
