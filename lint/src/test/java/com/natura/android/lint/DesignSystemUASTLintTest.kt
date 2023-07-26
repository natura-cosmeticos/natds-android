package com.natura.android.lint

import com.android.tools.lint.checks.infrastructure.TestFiles.java
import com.android.tools.lint.checks.infrastructure.TestFiles.kotlin
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test
import com.natura.android.lint.IssueRegistry.Companion.ISSUE_NON_DIALOG_STANDARD_VIEW

class DesignSystemUASTLintTest {
    @Test
    fun testUsingAlertDialogOnJava() {
        lint().files(
            java(
                """
            package test;
          
            import android.app.AlertDialog;
            import android.os.Bundle;
            import androidx.appcompat.app.AppCompatActivity;
            public class TestActivity extends AppCompatActivity {
            @Override protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                AlertDialog dialog = new AlertDialog.Builder(this).create();
            }
            }"""
            ).indented()
        ).issues(ISSUE_NON_DIALOG_STANDARD_VIEW)
            .run()
            .expect(
                "src/test/TestActivity.java:11: Warning: Please, use Design System Dialog Standard component.\n" +
                        " For more details, please take a look at Nat DS documentation: https://github.com/natura-cosmeticos/natds-android/blob/main/doc/getting-started.md [NonNatDsDialogStandard]\n" +
                        "    AlertDialog dialog = new AlertDialog.Builder(this).create();\n" +
                        "    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "0 errors, 1 warnings"
            )
    }

    @Test
    fun testUsingAlertDialogOnKotlin() {
        lint().files(
            kotlin(
                """
            package test
          
            import android.app.AlertDialog
            import android.os.Bundle
            import androidx.appcompat.app.AppCompatActivity
            class TestActivity : AppCompatActivity {
            override fun onCreate(savedInstanceState: Bundle) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                val dialog = AlertDialog.Builder(this).create()
            }
            }"""
            ).indented()
        ).issues(ISSUE_NON_DIALOG_STANDARD_VIEW)
            .run()
            .expect(
                "src/test/TestActivity.kt:11: Warning: Please, use Design System Dialog Standard component.\n" +
                        " For more details, please take a look at Nat DS documentation: https://github.com/natura-cosmeticos/natds-android/blob/main/doc/getting-started.md [NonNatDsDialogStandard]\n" +
                        "    val dialog = AlertDialog.Builder(this).create()\n" +
                        "    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "0 errors, 1 warnings"
            )
    }

    @Test
    fun testUsingDialogStandardOnKotlin() {
        lint().files(
            kotlin(
                """
            package test
          
            import android.content.DialogInterface
            import android.widget.Toast
            import com.natura.android.dialog.DialogStandard

          
            class TestActivity : AppCompatActivity() {

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
        
                val clickListener = DialogInterface.OnClickListener {
                        _, _ -> Toast.makeText(this, "", Toast.LENGTH_LONG).show()
                }
        
                var dialogStandard = DialogStandard(
                    this,
                    "Title",
                    "Confirm Button",
                    clickListener,
                    "Close",
                    clickListener,
                    "Dialog Text Message").create()
            }
            }"""
            )
        ).issues(ISSUE_NON_DIALOG_STANDARD_VIEW)
            .run()
            .expectClean()
    }

}