package com.natura.android.exceptions

import java.lang.IllegalArgumentException

class MissingThemeException :
    IllegalArgumentException("⚠️ ⚠️ Missing DS Theme. You are using a DS component without setting a DS Theme. You MUST set a DS theme at the component or in a parent view")
