package com.santiyunikas.mathgeo.view.content.beranda

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TabHost
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarLatihan
import com.santiyunikas.mathgeo.model.DaftarMateri
import com.santiyunikas.mathgeo.model.DaftarQuiz
import com.santiyunikas.mathgeo.presenter.latihan.DaftarLatihanPresenter
import com.santiyunikas.mathgeo.presenter.materi.DaftarMateriPresenter
import com.santiyunikas.mathgeo.presenter.quiz.DaftarQuizPresenter
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import com.santiyunikas.mathgeo.view.content.latihan.DaftarLatihanFragment
import com.santiyunikas.mathgeo.view.content.latihan.DetailLatihanActivity
import com.santiyunikas.mathgeo.view.content.materi.DaftarMateriFragment
import com.santiyunikas.mathgeo.view.content.materi.DetailMateriActivity
import com.santiyunikas.mathgeo.view.content.quiz.DaftarQuizFragment
import com.santiyunikas.mathgeo.view.content.quiz.DetailQuizActivity
import kotlinx.android.synthetic.main.fragment_beranda.*
import kotlinx.android.synthetic.main.fragment_beranda.rv_list_latihan
import kotlinx.android.synthetic.main.fragment_beranda.rv_list_materi
import kotlinx.android.synthetic.main.fragment_beranda.rv_list_quiz


class BerandaFragment : Fragment(){

    private lateinit var presenterLatihan: DaftarLatihanPresenter
    private val listLatihan = ArrayList<DaftarLatihan>()

    private val listMateri = ArrayList<DaftarMateri>()
    private lateinit var presenterMateri: DaftarMateriPresenter

    private lateinit var presenterQuiz: DaftarQuizPresenter
    private val listQuiz = ArrayList<DaftarQuiz>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nama = Preferences.getRegisteredFullname(activity?.applicationContext!!)
        tx_greetings.text = "Halo, $nama"
        val tabs = view.findViewById(R.id.tabhost) as TabHost
        tabs.setup()
        var spec = tabs.newTabSpec("tag1")
        spec.setContent(R.id.materi)
        spec.setIndicator("Materi")
        tabs.addTab(spec)
        spec = tabs.newTabSpec("tag2")
        spec.setContent(R.id.latihan)
        spec.setIndicator("Latihan")
        tabs.addTab(spec)
        spec = tabs.newTabSpec("tag3")
        spec.setContent(R.id.quiz)
        spec.setIndicator("Quiz")
        tabs.addTab(spec)

        rv_list_latihan.setHasFixedSize(true)
        presenterLatihan = DaftarLatihanPresenter(this)

        listLatihan.addAll(presenterLatihan.getDaftarLatihanBeranda())
        showRecyclerListLatihan()

        rv_list_materi.setHasFixedSize(true)
        presenterMateri = DaftarMateriPresenter(this)

        listMateri.addAll(presenterMateri.getDaftarMateriBeranda())
        showRecyclerListMateri()

        rv_list_quiz.setHasFixedSize(true)
        presenterQuiz = DaftarQuizPresenter(this)

        listQuiz.addAll(presenterQuiz.getDaftarQuizBeranda())
        showRecyclerListQuiz()
    }

    private fun showRecyclerListLatihan(){
        rv_list_latihan.layoutManager = LinearLayoutManager(context)
        val daftarLatihanAdapter = DaftarLatihanAdapter(listLatihan)
        rv_list_latihan.adapter = daftarLatihanAdapter

        daftarLatihanAdapter.setOnItemClickCallback(object :
            DaftarLatihanAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DaftarLatihan, position: Int) {
                moveDetailLatihan(data, position)
            }
        })
    }
    private fun moveDetailLatihan(latihan: DaftarLatihan, position: Int){
        val intent = Intent(context, DetailLatihanActivity::class.java)
        intent.putExtra(DaftarLatihanFragment.KEY_ID_LATIHAN, position+1)
        intent.putExtra(DaftarLatihanFragment.KEY_JUDUL_LATIHAN, latihan.title)
        startActivity(intent)
    }

    private fun showRecyclerListMateri(){
        rv_list_materi.layoutManager = LinearLayoutManager(context)
        val daftarMateriAdapter = DaftarMateriAdapter(listMateri)
        rv_list_materi.adapter = daftarMateriAdapter

        daftarMateriAdapter.setOnItemClickCallback(object :
            DaftarMateriAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DaftarMateri, position: Int) {
                moveDetailMateri(data, position)
            }

        })
    }

    private fun moveDetailMateri(materi: DaftarMateri, position: Int) {
        val intent = Intent(context, DetailMateriActivity::class.java)
        intent.putExtra(DaftarMateriFragment.KEY_ID_MATERI, position+1)
        intent.putExtra(DaftarMateriFragment.KEY_JUDUL_MATERI, materi.title)
        startActivity(intent)
    }

    private fun showRecyclerListQuiz(){
        rv_list_quiz.layoutManager = LinearLayoutManager(context)
        val daftarQuizAdapter = DaftarQuizAdapter(listQuiz)
        rv_list_quiz.adapter = daftarQuizAdapter

        daftarQuizAdapter.setOnItemClickCallback(object :
            DaftarQuizAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DaftarQuiz, position: Int) {
                if (view?.context?.let { Preferences.getRegisteredJumlahKoin(it) }!! <= 0){
                    Toast.makeText(view?.context, """Koin kamu tidak mencukupi!
                |Kerjakan latihan atau masukkan kode teman untuk mendapat tambahan koin
            """.trimMargin(), Toast.LENGTH_LONG).show()
                }else{
                    moveDetailQuiz(data, position)
                }
            }
        })
    }

    private fun moveDetailQuiz(quiz: DaftarQuiz, position: Int){
        val intent = Intent(context, DetailQuizActivity::class.java)
        intent.putExtra(DaftarQuizFragment.KEY_ID_QUIZ, position+1)
        intent.putExtra(DaftarQuizFragment.KEY_JUDUL_QUIZ, quiz.title)
        startActivity(intent)
    }



}
