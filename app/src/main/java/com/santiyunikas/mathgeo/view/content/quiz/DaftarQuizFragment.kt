package com.santiyunikas.mathgeo.view.content.quiz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarQuiz
import com.santiyunikas.mathgeo.presenter.quiz.DaftarQuizPresenter
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import kotlinx.android.synthetic.main.fragment_daftar_quiz.*

class DaftarQuizFragment : Fragment() {
    private lateinit var presenter: DaftarQuizPresenter
    private val list = ArrayList<DaftarQuiz>()

    companion object{
        const val KEY_ID_QUIZ = "EXTRA_ID_QUIZ"
        const val KEY_JUDUL_QUIZ = "EXTRA_JUDUL_QUIZ"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_daftar_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rv_list_quiz.setHasFixedSize(true)
        presenter = DaftarQuizPresenter(this)

        tx_koin.text = Preferences.getRegisteredJumlahKoin(view.context).toString()
        list.addAll(presenter.getDaftarQuiz())
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rv_list_quiz.layoutManager = LinearLayoutManager(context)
        val daftarQuizAdapter = DaftarQuizAdapter(list)
        rv_list_quiz.adapter = daftarQuizAdapter

        daftarQuizAdapter.setOnItemClickCallback(object :
            DaftarQuizAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DaftarQuiz, position: Int) {
                moveDetailQuiz(data, position)
            }
        })
    }

    private fun moveDetailQuiz(quiz: DaftarQuiz, position: Int){
        val intent = Intent(context, DetailQuizActivity::class.java)
        intent.putExtra(KEY_ID_QUIZ, position+1)
        intent.putExtra(KEY_JUDUL_QUIZ, quiz.title)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        rv_list_quiz.setHasFixedSize(true)
        presenter = DaftarQuizPresenter(this)

        tx_koin.text = activity?.applicationContext?.let { Preferences.getRegisteredJumlahKoin(it).toString() }
        list.addAll(presenter.getDaftarQuiz())
        showRecyclerList()
    }
}
