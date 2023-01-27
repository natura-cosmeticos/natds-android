package com.natura.android.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.natura.android.sample.databinding.ActivitySnackbarBinding
import com.natura.android.snackbar.*

class SnackbarActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySnackbarBinding
    private var snackbarDS: Snackbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()
        super.onCreate(savedInstanceState)

        binding = ActivitySnackbarBinding.inflate(layoutInflater)

        setContentView(binding.root)

        title = "SnackBar"

        binding.btnDefaultSnackbar.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
                mainView = binding.root,
                title = "",
                message = "This message is showing according with default test",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar main button clicked",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON,

            )
            snackbarDS?.show()
        }
        binding.btnWithTitle.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
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
            snackbarDS = Snackbar(
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
            snackbarDS = Snackbar(
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
            snackbarDS = Snackbar(
                mainView = binding.root,
                message = "This message is showing according with default test",
            )
            snackbarDS?.show()
        }
        binding.btnWithBlockButton.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
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
            snackbarDS = Snackbar(
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
            snackbarDS = Snackbar(
                mainView = binding.root,
                message = "This is the default snackbar feedback",
                feedbackType = SnackbarFeedbackType.DEFAULT,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }
        binding.btnSuccessFeedback.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
                mainView = binding.root,
                message = "This is the SUCCESS snackbar feedback",
                feedbackType = SnackbarFeedbackType.SUCCESS,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }
        binding.btnErrorFeedback.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
                mainView = binding.root,
                message = "This is the ERROR snackbar feedback",
                feedbackType = SnackbarFeedbackType.ERROR,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }
        binding.btnWarningFeedback.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
                mainView = binding.root,
                message = "This is the WARNING snackbar feedback",
                feedbackType = SnackbarFeedbackType.WARNING,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }
        binding.btnInfoFeedback.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
                mainView = binding.root,
                message = "This is the INFO snackbar feedback",
                feedbackType = SnackbarFeedbackType.INFO,
                iconName = "outlined-navigation-exit"
            )
            snackbarDS?.show()
        }

        binding.btnAnimationCenterTop.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
                mainView = binding.root,
                message = "This is the INFO snackbar feedback",
                feedbackType = SnackbarFeedbackType.INFO,
                iconName = "outlined-navigation-exit",
                animation = true,
                positionType = SnackbarPositionType.TOP,
                animationType = SnackbarAnimationtype.CENTER
            )
            snackbarDS?.show()
        }

        binding.btnAnimationCenterBottom.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
                mainView = binding.root,
                message = "This is the INFO snackbar feedback",
                feedbackType = SnackbarFeedbackType.INFO,
                iconName = "outlined-navigation-exit",
                animation = true,
                positionType = SnackbarPositionType.BOTTOM,
                animationType = SnackbarAnimationtype.CENTER
            )
            snackbarDS?.show()
        }
        binding.btnAnimationLeft.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
                mainView = binding.root,
                message = "This is the INFO snackbar feedback",
                feedbackType = SnackbarFeedbackType.INFO,
                iconName = "outlined-navigation-exit",
                animation = true,
                positionType = SnackbarPositionType.BOTTOM,
                animationType = SnackbarAnimationtype.LEFT
            )
            snackbarDS?.show()
        }
        binding.btnAnimationRight.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
                mainView = binding.root,
                message = "This is the INFO snackbar feedback",
                feedbackType = SnackbarFeedbackType.INFO,
                iconName = "outlined-navigation-exit",
                animation = true,
                positionType = SnackbarPositionType.TOP,
                animationType = SnackbarAnimationtype.RIGHT
            )
            snackbarDS?.show()
        }

        binding.btnIndeterminateTimer.setOnClickListener {
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
                mainView = binding.root,
                title = "",
                message = "SnackBar showing til user interact with it",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar showing til user interact with it",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON,
                timerType = SnackbarTimerType.INDETERMINATE
                )
            snackbarDS?.show()
        }
        binding.btnCustomTimer.setOnClickListener{
            snackbarDS?.dismiss()
            snackbarDS = Snackbar(
                mainView = binding.root,
                title = "",
                message = "Time showing snackbar 30 seconds",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"Time showing snackbar 30 seconds",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON,
                timerType = SnackbarTimerType.CUSTOM,
                customTimerMillisecondInterval = 30000
            )
            snackbarDS?.show()
        }
    }
}