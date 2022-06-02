package com.guohanlin.language.swift

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

/**
 * 注释：Swift 文件类型
 * 时间：2022/3/24 14:21
 * 作者：郭翰林
 */
class SwiftFileType : FileType {
    override fun getName(): String {
        return "Swift File"
    }

    override fun getDescription(): String {
        return "Swift source file"
    }

    override fun getDefaultExtension(): String {
        return ".swift"
    }

    override fun getIcon(): Icon? {
        return null
    }

    override fun isBinary(): Boolean {
        return false
    }

    override fun isReadOnly(): Boolean {
        return false
    }

    override fun getCharset(file: VirtualFile, content: ByteArray): String? {
        return null
    }
}