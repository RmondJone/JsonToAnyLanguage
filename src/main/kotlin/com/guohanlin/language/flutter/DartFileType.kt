package com.guohanlin.language.flutter

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

/**
 * 注释：Dart文件类型
 * 时间：2021/8/9 0009 16:19
 * 作者：郭翰林
 */
class DartFileType : FileType {
    override fun getCharset(p0: VirtualFile, p1: ByteArray): String? {
        return null
    }

    override fun getDefaultExtension(): String {
        return ".dart"
    }

    override fun getIcon(): Icon? {
        return null
    }

    override fun getName(): String {
        return "Dart file"

    }

    override fun getDescription(): String {
        return "Dart source file"

    }

    override fun isBinary(): Boolean {
        return false
    }

    override fun isReadOnly(): Boolean {
        return false
    }
}