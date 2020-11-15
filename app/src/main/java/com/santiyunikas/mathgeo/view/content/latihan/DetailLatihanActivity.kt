package com.santiyunikas.mathgeo.view.content.latihan

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.*
import com.santiyunikas.mathgeo.model.DetailLatihan
import com.santiyunikas.mathgeo.presenter.latihan.DetailLatihanPresenter
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import kotlinx.android.synthetic.main.activity_detail_latihan.*
import com.santiyunikas.mathgeo.view.content.latihan.DaftarLatihanFragment.Companion as DaftarLatihanFragment1

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailLatihanActivity : AppCompatActivity(), IView {
    private var idLatihan = 0
    private var judulLatihan = ""
    private lateinit var presenter: DetailLatihanPresenter
    private var arraySoal = arrayListOf<DetailLatihan>()
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
        setContentView(R.layout.activity_detail_latihan)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        idLatihan = intent.getIntExtra(DaftarLatihanFragment1.KEY_ID_LATIHAN, 0)
        judulLatihan = intent.getStringExtra(DaftarLatihanFragment1.KEY_JUDUL_LATIHAN)
//        Log.d("latihanIdentity", "$idLatihan = $judulLatihan")

        presenter = DetailLatihanPresenter(this)
        presenter.getDetailLatihan(idLatihan)
        initView()
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
        judul_latihan.text = judulLatihan
        content_detail_latihan.visibility = View.GONE
        btn_submit_soallatihan.visibility = View.GONE
        if (idLatihan == 1) {
            btn_cek_jawaban.visibility = View.GONE
        }
        btn_submit_soallatihan.setOnClickListener {
            if (Preferences.getTempJawaban(this) != "null") {
                if (isNotSubmited) {
                    rekamJawaban()
                    isNotSubmited = false
                }
                presenter.simpanReviewLatihan(jawaban, arraySoal)
            } else {
                Toast.makeText(this, "Pilih satu jawaban", Toast.LENGTH_LONG).show()
            }


        }

        btn_next_soallatihan.setOnClickListener {
            if (Preferences.getTempJawaban(this) != "null") {
                if (counterSoal == arraySoal.size - 2) {
                    btn_submit_soallatihan.visibility = View.VISIBLE
                    btn_next_soallatihan.visibility = View.GONE
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

        btn_cek_jawaban.setOnClickListener {
            if (Preferences.getTempJawaban(this) != "null") {
                TODO("munculkan dialog pembahasan dengan melakukan passing data id_soal, soal, pilihan ganda, ganda dari arraySoal.get(countersoal)")
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

    fun passingData(
        id_soal: String,
        id_latihan: String,
        soal: String,
        kunci: String,
        pilihan_ganda: String,
        gambar: String
    ) {
        val soal = DetailLatihan(id_soal, id_latihan, soal, kunci, pilihan_ganda, gambar)
//        Log.d("masuksini",soal.id_soal)
        arraySoal.add(soal)
    }

    override fun updateViewData() {
        val bundle = Bundle()
        bundle.putString(KEY_SOAL, arraySoal[counterSoal].soal)
        bundle.putString(KEY_KUNCI, arraySoal[counterSoal].kunci)
        bundle.putString(KEY_PILIHAN_GANDA, arraySoal[counterSoal].pilihan_ganda)
        bundle.putString(KEY_GAMBAR, arraySoal[counterSoal].gambar)
        val fragment = SoalLatihanFragment()
        fragment.arguments = bundle

        val fm: FragmentManager = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.frame_latihan, fragment)
        transaction.commit()
    }

    override fun onSuccess(msg: String?) {
//        Log.d("successGetDetailLatihan", msg)
        when (msg) {
            "passingDataDone" -> {
                updateViewData()
                content_detail_latihan.visibility = View.VISIBLE
                rolling.visibility = View.GONE
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
        Log.d("failGetDetailLatihan", msg)
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    fun showReviewLatihan(state: String) {
        val bundle = Bundle()
        bundle.putString(KEY_NILAI, state)
        val fragment = ReviewLatihanDialogFragment()
        fragment.arguments = bundle


        val fm = supportFragmentManager
        fragment.show(fm, ReviewLatihanDialogFragment::class.java.simpleName)
    }


}