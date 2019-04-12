package com.mangxing.myapplication.ui

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.google.gson.Gson
import com.mangxing.myapplication.R.layout.activity_list
import com.mangxing.myapplication.adapter.HometAdapter
import com.mangxing.myapplication.base.Contants
import com.mangxing.myapplication.bean.Data
import com.mangxing.myapplication.bean.ListBean
import com.mangxing.myapplication.remote.InterfaceImp
import kotlinx.android.synthetic.main.activity_list.*
import java.lang.ref.WeakReference


class ListActivity : AppCompatActivity() {

    var ll = ArrayList<Data>()


    inner class Myhander(activity: Activity) : Handler() {
        var weakReference: WeakReference<*> = WeakReference(activity)


        override fun handleMessage(msg: Message?) {
            when (msg!!.what) {
                Contants.LISTURLCODE -> {

                    val listBean = Gson().fromJson(msg.obj.toString(), ListBean::class.java)
                    var data = listBean.data as Collection<Data>

                    if (ll != null) {
                        ll.clear()
                        ll.addAll(data)
                    } else {
                        ll.addAll(data)
                    }

                    adapter?.notifyDataSetChanged()
                }
                Contants.REQUEST_POST_ERROR -> Toast.makeText(this@ListActivity, "请求失败", Toast.LENGTH_LONG).show()
            }

        }

    }

    private var interfaceImp: InterfaceImp? = null
    private val handler = Myhander(this)
    private var adapter: HometAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_list)
        interfaceImp = InterfaceImp(handler)



        adapter = HometAdapter(this, ll)


        val recyclerViewLayoutManager = LinearLayoutManager(this)
        recyclerViewLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = recyclerViewLayoutManager

        //recyclerView.
        recyclerView.adapter = adapter

        interfaceImp?.getListData()
    }
}

