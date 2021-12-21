package com.natura.android.extensions

fun String.getInitials(): String {

    if (this.isEmpty()) {
        return "NA"
    }

    if (this.length > 3) {
        return this.substring(0, 3)
    }

    return this.substring(0, this.length)
}
