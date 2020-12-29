package com.natura.android.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API

@Suppress("UnstableApiUsage")
class IssueRegistry : IssueRegistry() {
    override val issues = listOf(DesignSystemDetector.ISSUE_NON_DS_SIZE)

    override val api: Int
        get() = CURRENT_API
}