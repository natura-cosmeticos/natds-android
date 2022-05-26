package com.natura.android.sample.components

import android.content.DialogInterface
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.natura.android.dialog.DialogAlert
import com.natura.android.dialog.DialogStandard
import com.natura.android.dialog.DialogStandardFragment
import com.natura.android.dialog.DialogStandardFragmentCallback
import com.natura.android.sample.R
import com.natura.android.sample.databinding.ActivityDialogBinding
import com.natura.android.sample.setChosenDefaultTheme

class DialogActivity : AppCompatActivity(), DialogStandardFragmentCallback {
    private lateinit var standardDialog: DialogStandard
    private lateinit var standardDialogVerticalButtons: DialogStandard
    private lateinit var standardDialogHeaderIconButtons: DialogStandard
    private lateinit var standardDialogMaxHeight: DialogStandard
    private lateinit var standardDialogCustomView: DialogStandard
    private lateinit var standardDialogWithDivider: DialogStandard
    private lateinit var standardDialogWithOutlinedButton: DialogStandard
    private lateinit var dialogNoDismissable: DialogStandard

    private lateinit var alertDialog: DialogAlert
    private lateinit var binding: ActivityDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()
        super.onCreate(savedInstanceState)

        binding = ActivityDialogBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.title = "Dialog"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        createStandardDialog()
        createAlertDialog()
        createStandardDialogWithLongTitleButton()
        createStandardDialogWithMaxHeight()
        createStandardDialogWithHeaderIconButtons()
        createStandardDialogWithCustomView()
        createStandardDialogWithDivider()
        createNoDismissableStandardDialog()
        createStandardDialogWithOutlinedButton()

        binding.standardDialogButton.setOnClickListener {
            standardDialog.show()
        }

        binding.alertDialogButton.setOnClickListener {
            alertDialog.show()
        }

        binding.standardDialogVerticalButtonsButton.setOnClickListener {
            standardDialogVerticalButtons.show()
        }

        binding.standardDialogMaxHeightButton.setOnClickListener {
            standardDialogMaxHeight.show()
        }

        binding.standardDialogCustomViewButton.setOnClickListener {
            standardDialogCustomView.show()
        }

        binding.standardDialogWithDividerButton.setOnClickListener {
            standardDialogWithDivider.show()
        }

        binding.standardDialogHeaderIconButtonsButton.setOnClickListener {
            standardDialogHeaderIconButtons.show()
        }

        binding.dialogNoDismissableButton.setOnClickListener {
            dialogNoDismissable.show()
        }

        binding.standardDialogWithOutlinedButton.setOnClickListener {
            standardDialogWithOutlinedButton.show()
        }

        binding.standardFragmentButton.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            val alertDialog: DialogStandardFragment =
                DialogStandardFragment.newInstance("Some title", "Some text", "OK", "Cancel")
            alertDialog.show(fragmentManager, "DialogFragment")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    private fun createAlertDialog() {
        val mainClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Main Action",
                Toast.LENGTH_LONG
            ).show()
        }
        val secondaryClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Secondary Action",
                Toast.LENGTH_LONG
            ).show()
        }

        alertDialog = DialogAlert(
            this,
            "Confirm Button",
            mainClickListener,
            "Close",
            secondaryClickListener,
            "Long text that should be substitied for some alert text. This might actually take two lines or more"
        ).create()
    }

    private fun createStandardDialogWithHeaderIconButtons() {
        val mainClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Main Action",
                Toast.LENGTH_LONG
            ).show()
        }
        val secondaryClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Secondary Action",
                Toast.LENGTH_LONG
            ).show()
        }

        val firstHeaderAction = View.OnClickListener {
            Toast.makeText(this, "Dialog Header Icon Action", Toast.LENGTH_LONG).show()
        }
        val secondHeaderAction = View.OnClickListener {
            Toast.makeText(this, "Dialog Header Icon Action", Toast.LENGTH_LONG).show()
        }
        val thirdHeaderAction = View.OnClickListener {
            Toast.makeText(this, "Dialog Header Icon Action", Toast.LENGTH_LONG).show()
        }

        standardDialogHeaderIconButtons = DialogStandard(
            this,
            "Title",
            "Confirm Button",
            mainClickListener,
            "Close",
            secondaryClickListener,
            "Long text that should be substitied for some dialog text. This might actually take two lines or more",
            true,
            null,
            false,
            0,
            "outlined-action-mic",
            firstHeaderAction,
            "outlined-action-add",
            secondHeaderAction,
            "outlined-action-cancel",
            thirdHeaderAction
        ).create()
    }

    private fun createStandardDialog() {
        val mainClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Main Action",
                Toast.LENGTH_LONG
            ).show()
        }
        val secondaryClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Secondary Action",
                Toast.LENGTH_LONG
            ).show()
        }

        standardDialog = DialogStandard(
            this,
            "Title",
            "Confirm Button",
            mainClickListener,
            "Close",
            secondaryClickListener,
            "Long text that should be substitied for some dialog text. This might actually take two lines or more",
            true
        ).create()
    }

    private fun createStandardDialogWithLongTitleButton() {
        val mainClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Main Action",
                Toast.LENGTH_LONG
            ).show()
        }
        val secondaryClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Secondary Action",
                Toast.LENGTH_LONG
            ).show()
        }

        standardDialogVerticalButtons = DialogStandard(
            this,
            "Title",
            "This button is a long title",
            mainClickListener,
            "Close",
            secondaryClickListener,
            "Long text that should be substitied for some dialog text. This might actually take two lines or more",
            true
        ).create()
    }

    private fun createStandardDialogWithMaxHeight() {
        val mainClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Main Action",
                Toast.LENGTH_LONG
            ).show()
        }
        val secondaryClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Secondary Action",
                Toast.LENGTH_LONG
            ).show()
        }

        standardDialogMaxHeight = DialogStandard(
            this,
            "Title",
            "Confirm",
            mainClickListener,
            "Close",
            secondaryClickListener,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Commodo nulla facilisi nullam vehicula ipsum a arcu cursus vitae. Imperdiet nulla malesuada pellentesque elit eget gravida. Convallis tellus id interdum velit laoreet id donec. Id interdum velit laoreet id. Eget gravida cum sociis natoque penatibus et. Felis bibendum ut tristique et egestas quis ipsum suspendisse. Sodales ut etiam sit amet nisl purus in. Egestas dui id ornare arcu odio ut. Pellentesque id nibh tortor id aliquet lectus proin. Egestas dui id ornare arcu odio ut sem nulla pharetra. Pulvinar proin gravida hendrerit lectus a. Sapien pellentesque habitant morbi tristique senectus et. Facilisis leo vel fringilla est ullamcorper eget nulla. Egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate. Egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate. Egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate.",
            true
        ).create()
    }

    private fun createStandardDialogWithOutlinedButton() {
        val mainClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Main Action",
                Toast.LENGTH_LONG
            ).show()
        }
        standardDialogWithOutlinedButton = DialogStandard(
            this,
            "Title",
            "Confirm Button",
            mainClickListener,
            "Close",
            null,
            "Long text that should be substitied for some dialog text. This might actually take two lines or more",
            true,
            null,
            true,
            DialogStandard.OUTLINED
        ).create()
    }

    private fun createStandardDialogWithCustomView() {
        val mainClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Main Action",
                Toast.LENGTH_LONG
            ).show()
        }
        val secondaryClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Secondary Action",
                Toast.LENGTH_LONG
            ).show()
        }

        standardDialogCustomView = DialogStandard(
            this,
            "Title",
            "Confirm",
            mainClickListener,
            "Close",
            secondaryClickListener,
            R.layout.dialog_standard_custom_view,
            true
        ).create()
    }

    private fun createStandardDialogWithDivider() {
        val mainClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Main Action",
                Toast.LENGTH_LONG
            ).show()
        }
        val secondaryClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Secondary Action",
                Toast.LENGTH_LONG
            ).show()
        }

        val firstHeaderAction = View.OnClickListener {
            Toast.makeText(this, "Dialog Header Icon Action", Toast.LENGTH_LONG).show()
        }
        val secondHeaderAction = View.OnClickListener {
            Toast.makeText(this, "Dialog Header Icon Action", Toast.LENGTH_LONG).show()
        }
        val thirdHeaderAction = View.OnClickListener {
            Toast.makeText(this, "Dialog Header Icon Action", Toast.LENGTH_LONG).show()
        }

        standardDialogWithDivider = DialogStandard(
            this,
            "Title",
            "Confirm Button",
            mainClickListener,
            "Close",
            secondaryClickListener,
            "Long text that should be substitied for some dialog text. This might actually take two lines or more",
            true,
            null,
            true,
            DialogStandard.DEFAULT,
            "outlined-action-mic",
            firstHeaderAction,
            "outlined-action-add",
            secondHeaderAction,
            "outlined-action-cancel",
            thirdHeaderAction
        ).create()
    }

    private fun createNoDismissableStandardDialog() {
        val mainClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Main Action",
                Toast.LENGTH_LONG
            ).show()
        }
        val secondaryClickListener = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(
                this,
                "Dialog Secondary Action",
                Toast.LENGTH_LONG
            ).show()
        }

        dialogNoDismissable = DialogStandard(
            this,
            "Title",
            "Confirm Button",
            mainClickListener,
            "Close",
            secondaryClickListener,
            "Long text that should be substitied for some dialog text. This might actually take two lines or more",
            false
        ).create()
    }

    override fun onMainButtonClick() {
        Toast.makeText(
            this,
            "Dialog Main Action",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onSecondaryButtonClick() {
        Toast.makeText(
            this,
            "Dialog Secondary Action",
            Toast.LENGTH_LONG
        ).show()
    }
}
