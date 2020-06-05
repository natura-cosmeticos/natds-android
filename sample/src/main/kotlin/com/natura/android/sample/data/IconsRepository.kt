package com.natura.android.sample.data

import android.content.Context
import android.content.res.Resources
import java.io.File

class IconsRepository (val context: Context) {

    fun getIconsIdsList(): List<Int> {
        val rawIconList = getIconsNamesFromFile()
        val iconsIdsList = mutableListOf<Int>()
        for (iconName in rawIconList) {
            val iconName = "R.id.$iconName"
            iconsIdsList.add(context.resources.getIdentifier(iconName, "drawable", context.packageName))
        }
        return iconsIdsList
    }

    fun getIconsNamesFromFile(): List<String> {
        return File("icons-map.json").useLines { it.toList() }
    }
}