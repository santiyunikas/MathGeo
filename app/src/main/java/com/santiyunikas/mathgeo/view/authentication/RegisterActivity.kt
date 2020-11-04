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
import com.santiyunikas.mathgeo.presenter.auth.RegisterPresenter
import com.santiyunikas.mathgeo.util.network.InternetConnection

class RegisterActivity : AppCompatActivity(), View.OnClickListener, IView{
    private lateinit var edtFullName: EditText
    private lateinit var edtTelepon: EditText
    private lateinit var edtEmailSignUp: EditText
    private lateinit var edtPassSignUp: EditText
    private lateinit var edtConfirmPass: EditText
    private lateinit var btnSignUp: Button
    private lateinit var tvLogin: TextView
    private lateinit var imgShowHidePassSignup: ImageView
    private lateinit var imgShowHideConfirmPass: ImageView
    private lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
        presenter = RegisterPresenter(this)
    }

    override fun initView() {
        edtFullName = findViewById(R.id.edt_full_name)
        edtTelepon = findViewById(R.id.edt_telepon)
        edtEmailSignUp = findViewById(R.id.edt_email_signup)
        edtPassSignUp = findViewById(R.id.edt_pass_signup)
        edtConfirmPass = findViewById(R.id.edt_confirmpass)
        btnSignUp = findViewById(R.id.btn_signup)
        tvLogin = findViewById(R.id.tv_login)
        imgShowHidePassSignup = findViewById(R.id.img_showhide_passsignup)
        imgShowHideConfirmPass = findViewById(R.id.img_showhide_confirmpass)

        imgShowHidePassSignup.setOnClickListener(this)
        imgShowHideConfirmPass.setOnClickListener(this)
        btnSignUp.setOnClickListener(this)
        tvLogin.setOnClickListener(this)

    }

    override fun updateViewData() {
        edtFullName.setText("")
        edtEmailSignUp.setText("")
        edtTelepon.setText("")
        edtPassSignUp.setText("")
        edtConfirmPass.setText("")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            imgShowHidePassSignup.id->{
                presenter.showHidePass(edtPassSignUp, imgShowHidePassSignup)
            }
            imgShowHideConfirmPass.id->{
                presenter.showHidePass(edtConfirmPass, imgShowHideConfirmPass)
            }
            btnSignUp.id->{
                val fullname: String = edtFullName.text.toString().trim()
                val numberPhone: String = edtTelepon.text.toString().trim()
                val email: String = edtEmailSignUp.text.toString().trim()
                val password: String = edtPassSignUp.text.toString().trim()
                val confirmPassword: String = edtConfirmPass.text.toString().trim()

                if (inputValid(fullname, numberPhone, email, password, confirmPassword) && InternetConnection.isConnected(this)){
                        presenter.register(fullname, numberPhone, email, password, 0)
                }
            }
            tvLogin.id->{
                val intent: Intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun inputValid(fullname: String, numberPhone: String, email: String, password: String, confirmPassword: String):Boolean{
        var value:Boolean = true
        if(fullname.isEmpty()){
            edtFullName.error = "Nama tidak boleh kosong"
            value = false
        }

        if(numberPhone.isEmpty()){
            edtTelepon.error = "Nomor telepon tidak boleh kosong"
            value = false
        }else if (!Patterns.PHONE.matcher(numberPhone).matches()){
            edtTelepon.error = "Masukkan nomor telepon"
            value = false
        }else if(numberPhone.length<10){
            edtTelepon.error = "Masukkan nomor telepon"
            value = false
        }

        if(email.isEmpty()){
            edtEmailSignUp.error = "Email tidak boleh kosong"
            value = false
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmailSignUp.error = "Masukkan email"
            value = false
        }

        if (password.isEmpty()){
            edtPassSignUp.error = "Password tidak boleh kosong"
            value = false
        }else if(password.length<6){
            edtPassSignUp.error = "Password tidak boleh kurang dari 6 digit"
            value = false
        }

        if(confirmPassword.isEmpty()){
            edtConfirmPass.error = "Konfirmasi password tidak boleh kosong"
            value = false
        }else if(confirmPassword != password){
            edtConfirmPass.error = "Konfirmasi password tidak sama dengan password"
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
