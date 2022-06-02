package com.guohanlin.utils

import org.jetbrains.annotations.PropertyKey

const val BUNDLE = "LanguageBundle"

object TranslationBundle : MyDynamicBundle(BUNDLE)

/**
 * 注释：自适应语言
 * 时间：2022/5/17 4:33 下午
 * 作者：郭翰林
 */
fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any): String {
    return TranslationBundle.getMessage(key, *params)
}

/**
 * 注释：使用英语
 * 时间：2022/5/17 4:33 下午
 * 作者：郭翰林
 */
fun adaptedMessage(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any): String {
    return TranslationBundle.getAdaptedMessage(key, *params)
}