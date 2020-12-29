package com.natura.android.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.*

@Suppress("UnstableApiUsage")
class IssueRegistry : IssueRegistry() {
    override val issues = listOf(ISSUE_NON_DS_SIZE, ISSUE_NON_DS_COLOR)

    override val api: Int
        get() = CURRENT_API

    companion object {
        const val sizeId = "NonNatDsSize"
        private const val sizeExplanation = """
                    Using non Natura Design System size values
                    """

        val ISSUE_NON_DS_SIZE: Issue = Issue.create(
            id = sizeId,
            briefDescription = sizeExplanation,
            explanation = sizeExplanation,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemDetector::class.java, Scope.RESOURCE_FILE_SCOPE)
        )

        const val colorId = "NonNatDsColor"
        private const val colorExplanation = """
                    Using non Natura Design System color values
                    """

        val ISSUE_NON_DS_COLOR: Issue = Issue.create(
            id = colorId,
            briefDescription = colorExplanation,
            explanation = colorExplanation,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemDetector::class.java, Scope.RESOURCE_FILE_SCOPE)
        )

        const val elevationId = "NonNatDsElevation"
        private const val elevationExplanation = """
                    Using non Natura Design System elevation values
                    """

        val ISSUE_NON_DS_ELEVATION: Issue = Issue.create(
            id = elevationId,
            briefDescription = elevationExplanation,
            explanation = elevationExplanation,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemDetector::class.java, Scope.RESOURCE_FILE_SCOPE)
        )

        const val textAppearanceId = "NonNatDsTextAppearance"
        private const val textAppearanceExplanation = """
                    Using non Natura Design System Text Appearance values
                    """

        val ISSUE_NON_DS_TEXT_APPEARANCE: Issue = Issue.create(
            id = textAppearanceId,
            briefDescription = textAppearanceExplanation,
            explanation = textAppearanceExplanation,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemDetector::class.java, Scope.RESOURCE_FILE_SCOPE)
        )

        const val checkboxButtonId = "NonNatDsCheckboxButton"
        private const val checkboxButtonExplanation = """
                    Using non Natura Design System checkbox button
                    """

        val ISSUE_NON_DS_CHECKBOX_BUTTON: Issue = Issue.create(
            id = checkboxButtonId,
            briefDescription = checkboxButtonExplanation,
            explanation = checkboxButtonExplanation,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                DesignSystemDetector::class.java, Scope.RESOURCE_FILE_SCOPE)
        )
    }


}