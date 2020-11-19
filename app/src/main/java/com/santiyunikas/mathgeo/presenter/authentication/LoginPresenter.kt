package com.santiyunikas.mathgeo.presenter.authentication

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.model.Member
import com.santiyunikas.mathgeo.util.network.NetworkConfig
import com.santiyunikas.mathgeo.view.authentication.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(context: LoginActivity){

    private var view: LoginActivity = context

    //method untuk login member
    fun login(email: String, password: String){
        NetworkConfig.serviceConnection()
            .login(email)
            .enqueue(object:Callback<List<Member>>{
                override fun onFailure(call: Call<List<Member>>, t: Throwable) {
                    Log.d("memberGagalLogin",call.toString())
                    view.onError(t.localizedMessage)
                }
                override fun onResponse(
                    call: Call<List<Member>>,
                    response: Response<List<Member>>
                ) {
                    if(response.body()?.isNotEmpty()!!){
                        Log.d("memberLogin", response.body()?.toString())
                        if (response.body()?.get(0)?.email.toString() == email && response.body()?.get(0)?.password.toString() == password){
                            if (response.body()?.get(0)?.active.toString() == "0"){
                                view.onError("notActive")
                            }else{
                                view.onSuccess("isSuccess")
                                view.passingData(
                                    response.body()?.get(0)?.fullname.toString(),
                                    response.body()?.get(0)?.email.toString(),
                                    response.body()?.get(0)?.phoneNumber.toString(),
                                    response.body()?.get(0)?.kode_referal.toString(),
                                    response.body()?.get(0)?.jumlah_koin.toString().toInt(),
                                    response.body()?.get(0)?.id_member.toString().toInt())
                            }
                        }else{
                            view.onError("differentPass")
                        }
                    }else{
                        view.onError(response.message())
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