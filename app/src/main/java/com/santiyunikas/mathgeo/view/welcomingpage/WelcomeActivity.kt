package com.santiyunikas.mathgeo.view.welcomingpage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.util.sharedpreferences.SaveSharedPreference
import com.santiyunikas.mathgeo.view.ContentActivity


class WelcomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        if (SaveSharedPreference.getLoggedStatus(applicationContext)){
            //masuk ketika sudah pernah login sebelumnya
            val intent:Intent= Intent(this@WelcomeActivity, ContentActivity::class.java)
            startActivity(intent)
        }else{
            fragmentInit()
        }
    }

    //initial fragment
    fun fragmentInit(){
        val mFragmentManager = supportFragmentManager
        val mWelcomeFragment1 = WelcomeFragment1()
        val fragment = mFragmentManager.findFragmentByTag(WelcomeFragment1::class.java.simpleName)

        if (fragment !is WelcomeFragment1){
            Log.d("WelcomeFragment","Fragment Name :"+ WelcomeFragment1::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_welcome_container, mWelcomeFragment1, WelcomeFragment1::class.java.simpleName)
                .commit()
        }
    }

}
