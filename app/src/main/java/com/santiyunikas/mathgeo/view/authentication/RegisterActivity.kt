package com.santiyunikas.mathgeo.view.authentication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.*
import com.santiyunikas.mathgeo.presenter.authentication.RegisterPresenter
import com.santiyunikas.mathgeo.util.network.InternetConnection
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener, IView{
    private lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
        presenter = RegisterPresenter(this)
    }

    override fun initView() {
        img_showhide_passsignup.setOnClickListener(this)
        img_showhide_confirmpass.setOnClickListener(this)
        btn_signup.setOnClickListener(this)
        tv_login.setOnClickListener(this)

    }

    override fun updateViewData() {
        edt_full_name.setText("")
        edt_email_signup.setText("")
        edt_telepon.setText("")
        edt_pass_signup.setText("")
        edt_confirmpass.setText("")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            img_showhide_passsignup.id->{
                presenter.showHidePass(edt_pass_signup, img_showhide_passsignup)
            }
            img_showhide_confirmpass.id->{
                presenter.showHidePass(edt_confirmpass, img_showhide_passsignup)
            }
            btn_signup.id->{
                val fullname: String = edt_full_name.text.toString().trim()
                val numberPhone: String = edt_telepon.text.toString().trim()
                val email: String = edt_email_signup.text.toString().trim()
                val password: String = edt_pass_signup.text.toString().trim()
                val confirmPassword: String = edt_confirmpass.text.toString().trim()

                if (inputValid(fullname, numberPhone, email, password, confirmPassword) && InternetConnection.isConnected(this)){
                        presenter.register(fullname, numberPhone, email, password, 0)
                }
            }
            tv_login.id->{
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun inputValid(fullname: String, numberPhone: String, email: String, password: String, confirmPassword: String):Boolean{
        var value = true
        if(fullname.isEmpty()){
            edt_full_name.error = "Nama tidak boleh kosong"
            value = false
        }

        if(numberPhone.isEmpty()){
            edt_telepon.error = "Nomor telepon tidak boleh kosong"
            value = false
        }else if (!Patterns.PHONE.matcher(numberPhone).matches()){
            edt_telepon.error = "Masukkan nomor telepon"
            value = false
        }else if(numberPhone.length<10){
            edt_telepon.error = "Masukkan nomor telepon"
            value = false
        }

        if(email.isEmpty()){
            edt_email_signup.error = "Email tidak boleh kosong"
            value = false
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edt_email_signup.error = "Masukkan email"
            value = false
        }

        if (password.isEmpty()){
            edt_pass_signup.error = "Password tidak boleh kosong"
            value = false
        }else if(password.length<6){
            edt_pass_signup.error = "Password tidak boleh kurang dari 6 digit"
            value = false
        }

        if(confirmPassword.isEmpty()){
            edt_confirmpass.error = "Konfirmasi password tidak boleh kosong"
            value = false
        }else if(confirmPassword != password){
            edt_confirmpass.error = "Konfirmasi password tidak sama dengan password"
            value = false
        }

        return value
    }

    override fun onSuccess(msg: String?) {
        Log.d("suksesRegister", msg)
        Toast.makeText(this, "Registrasi Berhasil, Cek Email Kamu untuk Verifikasi!", Toast.LENGTH_LONG).show()
        updateViewData()
        val mIntent: Intent = Intent(this, LoginActivity::class.java)
        startActivity(mIntent)
        finish()
    }

    override fun onError(msg: String?) {
        Log.d("erorRegister", msg)
        Toast.makeText(this, "Registrasi Gagal, Email Sudah Terdaftar", Toast.LENGTH_LONG).show()
    }


}
