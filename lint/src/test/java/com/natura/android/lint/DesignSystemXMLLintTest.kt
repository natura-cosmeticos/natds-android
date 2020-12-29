package com.natura.android.lint

import com.android.tools.lint.checks.infrastructure.TestFiles.xml
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import com.natura.android.lint.DesignSystemDetector.Companion.errorMessage
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_CHECKBOX_BUTTON
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_COLOR
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_ELEVATION
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_SIZE
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DS_TEXT_APPEARANCE
import com.natura.android.lint.IssueRegistry.Companion.checkboxButtonId
import com.natura.android.lint.IssueRegistry.Companion.colorId
import com.natura.android.lint.IssueRegistry.Companion.elevationId
import com.natura.android.lint.IssueRegistry.Companion.sizeId
import com.natura.android.lint.IssueRegistry.Companion.textAppearanceId
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
    fun testUsingNonDesignSystemSize() {
        lint().files(xml("res/layout/textView_test.xml", """
                <TextView
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="40dp"
                android:layout_height="100dp"
                 />""").indented())
            .issues(ISSUE_NON_DS_SIZE)
            .run()
            .expectWarningCount(2)
    }

    @Test
    fun testUsingNonDesignSystemColor() {
        lint().files(xml("res/layout/textView_test.xml", """
                <TextView
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textColor="#FFFFFF"
                 />""").indented())
            .issues(ISSUE_NON_DS_COLOR)
            .run()
            .expectWarningCount(1)
    }

    @Test
    fun testUsingDesignSystemColor() {
        lint().files(xml("res/layout/textView_test.xml", """
                <TextView
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textColor="?colorBackground"
                 />""").indented())
            .issues(ISSUE_NON_DS_COLOR)
            .run()
            .expectClean()
    }

    @Test
    fun testUsingNonDesignSystemElevation() {
        lint().files(xml("res/layout/textView_test.xml", """
                <TextView
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:elevation="1dp"
                 />""").indented())
            .issues(ISSUE_NON_DS_ELEVATION)
            .run()
            .expectWarningCount(1)
    }

    @Test
    fun testUsingDesignSystemElevation() {
        lint().files(xml("res/layout/textView_test.xml", """
                <TextView
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:elevation="?elevation00"
                 />""").indented())
            .issues(ISSUE_NON_DS_ELEVATION)
            .run()
            .expectClean()
    }

    @Test
    fun testUsingNonDesignSystemTextAppearance() {
        lint().files(xml("res/layout/textView_test.xml", """
                <TextView
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textAppearance="@style/newStyle"
                 />""").indented())
            .allowCompilationErrors()
            .issues(ISSUE_NON_DS_TEXT_APPEARANCE)
            .run()
            .expectWarningCount(1)
    }

    @Test
    fun testUsingDesignSystemTextAppearance() {
        lint().files(xml("res/layout/textView_test.xml", """
                <TextView
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textAppearance="?textAppearanceBody1"
                 />""").indented())
            .issues(ISSUE_NON_DS_TEXT_APPEARANCE)
            .run()
            .expectClean()
    }

    @Test
    fun testUsingNonDesignSystemCheckboxButton() {
        lint().files(xml("res/layout/textView_test.xml", """
                <TextView
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:button="@drawable/radio_button_selector"
                 />""").indented())
            .allowCompilationErrors()
            .issues(ISSUE_NON_DS_CHECKBOX_BUTTON)
            .run()
            .expectWarningCount(1)
    }


    @Test
    fun testUsingDesignSystemCheckBoxButton() {
        lint().files(xml("res/layout/textView_test.xml", """
                <CheckBox
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                 />""").indented())
            .issues(ISSUE_NON_DS_CHECKBOX_BUTTON)
            .run()
            .expectClean()
    }

}

