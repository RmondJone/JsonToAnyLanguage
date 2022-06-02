package com.guohanlin.ui

import com.intellij.ui.IconManager
import javax.swing.Icon

object Icons {
    val yapiAction: Icon = load("/icons/action.svg")

    @JvmStatic
    fun load(path: String): Icon {
        return IconManager.getInstance().getIcon(path, Icons::class.java)
    }
}