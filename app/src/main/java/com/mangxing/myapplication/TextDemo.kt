package com.mangxing.myapplication

import android.util.Log

/**
 *  @ 作者 CODE_LYF
 *  @ 时间   2019/4/10.
 *  代码人生
 */
class TextDemo {

//@符号的自定义标记

    fun get() {
       /* val book: Book? = null
        book?.component1()

        val list: ArrayList<Int>? = null
        for (i in 0..15) {
            list?.add(i)
        }

        run outer@{
            list?.forEach {
                if (it == 0) return@forEach //相当于在forEach函数中continue,实际上是从匿名函数返回
                if (it == 2) return@outer //相当于在forEach函数中使用break,实际上是跳转到outer之外
            }
        }*/

        /*
        遍历map
         */
        val map: HashMap<String, String>? = HashMap()

        for (a in 0..12) {
            map?.put(a.toString(), a.toString())
        }
        for ((key, value) in map!!) {
            Log.d("测试测试", "key:$key,	value:$value")
        }


    }


}