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
import com.santiyunikas.mathgeo.contract.ContractInterface.IPresenter
import com.santiyunikas.mathgeo.model.Member
import com.santiyunikas.mathgeo.util.network.NetworkConfig
import com.santiyunikas.mathgeo.view.authentication.RegisterActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterPresenter(context: RegisterActivity): IPresenter {

    private var view: RegisterActivity = context
//    private var model: RegisterModel

    //method untuk register pengguna baru
    fun register(fullname: String, numberPhone: String, email: String, password: String, active: Int){
        NetworkConfig.serviceConnection()
            .register(email, password, fullname, numberPhone, active)
            .enqueue(object: Callback<Member>{
                override fun onFailure(call: Call<Member>, t: Throwable) {
                    view.onError(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<Member>,
                    response: Response<Member>
                ) {
                    if(response.body()?.email  != null){
                        view.onSuccess(response.message())
                        Log.d("memberRegister", response.body()?.toString())
                    }else{
                        view.onError(response.message())
                    }
                }
            })
    }

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