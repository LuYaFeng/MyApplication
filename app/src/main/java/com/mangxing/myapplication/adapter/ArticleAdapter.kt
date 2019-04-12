package com.mangxing.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mangxing.myapplication.R
import com.mangxing.myapplication.bean.DataX
import com.mangxing.myapplication.ui.WebDetailActivity

/**
 *  @ 作者 CODE_LYF
 *  @ 时间   2019/4/12.
 *  代码人生
 */
class ArticleAdapter(private val mContext: Context, private val mList: ArrayList<DataX>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.layout_item, p0, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {

        holder.tv.text = mList.get(p1).title
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tv = itemView.findViewById<TextView>(R.id.tv)

        init {
            itemView.setOnClickListener {
                var d = mList.get(adapterPosition)

                mContext.startActivity(Intent(mContext, WebDetailActivity::class.java).putExtra("url", d.link))
            }
        }

    }
}