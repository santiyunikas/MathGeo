package com.santiyunikas.mathgeo.presenter.quiz

import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarQuiz
import com.santiyunikas.mathgeo.view.content.beranda.BerandaFragment
import com.santiyunikas.mathgeo.view.content.quiz.DaftarQuizFragment

class DaftarQuizPresenter() {

    var viewQuiz = DaftarQuizFragment()
    var viewBeranda = BerandaFragment()

    constructor(context: DaftarQuizFragment):this(){
        viewQuiz = context
    }
    constructor(context1: BerandaFragment) : this(){
        viewBeranda = context1
    }

    fun getDaftarQuiz(): ArrayList<DaftarQuiz>{
        val dataTitle = viewQuiz.resources.getStringArray(R.array.array_title_quiz)

        val daftarQuiz = ArrayList<DaftarQuiz>()
        repeat(dataTitle.count()) {
            val quiz = DaftarQuiz(
                dataTitle[it]
            )

            daftarQuiz.add(quiz)
        }
        return daftarQuiz
    }

    fun getDaftarQuizBeranda(): ArrayList<DaftarQuiz>{
        val dataTitle = viewBeranda.resources.getStringArray(R.array.array_title_quiz)

        val daftarQuiz = ArrayList<DaftarQuiz>()
        repeat(dataTitle.count()) {
            val quiz = DaftarQuiz(
                dataTitle[it]
            )

            daftarQuiz.add(quiz)
        }
        return daftarQuiz
    }
}