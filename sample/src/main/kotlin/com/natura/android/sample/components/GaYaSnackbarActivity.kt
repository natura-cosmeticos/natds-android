package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.natura.android.sample.databinding.ActivityGayaSnackbarBinding
import com.natura.android.sample.setChosenDefaultTheme
import com.natura.android.snackbar.GaYaSnackbarActionButtonType
import com.natura.android.snackbar.GaYaSnackbarAnimationtype
import com.natura.android.snackbar.GaYaSnackbarColorType
import com.natura.android.snackbar.GaYaSnackbarPositionType
import com.natura.android.snackbar.GaYaSnackbarTimerType
import com.natura.android.snackbar.showGaYaSnackbar

class GaYaSnackbarActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityGayaSnackbarBinding

    var iconNameProp = "outlined-action-check"

    override fun onCreate(savedInstanceState: Bundle?) {
        setChosenDefaultTheme()
        super.onCreate(savedInstanceState)

        binding = ActivityGayaSnackbarBinding.inflate(layoutInflater)

        setContentView(binding.root)

        title = "SnackBar"

        binding.btnDefaultSnackbar.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This message is showing according with default test"
                mainButtonTitle = "Button"
                mainButtonAction = { Log.d("GaYa", "Botão clicado") }
                actionButtonType = GaYaSnackbarActionButtonType.INLINE_BOTTON
            }
        }
        binding.btnWithTitle.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                title = "Title"
                showTitle = true
                message = "This message is showing according with default test"
                mainButtonTitle = "Button"
                mainButtonAction = {  }
                actionButtonType = GaYaSnackbarActionButtonType.INLINE_BOTTON
            }
        }
        binding.btnWithIcon.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                title = "Title"
                showTitle = true
                message = "This message is showing according with default test"
                mainButtonTitle = "Button"
                mainButtonAction = {  }
                actionButtonType = GaYaSnackbarActionButtonType.INLINE_BOTTON
                showIcon = true
                iconName = iconNameProp
            }
        }
        binding.btnWithIconNoButton.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                title = "Title"
                showTitle = true
                message = "This message is showing according with default test"
                actionButtonType = GaYaSnackbarActionButtonType.NONE
                showIcon = true
                iconName = iconNameProp
            }
        }
        binding.btnOnlyText.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This message is showing according with default test"
            }
        }

        binding.btnWithInLineButton.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This message is showing according with default test"
                mainButtonTitle = "Button"
                mainButtonAction = { }
            }
        }

        binding.btnWithBlockButton.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                title = "Title"
                showTitle = true
                message = "This message is showing according with default test"
                mainButtonTitle = "Button with large text"
                mainButtonAction = { }
                actionButtonType = GaYaSnackbarActionButtonType.BLOCK_BOTTON
                showIcon = true
                iconName = iconNameProp
            }
        }
        binding.btnWithIconButton.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                title = "Title"
                showTitle = true
                message = "This message is showing according with default test"
                mainButtonTitle = "Button"
                mainButtonAction = { }
                actionButtonType = GaYaSnackbarActionButtonType.ICON_BOTTON
                iconButtonName = iconNameProp
                showIcon = true
                iconName = iconNameProp
            }
        }
        binding.btnDefaultColor.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This is the default snackbar color"
                colorType = GaYaSnackbarColorType.DEFAULT
                iconName = iconNameProp
            }
        }
        binding.btnSuccessColor.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This is the SUCCESS snackbar color"
                colorType = GaYaSnackbarColorType.SUCCESS
                title = "Meu título!"
                showTitle = true
                iconName = iconNameProp
            }
        }
        binding.btnErrorColor.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This is the ERROR snackbar color"
                colorType = GaYaSnackbarColorType.ERROR
                title = "Meu título!"
                showTitle = true
                iconName = iconNameProp
            }
        }
        binding.btnWarningColor.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This is the WARNING snackbar color"
                colorType = GaYaSnackbarColorType.WARNING
                title = "Meu título!"
                showTitle = true
                iconName = iconNameProp
            }
        }
        binding.btnInfoColor.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This is the INFO snackbar color"
                colorType = GaYaSnackbarColorType.INFO
                title = "Meu título!"
                showTitle = true
                iconName = iconNameProp
            }
        }

        binding.btnPositionCenterTop.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This is the DEFAULT snackbar color"
                colorType = GaYaSnackbarColorType.DEFAULT
                iconName = iconNameProp
                animation = true
                positionType = GaYaSnackbarPositionType.TOP_CENTER
                animationType = GaYaSnackbarAnimationtype.NONE
            }
        }

        binding.btnPositionCenterBottom.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This is the DEFAULT snackbar color"
                colorType = GaYaSnackbarColorType.DEFAULT
                iconName = iconNameProp
                animation = true
                positionType = GaYaSnackbarPositionType.BOTTOM_CENTER
                animationType = GaYaSnackbarAnimationtype.NONE
            }
        }


        binding.btnAnimationCenterTop.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This is the INFO snackbar color"
                colorType = GaYaSnackbarColorType.INFO
                iconName = iconNameProp
                animation = true
                positionType = GaYaSnackbarPositionType.TOP_CENTER
                animationType = GaYaSnackbarAnimationtype.CENTER
            }
        }

        binding.btnAnimationCenterBottom.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This is the INFO snackbar color"
                colorType = GaYaSnackbarColorType.INFO
                iconName = iconNameProp
                animation = true
                positionType = GaYaSnackbarPositionType.BOTTOM_CENTER
                animationType = GaYaSnackbarAnimationtype.CENTER
            }
        }
        binding.btnAnimationLeft.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This is the INFO snackbar color"
                colorType = GaYaSnackbarColorType.INFO
                iconName = iconNameProp
                animation = true
                positionType = GaYaSnackbarPositionType.BOTTOM_CENTER
                animationType = GaYaSnackbarAnimationtype.LEFT
            }
        }
        binding.btnAnimationRight.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "This is the INFO snackbar color"
                colorType = GaYaSnackbarColorType.INFO
                iconName = iconNameProp
                animation = true
                positionType = GaYaSnackbarPositionType.TOP_CENTER
                animationType = GaYaSnackbarAnimationtype.RIGHT
            }
        }

        binding.btnMinimumTimer.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "SnackBar showing til user interact with it"
                mainButtonTitle = "Button"
                mainButtonAction = { }
                actionButtonType = GaYaSnackbarActionButtonType.INLINE_BOTTON
                timerType = GaYaSnackbarTimerType.MINIMUM
            }
        }

        binding.btnIntermediaryTimer.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "SnackBar showing til user interact with it"
                mainButtonTitle = "Button"
                mainButtonAction = { }
                actionButtonType = GaYaSnackbarActionButtonType.INLINE_BOTTON
                timerType = GaYaSnackbarTimerType.INTERMEDIARY
            }
        }
        binding.btnIndeterminateTimer.setOnClickListener {
            showGaYaSnackbar(binding.root) {
                message = "SnackBar showing til user interact with it"
                mainButtonTitle = "Button"
                mainButtonAction = { }
                actionButtonType = GaYaSnackbarActionButtonType.INLINE_BOTTON
                timerType = GaYaSnackbarTimerType.INTERMEDIARY
            }
        }
        binding.btnCustomTimer.setOnClickListener{
            showGaYaSnackbar(binding.root) {
                message = "Time showing snackbar 30 seconds"
                mainButtonTitle = "Button"
                mainButtonAction = { }
                actionButtonType = GaYaSnackbarActionButtonType.INLINE_BOTTON
                timerType = GaYaSnackbarTimerType.CUSTOM
                customTimerMillisecondInterval = 30000
            }
        }
    }
}