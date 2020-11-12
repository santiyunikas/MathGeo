package com.santiyunikas.mathgeo.view.content.latihan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.DaftarLatihan
import com.santiyunikas.mathgeo.presenter.latihan.DaftarLatihanPresenter
import kotlinx.android.synthetic.main.fragment_daftar_latihan.*


class DaftarLatihanFragment : Fragment() {

    private lateinit var presenter: DaftarLatihanPresenter
    private val list = ArrayList<DaftarLatihan>()

    companion object{
        const val KEY_ID_LATIHAN = "EXTRA_ID_LATIHAN"
        const val KEY_JUDUL_LATIHAN = "EXTRA_JUDUL_LATIHAN"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_daftar_latihan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_list_latihan.setHasFixedSize(true)
        presenter = DaftarLatihanPresenter(this)

        list.addAll(presenter.getDaftarLatihan())
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rv_list_latihan.layoutManager = LinearLayoutManager(context)
        val daftarLatihanAdapter = DaftarLatihanAdapter(list)
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
        intent.putExtra(KEY_ID_LATIHAN, position+1)
        intent.putExtra(KEY_JUDUL_LATIHAN, latihan.title)
        startActivity(intent)
    }
}
