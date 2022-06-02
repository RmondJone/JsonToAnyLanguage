package com.guohanlin.language.react

import com.guohanlin.CodeStructure
import com.guohanlin.model.InterfaceResponseDTO
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile

/**
 * 注释：React 实体生成构造器
 * 时间：2022/3/24 14:28
 * 作者：郭翰林
 */
class ReactModelCodeStructure(
    directory: PsiDirectory,
    modelName: String,
    interfaceResponseDTO: InterfaceResponseDTO
) : CodeStructure(directory) {
    private var fileName: String = modelName
    private var codeStr: String = interfaceResponseDTO.info

    override fun creatCode(): String {
        return codeStr
    }

    override fun creatFileName(): String {
        return "${fileName}.ts"
    }

    override fun updateCode(psiFile: PsiFile) {
        val document = PsiDocumentManager.getInstance(getProject()).getDocument(psiFile)
        document?.deleteString(0, document.textLength)
        document?.insertString(0, codeStr)
    }

    override fun creatFileType(): FileType {
        return ReactFileType()
    }
}