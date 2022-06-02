package com.guohanlin

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.impl.file.PsiDirectoryFactory

/**
 * 注释：代码构造器
 * 时间：2021/5/27 0027 18:15
 * 作者：郭翰林
 */
abstract class CodeStructure(
    private val directory: PsiDirectory,
) {
    /**
     * 默认空格
     */
    var defaultSpace = " "

    /**
     * 分割行
     */
    var lineSeparator = "\n"

    /**
     * 注释：创建代码
     * 时间：2021/5/27 0027 18:16
     * 作者：郭翰林
     */
    abstract fun creatCode(): String

    /**
     * 注释：更新代码
     * 时间：2021/6/12 0012 21:48
     * 作者：郭翰林
     */
    open fun updateCode(psiFile: PsiFile) {}

    /**
     * 注释：创建文件名称
     * 时间：2021/5/31 0031 11:26
     * 作者：郭翰林
     */
    abstract fun creatFileName(): String

    /**
     * 注释：创建文件类型
     * 时间：2021/5/31 0031 11:27
     * 作者：郭翰林
     */
    abstract fun creatFileType(): FileType

    /**
     * 注释：获得Psi文件
     * 时间：2021/6/2 0002 10:21
     * 作者：郭翰林
     */
    fun getFile(): PsiFile? {
        val psiFileFactory = PsiFileFactory.getInstance(directory.project)
        if (psiFileFactory != null) {
            return psiFileFactory.createFileFromText(creatFileName(), creatFileType(), creatCode())
        }
        return null
    }

    /**
     * 注释：获取包名
     * 时间：2021/5/27 0027 18:17
     * 作者：郭翰林
     */
    fun getPackageName(): String {
        val directoryFactory = PsiDirectoryFactory.getInstance(directory.project)
        //当前包名
        return directoryFactory.getQualifiedName(directory, false)
    }

    /**
     * 注释：获取当前Project
     * 时间：2021/5/27 0027 18:27
     * 作者：郭翰林
     */
    fun getProject(): Project {
        return directory.project
    }
}