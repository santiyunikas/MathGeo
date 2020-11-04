package com.santiyunikas.mathgeo.presenter.quiz

import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarQuiz
import com.santiyunikas.mathgeo.view.content.quiz.DaftarQuizFragment

class DaftarQuizPresenter(context: DaftarQuizFragment) {
    private var view = context

    fun getDaftarQuiz(): ArrayList<DaftarQuiz>{
        val dataTitle = view.resources.getStringArray(R.array.array_title_quiz)

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