package com.mangxing.myapplication.bean

/**
 *  @ 作者 CODE_LYF
 *  @ 时间   2019/4/11.
 *  代码人生
 */
data class ListBean(
    val `data`: List<Data?>?,
    val errorCode: Int?,
    val errorMsg: String?
)

data class Data(
    val children: List<Any?>?,
    val courseId: Int?,
    val id: Int?,
    val name: String?,
    val order: Int?,
    val parentChapterId: Int?,
    val userControlSetTop: Boolean?,
    val visible: Int?
)