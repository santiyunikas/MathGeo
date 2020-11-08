package com.santiyunikas.mathgeo.view.content.materi

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarMateri
import com.santiyunikas.mathgeo.presenter.materi.DaftarMateriPresenter

class DaftarMateriFragment : Fragment() {
    private lateinit var rvDaftarMateri: RecyclerView
    private val list = ArrayList<DaftarMateri>()
    private lateinit var presenter: DaftarMateriPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_materi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvDaftarMateri = view.findViewById(R.id.rv_list_materi)
        rvDaftarMateri.setHasFixedSize(true)
        rvDaftarMateri.isNestedScrollingEnabled = true
        presenter = DaftarMateriPresenter(this)

        list.addAll(presenter.getDaftarMateri())
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvDaftarMateri.layoutManager = LinearLayoutManager(context)
        val daftarMateriAdapter = DaftarMateriAdapter(list)
        rvDaftarMateri.adapter = daftarMateriAdapter

        daftarMateriAdapter.setOnItemClickCallback(object :
            DaftarMateriAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DaftarMateri, position: Int) {
                moveDetailMateri(data, position)
            }

        })
    }

    private fun moveDetailMateri(materi: DaftarMateri, position: Int) {
        val intent = Intent(context, DetailMateriActivity::class.java)
        intent.putExtra("EXTRA_SESSION_ID", position+1)
        intent.putExtra("EXTRA_SESSION_JUDUL_MATERI", materi.title)
        startActivity(intent)
    }

}