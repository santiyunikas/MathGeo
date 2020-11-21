package com.santiyunikas.mathgeo.presenter.materi

import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarMateri
import com.santiyunikas.mathgeo.view.content.beranda.BerandaFragment
import com.santiyunikas.mathgeo.view.content.materi.DaftarMateriFragment

class DaftarMateriPresenter() {

    private var viewMateri = DaftarMateriFragment()
    private var viewBeranda = BerandaFragment()

    constructor(context: DaftarMateriFragment):this(){
        viewMateri = context
    }
    constructor(context1: BerandaFragment) : this(){
        viewBeranda = context1
    }

    fun getDaftarMateri(): ArrayList<DaftarMateri>{
        val dataTitle = viewMateri.resources.getStringArray(R.array.array_title_materi)
        val dataDesc = viewMateri.resources.getStringArray(R.array.array_desc_materi)

        val daftarMateri = ArrayList<DaftarMateri>()
        repeat(dataTitle.count()) {
            val materi = DaftarMateri(
                dataTitle[it],
                dataDesc[it]
            )
            daftarMateri.add(materi)
        }
        return daftarMateri
    }

    fun getDaftarMateriBeranda(): ArrayList<DaftarMateri>{
        val dataTitle = viewBeranda.resources.getStringArray(R.array.array_title_materi)
        val dataDesc = viewBeranda.resources.getStringArray(R.array.array_desc_materi)

        val daftarMateri = ArrayList<DaftarMateri>()
        repeat(dataTitle.count()) {
            val materi = DaftarMateri(
                dataTitle[it],
                dataDesc[it]
            )
            daftarMateri.add(materi)
        }
        return daftarMateri
    }
}