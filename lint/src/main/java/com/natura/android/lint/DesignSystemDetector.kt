package com.natura.android.lint

import com.android.tools.lint.detector.api.*
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_CHECKBOX_BUTTON
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_COLOR
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_ELEVATION
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_SIZE
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_TEXT_APPEARANCE
import org.w3c.dom.Element
import org.w3c.dom.Node

@Suppress("UnstableApiUsage")
class DesignSystemDetector : ResourceXmlDetector() {
    companion object {
        const val errorMessage = "Please use Design System values"
    }

    override fun getApplicableElements(): Collection<String> {
        return listOf("CheckBox", "TextView")
    }

    override fun visitElement(context: XmlContext, element: Element) {
        val attributes = element.attributes

        for (i in 0 until attributes.length) {
            val item = attributes.item(i)

            when (item.localName) {
                "layout_width", "layout_height" -> evaluateDSSizeUsage(context, item)
                "color", "background", "textColor" -> evaluateDSColorUsage(context, item)
                "elevation" -> evaluateDSElevationUsage(context, item)
                "textAppearance" -> evaluateDSTextAppearanceUsage(context, item)
                "button" -> evaluateDSCheckboxButton(context, item)
            }
        }
    }

    private fun evaluateDSSizeUsage(context: XmlContext, item: Node) {
        val value = item.nodeValue
        when {
            validateFixedValue(value) -> {
            }
            validateDesignSystem(value) -> {
            }
            else -> context.report(
                ISSUE_NON_DS_SIZE,
                item,
                context.getNameLocation(item),
                errorMessage,
            )
        }
    }

    private fun validateFixedValue(value: String): Boolean {
        return when (value) {
            "wrap_content", "match_parent", "0dp" -> true
            else -> false
        }
    }

    private fun validateDesignSystem(value: String): Boolean {
        return value.startsWith("?")
    }

    private fun evaluateDSColorUsage(context: XmlContext, item: Node) {
        val value = item.nodeValue
        when {
            validateDesignSystem(value) -> {
            }
            else -> context.report(
                ISSUE_NON_DS_COLOR,
                item,
                context.getNameLocation(item),
                errorMessage,
            )
        }
    }

    private fun evaluateDSElevationUsage(context: XmlContext, item: Node) {
        val value = item.nodeValue
        when {
            validateDesignSystem(value) -> { }
            else -> context.report(
                ISSUE_NON_DS_ELEVATION,
                item,
                context.getNameLocation(item),
                errorMessage,
            )
        }
    }

    private fun evaluateDSTextAppearanceUsage(context: XmlContext, item: Node) {
        val value = item.nodeValue
        when {
            validateDesignSystem(value) -> { }
            else -> context.report(
                ISSUE_NON_DS_TEXT_APPEARANCE,
                item,
                context.getNameLocation(item),
                errorMessage,
            )
        }
    }

    private fun evaluateDSCheckboxButton(context: XmlContext, item: Node) {
        context.report(
            ISSUE_NON_DS_CHECKBOX_BUTTON,
            item,
            context.getNameLocation(item),
            errorMessage,
        )
    }



}