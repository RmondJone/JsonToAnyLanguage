package com.guohanlin.utils

import javax.swing.text.AttributeSet
import javax.swing.text.BadLocationException
import javax.swing.text.PlainDocument

/**
 * 注释：限制JTextField只能输入字母
 * 时间：2021/8/31 0031 17:58
 * 作者：郭翰林
 */
class NumberTextField(private val limit: Int) : PlainDocument() {
    @Throws(BadLocationException::class)
    override fun insertString(offset: Int, str: String, attr: AttributeSet?) {
        if (length + str.length <= limit) {
            val upper = str.toCharArray()
            var length = 0
            for (i in upper.indices) {
                //'A' - 'z'中的ascii码
                if (upper[i] in 'A'..'z') {
                    upper[length++] = upper[i]
                }
            }
            super.insertString(offset, String(upper, 0, length), attr)
        }
    }
}