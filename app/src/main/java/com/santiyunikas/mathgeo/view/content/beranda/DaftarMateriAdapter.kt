package com.santiyunikas.mathgeo.view.content.beranda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarMateri
import kotlinx.android.synthetic.main.item_daftar_materi_latihan.view.*

class DaftarMateriAdapter(private val listMateri: ArrayList<DaftarMateri>): RecyclerView.Adapter<DaftarMateriAdapter.ListViewHolder>(){
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DaftarMateri, position: Int)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(materi: DaftarMateri, position: Int) {
            with(itemView){
                tv_item_title.text = materi.title
                tv_item_desc.text = materi.desc
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(materi, position) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_latihan_materi_beranda, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMateri[position], position)
    }

    override fun getItemCount(): Int = listMateri.size

}