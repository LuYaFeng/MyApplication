package com.mangxing.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mangxing.myapplication.R
import com.mangxing.myapplication.bean.Data
import com.mangxing.myapplication.ui.ArticleActivity

/**
 *  @ 作者 CODE_LYF
 *  @ 时间   2019/4/10.
 *  代码人生
 */
class HometAdapter(private val mContext: Context, private val mList: ArrayList<Data>) :
    RecyclerView.Adapter<HometAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.layout_item, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        holder.tv.text = mList.get(p1).name

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tv = itemView.findViewById<TextView>(R.id.tv)
            init {
                itemView.setOnClickListener {
                    var d = mList.get(adapterPosition)


                    mContext.startActivity(Intent(mContext,ArticleActivity::class.java).putExtra("id",d.id))
                }
            }

    }
}