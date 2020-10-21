package com.natura.android.sample.data

import android.content.Context
import java.io.BufferedReader

class IconsRepository(private val context: Context) {

    fun getIconsIdsList(): List<Int> {
        val rawIconList = getIconsNamesFromFile()
        val iconsIdsList = mutableListOf<Int>()
        for (iconName in rawIconList) {
            iconsIdsList.add(context.resources.getIdentifier(iconName, "drawable", context.packageName))
        }
        return iconsIdsList
    }

    fun getIconsNamesFromFile(): List<String> {
        val reader = BufferedReader(context.assets.open("icons_map.txt").bufferedReader())
        val iconsList = mutableListOf<String>()
        reader.use { fileReader ->
            var line = fileReader.readLine()
            while (line != null) {
                iconsList.add(line)
                line = fileReader.readLine()
            }
        }
        return iconsList
    }
}
