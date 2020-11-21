package com.santiyunikas.mathgeo.presenter.latihan

import android.util.Log
import com.santiyunikas.mathgeo.model.PembahasanLatihan
import com.santiyunikas.mathgeo.util.network.NetworkConfig
import com.santiyunikas.mathgeo.view.content.latihan.DetailLatihanActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PembahasanLatihanPresenter(context: DetailLatihanActivity) {
    private var view = context

    fun getPembahasan(idLatihan: String){
        NetworkConfig
            .serviceConnection()
            .getPembahasanLatihan(idLatihan)
            .enqueue(object: Callback<List<PembahasanLatihan>>{
                override fun onResponse(
                    call: Call<List<PembahasanLatihan>>,
                    response: Response<List<PembahasanLatihan>>
                ) {
                    Log.d("successPembahasan", response.body()!!.size.toString()+": "+response.body()!!)
                    repeat(response.body()!!.size){
                        view.passingPembahasan(response.body()!![it].id_pembahasan, response.body()!![it].id_soal, response.body()!![it].text, response.body()!![it].gambar)
                    }
                }

                override fun onFailure(call: Call<List<PembahasanLatihan>>, t: Throwable) {
                    Log.d("erorPembahasan", t.localizedMessage!!)
                }

            })
    }
}