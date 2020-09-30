package com.santiyunikas.mathgeo.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.santiyunikas.mathgeo.ContentActivity
import com.santiyunikas.mathgeo.ForgotPassActivity
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface
import com.santiyunikas.mathgeo.model.LoginModel
import com.santiyunikas.mathgeo.presenter.LoginPresenter


class LoginActivity : AppCompatActivity(), View.OnClickListener, ContractInterface.View, ResponseInterface{
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var imgPassDisplay: ImageView
    private lateinit var tvForgotPassword:TextView
    private lateinit var btnLogin: Button
    private lateinit var tvSignUp: TextView

    private lateinit var presenter: LoginPresenter
    private lateinit var model: LoginModel


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
                builder = AlertDialog.Builder(this@LoginActivity)
                builder!!.setTitle("Update Allocation Info")
                builder!!.setCancelable(false)
                val view: View = LayoutInflater.from(this@LoginActivity)
                    .inflate(R.layout.forgot_password, null, false)
                builder!!.setView(view)
                dialog = builder!!.create()
                dialog!!.show()
            }
            btnLogin.id->{
                var email: String = edtEmail.text.toString().trim()
                var password: String = edtPassword.text.toString().trim()
                model = LoginModel(email, password)

                if (inputValid(model)){
                   presenter.login(model.email, model.password)
                }
            }
            tvSignUp.id->{
                val intent: Intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    fun inputValid(model: LoginModel): Boolean{
        var value = true
        if (model.email.isEmpty()){
            edtEmail.setError("Email tidak boleh kosong")
            value = false
         }else if(!Patterns.EMAIL_ADDRESS.matcher(model.email).matches()){
            edtEmail.setError("Masukkan email")
        }

        if (model.password.isEmpty()){
            edtPassword.setError("Password tidak boleh kosong")
            value = false
        }else if(model.password.length<6){
            edtPassword.setError("Password tidak boleh kurang dari 6 digit")
            value = false
        }

        return value
    }

    override fun onSuccess(msg: String?) {
        if(msg.equals("isSuccess")){
            Log.d("suksesRegister", msg)
            updateViewData()
        }
    }

    override fun onError(msg: String?) {
        Log.d("erorLogin", msg)
        Toast.makeText(this, "Login gagal", Toast.LENGTH_LONG).show()
    }
}
//tambahin method untuk login belum konfigurasi done
