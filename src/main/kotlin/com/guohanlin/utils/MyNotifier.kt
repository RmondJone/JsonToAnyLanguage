package com.guohanlin.utils

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project
import java.util.*
import kotlin.concurrent.schedule

/**
 * 注释：通知管理器
 * 时间：2022/4/12 5:46 下午
 * 作者：郭翰林
 */
object MyNotifier {
    /**
     * 注释：错误悬浮通知
     * 时间：2022/4/12 5:46 下午
     * 作者：郭翰林
     */
    @JvmStatic
    fun notifyError(project: Project, content: String) {
        NotificationGroupManager.getInstance()
            .getNotificationGroup("JsonToAnyLanguage Error")
            .createNotification(content, NotificationType.ERROR)
            .notify(project)
    }

    /**
     * 注释：信息悬浮通知
     * 时间：2022/4/12 7:22 下午
     * 作者：郭翰林
     */
    @JvmStatic
    fun notifyMessage(project: Project, content: String) {
        val notification = NotificationGroupManager.getInstance()
            .getNotificationGroup("JsonToAnyLanguage Message")
            .createNotification(content, NotificationType.INFORMATION)
        notification.notify(project)
        //2s之后消失
        Timer().schedule(2000) {
            notification.expire()
        }
    }
}