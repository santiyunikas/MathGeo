package com.santiyunikas.mathgeo.view

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.santiyunikas.mathgeo.ContentActivity
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface
import com.santiyunikas.mathgeo.model.LoginModel
import com.santiyunikas.mathgeo.presenter.LoginPresenter
import com.santiyunikas.mathgeo.sharedpreferences.SaveSharedPreference
import org.w3c.dom.Text


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
        SaveSharedPreference.setLoggedIn(applicationContext, true)
        val intent: Intent = Intent(this@LoginActivity, ContentActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun isConnected(): Boolean {
        val state: Boolean
        val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetwork
        if (activeNetwork == null) {
            this.startActivity(Intent(Settings.ACTION_SETTINGS))
            Toast.makeText(this, "Aktifkan KOneksi Internet Anda", Toast.LENGTH_SHORT)
                .show()
            state=false
        } else {
            state=true
        }
        return state
    }

    override fun onClick(v: View?) {
        when(v?.id){
            imgPassDisplay.id->{
                    presenter.showHidePass(edtPassword, imgPassDisplay)
            }
            tvForgotPassword.id->{
                val openDialog = Dialog(this)
                openDialog.setContentView(R.layout.activity_forgot_pass)
                openDialog.setCancelable(false)
                openDialog.setTitle("Lupa Password")

                val edtEmail = openDialog.findViewById<EditText>(R.id.edt_email_forgotpass)
                val edtPassword= openDialog.findViewById<EditText>(R.id.edt_pass_forgotpass)
                val edtConfirmPassword = openDialog.findViewById<EditText>(R.id.edt_confirm_forgotpass)

                val imgDisplayPass= openDialog.findViewById<ImageView>(R.id.img_showhide_pass_forgotpass)
                val imgDisplayConfirmPass= openDialog.findViewById<ImageView>(R.id.img_showhide_confirm_forgotpass)

                val btnCancel = openDialog.findViewById<Button>(R.id.btn_cancel_reset_pass)
                val btnReset= openDialog.findViewById<Button>(R.id.btn_reset_pass)
                imgDisplayPass.setOnClickListener(View.OnClickListener {
                    presenter.showHidePass(edtPassword, imgDisplayPass)
                })
                imgDisplayConfirmPass.setOnClickListener(View.OnClickListener {
                    presenter.showHidePass(edtConfirmPassword, imgDisplayConfirmPass)
                })

                btnCancel.setOnClickListener(View.OnClickListener { openDialog!!.dismiss() })
                btnReset.setOnClickListener(View.OnClickListener {
                    if (isConnected()){Log.d("emailMasuk",edtEmail.text.toString().trim())
                        presenter.resetPassword(edtEmail.text.toString().trim(), edtPassword.text.toString().trim())
                    }
                })
                openDialog.show()
            }
            btnLogin.id->{
                var email: String = edtEmail.text.toString().trim()
                var password: String = edtPassword.text.toString().trim()
                model = LoginModel(email, password)

                if (inputValid(model) && isConnected()){
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

        }else if(msg.equals("resetPassSuccess")){
            Log.d("suksesResetPassword", msg)
            Toast.makeText(this, "Pasword Berhasil Diubah", Toast.LENGTH_LONG).show()
        }
    }

    override fun onError(msg: String?) {

        if (msg.equals("differentPass")){
            Toast.makeText(this, "Login gagal: Email atau Password Salah", Toast.LENGTH_LONG).show()

        }else if (msg.equals("resetPasswordFail")){
            Toast.makeText(this, "Password Gagal Diubah", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Login gagal", Toast.LENGTH_LONG).show()
            Log.d("erorLogin", msg)
        }

    }
}
//tambahin method untuk login belum konfigurasi done
