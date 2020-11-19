package com.santiyunikas.mathgeo.presenter.authentication

import android.util.Log
import com.santiyunikas.mathgeo.model.Member
import com.santiyunikas.mathgeo.util.network.NetworkConfig
import com.santiyunikas.mathgeo.view.authentication.OtpFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OtpPresenter(contextOtp: OtpFragment){
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
}