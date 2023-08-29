package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.natura.android.sample.databinding.ActivitySnackbarBinding
import com.natura.android.sample.setChosenDefaultTheme
import com.natura.android.snackbar.*

class SnackbarActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySnackbarBinding
    private var snackBarDS: SnackBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()
        super.onCreate(savedInstanceState)

        binding = ActivitySnackbarBinding.inflate(layoutInflater)

        setContentView(binding.root)

        title = "SnackBar"

        binding.btnDefaultSnackbar.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This message is showing according with default test",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar main button clicked",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON,

                )
            snackBarDS?.show()
        }
        binding.btnWithTitle.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                title = "Title",
                showTitle = true,
                message = "This message is showing according with default test",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar main button clicked",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON
            )
            snackBarDS?.show()
        }
        binding.btnWithIcon.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                title = "Title",
                showTitle = true,
                message = "This message is showing according with default test",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar main button clicked",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON,
                showIcon = true,
                iconName = "outlined-navigation-exit"
            )
            snackBarDS?.show()
        }
        binding.btnWithIconNoButton.setOnClickListener {

            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                title = "Title",
                showTitle = true,
                message = "This message is showing according with default test",
                mainButtonType = SnackbarActionButtonType.NONE,
                showIcon = true,
                iconName = "outlined-navigation-exit"
            )
            snackBarDS?.show()
        }
        binding.btnOnlyText.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This message is showing according with default test",
            )
            snackBarDS?.show()
        }

        binding.btnWithInLineButton.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This message is showing according with default test",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar main button clicked",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON,

                )
            snackBarDS?.show()
        }

        binding.btnWithBlockButton.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                title = "Title",
                showTitle = true,
                message = "This message is showing according with default test",
                mainButtonTitle = "Button with large text",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar main button clicked",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.BLOCK_BOTTON,
                showIcon = true,
                iconName = "outlined-navigation-exit"
            )
            snackBarDS?.show()
        }
        binding.btnWithIconButton.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                title = "Title",
                showTitle = true,
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
            snackBarDS?.show()
        }
        binding.btnDefaultFeedback.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This is the default snackbar feedback",
                feedbackType = SnackbarFeedbackType.DEFAULT,
                iconName = "outlined-navigation-exit"
            )
            snackBarDS?.show()
        }
        binding.btnSuccessFeedback.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This is the SUCCESS snackbar feedback",
                feedbackType = SnackbarFeedbackType.SUCCESS,
                iconName = "outlined-navigation-exit"
            )
            snackBarDS?.show()
        }
        binding.btnErrorFeedback.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This is the ERROR snackbar feedback",
                feedbackType = SnackbarFeedbackType.ERROR,
                iconName = "outlined-navigation-exit"
            )
            snackBarDS?.show()
        }
        binding.btnWarningFeedback.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This is the WARNING snackbar feedback",
                feedbackType = SnackbarFeedbackType.WARNING,
                iconName = "outlined-navigation-exit"
            )
            snackBarDS?.show()
        }
        binding.btnInfoFeedback.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This is the INFO snackbar feedback",
                feedbackType = SnackbarFeedbackType.INFO,
                iconName = "outlined-navigation-exit"
            )
            snackBarDS?.show()
        }

        binding.btnPositionCenterTop.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This is the DEFAULT snackbar feedback",
                feedbackType = SnackbarFeedbackType.DEFAULT,
                iconName = "outlined-navigation-exit",
                animation = true,
                positionType = SnackbarPositionType.TOP_CENTER,
                animationType = SnackbarAnimationtype.NONE
            )
            snackBarDS?.show()
        }

        binding.btnPositionCenterBottom.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This is the DEFAULT snackbar feedback",
                feedbackType = SnackbarFeedbackType.DEFAULT,
                iconName = "outlined-navigation-exit",
                animation = true,
                positionType = SnackbarPositionType.BOTTOM_CENTER,
                animationType = SnackbarAnimationtype.NONE
            )
            snackBarDS?.show()
        }


        binding.btnAnimationCenterTop.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This is the INFO snackbar feedback",
                feedbackType = SnackbarFeedbackType.INFO,
                iconName = "outlined-navigation-exit",
                animation = true,
                positionType = SnackbarPositionType.TOP_CENTER,
                animationType = SnackbarAnimationtype.CENTER
            )
            snackBarDS?.show()
        }

        binding.btnAnimationCenterBottom.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This is the INFO snackbar feedback",
                feedbackType = SnackbarFeedbackType.INFO,
                iconName = "outlined-navigation-exit",
                animation = true,
                positionType = SnackbarPositionType.BOTTOM_CENTER,
                animationType = SnackbarAnimationtype.CENTER
            )
            snackBarDS?.show()
        }
        binding.btnAnimationLeft.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This is the INFO snackbar feedback",
                feedbackType = SnackbarFeedbackType.INFO,
                iconName = "outlined-navigation-exit",
                animation = true,
                positionType = SnackbarPositionType.BOTTOM_CENTER,
                animationType = SnackbarAnimationtype.LEFT
            )
            snackBarDS?.show()
        }
        binding.btnAnimationRight.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "This is the INFO snackbar feedback",
                feedbackType = SnackbarFeedbackType.INFO,
                iconName = "outlined-navigation-exit",
                animation = true,
                positionType = SnackbarPositionType.TOP_CENTER,
                animationType = SnackbarAnimationtype.RIGHT
            )
            snackBarDS?.show()
        }

        binding.btnMinimumTimer.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "SnackBar showing til user interact with it",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar showing til user interact with it",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON,
                timerType = SnackbarTimerType.MINIMUM
            )
            snackBarDS?.show()
        }

        binding.btnIntermediaryTimer.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "SnackBar showing til user interact with it",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar showing til user interact with it",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON,
                timerType = SnackbarTimerType.INTERMEDIARY
            )
            snackBarDS?.show()
        }
        binding.btnIndeterminateTimer.setOnClickListener {
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "SnackBar showing til user interact with it",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"SnackBar showing til user interact with it",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON,
                timerType = SnackbarTimerType.INTERMEDIARY
            )
            snackBarDS?.show()
        }
        binding.btnCustomTimer.setOnClickListener{
            snackBarDS?.dismiss()
            snackBarDS = SnackBar(
                mainView = binding.root,
                message = "Time showing snackbar 30 seconds",
                mainButtonTitle = "Button",
                mainButtonAction = {
                    Toast.makeText(this,"Time showing snackbar 30 seconds",Toast.LENGTH_SHORT).show()
                },
                mainButtonType = SnackbarActionButtonType.INLINE_BOTTON,
                timerType = SnackbarTimerType.CUSTOM,
                customTimerMillisecondInterval = 30000
            )
            snackBarDS?.show()
        }
    }
}
