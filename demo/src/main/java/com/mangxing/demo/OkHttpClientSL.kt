package com.mangxing.demo

import okhttp3.OkHttpClient

import java.util.concurrent.TimeUnit

object OkHttpClientSL {

    private var okHttpClient: OkHttpClient? = null

    fun getOkHttpClient(): OkHttpClient? {
        if (okHttpClient == null) {
            synchronized(OkHttpClientSL::class.java) {
                if (okHttpClient == null) {
                    okHttpClient = OkHttpClient().newBuilder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .build()
                }
            }
        }
        return okHttpClient
    }

}//非常有必要，要不此类还是可以被new  单例
