package com.spacecolony.mvp_volley.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.spacecolony.mvp_volley.R
import com.spacecolony.mvp_volley.model.Stamp
import com.squareup.picasso.Picasso

class PageStampAdapter(private val stamplist: ArrayList<Stamp>,
                       private val listener: (Stamp) -> Unit) :
    RecyclerView.Adapter<PageStampAdapter.StampHolder>() {

    private lateinit var contextadapter: Context

    class StampHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val txtnama: TextView = itemView.findViewById(R.id.TxtNamaStamp)
        private val txtdatestart: TextView = itemView.findViewById(R.id.TxtDateStart)
        private val txtdateend: TextView = itemView.findViewById(R.id.TxtDateEnd)

        private val stampimg: ImageView = itemView.findViewById(R.id.ImgStamp)

        fun binditem(data: Stamp, listener: (Stamp) -> Unit, context: Context, i: Int){
            txtnama.text = data.name
            txtdatestart.text = data.start_time
            txtdateend.text = data.end_time
            Picasso.with(context).load(data.gambar).fit().centerInside().into(stampimg)

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StampHolder {
        contextadapter = parent.context
        val v = LayoutInflater.from(parent.context).inflate(R.layout.stamp_list_layout, parent,false)
        return StampHolder(v)
    }

    override fun getItemCount(): Int {
        return stamplist.size
    }

    override fun onBindViewHolder(holder: StampHolder, position: Int) {
        holder.binditem(stamplist[position],listener,contextadapter,position)
    }
}