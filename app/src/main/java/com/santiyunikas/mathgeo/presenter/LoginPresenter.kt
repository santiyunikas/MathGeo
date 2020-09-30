package com.santiyunikas.mathgeo.presenter

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.*
import com.santiyunikas.mathgeo.model.Member
import com.santiyunikas.mathgeo.network.NetworkConfig
import com.santiyunikas.mathgeo.view.RegisterActivity
import com.santiyunikas.mathgeo.view.ResponseInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val loginView: ResponseInterface): Presenter {
    //method untuk login member
    fun login(email: String, password: String){
        NetworkConfig.serviceRegisterMember()
            .login(email)
            .enqueue(object:Callback<List<Member>>{
                override fun onFailure(call: Call<List<Member>>, t: Throwable) {
                    Log.d("memberLogin",call.toString())
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
                            loginView.onError(response.message())
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