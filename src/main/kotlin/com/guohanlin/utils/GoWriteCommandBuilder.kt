package com.guohanlin.utils

import com.guohanlin.creatPsiFile
import com.guohanlin.language.go.GoModelCodeStructure
import com.guohanlin.model.InterfaceResponseDTO
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class GoWriteCommandBuilder {
    private lateinit var project: Project

    open fun newBuilder(project: Project): Builder {
        this.project = project
        return Builder(this)
    }

    class Builder internal constructor(mBuilder: GoWriteCommandBuilder) {
        private lateinit var directory: PsiDirectory
        private var modelName: String? = null
        private var interfaceResponse: InterfaceResponseDTO? = null
        private var project: Project = mBuilder.project

        //设置Psi文件夹
        fun setPsiDirectory(directory: PsiDirectory): Builder {
            this.directory = directory
            return this
        }

        //设置将要生成的Model实体名称
        fun setModelName(modelName: String): Builder {
            this.modelName = modelName
            return this
        }

        //设置实体转换请求返回
        fun setInterfaceResponse(interfaceResponse: InterfaceResponseDTO): Builder {
            this.interfaceResponse = interfaceResponse
            return this
        }

        //构建
        fun build() {
            WriteCommandAction.runWriteCommandAction(project) {
                modelName?.let {
                    creatPsiFile(
                        directory,
                        GoModelCodeStructure(
                            directory,
                            it,
                            interfaceResponse!!
                        )
                    )
                }
            }
        }
    }
}