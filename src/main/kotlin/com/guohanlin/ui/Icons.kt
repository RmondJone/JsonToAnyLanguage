package com.guohanlin.ui

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object Icons {
    val yapiAction: Icon = load("/icons/action.svg")

    @JvmStatic
    fun load(path: String): Icon {
        return IconLoader.getIcon(path, Icons::class.java)
    }
}