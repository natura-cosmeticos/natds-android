package com.natura.android.extensions

import android.util.TypedValue

/**
 * Get an alpha value converted to base 255. Its in interesting use
 * this method when you want to access a opacity token defined at
 * theme and use it programmatically to set alpha on a component
 * that receives a value between 0 and 255 inclusive, with 0 being
 * transparent and 255 being opaque
 * @return an int with the corresponding alpha value
 */
fun TypedValue.getAlphaAsBase255(): Int {
    return (this.float * 255).toInt()
}
