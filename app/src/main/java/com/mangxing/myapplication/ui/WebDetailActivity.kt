package com.mangxing.myapplication.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import com.mangxing.myapplication.R
import kotlinx.android.synthetic.main.activity_web_detail.*

class WebDetailActivity : AppCompatActivity() {
    var strin:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_detail)

        strin = intent.getStringExtra("url")

        initView()
    }

    private fun initView() {
        val settings = webView.settings
        settings.javaScriptEnabled=true
        settings.useWideViewPort=true
        settings.loadWithOverviewMode=true
        settings.cacheMode=WebSettings.LOAD_NO_CACHE
        settings.allowFileAccess=true
        settings.setAppCacheEnabled(true)
        settings.domStorageEnabled=true
        settings.databaseEnabled=true
        settings.blockNetworkImage=true
        webView.loadUrl(strin)
    }
}
