package com.guohanlin.language.android

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

class JavaFileType : FileType {
    override fun getCharset(p0: VirtualFile, p1: ByteArray): String? {
        return null
    }

    override fun getDefaultExtension(): String {
        return ".java"
    }

    override fun getIcon(): Icon? {
        return null
    }

    override fun getName(): String {
        return "Java file"

    }

    override fun getDescription(): String {
        return "Java source file"

    }

    override fun isBinary(): Boolean {
        return false
    }

    override fun isReadOnly(): Boolean {
        return false
    }
}