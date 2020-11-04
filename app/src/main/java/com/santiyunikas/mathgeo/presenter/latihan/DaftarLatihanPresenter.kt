package com.santiyunikas.mathgeo.presenter.latihan

import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarLatihan
import com.santiyunikas.mathgeo.view.content.latihan.DaftarLatihanFragment

class DaftarLatihanPresenter(context: DaftarLatihanFragment) {
    private var view = context

    fun getDaftarLatihan(): ArrayList<DaftarLatihan>{
        val dataTitle = view.resources.getStringArray(R.array.array_title_latihan)
        val dataDesc = view.resources.getStringArray(R.array.array_desc_latihan)

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