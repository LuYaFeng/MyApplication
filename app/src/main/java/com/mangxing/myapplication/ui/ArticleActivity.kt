package com.mangxing.myapplication.ui

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.gson.Gson
import com.mangxing.myapplication.R
import com.mangxing.myapplication.base.Contants
import com.mangxing.myapplication.bean.Data
import com.mangxing.myapplication.bean.ListBean
import java.lang.ref.WeakReference


class ArticleActivity : AppCompatActivity() {
    private var ll = ArrayList<Data>()
    private val handler = Myhander(this)

    inner class Myhander(activity: Activity) : Handler() {
        var weakReference: WeakReference<*> = WeakReference(activity)


        override fun handleMessage(msg: Message?) {
            when (msg!!.what) {
                Contants.LISTURLCODE2 -> {

                    val listBean = Gson().fromJson(msg.obj.toString(), ListBean::class.java)
                    var data = listBean.data as Collection<Data>

                    if (ll != null) {
                        ll.clear()
                        ll.addAll(data)
                    } else {
                        ll.addAll(data)
                    }

                    //   adapter?.notifyDataSetChanged()
                }
                Contants.REQUEST_POST_ERROR -> Toast.makeText(this@ArticleActivity, "请求失败", Toast.LENGTH_LONG).show()
            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        var stringExtra = intent.getStringExtra("id")




    }
}
