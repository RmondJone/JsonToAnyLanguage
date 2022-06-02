package com.guohanlin.ui

import com.guohanlin.*
import com.guohanlin.utils.SharePreferences
import com.guohanlin.utils.message
import com.intellij.ide.BrowserUtil
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.project.Project
import com.intellij.util.ui.JBDimension
import java.awt.BorderLayout
import java.awt.datatransfer.StringSelection
import javax.swing.JPanel
import javax.swing.JTextField

class ApiSetting(private val project: Project) : JPanel(BorderLayout()) {
    private lateinit var needParseField: JTextField
    private lateinit var quickTypeNodeInput: JTextField

    init {
        jScrollPanel(JBDimension(500, 300)) {
            jVerticalLinearLayout {
                //自定义QuickTypeNode服务配置
                jHorizontalLinearLayout {
                    jLabel(message("setting.api.quicktype.node"), 15f)
                    jLink(message("setting.api.quicktype.reset")) {
                        quickTypeNodeInput.text = Constant.QUICK_TYPE_URL
                    }
                    fillSpace()
                }
                quickTypeNodeInput =
                    jTextInput(
                        initText = SharePreferences.get(
                            Constant.QUICK_TYPE_SERVICE,
                            Constant.QUICK_TYPE_URL
                        )
                    )
                jHorizontalLinearLayout {
                    jLabel(message("setting.api.tip"))
                    jLink(message("setting.api.copy")) {
                        CopyPasteManager.getInstance()
                            .setContents(StringSelection("104.168.153.3 quicktype.guohanlin.com"))
                        showMessageTip(message("copy.success"))
                    }
                    fillSpace()
                }
                jHorizontalLinearLayout {
                    jLabel(message("setting.api.quicktype.error"))
                    jLink(message("quicktypenode.url")) {
                        BrowserUtil.browse("https://github.com/RmondJone/QuickTypeNode")
                    }
                    fillSpace()
                }
                jLine()
                //一级请求解析字段配置
                jVerticalLinearLayout {
                    jHorizontalLinearLayout {
                        jLabel(message("label.parse"), 15f)
                        fillSpace()
                    }
                    jHorizontalLinearLayout {
                        jLabel(message("setting.api.response"))
                        fillSpace()
                    }
                }
                needParseField = jTextInput(
                    initText = SharePreferences.get(
                        Constant.NEED_PARSE_FIELD,
                        ""
                    )
                )
            }
        }
    }

    /**
     * 注释：是否有更改
     * 时间：2021/7/10 0010 15:43
     * 作者：郭翰林
     */
    fun isModified(): Boolean {
        val needParseFieldText = SharePreferences.get(Constant.NEED_PARSE_FIELD, "")
        val yApiQuickTypeText =
            SharePreferences.get(Constant.QUICK_TYPE_SERVICE, Constant.QUICK_TYPE_URL)
        return needParseFieldText != needParseField.text
                || yApiQuickTypeText != quickTypeNodeInput.text
    }

    /**
     * 注释：重置
     * 时间：2021/7/10 0010 15:44
     * 作者：郭翰林
     */
    fun reset() {
        val needParseFieldText = SharePreferences.get(Constant.NEED_PARSE_FIELD, "")
        needParseField.text = needParseFieldText
        val yApiQuickTypeText =
            SharePreferences.get(Constant.QUICK_TYPE_SERVICE, Constant.QUICK_TYPE_URL)
        quickTypeNodeInput.text = yApiQuickTypeText
    }

    /**
     * 注释：应用更改
     * 时间：2021/7/10 0010 15:45
     * 作者：郭翰林
     */
    fun apply() {
        SharePreferences.put(Constant.NEED_PARSE_FIELD, needParseField.text)
        SharePreferences.put(Constant.QUICK_TYPE_SERVICE, quickTypeNodeInput.text)
    }
}