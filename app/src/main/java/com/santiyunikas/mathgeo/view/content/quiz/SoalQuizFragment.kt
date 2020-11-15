package com.santiyunikas.mathgeo.view.content.quiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import kotlinx.android.synthetic.main.fragment_soal_quiz.*

class SoalQuizFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_soal_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gambar = arguments?.getString(DetailQuizActivity.KEY_GAMBAR)
        if (gambar != "-"){
            Glide.with(view)
                .load(gambar)
                .into(img_soal_quiz)
        }else{
            img_soal_quiz.visibility = View.GONE
        }
        val soal = arguments?.getString(DetailQuizActivity.KEY_SOAL)
        tx_soal_quiz.text = soal?.trimMargin()
        val pilgan_string = arguments?.getString(DetailQuizActivity.KEY_PILIHAN_GANDA)
        val array: Array<String>? = pilgan_string?.split("|")?.toTypedArray()
        pilihan_A.text = array?.get(0) ?: "null"
        pilihan_B.text = array?.get(1) ?: "null"
        pilihan_C.text = array?.get(2) ?: "null"
        pilihan_D.text = array?.get(3) ?: "null"
        pilihan_E.text = array?.get(4) ?: "null"

        radio_quiz.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                pilihan_A.id -> {
                    Preferences.setTempJawaban(view?.context!!, "A")
                    Log.d("pilihan", "A")
                }
                pilihan_B.id -> {
                    Preferences.setTempJawaban(view?.context!!, "B")
                    Log.d("pilihan", "B")
                }
                pilihan_C.id -> {
                    Preferences.setTempJawaban(view?.context!!, "C")
                    Log.d("pilihan", "C")
                }
                pilihan_D.id -> {
                    Preferences.setTempJawaban(view?.context!!, "D")
                    Log.d("pilihan", "D")
                }
                pilihan_E.id -> {
                    Preferences.setTempJawaban(view?.context!!, "E")
                    Log.d("pilihan", "E")
                }
            }
        }
    }
}