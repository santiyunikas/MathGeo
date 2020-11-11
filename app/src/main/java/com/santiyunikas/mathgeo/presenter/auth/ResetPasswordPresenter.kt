package com.santiyunikas.mathgeo.presenter.auth

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.Member
import com.santiyunikas.mathgeo.util.network.NetworkConfig
import com.santiyunikas.mathgeo.view.authentication.ResetPasswordFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ResetPasswordPresenter(context: ResetPasswordFragment) {
    private var view: ResetPasswordFragment = context

    //method untuk menampilkan dan menyembunyikan password
    fun showHidePass(editText: EditText, imageView: ImageView){
        if(editText.transformationMethod == PasswordTransformationMethod.getInstance()){
            imageView.setImageResource(R.drawable.ic_show_pass)
            //Show Password
            editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }
        else{
            imageView.setImageResource(R.drawable.ic_hide_pass)
            //Hide Password
            editText.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

    fun changePassword(email: String?, password: String){
        NetworkConfig.serviceConnection()
            .resetPassword(email, password)
            .enqueue(object: Callback<Member> {
                override fun onResponse(call: Call<Member>, response: Response<Member>) {
                    if(response.body()?.email != null){
                        view.onSuccess(response.message())
                        Log.d("changePasswordSuccess", response.body()?.toString())
                    }else{
                        view.onError("noAccount")
                        Log.d("changePasswordFail", response.message())
                    }
                }

                override fun onFailure(call: Call<Member>, t: Throwable) {
                    view.onError("noResponse")
                    Log.d("changePasswordFail", t.localizedMessage)
                }

            })
    }
}