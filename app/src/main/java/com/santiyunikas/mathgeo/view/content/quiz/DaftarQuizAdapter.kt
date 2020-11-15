package com.santiyunikas.mathgeo.view.content.quiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarQuiz
import kotlinx.android.synthetic.main.item_daftar_quiz.view.*

class DaftarQuizAdapter(private val listQuiz: ArrayList<DaftarQuiz>): RecyclerView.Adapter<DaftarQuizAdapter.ListViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DaftarQuiz, position: Int)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(quiz: DaftarQuiz, position: Int) {
            with(itemView){
                tv_item_title.text = quiz.title
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(quiz, position) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daftar_quiz, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listQuiz[position], position)
    }

    override fun getItemCount(): Int = listQuiz.size

}