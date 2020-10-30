package com.santiyunikas.mathgeo.presenter

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import com.santiyunikas.mathgeo.contract.ContractInterface.*
import com.santiyunikas.mathgeo.model.Member
import com.santiyunikas.mathgeo.util.network.NetworkConfig
import com.santiyunikas.mathgeo.view.authentication.OtpFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OtpPresenter(contextOtp: OtpFragment): IPresenter{
    private var view: OtpFragment = contextOtp

    fun sendOtp(email: String){
        NetworkConfig.serviceConnection()
            .sendOtp(email)
            .enqueue(object:Callback<List<Member>>{
                override fun onFailure(call: Call<List<Member>>, t: Throwable) {
                    Log.d("memberGagalSendOtp",call.toString())
                    view.onError(t.localizedMessage)
                }
                override fun onResponse(
                    call: Call<List<Member>>,
                    response: Response<List<Member>>
                ) {
                    if (response.body()!![0].email.isNotEmpty()){
                        if(response.body()!![0].email == email){
                            Log.d("memberSendOtp", response.body()?.toString())
                            if (response.body()!![0].active == "0"){
                                view.onError("notActive")
                            }else{
                                view.onSuccess(response.body()!![0].otp)
                            }
                        }else{
                            view.onError(response.message())
                        }
                    }else{
                        view.onError("noEmail")
                    }

                }

            })
    }

    override fun setView(
        view1: View?,
        view2: View?,
        view3: View?,
        view4: View?,
        view5: View?,
        view6: View?,
        view7: View?
    ) {
        TODO("Not yet implemented")
    }

    override fun isConnected(context: Context?): Boolean {
        val state: Boolean
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetwork
        state = if (activeNetwork == null) {
            context.startActivity(Intent(Settings.ACTION_SETTINGS))
            Toast.makeText(context, "Aktifkan Koneksi Internet Kamu", Toast.LENGTH_SHORT)
                .show()
            false
        } else {
            true
        }
        return state
    }
}