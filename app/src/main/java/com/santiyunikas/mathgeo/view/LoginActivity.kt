package com.santiyunikas.mathgeo.view

import android.content.Intent
import android.os.Bundle
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


class LoginActivity : AppCompatActivity(), View.OnClickListener, ContractInterface.View{
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var imgPassDisplay: ImageView
    private lateinit var tvForgotPassword:TextView
    private lateinit var btnLogin: Button
    private lateinit var tvSignUp: TextView

    private lateinit var presenter: LoginPresenter
    private lateinit var model: LoginModel

    private lateinit var mAuth: FirebaseAuth

    var builder: AlertDialog.Builder? = null
    var dialog: AlertDialog? = null
//    private lateinit var mUser: FirebaseUser

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

        mAuth = FirebaseAuth.getInstance()
//        mUser = mAuth.currentUser!!
    }

    override fun updateViewData() {
        TODO("Not yet implemented")
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
                    mAuth.signInWithEmailAndPassword(model.email, model.password)
                        .addOnCompleteListener(this, OnCompleteListener {
                            if(!it.isSuccessful){
                                var errorCode:String = it.exception.toString().trim()
                                when(errorCode){
                                    "ERROR_USER_NOT_FOUND"->{
                                        Toast.makeText(this, "Akun belum terdaftar", Toast.LENGTH_LONG).show();
                                    }
                                    "ERROR_WRONG_PASSWORD"->{
                                        Toast.makeText(this, "Password salah", Toast.LENGTH_LONG).show();
                                    }
                                }
                            } else if (!mAuth.currentUser?.isEmailVerified!!){
                                mAuth.currentUser?.sendEmailVerification()
                                Toast.makeText(this, "Cek email kamu, untuk verifikasi akun", Toast.LENGTH_SHORT).show()
                                FirebaseAuth.getInstance().signOut()
                            }else{
                                Toast.makeText(this, "Berhasil login", Toast.LENGTH_SHORT).show()
                                afterLogin()
                            }
                        })
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

    fun afterLogin(){
        edtEmail.setText("")
        edtPassword.setText("")

        val intent: Intent = Intent(this@LoginActivity, ContentActivity::class.java)
        startActivity(intent)
        finish()
    }
}
//tambahin method untuk login belum konfigurasi done
