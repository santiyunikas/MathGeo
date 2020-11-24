package com.santiyunikas.mathgeo.view.authentication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.IView
import com.santiyunikas.mathgeo.presenter.authentication.LoginPresenter
import com.santiyunikas.mathgeo.util.network.InternetConnection
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import com.santiyunikas.mathgeo.view.content.ContentActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener, IView{
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
        presenter = LoginPresenter(this)
    }

    override fun initView() {
        img_showhide_pass.setOnClickListener(this)
        tv_forgot_pass.setOnClickListener(this)
        btn_login.setOnClickListener(this)
        tv_signup.setOnClickListener(this)

    }

    override fun updateViewData() {
        edt_email_login.setText("")
        edt_pass_login.setText("")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.img_showhide_pass->{
                    presenter.showHidePass(edt_pass_login, img_showhide_pass)
            }
            R.id.tv_forgot_pass->{
                val fragmentOtp = OtpFragment()
                val mBundle = Bundle()
                mBundle.putString("STATE_KEY", "Login")
                fragmentOtp.arguments = mBundle

                val intent = Intent(this@LoginActivity, ResetPasswordActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_login->{
                val email: String = edt_email_login.text.toString().trim()
                val password: String = edt_pass_login.text.toString().trim()

                if (inputValid(email, password) && InternetConnection.isConnected(this)){
                   presenter.login(email, password)
                }
            }
            R.id.tv_signup->{
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    fun passingData(fullname: String, email: String, nomor_telepon: String, kode_referal: String, nKoin: Int, id_member: Int){
        Preferences.setLoggedInStatus(applicationContext, true)
        Preferences.setRegisteredEmail(applicationContext, email)
        Preferences.setRegisteredFullname(applicationContext, fullname)
        Preferences.setRegisteredPhone(applicationContext, nomor_telepon)
        Preferences.setRegisteredKodeReferal(applicationContext, kode_referal)
        Preferences.setRegisteredJumlahKoin(applicationContext, nKoin)
        Preferences.setRegisteredIdUser(applicationContext, id_member)
    }

    private fun inputValid(email: String, password: String): Boolean{
        var value = true
        if (email.isEmpty()){
            edt_email_login.error = "Email tidak boleh kosong"
            value = false
         }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edt_email_login.error = "Masukkan email dengan benar"
        }

        if (password.isEmpty()){
            edt_pass_login.error = "Password tidak boleh kosong"
            value = false
        }else if(password.length<6){
            edt_pass_login.error = "Password tidak boleh kurang dari 6 digit"
            value = false
        }

        return value
    }

     override fun onSuccess(msg: String?) {
        if(msg.equals("isSuccess")){
            Log.d("suksesRegister", msg!!)
            updateViewData()
            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_LONG).show()

            val intent = Intent(this@LoginActivity, ContentActivity::class.java)
            startActivity(intent)
            finish()

        }else if(msg.equals("resetPassSuccess")){
            Log.d("suksesResetPassword", msg!!)
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
                Log.d("erorLogin", msg!!)
            }
        }
    }
}
