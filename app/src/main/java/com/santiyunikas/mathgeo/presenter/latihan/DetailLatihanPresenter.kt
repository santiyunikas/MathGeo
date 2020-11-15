package com.santiyunikas.mathgeo.presenter.latihan

import android.content.Context
import android.util.Log
import com.santiyunikas.mathgeo.model.DetailLatihan
import com.santiyunikas.mathgeo.model.Member
import com.santiyunikas.mathgeo.model.StatusMengerjakanLatihan
import com.santiyunikas.mathgeo.util.network.NetworkConfig
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import com.santiyunikas.mathgeo.view.content.latihan.DetailLatihanActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailLatihanPresenter() {
    lateinit var view: DetailLatihanActivity
    lateinit var view2: Context
    constructor(context: DetailLatihanActivity):this(){
        view = context
    }
    constructor(context: Context):this(){
        view2 = context
    }


    fun getDetailLatihan(id_latihan: Int) {
        NetworkConfig
            .serviceConnection()
            .getDetailLatihan(id_latihan)
            .enqueue(object : Callback<List<DetailLatihan>> {
                override fun onResponse(
                    call: Call<List<DetailLatihan>>,
                    response: Response<List<DetailLatihan>>
                ) {
                    val n = response.body()?.size
                    var it = 0
                    if (n != null) {
                        while (it < n) {
//                            Log.d("isiSoal",response.body()?.get(it)?.id_soal!!)
                            view?.passingData(
                                response.body()?.get(it)?.id_soal!!,
                                response.body()?.get(it)?.id_latihan!!,
                                response.body()?.get(it)?.soal!!,
                                response.body()?.get(it)?.kunci!!,
                                response.body()?.get(it)?.pilihan_ganda!!,
                                response.body()?.get(it)?.gambar!!)
                            it++
                        }
                    }
                    view?.onSuccess("passingDataDone")
                }

                override fun onFailure(call: Call<List<DetailLatihan>>, t: Throwable) {
                    view?.onError(t.localizedMessage)
                }

            })
    }

    fun simpanReviewLatihan(jawaban: ArrayList<String>, soal: ArrayList<DetailLatihan>){
        var jmlBenar = 0
        var jmlSalah = 0
        repeat(jawaban.size){
            if (jawaban.get(it) == soal.get(it).kunci){
                jmlBenar++
            }else{
                jmlSalah++
            }
        }
        view?.onSuccess(jmlBenar.toString())

        NetworkConfig
            .serviceConnection()
            .getStatusMengerjakanLatihan(Preferences.getRegisteredIdUser(view?.applicationContext!!).toString(), soal[0].id_latihan)
            .enqueue(object : Callback<List<StatusMengerjakanLatihan>>{
                override fun onResponse(
                    call: Call<List<StatusMengerjakanLatihan>>,
                    response: Response<List<StatusMengerjakanLatihan>>
                ) {
                    Log.d("jmlbenar", response.body()?.size.toString())
                    Log.d("jmlbenar", response.body()?.toString())
                    if (response.body()?.size!! > 0){
                        Preferences.getRegisteredIdUser(view?.applicationContext!!)?.let {
                            Log.d("jmlbenar", jmlBenar.toString())
                            updateReview(it, soal[0].id_latihan, jmlBenar)
                        }
                    }else if (response.body()?.size!! == 0){
                        Preferences.getRegisteredIdUser(view?.applicationContext!!)?.let {
                            postReview(it, soal[0].id_latihan, jmlBenar)
                        }
                    }
                }

                override fun onFailure(call: Call<List<StatusMengerjakanLatihan>>, t: Throwable) {
                    view?.onError(t.localizedMessage)
                }


            })

        if (jmlSalah > jmlBenar){
            view?.showReviewLatihan("gagal")
        }else{
            view?.showReviewLatihan("lulus")
        }
    }

    private fun postReview(id_member: Int, id_latihan: String, nilai: Int){
        NetworkConfig
            .serviceConnection()
            .addNilaiLatihan(id_member.toString(), id_latihan, nilai.toString())
            .enqueue(object : Callback<StatusMengerjakanLatihan>{
                override fun onResponse(
                    call: Call<StatusMengerjakanLatihan>,
                    response: Response<StatusMengerjakanLatihan>
                ) {
                    if (response.body()?.id_latihan != null){
                        Log.d("successAddNilai", response.body().toString())
                        view?.onSuccess("successAddNilai")
                    }else{
                        view?.onError("Gagal Tambah Nilai")
                    }

                }

                override fun onFailure(call: Call<StatusMengerjakanLatihan>, t: Throwable) {
                    view?.onError(t.localizedMessage)
                }

            })
    }

    private fun updateReview(id_member: Int, id_latihan: String, nilai: Int){
        NetworkConfig
            .serviceConnection()
            .updateNilaiLatihan(id_member.toString(), id_latihan, nilai.toString())
            .enqueue(object: Callback<StatusMengerjakanLatihan>{
                override fun onResponse(
                    call: Call<StatusMengerjakanLatihan>,
                    response: Response<StatusMengerjakanLatihan>
                ) {
                    if (response.body()?.toString()?.isNotEmpty()!!){
                        Log.d("successUpdateNilai", response.body().toString())
                        view?.onSuccess("successUpdateNilai")
                    }else{
                        view?.onError("Gagal Update Nilai")
                    }
                }

                override fun onFailure(call: Call<StatusMengerjakanLatihan>, t: Throwable) {
                    view?.onError(t.localizedMessage)
                }
            })
    }

    fun updateJumlahKoin(nKoin: String){
        NetworkConfig.serviceConnection()
            .addNCoin(Preferences.getRegisteredEmail(view2), nKoin)
            .enqueue(object: Callback<Member> {
                override fun onFailure(call: Call<Member>, t: Throwable) {
                    Log.d("eror",t.localizedMessage)
                }
                override fun onResponse(
                    call: Call<Member>,
                    response: Response<Member>
                ) {
                    if(response.body()?.jumlah_koin.toString().isNotEmpty()){
                        val koin = response.body()?.jumlah_koin.toString().toInt()
                        view2.let { Preferences.setRegisteredJumlahKoin(it, koin) }
                        Log.d("jmlkoin1", Preferences.getRegisteredJumlahKoin(view2).toString())
                    }else{
                        Log.d("eror2",response.message())
                    }
                }

            })
    }
}