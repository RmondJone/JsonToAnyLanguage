package com.guohanlin

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.guohanlin.model.InterfaceResponseDTO
import com.guohanlin.network.api.Api
import com.guohanlin.network.api.ApiService
import com.guohanlin.ui.Icons
import com.guohanlin.ui.JsonToClassDialog
import com.guohanlin.utils.*
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.util.NlsActions
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import io.reactivex.schedulers.Schedulers
import javax.swing.Icon

/**
 * 注释：Json转实体代码生成插件
 * 时间：2022/4/12 10:52 上午
 * 作者：郭翰林
 */
class JsonAction(
    @NlsActions.ActionText text: String? = message("action.json"),
    @NlsActions.ActionDescription description: String? = message("action.json"),
    icon: Icon? = Icons.yapiAction
) : AnAction(text, description, icon) {
    override fun actionPerformed(e: AnActionEvent) {
        //获取插件环境
        val project = e.getData(PlatformDataKeys.PROJECT) ?: return
        val dataContext = e.dataContext
        //当前模块
        val module = LangDataKeys.MODULE.getData(dataContext) ?: return
        //当前文件夹
        val directory = when (val navigatable = LangDataKeys.NAVIGATABLE.getData(dataContext)) {
            is PsiDirectory -> navigatable
            is PsiFile -> navigatable.containingDirectory
            else -> {
                val root = ModuleRootManager.getInstance(module)
                root.sourceRoots
                    .asSequence()
                    .mapNotNull {
                        PsiManager.getInstance(project).findDirectory(it)
                    }.firstOrNull()
            }
        } ?: return
        val dialog = JsonToClassDialog(project)
        if (dialog.showAndGet()) {
            val modelName = dialog.modelInput.text.toString()
            val selectPlatform = dialog.selectPlatform
            val jsonStr = dialog.textAreaDocument?.text ?: ""
            val resBody: JSONObject = JSON.parseObject(jsonStr)
            val needParseField = SharePreferences.get(Constant.NEED_PARSE_FIELD, "")
            var jsonString = jsonStr
            //如果设置中配置了一级解析字段，则从JSON串中配置的一级字段开始解析
            if (!StringUtils.isEmpty(needParseField)) {
                if (resBody[needParseField] != null) {
                    val jsonSchema = resBody[needParseField] as JSONObject
                    jsonString = JSON.toJSONString(jsonSchema)
                } else {
                    MyNotifier.notifyMessage(project, message("setting.api.parseError"))
                }
            }
            requestQuickType(modelName, jsonString, selectPlatform, project, directory)
        }
    }

    /**
     * 注释：请求QuickType服务
     * 时间：2022/4/12 3:55 下午
     * 作者：郭翰林
     */
    private fun requestQuickType(
        modelName: String,
        jsonStr: String,
        targetLanguage: String,
        project: Project,
        directory: PsiDirectory,
    ) {
        val params = HashMap<String, String>()
        params["conversionType"] = "json"
        params["targetLanguage"] = targetLanguage
        params["className"] = modelName
        params["jsonString"] = jsonStr
        MyNotifier.notifyMessage(project, message("notify.quickNode.loading"))
        //QuickTypeNode服务请求地址
        val quickTypeService =
            SharePreferences.get(Constant.QUICK_TYPE_SERVICE, Constant.QUICK_TYPE_URL)
        Api.getService(ApiService::class.java, quickTypeService)
            .getInterfaceModel(params)
            .subscribeOn(Schedulers.io())
            .doOnError {
                MyNotifier.notifyError(project, "${message("notify.quickNode.error")}${it}")
            }
            .subscribe {
                generateFile(targetLanguage, project, directory, it, modelName)
                MyNotifier.notifyMessage(project, message("notify.quickNode.success"))
            }

    }

    /**
     * 注释：生成文件
     * 时间：2022/4/12 4:37 下午
     * 作者：郭翰林
     */
    private fun generateFile(
        targetLanguage: String,
        project: Project,
        directory: PsiDirectory,
        it: InterfaceResponseDTO,
        modelName: String
    ) {
        when (targetLanguage) {
            "Java" -> {
                JavaWriteCommandBuilder()
                    .newBuilder(project)
                    .setPsiDirectory(directory)
                    .setInterfaceResponse(it)
                    .setModelName(modelName)
                    .build()
            }
            "Kotlin" -> {
                KotlinWriteCommandBuilder()
                    .newBuilder(project)
                    .setPsiDirectory(directory)
                    .setInterfaceResponse(it)
                    .setModelName(modelName)
                    .build()
            }
            "Dart" -> {
                DartWriteCommandBuilder()
                    .newBuilder(project)
                    .setPsiDirectory(directory)
                    .setInterfaceResponse(it)
                    .setModelName(modelName)
                    .build()
            }
            "TypeScript" -> {
                ReactWriteCommandBuilder()
                    .newBuilder(project)
                    .setPsiDirectory(directory)
                    .setInterfaceResponse(it)
                    .setModelName(modelName)
                    .build()
            }
            "C++" -> {
                CppWriteCommandBuilder()
                    .newBuilder(project)
                    .setPsiDirectory(directory)
                    .setInterfaceResponse(it)
                    .setModelName(modelName)
                    .build()
            }
            "Swift" -> {
                SwiftWriteCommandBuilder()
                    .newBuilder(project)
                    .setPsiDirectory(directory)
                    .setInterfaceResponse(it)
                    .setModelName(modelName)
                    .build()
            }
            "Objective-C" -> {
                OcWriteCommandBuilder()
                    .newBuilder(project)
                    .setPsiDirectory(directory)
                    .setInterfaceResponse(it)
                    .setModelName(modelName)
                    .build()
            }
            "Go" -> {
                GoWriteCommandBuilder()
                    .newBuilder(project)
                    .setPsiDirectory(directory)
                    .setInterfaceResponse(it)
                    .setModelName(modelName)
                    .build()
            }
        }
    }
}