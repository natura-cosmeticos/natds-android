package com.natura.android.rating

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.background
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AbstractComposeView

class Rating @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {

    @Composable
    override fun Content() {
        Text(text = "Hello World!")
    }
}
