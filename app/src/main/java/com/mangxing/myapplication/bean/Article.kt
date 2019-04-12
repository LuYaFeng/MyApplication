package com.mangxing.myapplication.bean

/**
 *  @ 作者 CODE_LYF
 *  @ 时间   2019/4/10.
 *  代码人生
Article */
data class Article(
    val `data`: Data1?,
    val errorCode: Int?,
    val errorMsg: String?
)

data class Data1(
    val curPage: Int?,
    val datas: List<DataX?>?,
    val offset: Int?,
    val over: Boolean?,
    val pageCount: Int?,
    val size: Int?,
    val total: Int?
)

data class DataX(
    val apkLink: String?,
    val author: String?,
    val chapterId: Int?,
    val chapterName: String?,
    val collect: Boolean?,
    val courseId: Int?,
    val desc: String?,
    val envelopePic: String?,
    val fresh: Boolean?,
    val id: Int?,
    val link: String?,
    val niceDate: String?,
    val origin: String?,
    val prefix: String?,
    val projectLink: String?,
    val publishTime: Long?,
    val superChapterId: Int?,
    val superChapterName: String?,
    val tags: List<Tag?>?,
    val title: String?,
    val type: Int?,
    val userId: Int?,
    val visible: Int?,
    val zan: Int?
)

data class Tag(
    val name: String?,
    val url: String?
)