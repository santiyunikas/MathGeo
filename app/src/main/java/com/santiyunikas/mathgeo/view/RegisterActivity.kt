package com.santiyunikas.mathgeo.view

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface
import com.santiyunikas.mathgeo.model.RegisterModel
import com.santiyunikas.mathgeo.presenter.RegisterPresenter

class RegisterActivity : AppCompatActivity(), View.OnClickListener, ContractInterface.View{

    private lateinit var edtFullName: EditText
    private lateinit var edtTelepon: EditText
    private lateinit var edtEmailSignUp: EditText
    private lateinit var edtPassSignUp: EditText
    private lateinit var edtConfirmPass: EditText
    private lateinit var btnSignUp: Button
    private lateinit var tvLogin: TextView
    private lateinit var imgShowHidePassSignup: ImageView
    private lateinit var imgShowHideConfirmPass: ImageView
    private lateinit var mAuth: FirebaseAuth

    private lateinit var presenter: RegisterPresenter
    private lateinit var model: RegisterModel

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

        mAuth = FirebaseAuth.getInstance()
    }

    override fun updateViewData() {
        TODO("Not yet implemented")
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
                model = RegisterModel(fullname, numberPhone, email, password, confirmPassword)

                if (inputValid(model)){
                    mAuth.createUserWithEmailAndPassword(model.email, model.password)
                        .addOnCompleteListener(this, OnCompleteListener {
                            if (it.isSuccessful){
                                presenter.inputUser(mAuth, model)
                                afterRegister()
                                Toast.makeText(this, "Register berhasil, silakan verifikasi email anda", Toast.LENGTH_LONG).show()
                            }else{
                                Toast.makeText(this,
                                    "Registrasi gagal, email yang anda masukkan telah terdaftar"
                                    , Toast.LENGTH_LONG).show()
                            }
                        })
                }

            }
            tvLogin.id->{
                val intent: Intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    fun inputValid(user: RegisterModel):Boolean{
        var value:Boolean = true
        if(user.fullname.isEmpty()){
            edtFullName.setError("Nama tidak boleh kosong")
            value = false
        }

        if(user.numberPhone.isEmpty()){
            edtTelepon.setError("Nomor telepon tidak boleh kosong")
            value = false
        }else if (!Patterns.PHONE.matcher(user.numberPhone).matches()){
            edtTelepon.setError("Masukkan nomor telepon")
            value = false
        }else if(user.numberPhone.length<10){
            edtTelepon.setError("Masukkan nomor telepon")
            value = false
        }

        if(user.email.isEmpty()){
            edtEmailSignUp.setError("Email tidak boleh kosong")
            value = false
        }else if(!Patterns.EMAIL_ADDRESS.matcher(user.email).matches()){
            edtEmailSignUp.setError("Masukkan email")
            value = false
        }

        if (user.password.isEmpty()){
            edtPassSignUp.setError("Password tidak boleh kosong")
            value = false
        }else if(user.password.length<6){
            edtPassSignUp.setError("Password tidak boleh kurang dari 6 digit")
            value = false
        }

        if(user.confirmPassword.isEmpty()){
            edtConfirmPass.setError("Konfirmasi password tidak boleh kosong")
            value = false
        }else if(user.confirmPassword != user.password){
            edtConfirmPass.setError("Konfirmasi password tidak sama dengan password")
            value = false
        }

        return value
    }

    fun afterRegister(){
        edtFullName.setText("")
        edtEmailSignUp.setText("")
        edtTelepon.setText("")
        edtPassSignUp.setText("")
        edtConfirmPass.setText("")

        val intent: Intent = Intent(this@RegisterActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }


}
