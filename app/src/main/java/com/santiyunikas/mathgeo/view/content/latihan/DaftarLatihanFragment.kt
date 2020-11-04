package com.santiyunikas.mathgeo.view.content.latihan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarLatihan
import com.santiyunikas.mathgeo.presenter.latihan.DaftarLatihanPresenter

class DaftarLatihanFragment : Fragment() {
    private lateinit var rvDaftarLatihan: RecyclerView
    private lateinit var presenter: DaftarLatihanPresenter
    private val list = ArrayList<DaftarLatihan>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_latihan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvDaftarLatihan = view.findViewById(R.id.rv_list_latihan)
        rvDaftarLatihan.setHasFixedSize(true)

        presenter = DaftarLatihanPresenter(this)

        list.addAll(presenter.getDaftarLatihan())
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvDaftarLatihan.layoutManager = LinearLayoutManager(context)
        val daftarLatihanAdapter = DaftarLatihanAdapter(list)
        rvDaftarLatihan.adapter = daftarLatihanAdapter
    }
}
