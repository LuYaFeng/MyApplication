package com.mangxing.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mangxing.myapplication.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val t: String = "www"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        btn.setOnClickListener {
            toast("你好", t)

        }
    }


    fun toast(message: String, string: String = "741") {
        Toast.makeText(this, message + string, Toast.LENGTH_LONG).show()

    }


}
