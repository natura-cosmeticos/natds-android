package com.natura.android.lint

import com.android.tools.lint.detector.api.*
import org.w3c.dom.Element

@Suppress("UnstableApiUsage")
class DesignSystemDetector : ResourceXmlDetector() {

    override fun getApplicableElements(): Collection<String>? {
        return XmlScannerConstants.ALL
    }

    override fun visitElement(context: XmlContext, element: Element) {
        val attributes = element.attributes

        for (i in 0 until attributes.length) {
            val item = attributes.item(i)

            val usesDS = when (item.localName) {
                "layout_width", "layout_height" -> evaluateDSSizeUsage(item.nodeValue)
                else -> true
            }
            if (!usesDS) {
                context.report(
                    ISSUE_NON_DS_SIZE,
                    item,
                    context.getNameLocation(item),
                    "Please use Design System values"
                )
            }
        }
    }

    private fun evaluateDSSizeUsage(value: String): Boolean {
        //TODO: use regex (or maybe get design system variables?
        return when(value) {
            "wrap_content", "match_parent", "0dp" -> true
            else -> false
        }
    }

    companion object {
        @JvmField
        val ISSUE_NON_DS_SIZE: Issue = Issue.create(
                id = "NonNatDsSize",
                briefDescription = "Non NatDs Size",
                explanation = """
                    Using non Natura Design System size values
                    """,
                category = Category.CORRECTNESS,
                priority = 6,
                severity = Severity.WARNING,
                implementation = Implementation(
                        DesignSystemDetector::class.java, Scope.RESOURCE_FILE_SCOPE))
    }
}