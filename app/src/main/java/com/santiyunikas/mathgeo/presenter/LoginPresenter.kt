package com.santiyunikas.mathgeo.presenter

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.*
import com.santiyunikas.mathgeo.model.MemberModel
import com.santiyunikas.mathgeo.network.NetworkConfig
import com.santiyunikas.mathgeo.view.ResponseInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val loginView: ResponseInterface): Presenter {
    //method untuk reset password
    fun resetPassword(email: String, password: String){
        NetworkConfig.serviceConnection()
            .resetPassword(email, password)
            .enqueue(object:Callback<MemberModel>{
                override fun onFailure(call: Call<MemberModel>, t: Throwable) {
                    loginView.onError("resetPasswordFail")
                    Log.d("erorResetPassword", t.localizedMessage)
                }

                override fun onResponse(call: Call<MemberModel>, response: Response<MemberModel>) {
                    Log.d("memberResetPassword", response.body()?.toString())
                    loginView.onSuccess("resetPassSuccess")
                }

            })
    }

    //method untuk login member
    fun login(email: String, password: String){
        NetworkConfig.serviceConnection()
            .login(email)
            .enqueue(object:Callback<List<MemberModel>>{
                override fun onFailure(call: Call<List<MemberModel>>, t: Throwable) {
                    Log.d("memberGagalLogin",call.toString())
                    loginView.onError(t.localizedMessage)
                }
                override fun onResponse(
                    call: Call<List<MemberModel>>,
                    response: Response<List<MemberModel>>
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