package com.santiyunikas.mathgeo.presenter

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.provider.Settings
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.*
import com.santiyunikas.mathgeo.model.Member
import com.santiyunikas.mathgeo.util.network.NetworkConfig
import com.santiyunikas.mathgeo.view.authentication.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(context: LoginActivity): IPresenter {

    private var view: LoginActivity = context
//    private lateinit var model: LoginModel

    //method untuk reset password
    fun resetPassword(email: String, password: String){
        NetworkConfig.serviceConnection()
            .resetPassword(email, password)
            .enqueue(object:Callback<Member>{
                override fun onFailure(call: Call<Member>, t: Throwable) {
                    view.onError("resetPasswordFail")
                    Log.d("erorResetPassword", t.localizedMessage)
                }

                override fun onResponse(call: Call<Member>, response: Response<Member>) {
                    Log.d("memberResetPassword", response.body()?.toString())
                    view.onSuccess("resetPassSuccess")
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
                    view.onError(t.localizedMessage)
                }
                override fun onResponse(
                    call: Call<List<Member>>,
                    response: Response<List<Member>>
                ) {
                    if(!response.body()?.isEmpty()!!){
                        Log.d("memberLogin", response.body()?.toString())
                        if (response.body()?.get(0)?.email.toString().equals(email) && response.body()?.get(0)?.password.toString().toString().equals(password)){
                            if (response.body()?.get(0)?.active.toString().equals("0")){
                                view.onError("notActive")
                            }else{
                                view.onSuccess("isSuccess")
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
            Toast.makeText(context, "Aktifkan KOneksi Internet Anda", Toast.LENGTH_SHORT)
                .show()
            false
        } else {
            true
        }
        return state
    }

}