package com.mangxing.myapplication.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.mangxing.myapplication.R.layout.activity_article
import com.mangxing.myapplication.adapter.ArticleAdapter
import com.mangxing.myapplication.base.Contants
import com.mangxing.myapplication.bean.Article
import com.mangxing.myapplication.bean.DataX
import com.mangxing.myapplication.remote.InterfaceImp
import kotlinx.android.synthetic.main.activity_article.*
import java.lang.ref.WeakReference


class ArticleActivity : AppCompatActivity() {
    private var ll = ArrayList<DataX>()
    private val handler = Myhander(this)

    inner class Myhander(activity: Activity) : Handler() {
        var weakReference: WeakReference<*> = WeakReference(activity)


        override fun handleMessage(msg: Message?) {
            when (msg!!.what) {
                Contants.LISTURLCODE2 -> {

                    val listBean = Gson().fromJson(msg.obj.toString(), Article::class.java)
                    var datas = listBean.data?.datas as Collection<DataX>

                    Log.d("数据--", msg.obj.toString())
                    if (ll != null) {
                        ll.clear()
                        ll.addAll(datas)
                    } else {
                        ll.addAll(datas)
                    }

                    articleAdapter?.notifyDataSetChanged()
                }
                Contants.REQUEST_POST_ERROR -> Toast.makeText(this@ArticleActivity, "请求失败", Toast.LENGTH_LONG).show()
            }

        }

    }

    private var interfaceImp: InterfaceImp? = null
    var articleAdapter: ArticleAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_article)

        var stringExtra = intent.getStringExtra("id")
        interfaceImp = InterfaceImp(handler)
        Log.d("数据--", stringExtra + "${ll.size}")
        val recyclerViewLayoutManager = LinearLayoutManager(this)
        recyclerViewLayoutManager.orientation = LinearLayoutManager.VERTICAL
        ar_recyclerView.layoutManager = recyclerViewLayoutManager
        articleAdapter = ArticleAdapter(this, ll)
        ar_recyclerView.adapter = articleAdapter


        interfaceImp?.getArticleData("1", stringExtra)


    }

    fun toMarket(context: Context, appPkg: String, marketPkg: String = "com.xiaomi.market") {
        var parse = Uri.parse("market://detail?id=$appPkg")

        var intent = Intent(Intent.ACTION_VIEW, parse)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage(marketPkg)
        try {

            startActivity(intent)

        } catch (e: Exception) {
            e.printStackTrace()

        }


    }


}
