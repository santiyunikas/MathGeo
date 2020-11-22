package com.santiyunikas.mathgeo.view.content.beranda

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TabHost
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
    }
    private fun showRecyclerListMateri(){
        rv_list_materi.layoutManager = LinearLayoutManager(context)
        val daftarMateriAdapter = DaftarMateriAdapter(listMateri)
        rv_list_materi.adapter = daftarMateriAdapter
    }

    private fun showRecyclerListQuiz(){
        rv_list_quiz.layoutManager = LinearLayoutManager(context)
        val daftarQuizAdapter = DaftarQuizAdapter(listQuiz)
        rv_list_quiz.adapter = daftarQuizAdapter
    }



}
