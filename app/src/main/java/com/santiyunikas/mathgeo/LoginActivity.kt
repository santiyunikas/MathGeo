package com.santiyunikas.mathgeo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.*

class LoginActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var imgPassDisplay: ImageView
    private lateinit var tvForgotPassword:TextView
    private lateinit var btnLogin: Button
    private lateinit var tvSignUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun viewInit(){
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

    override fun onClick(v: View?) {
        when(v?.id){
            imgPassDisplay.id->{
                if(edtPassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    imgPassDisplay.setImageResource(R.drawable.ic_hide_pass);

                    //Show Password
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    imgPassDisplay.setImageResource(R.drawable.ic_show_pass);

                    //Hide Password
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
            }
            tvForgotPassword.id->{

            }
            btnLogin.id->{

            }
            tvSignUp.id->{

            }
        }
    }
}
