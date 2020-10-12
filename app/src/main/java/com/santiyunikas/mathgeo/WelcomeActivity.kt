package com.santiyunikas.mathgeo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener
import com.google.android.material.tabs.TabLayout
import com.santiyunikas.mathgeo.sharedpreferences.SaveSharedPreference
import com.santiyunikas.mathgeo.view.LoginActivity
import com.santiyunikas.mathgeo.welcomingpage.WelcomeFragment1
import com.santiyunikas.mathgeo.welcomingpage.WelcomeViewPagerAdapter



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
