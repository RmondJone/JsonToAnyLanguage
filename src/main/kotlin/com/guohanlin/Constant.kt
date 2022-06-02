package com.guohanlin

object Constant {
    //QuickType服务地址
    const val QUICK_TYPE_URL = "http://quicktype.guohanlin.com"

    //需要解析的字段
    const val NEED_PARSE_FIELD = "need_parse_field"

    //自定义QuickTypeNode服务
    const val QUICK_TYPE_SERVICE = "quickTypeService"

    //生成语言集合
    var platformList: ArrayList<String> =
        arrayListOf<String>(
            "Java",
            "Kotlin",
            "Dart",
            "TypeScript",
            "C++",
            "Swift",
            "Objective-C",
            "Go"
        )
}