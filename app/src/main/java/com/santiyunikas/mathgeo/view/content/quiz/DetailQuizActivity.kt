package com.santiyunikas.mathgeo.view.content.quiz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface
import com.santiyunikas.mathgeo.model.DetailQuiz
import com.santiyunikas.mathgeo.presenter.quiz.DetailQuizPresenter
import com.santiyunikas.mathgeo.util.network.InternetConnection
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import kotlinx.android.synthetic.main.activity_detail_quiz.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailQuizActivity : AppCompatActivity(), ContractInterface.IView {
    private var idQuiz = 0
    private var judulQuiz = ""
    private lateinit var presenter: DetailQuizPresenter
    private var arraySoal = arrayListOf<DetailQuiz>()
    private var jawaban = arrayListOf<String>()
    private var counterSoal = 0
    private var isNotSubmited = true

    companion object {
        const val KEY_SOAL = "SOAL"
        const val KEY_KUNCI = "KUNCI"
        const val KEY_PILIHAN_GANDA = "PILIHAN_GANDA"
        const val KEY_GAMBAR = "GAMBAR"
        const val KEY_NILAI = "NILAI"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_quiz)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Quiz Bangun Ruang"

        if (InternetConnection.isConnected(this)){
            idQuiz = intent.getIntExtra(DaftarQuizFragment.KEY_ID_QUIZ, 0)
            judulQuiz = intent.getStringExtra(DaftarQuizFragment.KEY_JUDUL_QUIZ)
            presenter = DetailQuizPresenter(this)
            presenter.getDetailQuiz(idQuiz)
            initView()
        }else{
            finish()
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                super.onOptionsItemSelected(item)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun initView() {
        judul_quiz.text = judulQuiz
        content_detail_quiz.visibility = View.GONE
        btn_submit_soalquiz.visibility = View.GONE
        btn_submit_soalquiz.setOnClickListener {
            if (Preferences.getTempJawaban(this) != "null") {
                if (isNotSubmited){
                    var temp = Preferences.getRegisteredJumlahKoin(this)
                    temp = temp?.minus(1 )
                    presenter.updateJumlahKoin(temp.toString())

                    rekamJawaban()
                    isNotSubmited = false
                }
                presenter.simpanReviewQuiz(jawaban, arraySoal)
            } else {
                Toast.makeText(this, "Pilih satu jawaban", Toast.LENGTH_LONG).show()
            }


        }

        btn_next_soalquiz.setOnClickListener {
            if (Preferences.getTempJawaban(this) != "null") {
                if (counterSoal == arraySoal.size - 2) {
                    btn_submit_soalquiz.visibility = View.VISIBLE
                    btn_next_soalquiz.visibility = View.GONE
                }

                if (counterSoal != arraySoal.size - 1) {
                    rekamJawaban()
                    counterSoal++
                    updateViewData()
                }
            } else {
                Toast.makeText(this, "Pilih satu jawaban", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun rekamJawaban() {
        jawaban.add(counterSoal, Preferences.getTempJawaban(this).toString())
//        Log.d("pilihanmasuk", Preferences.getTempJawaban(this).toString())
        Preferences.clearTempJawaban(this)
    }

    override fun updateViewData() {
        val bundle = Bundle()
        bundle.putString(KEY_SOAL, arraySoal[counterSoal].soal)
        bundle.putString(KEY_KUNCI, arraySoal[counterSoal].kunci)
        bundle.putString(KEY_PILIHAN_GANDA, arraySoal[counterSoal].pilihan_ganda)
        bundle.putString(KEY_GAMBAR, arraySoal[counterSoal].gambar)
        val fragment = SoalQuizFragment()
        fragment.arguments = bundle

        val fm: FragmentManager = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.frame_quiz, fragment)
        transaction.commit()
    }

    override fun onSuccess(msg: String?) {
        when (msg) {
            "passingDataDone" -> {
                updateViewData()
                content_detail_quiz.visibility = View.VISIBLE
                rolling_quiz.visibility = View.GONE
            }
            "successAddNilai" -> {
                Toast.makeText(this, "Jawaban kamu berhasil disimpan", Toast.LENGTH_LONG).show()
            }
            "successUpdateNilai" -> {
                Toast.makeText(this, "Jawaban kamu berhasil disimpan", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onError(msg: String?) {
        Log.d("failGetDetailQuiz", msg)
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    fun passingData(
        id_soal: String,
        id_quiz: String,
        soal: String,
        kunci: String,
        pilihan_ganda: String,
        gambar: String
    ) {
        val soalQuiz = DetailQuiz(id_soal, id_quiz, soal, kunci, pilihan_ganda, gambar)
//        Log.d("masuksini",soal.id_soal)
        arraySoal.add(soalQuiz)
    }

    fun showReviewDialog(nilai: Int){
        val bundle = Bundle()
        bundle.putInt(KEY_NILAI, nilai)
        val fragment = ReviewQuizDialogFragment()
        fragment.arguments = bundle

        val fm = supportFragmentManager

        fragment.show(fm, ReviewQuizDialogFragment::class.java.simpleName)
    }
}