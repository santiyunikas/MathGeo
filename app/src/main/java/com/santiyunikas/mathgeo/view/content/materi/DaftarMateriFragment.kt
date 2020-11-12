package com.santiyunikas.mathgeo.view.content.materi

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarMateri
import com.santiyunikas.mathgeo.presenter.materi.DaftarMateriPresenter
import kotlinx.android.synthetic.main.fragment_daftar_materi.*

class DaftarMateriFragment : Fragment() {
    private val list = ArrayList<DaftarMateri>()
    private lateinit var presenter: DaftarMateriPresenter

    companion object{
        const val KEY_ID_MATERI = "EXTRA_ID_MATERI"
        const val KEY_JUDUL_MATERI = "EXTRA_JUDUL_MATERI"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_materi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_list_materi.setHasFixedSize(true)
        rv_list_materi.isNestedScrollingEnabled = true
        presenter = DaftarMateriPresenter(this)

        list.addAll(presenter.getDaftarMateri())
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rv_list_materi.layoutManager = LinearLayoutManager(context)
        val daftarMateriAdapter = DaftarMateriAdapter(list)
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
        intent.putExtra(KEY_ID_MATERI, position+1)
        intent.putExtra(KEY_JUDUL_MATERI, materi.title)
        startActivity(intent)
    }

}