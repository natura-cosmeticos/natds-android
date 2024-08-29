package com.natura.android.exceptions

import java.lang.IllegalArgumentException

class MissingThemeException :
    IllegalArgumentException("⚠️ ⚠️ GaYaIssue: Missing GaYa Theme. You are using a GaYa component without setting a GaYa Theme. You MUST set a GaYa theme at the component or in a parent view")
