package com.guohanlin.language.oc

import com.guohanlin.CodeStructure
import com.guohanlin.model.InterfaceResponseDTO
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile

class OcHeadCodeStructure(
    directory: PsiDirectory,
    modelName: String,
    interfaceResponseDTO: InterfaceResponseDTO
) : CodeStructure(directory) {
    private var fileName: String = modelName
    private var codeStr: String = interfaceResponseDTO.info

    override fun creatCode(): String {
        return codeStr.split("// QT${fileName}.m")[0]
    }

    override fun updateCode(psiFile: PsiFile) {
        val document = PsiDocumentManager.getInstance(getProject()).getDocument(psiFile)
        document?.deleteString(0, document.textLength)
        document?.insertString(0, codeStr.split("// QT${fileName}.m")[0])
    }

    override fun creatFileName(): String {
        return "QT${fileName}.h"
    }

    override fun creatFileType(): FileType {
        return OcHeadFileType();
    }
}