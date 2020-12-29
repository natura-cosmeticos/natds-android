package com.natura.android.lint

import com.android.tools.lint.checks.infrastructure.TestFiles.xml
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import com.natura.android.lint.DesignSystemDetector.Companion.ISSUE_NON_DS_SIZE
import org.junit.Test

@Suppress("UnstableApiUsage")
class DesignSystemIssueRegistry {
    @Test
    fun testUsingMatchParentOrWrapContent() {
        lint().files(xml("res/layout/textView_test.xml", """
                <TextView
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                 />""").indented())
            .issues(ISSUE_NON_DS_SIZE)
            .run()
            .expectClean()
    }

    @Test
    fun testUsingNonDesignSystem() {
        lint().files(xml("res/layout/textView_test.xml", """
                <TextView
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="40dp"
                android:layout_height="100dp"
                 />""").indented())
            .issues(ISSUE_NON_DS_SIZE)
            .run()
            .expect("""
                res/layout/textView_test.xml:3: Warning: Please use Design System values [NonNatDsSize]
                android:layout_width="40dp"
                ~~~~~~~~~~~~~~~~~~~~
                res/layout/textView_test.xml:4: Warning: Please use Design System values [NonNatDsSize]
                android:layout_height="100dp"
                ~~~~~~~~~~~~~~~~~~~~~
                0 errors, 2 warnings
                """)
    }

}

