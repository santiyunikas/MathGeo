package com.santiyunikas.mathgeo.presenter

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.provider.Settings
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.*
import com.santiyunikas.mathgeo.model.Member
import com.santiyunikas.mathgeo.network.NetworkConfig
import com.santiyunikas.mathgeo.view.LoginActivity
import com.santiyunikas.mathgeo.view.RegisterActivity
import com.santiyunikas.mathgeo.view.ResponseInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val loginView: ResponseInterface): Presenter {
    //method untuk reset password
    fun resetPassword(email: String, password: String){
        NetworkConfig.serviceConnection()
            .resetPassword(email, password)
            .enqueue(object:Callback<Member>{
                override fun onFailure(call: Call<Member>, t: Throwable) {
                    loginView.onError("resetPasswordFail")
                    Log.d("erorResetPassword", t.localizedMessage)
                }

                override fun onResponse(call: Call<Member>, response: Response<Member>) {
                    Log.d("memberResetPassword", response.body()?.toString())
                    loginView.onSuccess("resetPassSuccess")
                }

            })
    }

    //method untuk login member
    fun login(email: String, password: String){
        NetworkConfig.serviceConnection()
            .login(email)
            .enqueue(object:Callback<List<Member>>{
                override fun onFailure(call: Call<List<Member>>, t: Throwable) {
                    Log.d("memberGagalLogin",call.toString())
                    loginView.onError(t.localizedMessage)
                }
                override fun onResponse(
                    call: Call<List<Member>>,
                    response: Response<List<Member>>
                ) {
                    if(!response.body()?.isEmpty()!!){
                        Log.d("memberLogin", response.body()?.toString())
                        if (response.body()?.get(0)?.email.toString().equals(email) && response.body()?.get(0)?.password.toString().toString().equals(password)){
                            loginView.onSuccess("isSuccess")
                        }else{
                            loginView.onError("differentPass")
                        }
                    }else{
                        loginView.onError(response.message())
                    }
                }

            })
    }
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