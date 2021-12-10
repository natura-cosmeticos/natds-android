package com.natura.android.lint

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.TextFormat
import com.intellij.psi.PsiType
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DIALOG_STANDARD_VIEW
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UVariable

class DesignSystemUastDetector : Detector(), Detector.UastScanner {

    companion object {
        private const val ALERT_DIALOG_VIEW = "android.app.AlertDialog"

        private const val ANDROIDX_ALERT_DIALOG_VIEW = "androidx.appcompat.app.AlertDialog"

        private const val NAT_DS_DIALOG_STANDARD_VIEW = "com.natura.android.dialog.DialogStandard"
    }

    override fun getApplicableUastTypes() =
        listOf<Class<out UElement>>(UVariable::class.java, UClass::class.java)

    override fun createUastHandler(context: JavaContext) = UastHandler(context)

    inner class UastHandler(private val context: JavaContext) : UElementHandler() {

        override fun visitVariable(node: UVariable) = process(node.type, node)

        override fun visitClass(node: UClass) = node.uastSuperTypes.forEach { process(it.type, it) }

        private fun process(type: PsiType, node: UElement) {
            val qualifiedName = context.evaluator.getTypeClass(type)?.getQualifiedName()
            val issue = getSuggestedIssue(qualifiedName)

            if (issue == null) {
                return
            }

            context.report(
                issue = issue,
                scope = node,
                location = context.getLocation(node),
                message = issue.getExplanation(TextFormat.TEXT)
            )
        }

        private fun getSuggestedIssue(name: String?) = when (name) {
            ANDROIDX_ALERT_DIALOG_VIEW, ALERT_DIALOG_VIEW -> ISSUE_NON_DIALOG_STANDARD_VIEW
            else -> null
        }
    }

}