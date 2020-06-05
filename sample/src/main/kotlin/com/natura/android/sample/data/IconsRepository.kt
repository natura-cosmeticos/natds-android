package com.natura.android.sample.data

import android.content.Context
import android.content.res.Resources
import com.natura.android.sample.R
import java.io.BufferedReader
import java.io.File

class IconsRepository (val context: Context) {

    fun getIconsIdsList(): List<Int> {
        val rawIconList = getIconsNamesFromFile()
        val iconsIdsList = mutableListOf<Int>()
        val id = R.drawable.filled_action_add
        for (iconName in rawIconList) {
            iconsIdsList.add(context.resources.getIdentifier(iconName, "drawable", context.packageName))
        }
        return iconsIdsList
    }

    fun getIconsNamesFromFile(): List<String> {
        val reader = BufferedReader(context.assets.open("icons_map.txt").bufferedReader())
        val iconsList = mutableListOf<String>()
        reader.use { reader ->
            var line = reader.readLine()
            while (line != null) {
                iconsList.add(line)
                line = reader.readLine()
            }
        }
        return iconsList
    }
}