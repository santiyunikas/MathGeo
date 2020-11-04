package com.santiyunikas.mathgeo.presenter.materi

import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarMateri
import com.santiyunikas.mathgeo.view.content.materi.DaftarMateriFragment

class DaftarMateriPresenter(context: DaftarMateriFragment) {
    private var view = context

    fun getDaftarMateri(): ArrayList<DaftarMateri>{
        val dataTitle = view.resources.getStringArray(R.array.array_title_materi)
        val dataDesc = view.resources.getStringArray(R.array.array_desc_materi)

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