package com.santiyunikas.mathgeo.view.content.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarQuiz
import com.santiyunikas.mathgeo.presenter.quiz.DaftarQuizPresenter

class DaftarQuizFragment : Fragment() {
    private lateinit var rvDaftarQuiz: RecyclerView
    private lateinit var presenter: DaftarQuizPresenter
    private val list = ArrayList<DaftarQuiz>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvDaftarQuiz = view.findViewById(R.id.rv_list_quiz)
        rvDaftarQuiz.setHasFixedSize(true)

        presenter = DaftarQuizPresenter(this)

        list.addAll(presenter.getDaftarQuiz())
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvDaftarQuiz.layoutManager = LinearLayoutManager(context)
        val daftarQuizAdapter = DaftarQuizAdapter(list)
        rvDaftarQuiz.adapter = daftarQuizAdapter
    }
}
