package com.natura.android.extensions

import android.os.Build
import android.widget.TextView

fun TextView.setAppearance(textAppearance: Int) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        this.setTextAppearance(context, textAppearance);
    } else {
        this.setTextAppearance(textAppearance);
    }
}