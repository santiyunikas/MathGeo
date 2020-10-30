package com.santiyunikas.mathgeo.view.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.santiyunikas.mathgeo.R

class ResetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        fragmentInit()
    }

    private fun fragmentInit(){
        val mFragmentManager = supportFragmentManager
        val mOtpFragment = OtpFragment()
        val fragment = mFragmentManager.findFragmentByTag(OtpFragment::class.java.simpleName)
        if(fragment !is OtpFragment){
            Log.d("MyFlexibleFragment","Fragment Name :"+ OtpFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_reset_password_container, mOtpFragment, OtpFragment::class.java.simpleName)
                .commit()
        }
    }
}