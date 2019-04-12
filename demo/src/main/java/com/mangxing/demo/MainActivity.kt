package com.mangxing.demo

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mangxing.demo.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference


class MainActivity : AppCompatActivity() {

    private val handler = MyHandler(this)
    private var interfaceImp: InterfaceImp? = null

   inner class MyHandler(activity: MainActivity) : Handler() {
        var weakReference: WeakReference<*>

        init {
            weakReference = WeakReference(activity)
        }

        override fun handleMessage(msg: Message) {

            when (msg.what) {
                Contants.LISTURLCODE -> supportsLollipop { window.setStatusBarColor(Color.BLACK) }

            }


        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        interfaceImp = InterfaceImp(handler)
        btnLogin.setOnClickListener {
            val phone = etPhone!!.text.toString()
            val pwd = etPwd!!.text.toString()

            if (phone.length != 11) {
                toastMsg("手机号码不正确")
            } else if (pwd.length != 6) {
                toastMsg("验证码不正确")
            } else if (phone.equals("18317776716") && pwd.equals("123123")) {

                toastMsg("登录成功")
                interfaceImp?.getListData()
            } else {
                toastMsg("账号密码错误请重新输入")
            }

        }
    }

    private fun toastMsg(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()

    }

    inline fun supportsLollipop(code: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            code()
        }
    }




}
