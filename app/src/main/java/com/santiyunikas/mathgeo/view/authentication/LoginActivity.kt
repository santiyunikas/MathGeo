package com.santiyunikas.mathgeo.view.authentication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.IView
import com.santiyunikas.mathgeo.presenter.LoginPresenter
import com.santiyunikas.mathgeo.util.sharedpreferences.SaveSharedPreference
import com.santiyunikas.mathgeo.view.ContentActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener, IView{
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var imgPassDisplay: ImageView
    private lateinit var tvForgotPassword:TextView
    private lateinit var btnLogin: Button
    private lateinit var tvSignUp: TextView

    private lateinit var presenter: LoginPresenter

    var builder: AlertDialog.Builder? = null
    var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
        presenter = LoginPresenter(this)
    }

    override fun initView() {
        edtEmail = findViewById(R.id.edt_email_login)
        edtPassword = findViewById(R.id.edt_pass_login)
        imgPassDisplay = findViewById(R.id.img_showhide_pass)
        tvForgotPassword = findViewById(R.id.tv_forgot_pass)
        btnLogin = findViewById(R.id.btn_login)
        tvSignUp = findViewById(R.id.tv_signup)

        imgPassDisplay.setOnClickListener(this)
        tvForgotPassword.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        tvSignUp.setOnClickListener(this)

    }

    override fun updateViewData() {
        edtEmail.setText("")
        edtPassword.setText("")
        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_LONG).show()
        SaveSharedPreference.setLoggedIn(applicationContext, true)
        val intent: Intent = Intent(this@LoginActivity, ContentActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            imgPassDisplay.id->{
                    presenter.showHidePass(edtPassword, imgPassDisplay)
            }
            tvForgotPassword.id->{
                val intent: Intent = Intent(this@LoginActivity, ResetPasswordActivity::class.java)
                startActivity(intent)
                finish()
            }
            btnLogin.id->{
                var email: String = edtEmail.text.toString().trim()
                var password: String = edtPassword.text.toString().trim()

                if (inputValid(email, password) && presenter.isConnected(this)){
                   presenter.login(email, password)
                }
            }
            tvSignUp.id->{
                val intent: Intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun inputValid(email: String, password: String): Boolean{
        var value = true
        if (email.isEmpty()){
            edtEmail.error = "Email tidak boleh kosong"
            value = false
         }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmail.error = "Masukkan email"
        }

        if (password.isEmpty()){
            edtPassword.error = "Password tidak boleh kosong"
            value = false
        }else if(password.length<6){
            edtPassword.error = "Password tidak boleh kurang dari 6 digit"
            value = false
        }

        return value
    }

    override fun onSuccess(msg: String?) {
        if(msg.equals("isSuccess")){
            Log.d("suksesRegister", msg)
            updateViewData()

        }else if(msg.equals("resetPassSuccess")){
            Log.d("suksesResetPassword", msg)
            Toast.makeText(this, "Pasword Berhasil Diubah", Toast.LENGTH_LONG).show()
        }
    }

    override fun onError(msg: String?) {

        when {
            msg.equals("notActive") -> {
                Toast.makeText(this, "Login gagal: Cek email untuk konfirmasi akun anda", Toast.LENGTH_LONG).show()
            }
            msg.equals("differentPass") -> {
                Toast.makeText(this, "Login gagal: Email atau Password Salah", Toast.LENGTH_LONG).show()
            }
            msg.equals("resetPasswordFail") -> {
                Toast.makeText(this, "Password Gagal Diubah", Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(this, "Login gagal", Toast.LENGTH_LONG).show()
                Log.d("erorLogin", msg)
            }
        }

    }
}
