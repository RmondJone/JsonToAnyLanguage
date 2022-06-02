package com.guohanlin.utils

import com.alibaba.fastjson.JSON
import org.apache.http.util.TextUtils

/**
 * 注释：字符串工具
 * 时间：2020/5/27 0027 14:07
 * 作者：郭翰林
 */
object StringUtils {
    /**
     * 注释：判断是否是空字符串
     * 时间：2022/5/17 2:25 下午
     * 作者：郭翰林
     */
    fun isEmpty(s: String?): Boolean {
        return s == null || s.isEmpty()
    }

    /**
     * 注释：是否是JSON字符串
     * 时间：2022/5/17 2:57 下午
     * 作者：郭翰林
     */
    fun isJSON(str: String?): Boolean {
        var result = false
        result = try {
            val obj: Any = JSON.parse(str)
            true
        } catch (e: Exception) {
            false
        }
        return result
    }

    /**
     * 注释：转化驼峰写法（首字母大写）
     * 时间：2020/5/27 0027 14:26
     * 作者：郭翰林
     *
     * @param text
     * @return
     */
    fun captureStringLeaveUnderscore(text: String): String {
        if (TextUtils.isEmpty(text)) {
            return text
        }
        val strings = text.split("_").toTypedArray()
        val stringBuilder = StringBuilder()
        stringBuilder.append(captureName(strings[0]))
        for (i in 1 until strings.size) {
            stringBuilder.append(captureName(strings[i]))
        }
        return stringBuilder.toString()
    }

    /**
     * 注释：驼峰转下划线写法
     * 时间：2021/8/31 0031 20:37
     * 作者：郭翰林
     */
    fun humpToUnderscore(text: String, isNeedLowerCase: Boolean): String {
        if (TextUtils.isEmpty(text)) {
            return text
        }
        val stringBuilder = StringBuilder()
        val charArray = text.toCharArray()
        for (index in charArray.indices) {
            val char = charArray[index]
            if (Character.isUpperCase(char) && index != 0) {
                stringBuilder.append("_")
            }
            if (isNeedLowerCase) {
                stringBuilder.append(char.toLowerCase())
            } else {
                stringBuilder.append(char)
            }
        }
        return stringBuilder.toString()
    }

    /**
     * 注释：第一个字母大写
     * 时间：2020/5/27 0027 15:09
     * 作者：郭翰林
     *
     * @param text
     * @return
     */
    @JvmStatic
    fun captureName(text: String): String {
        var text = text
        if (text.length > 0) {
            text = text.substring(0, 1).toUpperCase() + text.substring(1)
        }
        return text
    }

    /**
     * 注释：重复字符串多少次
     * 时间：2020/5/27 0027 14:07
     * 作者：郭翰林
     *
     * @param repeat
     * @param number
     * @return
     */
    @JvmStatic
    fun repeatStr(repeat: String?, number: Int): String {
        val stringBuilder = StringBuilder()
        for (i in 0 until number) {
            stringBuilder.append(repeat)
        }
        return stringBuilder.toString()
    }

    /**
     * 注释：字符串函数对齐
     * 时间：2021/7/11 0011 14:09
     * 作者：郭翰林
     */
    @JvmStatic
    fun functionSpace(source: String, number: Int): String {
        val functionLines = source.split("\n")
        val stringBuilder = StringBuilder()
        for (line in functionLines) {
            stringBuilder.append("${repeatStr(" ", number)}${line}\n")
        }
        return "\n${repeatStr(" ", number)}${stringBuilder.toString().trimStart().trimEnd()}"
    }

}