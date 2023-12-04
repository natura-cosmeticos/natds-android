package com.natura.android.extensions

fun String.getInitials(): String {

    if (this.isEmpty()) {
        return "NA"
    }

    if (this.length > 2) {
        return this.substring(0, 2)
    }

    return this.substring(0, this.length)
}
