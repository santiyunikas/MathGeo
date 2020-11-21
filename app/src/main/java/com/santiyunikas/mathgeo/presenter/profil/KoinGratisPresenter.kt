package com.santiyunikas.mathgeo.presenter.profil

import android.util.Log
import com.santiyunikas.mathgeo.view.content.profil.KoinGratisActivity
import com.santiyunikas.mathgeo.model.KodeTeman
import com.santiyunikas.mathgeo.model.Member
import com.santiyunikas.mathgeo.util.network.NetworkConfig
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KoinGratisPresenter(context: KoinGratisActivity) {
    private var view: KoinGratisActivity = context

    fun updateJumlahKoin(nKoin: String){
        NetworkConfig.serviceConnection()
            .addNCoin(Preferences.getRegisteredEmail(view), nKoin)
            .enqueue(object: Callback<Member> {
                override fun onFailure(call: Call<Member>, t: Throwable) {
                    Log.d("memberUpdateNKoin",call.toString())
                    view.onError(t.localizedMessage)
                }
                override fun onResponse(
                    call: Call<Member>,
                    response: Response<Member>
                ) {
                    if(response.body()?.jumlah_koin.toString().isNotEmpty()){
                        Log.d("memberNKoin", response.body().toString())
                        val koin = response.body()?.jumlah_koin.toString().toInt()
                        Preferences.setRegisteredJumlahKoin(view, koin)
                        view.onSuccess("addCoinSuccess")
                    }else{
                        view.onError(response.message())
                    }
                }

            })
    }

    fun validasiKode(kodeReferal: String){
        NetworkConfig.serviceConnection()
            .getKodeReferal(kodeReferal)
            .enqueue(object: Callback<List<Member>>{
                override fun onResponse(
                    call: Call<List<Member>>,
                    response: Response<List<Member>>
                ) {
                    if (response.body()?.isNotEmpty()!!) {
                        view.onSuccess("valid")
                    }else{
                        view.onError("notValid")
                    }
                }
                override fun onFailure(call: Call<List<Member>>, t: Throwable) {
                    Log.d("failGetKodeReferal", t.localizedMessage!!)

                }
            })
    }

    fun cekKodeSendiri(kodeReferal: String):Boolean{
        var state = false
        if (kodeReferal != Preferences.getRegisteredKodeReferal(view)){
            state = true
        }else{
            view.onError("kodeSendiri")
        }
        return state
    }

    fun tambahKodeTeman(kodeReferal: String){
        NetworkConfig.serviceConnection()
            .addKodeTeman(Preferences.getRegisteredIdUser(view).toString(), kodeReferal)
            .enqueue(object: Callback<KodeTeman>{
                override fun onResponse(call: Call<KodeTeman>, response: Response<KodeTeman>) {
                    if(response.body()?.id_member.toString() == Preferences.getRegisteredIdUser(view).toString()){
                        var temp = Preferences.getRegisteredJumlahKoin(view)
                        temp = temp?.plus(1)
                        updateJumlahKoin(temp.toString())
                    }else{
                        view.onError("sudahAdaKodeTeman")
                    }
                }

                override fun onFailure(call: Call<KodeTeman>, t: Throwable) {
                    Log.d("onErorAddKodeTeman", t.localizedMessage!!)
                }

            })

    }
}