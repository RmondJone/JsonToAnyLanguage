package com.guohanlin.language.react

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

/**
 * 注释：React 文件类型
 * 时间：2022/3/24 14:21
 * 作者：郭翰林
 */
class ReactFileType : FileType {
    override fun getName(): String {
        return "React File"
    }

    override fun getDescription(): String {
        return "React source file"
    }

    override fun getDefaultExtension(): String {
        return ".ts"
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