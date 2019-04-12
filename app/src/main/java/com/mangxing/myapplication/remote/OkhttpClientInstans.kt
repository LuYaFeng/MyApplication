package com.mangxing.myapplication.remote

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 *  @ 作者 CODE_LYF
 *  @ 时间   2019/4/9.
 *  代码人生
 */
object OkhttpClientInstans {

    private var okHttpClient: OkHttpClient? = null
    fun getOKhttpClient(): OkHttpClient? {

        if (okHttpClient == null) {
            synchronized(OkhttpClientInstans::class.java) {

                if (okHttpClient == null) {
                    okHttpClient = OkHttpClient().newBuilder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .build()
                }

            }
        }

        return okHttpClient
    }

}