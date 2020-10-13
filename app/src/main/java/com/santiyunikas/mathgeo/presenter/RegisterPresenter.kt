package com.santiyunikas.mathgeo.presenter

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.EditText
import android.widget.ImageView

import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.Presenter
import com.santiyunikas.mathgeo.model.MemberModel
import com.santiyunikas.mathgeo.network.NetworkConfig
import com.santiyunikas.mathgeo.view.ResponseInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterPresenter(val registerView: ResponseInterface): Presenter {

    //method untuk register pengguna baru
    fun register(fullname: String, numberPhone: String, email: String, password: String, active: Int){
        NetworkConfig.serviceConnection()
            .register(email, password, fullname, numberPhone, active)
            .enqueue(object: Callback<MemberModel>{
                override fun onFailure(call: Call<MemberModel>, t: Throwable) {
                    registerView.onError(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<MemberModel>,
                    response: Response<MemberModel>
                ) {
                    if(response.body()?.email  != null){
                        registerView.onSuccess(response.message())
                        Log.d("memberRegister", response.body()?.toString())
                    }else{
                        registerView.onError(response.message())
                    }
                }
            })
    }

    //method untuk menampilkan dan menyembunyikan password
    fun showHidePass(editText: EditText, imageView: ImageView){
        if(editText.transformationMethod == PasswordTransformationMethod.getInstance()){
            imageView.setImageResource(R.drawable.ic_show_pass);
            //Show Password
            editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }
        else{
            imageView.setImageResource(R.drawable.ic_hide_pass);
            //Hide Password
            editText.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }
}