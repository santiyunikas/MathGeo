package com.santiyunikas.mathgeo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar

class ForgotPassActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var edtEmailForgotPass: EditText
    private  lateinit var btnResetForgotPass: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)
        initView()
        toolbarSet()
    }

    private fun initView(){
        edtEmailForgotPass = findViewById(R.id.edt_email_forgotpass)
        btnResetForgotPass = findViewById(R.id.btn_reset_forgotpass)
        btnResetForgotPass.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        forgotPass()
    }

    private fun forgotPass(){

    }


    fun toolbarSet(){
        val toolbar: Toolbar = findViewById(R.id.toolbarPass)
        setActionBar(toolbar)
        actionBar?.setDisplayShowTitleEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setTitle("Lupa Password")
        toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}
