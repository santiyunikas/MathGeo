package com.santiyunikas.mathgeo

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtFullName: EditText
    private lateinit var edtTelepon: EditText
    private lateinit var edtEmailSignUp: EditText
    private lateinit var edtPassSignUp: EditText
    private lateinit var edtConfirmPass: EditText
    private lateinit var btnSignUp: Button
    private lateinit var tvLogin: TextView
    private lateinit var imgShowHidePassSignup: ImageView
    private lateinit var imgShowHideConfirmPass: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        viewInit()
    }

    private fun viewInit(){
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

    override fun onClick(v: View?) {
        when(v?.id){
            imgShowHidePassSignup.id->{
                if(edtPassSignUp.transformationMethod == PasswordTransformationMethod.getInstance()){
                    imgShowHidePassSignup.setImageResource(R.drawable.ic_show_pass);

                    //Show Password
                    edtPassSignUp.transformationMethod = HideReturnsTransformationMethod.getInstance()
                }
                else{
                    imgShowHidePassSignup.setImageResource(R.drawable.ic_hide_pass);

                    //Hide Password
                    edtPassSignUp.transformationMethod = PasswordTransformationMethod.getInstance()

                }

            }
            imgShowHideConfirmPass.id->{
                if(edtConfirmPass.transformationMethod == PasswordTransformationMethod.getInstance()){
                    imgShowHideConfirmPass.setImageResource(R.drawable.ic_show_pass);

                    //Show Password
                    edtConfirmPass.transformationMethod = HideReturnsTransformationMethod.getInstance()
                }
                else{
                    imgShowHideConfirmPass.setImageResource(R.drawable.ic_hide_pass);

                    //Hide Password
                    edtConfirmPass.transformationMethod = PasswordTransformationMethod.getInstance()

                }

            }
            btnSignUp.id->{
                val intent: Intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            tvLogin.id->{
                val intent: Intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
