package com.santiyunikas.mathgeo.view.content.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.santiyunikas.mathgeo.R
import kotlinx.android.synthetic.main.fragment_review_quiz_dialog.*

class ReviewQuizDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review_quiz_dialog, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nilai = arguments?.getInt(DetailQuizActivity.KEY_NILAI)
        if (nilai != null) {
            when {
                nilai <= 1 -> {
                    review_quiz_text.text = "Kamu menjawab quiz ini dengan Sangat Buruk!"
                    getEmoji("https://mathgeo.ub-learningtechnology.com/asset/quiz/review/emoji_1.png")
                    getBintang("https://mathgeo.ub-learningtechnology.com/asset/quiz/review/bintang_1.png")
                }
                nilai <= 2 -> {
                    review_quiz_text.text = "Kamu menjawab quiz ini dengan Cukup Buruk!"
                    getEmoji("https://mathgeo.ub-learningtechnology.com/asset/quiz/review/emoji_2.png")
                    getBintang("https://mathgeo.ub-learningtechnology.com/asset/quiz/review/bintang_2.png")
                }
                nilai <= 3 -> {
                    review_quiz_text.text = "Kamu menjawab quiz ini dengan Baik!"
                    getEmoji("https://mathgeo.ub-learningtechnology.com/asset/quiz/review/emoji_3.png")
                    getBintang("https://mathgeo.ub-learningtechnology.com/asset/quiz/review/bintang_3.png")
                }
                nilai <= 4 -> {
                    review_quiz_text.text = "Kamu menjawab quiz ini dengan Cukup Baik!"
                    getEmoji("https://mathgeo.ub-learningtechnology.com/asset/quiz/review/emoji_4.png")
                    getBintang("https://mathgeo.ub-learningtechnology.com/asset/quiz/review/bintang_4.png")
                }
                nilai <= 5 -> {
                    review_quiz_text.text = "Kamu menjawab quiz ini dengan Sangat Baik!"
                    getEmoji("https://mathgeo.ub-learningtechnology.com/asset/quiz/review/emoji_5.png")
                    getBintang("https://mathgeo.ub-learningtechnology.com/asset/quiz/review/bintang_5.png")
                }
            }
        }

        btn_selesai_quiz.setOnClickListener {
            dismiss()
            activity?.finish()
        }
    }

    private fun getEmoji(url: String){
        Glide.with(this)
            .load(url)
            .into(review_quiz_emoji)
    }

    private fun getBintang(url: String){
        Glide.with(this)
            .load(url)
            .into(review_quiz_bintang)
    }
}