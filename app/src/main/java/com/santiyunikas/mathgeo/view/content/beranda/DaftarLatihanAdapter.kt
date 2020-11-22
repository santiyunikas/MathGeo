package com.santiyunikas.mathgeo.view.content.beranda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarLatihan
import kotlinx.android.synthetic.main.item_daftar_materi_latihan.view.*

class DaftarLatihanAdapter(private val listLatihan: ArrayList<DaftarLatihan>): RecyclerView.Adapter<DaftarLatihanAdapter.ListViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    interface OnItemClickCallback {
        fun onItemClicked(data: DaftarLatihan, position: Int)
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(latihan: DaftarLatihan, position: Int ) {
            with(itemView){
                tv_item_title.text = latihan.title
                tv_item_desc.text = latihan.desc
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(latihan, position) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_latihan_materi_beranda, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listLatihan[position], position)
    }

    override fun getItemCount(): Int = listLatihan.size

}