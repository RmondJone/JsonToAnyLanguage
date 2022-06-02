package com.guohanlin.language.android

import com.guohanlin.CodeStructure
import com.guohanlin.model.InterfaceResponseDTO
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile

/**
 * 注释：Kotlin Model层代码生成器
 * 时间：2021/9/1 0001 10:03
 * 作者：郭翰林
 */
class KotlinModelCodeStructure(
    directory: PsiDirectory,
    private val modelName: String,
    private val interfaceResponseDTO: InterfaceResponseDTO
) :
    CodeStructure(directory) {
    override fun creatCode(): String {
        var code: String = interfaceResponseDTO.info
        code = code.replaceFirst("package quicktype", "package ${getPackageName()}")
        return code
    }

    override fun updateCode(psiFile: PsiFile) {
        val document = PsiDocumentManager.getInstance(getProject()).getDocument(psiFile)
        document?.deleteString(0, document.textLength)
        var code: String = interfaceResponseDTO.info
        code = code.replaceFirst("package quicktype", "package ${getPackageName()}")
        document?.insertString(0, code)
    }

    override fun creatFileName(): String {
        return "${modelName}.kt"
    }

    override fun creatFileType(): FileType {
        return KotlinFileType()
    }
}