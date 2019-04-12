package com.mangxing.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mangxing.myapplication.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)


        btnLogin.setOnClickListener {
            val phone = etPhone?.text.toString()
            val pwd = etPwd?.text.toString()

            if (phone.length != 11) {
                toastMsg("手机号码不正确")
            } else if (pwd.length != 6) {
                toastMsg("验证码不正确")
            } else if (phone.equals("18317776716") && pwd.equals("123123")) {

                startActivity(Intent(this, ListActivity::class.java))
            } else { toastMsg("账号密码错误请重新输入")
            }

        }



    }

    private fun toastMsg(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }


}
