package com.santiyunikas.mathgeo.presenter.profil

import android.util.Log
import com.santiyunikas.mathgeo.view.content.profil.EditProfileActivity
import com.santiyunikas.mathgeo.util.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.santiyunikas.mathgeo.model.Member
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences


class EditProfilPresenter(context: EditProfileActivity) {
    private var view = context

    fun editProfil(name: String, phone: String, email: String){
        NetworkConfig.serviceConnection()
            .editProfile(Preferences.getRegisteredIdUser(view).toString(),name, phone, email)
            .enqueue(object: Callback<Member>{
                override fun onResponse(call: Call<Member>, response: Response<Member>) {
                    if(response.body()?.email!=null){
                        Preferences.setRegisteredFullname(view, response.body()?.fullname)
                        Preferences.setRegisteredPhone(view, response.body()?.phoneNumber)
                        Preferences.setRegisteredEmail(view, response.body()?.email)
                        view.onSuccess("editSuccess")
                    }else{
                        view.onError("editError")
                    }
                }

                override fun onFailure(call: Call<Member>, t: Throwable) {
                    Log.d("editMemberFail", t.localizedMessage!!)
                    view.onError("editError")
                }

            })
    }
}