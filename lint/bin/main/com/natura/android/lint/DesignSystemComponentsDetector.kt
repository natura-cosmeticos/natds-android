package com.natura.android.lint

import com.android.tools.lint.detector.api.LayoutDetector
import com.android.tools.lint.detector.api.LintFix
import com.android.tools.lint.detector.api.TextFormat
import com.android.tools.lint.detector.api.XmlContext
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_CARD
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_CHECKBOX
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_PROGRESS_INDICATOR
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_TEXT_FIELD
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_VIEW
import org.w3c.dom.Element

@Suppress("UnstableApiUsage")
class DesignSystemComponentsDetector : LayoutDetector() {

    companion object {
        private const val CHECK_BOX_VIEW =
            "CheckBox"

        private const val APP_COMPAT_CHECK_BOX_VIEW =
            "androidx.appcompat.widget.AppCompatCheckBox"

        private const val NAT_DS_CHECK_BOX_VIEW =
            "com.natura.android.checkbox.CheckBox"

        private const val PROGRESS_BAR_VIEW =
            "ProgressBar"

        private const val NAT_DS_PROGRESS_BAR_VIEW =
            "com.natura.android.progressindicator.ProgressIndicator"

        private const val CARD_VIEW =
            "androidx.cardview.widget.CardView"

        private const val NAT_DS_CARD_VIEW =
            "com.natura.android.card.Card"

        private const val TEXT_INPUT_LAYOUT_VIEW =
            "com.google.android.material.textfield.TextInputLayout"

        private const val NATURA_EDIT_TEXT =
            "net.natura.minegocionatura.widgets.NaturaEditText"

        private const val EDIT_TEXT_VIEW =
            "EditText"

        private const val NATURA_LOGIN_EDIT_TEXT =
            "net.natura.minegocionatura.login.widget.NaturaEditText"

        private const val APP_COMPAT_EDIT_TEXT =
            "androidx.appcompat.widget.AppCompatEditText"

        private const val VALIDATE_EDIT_TEXT =
            "net.natura.atg.core.components.ValidableEditText"

        private const val GILLSANS_EDIT_TEXT =
            "net.natura.cn.widgets.GillSansEditTextView"

        private const val NATURA_TEXT_FIELD =
            "com.natura.android.textfield.TextField"


        private val VIEW_REPLACEMENT_MAP = mapOf(
            CHECK_BOX_VIEW to NAT_DS_CHECK_BOX_VIEW,
            APP_COMPAT_CHECK_BOX_VIEW to NAT_DS_CHECK_BOX_VIEW,
            PROGRESS_BAR_VIEW to NAT_DS_PROGRESS_BAR_VIEW,
            CARD_VIEW to NAT_DS_CARD_VIEW,
            TEXT_INPUT_LAYOUT_VIEW to NATURA_TEXT_FIELD,
            NATURA_EDIT_TEXT to NATURA_TEXT_FIELD,
            EDIT_TEXT_VIEW to NATURA_TEXT_FIELD,
            NATURA_LOGIN_EDIT_TEXT to NATURA_TEXT_FIELD,
            APP_COMPAT_EDIT_TEXT to NATURA_TEXT_FIELD,
            VALIDATE_EDIT_TEXT to NATURA_TEXT_FIELD,
            GILLSANS_EDIT_TEXT to NATURA_TEXT_FIELD
        )
    }

    override fun getApplicableElements(): Collection<String> {
        return VIEW_REPLACEMENT_MAP.keys
    }

    override fun visitElement(context: XmlContext, element: Element) {
        val foundViewName = element.nodeName
        val suggestedName = VIEW_REPLACEMENT_MAP[foundViewName]
        val issue = getSuggestedIssue(suggestedName)

        context.report(
            issue = issue,
            location = context.getNameLocation(element),
            message = issue.getExplanation(TextFormat.TEXT),
            quickfixData = LintFix.create()
                .replace()
                .text(foundViewName)
                .with(suggestedName)
                .build()
        )
    }

    private fun getSuggestedIssue(name: String?) = when(name) {
        NAT_DS_CHECK_BOX_VIEW -> ISSUE_NON_DS_CHECKBOX
        NAT_DS_PROGRESS_BAR_VIEW -> ISSUE_NON_DS_PROGRESS_INDICATOR
        NAT_DS_CARD_VIEW -> ISSUE_NON_DS_CARD
        NATURA_TEXT_FIELD -> ISSUE_NON_DS_TEXT_FIELD
        else -> ISSUE_NON_DS_VIEW
    }
}