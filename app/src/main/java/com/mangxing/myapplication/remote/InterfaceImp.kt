package com.mangxing.myapplication.remote

import android.os.Handler
import android.os.Message
import com.mangxing.myapplication.base.Contants
import okhttp3.*
import java.io.IOException


/**
 *  @ 作者 CODE_LYF
 *  @ 时间   2019/4/10.
 *  代码人生
 */
class InterfaceImp(private val handler: Handler) : Interator {


    /**
     * 请求队列
     */
    private fun addToRequestQueue(url: String, paramsMap: HashMap<String, String>?, method: String, acceptCode: Int) {
        var url: String = url
        //请求头
        val requestBuilder = Request.Builder()

        requestBuilder.addHeader("token", "")
        //请求体
        val builder = FormBody.Builder()


        if (paramsMap != null && paramsMap.size > 0) {
            for ((key, value) in paramsMap) {
                builder.add(key, value)
            }
        }

        val formBody = builder.build()
        if (method.equals("POST")) {
            requestBuilder.method("POST", formBody)
        } else {
            url += "?${getUrlParamsByMap(paramsMap)}"
            requestBuilder.get()
        }

        //设置请求地址
        requestBuilder.url(url)
        //获取请求对象
        val request = requestBuilder.build()
        val call = OkhttpClientInstans.getOKhttpClient()!!.newCall(request)

        //发起异步请求
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                //失败的方法
                val message = Message()
                message.what = Contants.REQUEST_POST_ERROR
                message.obj = e.toString()
                handler.sendMessage(message)

            }

            override fun onResponse(call: Call, response: Response) {
                //成功的方法

                val result = response.body()!!.string()

                val message = Message()
                message.what = acceptCode
                message.obj = result
                handler.sendMessage(message)


            }
        })


    }

    /**
     * 将map转换成url
     *
     * @param map
     * @return
     */
    private fun getUrlParamsByMap(map: Map<String, String>?): String {
        if (map == null) {
            return ""
        }
        val sb = StringBuffer()
        for ((key, value) in map) {
            sb.append("$value")
            sb.append("/")
        }

        return sb.toString()
    }

    /**
     *
     */
    override fun getListData() {
        addToRequestQueue(
            Contants.LISTURL, null,
            Contants.GET,
            Contants.LISTURLCODE
        )
    }

    override fun getArticleData(page: String, id: String) {
        addToRequestQueue(
            Contants.LISTURL2 + "$id/$page/json", null,
            Contants.GET,
            Contants.LISTURLCODE2
        )
    }


}