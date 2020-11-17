package com.santiyunikas.mathgeo.presenter.latihan

import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarLatihan
import com.santiyunikas.mathgeo.view.content.beranda.BerandaFragment
import com.santiyunikas.mathgeo.view.content.latihan.DaftarLatihanFragment

class DaftarLatihanPresenter() {
     var viewLatihan = DaftarLatihanFragment()
     var viewBeranda = BerandaFragment()

    constructor(context: DaftarLatihanFragment):this(){
        viewLatihan = context
    }
    constructor(context1: BerandaFragment) : this(){
        viewBeranda = context1
    }

    fun getDaftarLatihan(): ArrayList<DaftarLatihan>{
        val dataTitle = viewLatihan.resources.getStringArray(R.array.array_title_latihan)
        val dataDesc = viewLatihan.resources.getStringArray(R.array.array_title_materi)

        val daftarLatihan = ArrayList<DaftarLatihan>()
        repeat(dataTitle.count()) {
            val latihan = DaftarLatihan(
                dataTitle[it],
                dataDesc[it]
            )
            daftarLatihan.add(latihan)
        }
        return daftarLatihan
    }

    fun getDaftarLatihanBeranda(): ArrayList<DaftarLatihan>{
        val dataTitle = viewBeranda.resources.getStringArray(R.array.array_title_latihan)
        val dataDesc = viewBeranda.resources.getStringArray(R.array.array_title_materi)

        val daftarLatihan = ArrayList<DaftarLatihan>()
        repeat(dataTitle.count()) {
            val latihan = DaftarLatihan(
                dataTitle[it],
                dataDesc[it]
            )
            daftarLatihan.add(latihan)
        }
        return daftarLatihan
    }
}