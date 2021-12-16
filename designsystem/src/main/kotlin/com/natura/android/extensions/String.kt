package com.natura.android.extensions

fun String.printInitials(): String {
    val textParts = this.split(" ").toTypedArray()
    val firstPart = textParts[0]
    val firstPartChar = firstPart[0]
    var lastPartChar = ""
    if (textParts.size > 1) {
        val lastPart = textParts[textParts.size - 1]
        lastPartChar = lastPart[0].toString()
    } else if (firstPart.length > 1) {
        lastPartChar = firstPart[1].toString()
    }
    return firstPartChar + lastPartChar.uppercase()
}
