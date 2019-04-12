package com.mangxing.demo

import android.os.Handler
import android.os.Message
import android.util.Log
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject

import java.io.IOException

/*
 *
 * @作者 code_lyf
 *
 * @时间 2019/4/8 17:46
 *
 */

class InterfaceImp(private val handler: Handler?) : Interator {


    private fun addToRequestQueue(url: String, paramsMap: Map<String, String>?, method: String, responseType: Int) {
        var url = url
        val requestBuilder = Request.Builder()
        // requestBuilder.addHeader("token", "")
        //  requestBuilder.addHeader("userid", SPUtil.getData("userid", "").toString());
        //        requestBuilder.addHeader("os-ver", SystemUtil.getSystemVersion().trim());//系统版本号
        //        requestBuilder.addHeader("app-ver", SystemUtil.getVersion().trim());//app版本号
        //  requestBuilder.addHeader("brand", encodeHeadInfo(SystemUtil.getDeviceBrand()) + "\\" + encodeHeadInfo(SystemUtil.getSystemModel()));//手机品牌
        //Log.e("mazhuang"," os-ver:"+SystemUtil.getSystemVersion().trim()+" app-ver:"+SystemUtil.getVersion().trim()+" brand："+encodeHeadInfo(SystemUtil.getDeviceBrand()) + "\\" + encodeHeadInfo(SystemUtil.getSystemModel()));
        ///--------------------


        val builder = FormBody.Builder()
        if (paramsMap != null && paramsMap?.size > 0) {
            for (key in paramsMap?.keys) {
                builder.add(key, paramsMap[key])
            }
        }

      //  paramsMap.let { }



        val formBody = builder.build()
        if (method == "POST") {
            requestBuilder.method("POST", formBody)
        } else {
            url = url + "?" + getUrlParamsByMap(paramsMap)
            Log.e(">>url>>", url)
            requestBuilder.get()
        }


        requestBuilder.url(url)
        val request = requestBuilder.build()


        val call = OkHttpClientSL.getOkHttpClient()!!.newCall(request)


        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

                val message = Message()
                message.what = Contants.REQUEST_POST_ERROR
                message.obj = e.toString() + ""
                handler!!.sendMessage(message)

            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {

                val result = response.body()!!.string()
                try {
                    val jo = JSONObject(result)
                    Log.d(Contants.LYF, result)
                    /*   String code = jo.getString("reCode");
                    final String reMsg = jo.getString("reMsg");*/
                    if (handler != null) {

                        val message = Message()
                        message.obj = result
                        message.what = responseType
                        handler.sendMessage(message)

                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

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
            sb.append("$key=$value")
            sb.append("&")
        }
//        if (s.endsWith("&")) {
        //            s = org.apache.commons.lang.StringUtils.substringBeforeLast(s, "&");
        //        }
        return sb.toString()
    }

    override fun getListData() {
        addToRequestQueue(Contants.LISTURL, null, Contants.GET, Contants.LISTURLCODE)
    }
}




