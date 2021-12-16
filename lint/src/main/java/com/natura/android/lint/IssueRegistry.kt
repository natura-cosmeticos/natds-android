package com.natura.android.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.*
import java.util.EnumSet

@Suppress("UnstableApiUsage")
class IssueRegistry : IssueRegistry() {
    override val issues = listOf(
        ISSUE_NON_DS_SIZE, ISSUE_NON_DS_SPACING, ISSUE_NON_DS_COLOR,
        ISSUE_NON_DS_RADIUS, ISSUE_NON_DS_ELEVATION, ISSUE_NON_DS_TEXT_APPEARANCE,
        ISSUE_NON_DS_CHECKBOX_BUTTON, ISSUE_NON_DS_CHECKBOX, ISSUE_NON_DS_PROGRESS_INDICATOR,
        ISSUE_NON_DS_CARD, ISSUE_NON_DS_TEXT_FIELD, ISSUE_NON_DIALOG_STANDARD_VIEW
    )

    override val api: Int
        get() = CURRENT_API

    companion object {
        private const val DETAILS_LINK = "For more details, please take a look at Nat DS documentation: " +
                "https://github.com/natura-cosmeticos/natds-android/blob/master/doc/getting-started.md"

        private const val SPACING_ERROR_MESSAGE =
            "Please, use one of Design System spacing tokens. Nat DS currently supports:\n" +
                    "?spacingNone = 0dp\n" +
                    "?spacingMicro = 4dp\n" +
                    "?spacingTiny = 8dp\n" +
                    "?spacingSmall = 16dp\n" +
                    "?spacingStandard = 24dp\n" +
                    "?spacingSemi = 32dp\n" +
                    "?spacingLarge = 48dp\n" +
                    "?spacingXLarge = 64dp\n $DETAILS_LINK"

        private const val RADIUS_ERROR_MESSAGE =
            "Please, use one of Design System radius tokens. Nat DS currently supports:\n" +
                    "?borderRadiusNone = 0dp\n" +
                    "?borderRadiusSmall = 2dp\n" +
                    "?borderRadiusMedium = 4dp\n" +
                    "?borderRadiusLarge = 8dp\n $DETAILS_LINK"

        private const val SIZE_ERROR_MESSAGE =
            "Please, use one of Design System size tokens. Nat DS currently supports:\n" +
                    "?sizeNone = 0dp\n" +
                    "?sizeMicro = 4dp\n" +
                    "?sizeTiny = 8dp\n" +
                    "?sizeSmall = 16dp\n" +
                    "?sizeStandard = 24dp\n" +
                    "?sizeSemi = 32dp\n" +
                    "?sizeSemi_x = 40dp\n" +
                    "?sizeMedium = 48dp\n" +
                    "?sizeMediumX = 56dp\n" +
                    "?sizeLarge = 64dp\n" +
                    "?sizeLargeX = 72dp\n" +
                    "?sizeLargeXX = 80dp\n" +
                    "?sizeLargeXXX = 88dp\n" +
                    "?sizeHuge = 96dp\n" +
                    "?sizeHugeX = 128dp\n" +
                    "?sizeHugeXX = 144dp\n" +
                    "?sizeHugeXXX = 192dp\n" +
                    "?sizeVeryHuge= 256dp\n $DETAILS_LINK"

        private const val COLOR_ERROR_MESSAGE = "Please, use one of Design System color tokens.\n" +
                "You can search for the colors in the following link: " +
                "https://zeroheight.com/28db352be/p/3880eb-search\n $DETAILS_LINK"

        private const val ELEVATION_ERROR_MESSAGE = "Please, use one of Design System elevation tokens. Nat DS currently supports:\n" +
                "?elevationNone = 0dp\n" +
                "?elevationMicro = 1dp\n" +
                "?elevationTiny = 2dp\n" +
                "?elevationSmall = 3dp\n" +
                "?elevationMedium = 4dp\n" +
                "?elevationLarge = 6dp\n" +
                "?elevationLargeX = 8dp\n" +
                "?elevationLargeXX= 9dp\n" +
                "?elevationHuge = 12dp\n" +
                "?elevationHugeX = 16dp\n" +
                "?elevationHugeXX = 24dp\n $DETAILS_LINK"

        private const val TEXT_APPEARANCE_ERROR_MESSAGE = "Please, use one of Design System textAppearance tokens. Nat DS currently supports:\n" +
                "?textAppearanceHeadline1\n" +
                "?textAppearanceHeadline2\n" +
                "?textAppearanceHeadline3\n" +
                "?textAppearanceHeadline4\n" +
                "?textAppearanceHeadline5\n" +
                "?textAppearanceHeadline6\n" +
                "?textAppearanceSubtitle1\n" +
                "?textAppearanceSubtitle2\n" +
                "?textAppearanceBody1\n" +
                "?textAppearanceBody2\n" +
                "?textAppearanceButton\n" +
                "?textAppearanceCaption\n" +
                "?textAppearanceOverline\n $DETAILS_LINK"

        private const val VIEW_ERROR_MESSAGE = "Please, use Design System component.\n $DETAILS_LINK"

        private const val CHECK_BOX_BUTTON_ERROR_MESSAGE = "Please, use Design System CheckBox component.\n $DETAILS_LINK"

        private const val PROGRESS_BAR_ERROR_MESSAGE = "Please, use Design System ProgressIndicator component.\n $DETAILS_LINK"

        private const val CARD_ERROR_MESSAGE = "Please, use Design System Card component.\n $DETAILS_LINK"

        private const val DIALOG_ERROR_MESSAGE = "Please, use Design System Dialog Standard component.\n $DETAILS_LINK"

        private const val TEXT_FIELD_MESSAGE = "Please, use Design System TextField component.\n $DETAILS_LINK"

        private const val sizeId = "NonNatDsSize"

        val ISSUE_NON_DS_SIZE: Issue = Issue.create(
            id = sizeId,
            briefDescription = SIZE_ERROR_MESSAGE,
            explanation = SIZE_ERROR_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemTokensDetector::class.java, Scope.RESOURCE_FILE_SCOPE
            )
        )

        private const val spacingId = "NonNatDsSpacing"

        val ISSUE_NON_DS_SPACING: Issue = Issue.create(
            id = spacingId,
            briefDescription = SPACING_ERROR_MESSAGE,
            explanation = SPACING_ERROR_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemTokensDetector::class.java, Scope.RESOURCE_FILE_SCOPE
            )
        )

        private const val colorId = "NonNatDsColor"

        val ISSUE_NON_DS_COLOR: Issue = Issue.create(
            id = colorId,
            briefDescription = COLOR_ERROR_MESSAGE,
            explanation = COLOR_ERROR_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemTokensDetector::class.java, Scope.RESOURCE_FILE_SCOPE
            )
        )

        private const val radiusId = "NonNatDsRadius"

        val ISSUE_NON_DS_RADIUS: Issue = Issue.create(
            id = radiusId,
            briefDescription = RADIUS_ERROR_MESSAGE,
            explanation = RADIUS_ERROR_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemTokensDetector::class.java, Scope.RESOURCE_FILE_SCOPE
            )
        )

        private const val elevationId = "NonNatDsElevation"

        val ISSUE_NON_DS_ELEVATION: Issue = Issue.create(
            id = elevationId,
            briefDescription = ELEVATION_ERROR_MESSAGE,
            explanation = ELEVATION_ERROR_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemTokensDetector::class.java, Scope.RESOURCE_FILE_SCOPE
            )
        )

        private const val textAppearanceId = "NonNatDsTextAppearance"

        val ISSUE_NON_DS_TEXT_APPEARANCE: Issue = Issue.create(
            id = textAppearanceId,
            briefDescription = TEXT_APPEARANCE_ERROR_MESSAGE,
            explanation = TEXT_APPEARANCE_ERROR_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemTokensDetector::class.java, Scope.RESOURCE_FILE_SCOPE
            )
        )

        private const val checkboxButtonId = "NonNatDsCheckboxButton"

        val ISSUE_NON_DS_CHECKBOX_BUTTON: Issue = Issue.create(
            id = checkboxButtonId,
            briefDescription = CHECK_BOX_BUTTON_ERROR_MESSAGE,
            explanation = CHECK_BOX_BUTTON_ERROR_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemTokensDetector::class.java, Scope.RESOURCE_FILE_SCOPE
            )
        )

        private const val nonNatCheckBoxId = "NonNatDsCheckBox"

        val ISSUE_NON_DS_CHECKBOX = Issue.create(
            id = nonNatCheckBoxId,
            briefDescription = CHECK_BOX_BUTTON_ERROR_MESSAGE,
            explanation = CHECK_BOX_BUTTON_ERROR_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemComponentsDetector::class.java, Scope.RESOURCE_FILE_SCOPE
            )
        )

        private const val nonNatProgressIndicatorId = "NonNatDsProgressIndicator"

        val ISSUE_NON_DS_PROGRESS_INDICATOR = Issue.create(
            id = nonNatProgressIndicatorId,
            briefDescription = PROGRESS_BAR_ERROR_MESSAGE,
            explanation = PROGRESS_BAR_ERROR_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemComponentsDetector::class.java, Scope.RESOURCE_FILE_SCOPE
            )
        )

        private const val nonNatCardId = "NonNatDsCard"

        val ISSUE_NON_DS_CARD = Issue.create(
            id = nonNatCardId,
            briefDescription = CARD_ERROR_MESSAGE,
            explanation = CARD_ERROR_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemComponentsDetector::class.java, Scope.RESOURCE_FILE_SCOPE
            )
        )

        private const val nonNatTextFieldId = "NonNatDsTextField"

        val ISSUE_NON_DS_TEXT_FIELD = Issue.create(
            id = nonNatTextFieldId,
            briefDescription = TEXT_FIELD_MESSAGE,
            explanation = TEXT_FIELD_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemComponentsDetector::class.java, Scope.RESOURCE_FILE_SCOPE
            )
        )

        private const val nonNatViewId = "NonNatDsView"

        val ISSUE_NON_DS_VIEW = Issue.create(
            id = nonNatViewId,
            briefDescription = VIEW_ERROR_MESSAGE,
            explanation = VIEW_ERROR_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemComponentsDetector::class.java, Scope.RESOURCE_FILE_SCOPE
            )
        )

        private const val nonDialogStandardViewId = "NonNatDsDialogStandard"

        val ISSUE_NON_DIALOG_STANDARD_VIEW = Issue.create(
            id = nonDialogStandardViewId,
            briefDescription = DIALOG_ERROR_MESSAGE,
            explanation= DIALOG_ERROR_MESSAGE,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemUastDetector::class.java, EnumSet.of(Scope.JAVA_FILE)
            )
        )
    }
}