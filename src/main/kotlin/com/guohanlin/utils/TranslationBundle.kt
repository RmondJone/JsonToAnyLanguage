package com.guohanlin.utils

import com.intellij.AbstractBundle
import org.jetbrains.annotations.PropertyKey

const val BUNDLE = "LanguageBundle"

object TranslationBundle : AbstractBundle(BUNDLE)

/**
 * 注释：自适应语言
 * 时间：2022/5/17 4:33 下午
 * 作者：郭翰林
 */
fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any): String {
    return TranslationBundle.getMessage(key, *params)
}
