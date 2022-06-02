package com.guohanlin.ui

import com.guohanlin.*
import com.guohanlin.json.JSONArray
import com.guohanlin.json.JSONObject
import com.guohanlin.utils.NumberTextField
import com.guohanlin.utils.StringUtils
import com.guohanlin.utils.message
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.util.ui.JBDimension
import java.awt.Dimension
import java.awt.event.ItemEvent
import javax.swing.JComboBox
import javax.swing.JComponent
import javax.swing.JTextField

/**
 * 注释：JSON转实体弹窗
 * 时间：2022/4/12 3:52 下午
 * 作者：郭翰林
 */
class JsonToClassDialog(private val project: Project) : DialogWrapper(project) {
    var textAreaDocument: Document? = null
    lateinit var modelInput: JTextField
    private lateinit var platformJComboBox: JComboBox<Any>
    var selectPlatform: String = "Java"

    init {
        init()
        title = message("json.dialog.title")
    }

    override fun doOKAction() {
        val modelName = modelInput.text.toString()
        val jsonStr = textAreaDocument?.text.toString().trim()
        if (StringUtils.isEmpty(jsonStr)) {
            showMessageTip(message("json.dialog.tip.json"))
            return
        }
        if (!StringUtils.isJSON(jsonStr)) {
            showMessageTip(message("json.dialog.tip.jsonerr"))
            return
        }
        if (StringUtils.isEmpty(modelName)) {
            showMessageTip(message("yapi.dialog.tip"))
            return
        }
        super.doOKAction()
    }

    override fun createCenterPanel(): JComponent? {
        return jVerticalLinearLayout {
            jHorizontalLinearLayout {
                jLabel(message("json.dialog.label"))
                fillSpace()
                jButton(message("json.dialog.format"), clickListener = {
                    WriteCommandAction.runWriteCommandAction(project) {
                        textAreaDocument?.let {
                            var json: String = it.text
                            json = json.trim()
                            try {
                                if (json.startsWith("{")) {
                                    val jsonObject = JSONObject(json)
                                    val formatJson: String = jsonObject.toString(4)
                                    it.setText(formatJson)
                                } else if (json.startsWith("[")) {
                                    val jsonArray = JSONArray(json)
                                    val formatJson: String = jsonArray.toString(4)
                                    it.setText(formatJson)
                                }
                            } catch (e: Exception) {
                                println(e.toString())
                            }
                        }
                    }
                })
            }
            jScrollPanel(JBDimension(800, 600)) {
                jTextAreaInput(
                    project = project,
                    size = JBDimension(800, 400),
                ) { textAreaDocument = it }
            }
            jLine()
            jHorizontalLinearLayout {
                jLabel(message("json.dialog.modelName"))
                modelInput = jTextInput {
                    minimumSize = Dimension(200, 50)
                    document = NumberTextField(30)
                }
                fixedSpace(100)
                jLabel(message("json.dialog.platformList"))
                platformJComboBox = jComboBox(items = Constant.platformList.toArray()) {
                    it?.let {
                        if (it.stateChange == ItemEvent.SELECTED) {
                            selectPlatform = platformJComboBox.selectedItem as String
                        }
                    }
                }
            }
        }
    }
}