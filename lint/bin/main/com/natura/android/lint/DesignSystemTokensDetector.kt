package com.natura.android.lint

import com.android.SdkConstants
import com.android.tools.lint.detector.api.*
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_CHECKBOX_BUTTON
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_COLOR
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_ELEVATION
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_SIZE
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_TEXT_APPEARANCE
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_RADIUS
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_SPACING
import org.w3c.dom.Element
import org.w3c.dom.Node

@Suppress("UnstableApiUsage")
class DesignSystemTokensDetector : ResourceXmlDetector() {

    override fun getApplicableElements(): Collection<String> {
        return XmlScannerConstants.ALL
    }

    override fun visitElement(context: XmlContext, element: Element) {
        val attributes = element.attributes

        for (i in 0 until attributes.length) {
            val item = attributes.item(i)

            when (item.localName) {
                SdkConstants.ATTR_LAYOUT_WIDTH, SdkConstants.ATTR_LAYOUT_HEIGHT -> evaluateDSSizeUsage(
                    context,
                    item
                )
                SdkConstants.ATTR_LAYOUT_MARGIN_START, SdkConstants.ATTR_LAYOUT_MARGIN_END,
                SdkConstants.ATTR_LAYOUT_MARGIN_TOP, SdkConstants.ATTR_LAYOUT_MARGIN_BOTTOM,
                SdkConstants.ATTR_LAYOUT_MARGIN, SdkConstants.ATTR_PADDING_START,
                SdkConstants.ATTR_PADDING_END, SdkConstants.ATTR_PADDING_TOP,
                SdkConstants.ATTR_PADDING_BOTTOM, SdkConstants.ATTR_PADDING -> evaluateDSSpacingUsage(
                    context,
                    item
                )
                SdkConstants.ATTR_COLOR, SdkConstants.ATTR_TINT, SdkConstants.ATTR_BACKGROUND,
                SdkConstants.ATTR_TEXT_COLOR, SdkConstants.ATTR_BACKGROUND_TINT,
                SdkConstants.ATTR_DRAWABLE_TINT -> evaluateDSColorUsage(context, item)
                SdkConstants.ATTR_ELEVATION, SdkConstants.ATTR_CARD_ELEVATION -> evaluateDSElevationUsage(
                    context,
                    item
                )
                SdkConstants.ATTR_TEXT_APPEARANCE -> evaluateDSTextAppearanceUsage(context, item)
                SdkConstants.ATTR_BUTTON -> evaluateDSCheckboxButton(context, item)
                SdkConstants.ATTR_CARD_CORNER_RADIUS, SdkConstants.ATTR_CORNER_RADIUS -> evaluateDSRadiusUsage(
                    context,
                    item
                )
            }
        }
    }

    private fun validateDesignSystemBorderRadius(value: String): Boolean =
        value.startsWith("?borderRadius")

    private fun validateDesignSystemColor(value: String): Boolean = value.startsWith("?color")

    private fun validateDesignSystemElevation(value: String): Boolean =
        value.startsWith("?elevation")

    private fun validateDesignSystemSize(value: String): Boolean = value.startsWith("?size")

    private fun validateDesignSystemSpacing(value: String): Boolean = value.startsWith("?spacing")

    private fun validateDesignSystemTextAppearance(value: String): Boolean =
        value.startsWith("?textAppearance")

    private fun evaluateDSSpacingUsage(context: XmlContext, item: Node) {
        val value = item.nodeValue
        when {
            validateDesignSystemSpacing(value) -> {
                //ignored
            }
            else -> context.report(
                ISSUE_NON_DS_SPACING,
                item,
                context.getNameLocation(item),
                ISSUE_NON_DS_SPACING.getExplanation(TextFormat.TEXT),
            )
        }
    }

    private fun evaluateDSSizeUsage(context: XmlContext, item: Node) {
        val value = item.nodeValue
        when {
            validateFixedValue(value) -> {
                //ignored
            }
            validateDesignSystemSize(value) -> {
                //ignored
            }
            else -> context.report(
                ISSUE_NON_DS_SIZE,
                item,
                context.getNameLocation(item),
                ISSUE_NON_DS_SIZE.getExplanation(TextFormat.TEXT),
            )
        }
    }

    private fun validateFixedValue(value: String): Boolean {
        return when (value) {
            "wrap_content", "match_parent", "0dp" -> true
            else -> false
        }
    }

    private fun evaluateDSRadiusUsage(context: XmlContext, item: Node) {
        val value = item.nodeValue
        when {
            validateDesignSystemBorderRadius(value) -> {
                //ignored
            }
            else -> context.report(
                ISSUE_NON_DS_RADIUS,
                item,
                context.getNameLocation(item),
                ISSUE_NON_DS_RADIUS.getExplanation(TextFormat.TEXT),
            )
        }
    }

    private fun evaluateDSColorUsage(context: XmlContext, item: Node) {
        val value = item.nodeValue
        when {
            validateDesignSystemColor(value) -> {
                //ignored
            }
            else -> context.report(
                ISSUE_NON_DS_COLOR,
                item,
                context.getNameLocation(item),
                ISSUE_NON_DS_COLOR.getExplanation(TextFormat.TEXT),
            )
        }
    }

    private fun evaluateDSElevationUsage(context: XmlContext, item: Node) {
        val value = item.nodeValue
        when {
            validateDesignSystemElevation(value) -> {
                //ignored
            }
            else -> context.report(
                ISSUE_NON_DS_ELEVATION,
                item,
                context.getNameLocation(item),
                ISSUE_NON_DS_ELEVATION.getExplanation(TextFormat.TEXT),
            )
        }
    }

    private fun evaluateDSTextAppearanceUsage(context: XmlContext, item: Node) {
        val value = item.nodeValue
        when {
            validateDesignSystemTextAppearance(value) -> {
                //ignored
            }
            else -> context.report(
                ISSUE_NON_DS_TEXT_APPEARANCE,
                item,
                context.getNameLocation(item),
                ISSUE_NON_DS_TEXT_APPEARANCE.getExplanation(TextFormat.TEXT),
            )
        }
    }

    private fun evaluateDSCheckboxButton(context: XmlContext, item: Node) {
        context.report(
            ISSUE_NON_DS_CHECKBOX_BUTTON,
            item,
            context.getNameLocation(item),
            ISSUE_NON_DS_CHECKBOX_BUTTON.getExplanation(TextFormat.TEXT),
        )
    }
}