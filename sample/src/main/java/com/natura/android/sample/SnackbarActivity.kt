package com.natura.android.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.natura.android.sample.databinding.ActivitySnackbarBinding
import com.natura.android.snackbar.SnackbarActionButtonType
import com.natura.android.snackbar.SnackbarDS
import com.natura.android.snackbar.SnackbarFeedbackType

class SnackbarActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySnackbarBinding
    private var snackbarDS: SnackbarDS? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySnackbarBinding.inflate(layoutInflater)

        setContentView(binding.root)

        title = "SnackBar"

        binding.btnDefaultSnackbar.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = SnackbarDS(
                mainView = binding.root,
                title = "",
                message = "This message is showing according with default test",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar main button clicked",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON
            )
            snackbarDS?.show()
        }
        binding.btnWithTitle.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = SnackbarDS(
                mainView = binding.root,
                title = "Title",
                message = "This message is showing according with default test",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar main button clicked",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON
            )
            snackbarDS?.show()
        }
        binding.btnWithIcon.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = SnackbarDS(
                mainView = binding.root,
                title = "Title",
                message = "This message is showing according with default test",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar main button clicked",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON,
                showIcon = true,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }
        binding.btnWithIconNoButton.setOnClickListener {

            snackbarDS?.dismiss()
            snackbarDS = SnackbarDS(
                mainView = binding.root,
                title = "Title",
                message = "This message is showing according with default test",
                mainButtonType = SnackbarActionButtonType.NONE,
                showIcon = true,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }
        binding.btnOnlyText.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = SnackbarDS(
                mainView = binding.root,
                message = "This message is showing according with default test",
            )
            snackbarDS?.show()
        }
        binding.btnWithBlockButton.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = SnackbarDS(
                mainView = binding.root,
                title = "Title",
                message = "This message is showing according with default test",
                mainButtonTitle = "Button with large text",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar main button clicked",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.BLOCK_BOTTON,
                showIcon = true,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }
        binding.btnWithIconButton.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = SnackbarDS(
                mainView = binding.root,
                title = "Title",
                message = "This message is showing according with default test",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar main button clicked",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.ICON_BOTTON,
                iconButtonName = "outlined-navigation-exit",
                showIcon = true,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }
        binding.btnDefaultFeedback.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = SnackbarDS(
                mainView = binding.root,
                message = "This is the default snack feedback",
                feedbackType = SnackbarFeedbackType.DEFAULT,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }
        binding.btnSuccessFeedback.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = SnackbarDS(
                mainView = binding.root,
                message = "This is the SUCCESS snack feedback",
                feedbackType = SnackbarFeedbackType.SUCCESS,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }
        binding.btnErrorFeedback.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = SnackbarDS(
                mainView = binding.root,
                message = "This is the ERROR snack feedback",
                feedbackType = SnackbarFeedbackType.ERROR,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }
        binding.btnWarningFeedback.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = SnackbarDS(
                mainView = binding.root,
                message = "This is the WARNING snack feedback",
                feedbackType = SnackbarFeedbackType.WARNING,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }
        binding.btnInfoFeedback.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = SnackbarDS(
                mainView = binding.root,
                message = "This is the INFO snack feedback",
                feedbackType = SnackbarFeedbackType.INFO,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }

    }
}