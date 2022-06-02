package com.guohanlin.utils

import com.intellij.ide.util.PropertiesComponent

/**
 * 注释：存储保存工具
 * 时间：2021/7/10 0010 15:58
 * 作者：郭翰林
 */
object SharePreferences {
    /**
     * 注释：存储Android Api代码结构模板
     * 时间：2021/7/10 0010 16:03
     * 作者：郭翰林
     */
    @JvmStatic
    fun put(key: String, value: String) {
        PropertiesComponent.getInstance()
            .setValue(key, value)
    }

    /**
     * 注释：获取Android Api代码结构模板
     * 时间：2021/7/10 0010 16:12
     * 作者：郭翰林
     */
    @JvmStatic
    fun get(key: String, default: String): String {
        return PropertiesComponent.getInstance().getValue(key) ?: default
    }
}