package com.guohanlin

import com.intellij.psi.PsiDirectory
import com.intellij.psi.impl.file.PsiDirectoryFactory

/**
 * 注释：创建Psi文件夹
 * 时间：2021/5/27 0027 17:07
 * 作者：郭翰林
 */
fun createPsiDirectory(directory: PsiDirectory, directoryName: String): PsiDirectory {
    return if (directory.findSubdirectory(directoryName) == null) {
        directory.createSubdirectory(directoryName)
    } else {
        directory.findSubdirectory(directoryName)!!
    }
}

/**
 * 注释：创建Psi文件
 * 时间：2021/5/27 0027 17:27
 * 作者：郭翰林
 */
fun creatPsiFile(directory: PsiDirectory, codeStructure: CodeStructure) {
    var psiFile = directory.findFile(codeStructure.creatFileName())
    if (psiFile != null) {
        //如果不为空则去更新代码
        codeStructure.updateCode(psiFile)
    } else {
        //如果为空，则新建
        psiFile = codeStructure.getFile()
        if (psiFile != null) {
            directory.add(psiFile)
        }
    }
}


/**
 * 注释：获取包名
 * 时间：2021/5/27 0027 18:17
 * 作者：郭翰林
 */
fun getPackageName(directory: PsiDirectory): String {
    val directoryFactory = PsiDirectoryFactory.getInstance(directory.project)
    //当前包名
    return directoryFactory.getQualifiedName(directory, false)
}

/**
 * 注释：第一个字母大写其余字母全部小写
 * 时间：2020/5/27 0027 15:09
 * 作者：郭翰林
 *
 * @param text
 * @return
 */
fun captureName(text: String): String? {
    var text = text
    if (text.isNotEmpty()) {
        text = text.substring(0, 1).toUpperCase() + text.substring(1)
    }
    return text
}

/**
 * 注释：重复字符串多少次
 * 时间：2020/5/27 0027 14:07
 * 作者：郭翰林
 *
 * @param repeat
 * @param number
 * @return
 */
fun repeatStr(repeat: String?, number: Int): String? {
    val stringBuilder = StringBuilder()
    for (i in 0 until number) {
        stringBuilder.append(repeat)
    }
    return stringBuilder.toString()
}