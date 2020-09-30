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
import com.santiyunikas.mathgeo.welcomingpage.WelcomeViewPagerAdapter



class WelcomeActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var welcomeViewPager: ViewPager
    private lateinit var welcomeViewPagerAdapter: FragmentPagerAdapter
    private lateinit var btnDone: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        if (SaveSharedPreference.getLoggedStatus(applicationContext)){
            val intent:Intent= Intent(this@WelcomeActivity, ContentActivity::class.java)
            startActivity(intent)
        }else{
            welcomeViewSet()
            btnDone = findViewById(R.id.btn_done)
            btnDone.setOnClickListener(this)
            btnDone.visibility = View.INVISIBLE
        }
    }

    fun welcomeViewSet(){
        welcomeViewPager = findViewById(R.id.welcome_view_pager)
        welcomeViewPagerAdapter = WelcomeViewPagerAdapter(supportFragmentManager)
        welcomeViewPager.adapter = welcomeViewPagerAdapter

        val tabDots: TabLayout = findViewById(R.id.tab_dots)
        tabDots.setupWithViewPager(welcomeViewPager)

        welcomeViewPager.setOnPageChangeListener(
            object : SimpleOnPageChangeListener() {
                override fun onPageSelected(position: Int) {
                    if (welcomeViewPager.currentItem == 0){
                        Log.d("posisi", tabDots.selectedTabPosition.toString())
                        btnDone.visibility = View.INVISIBLE
                    }else if(welcomeViewPager.currentItem == 1){
                        Log.d("posisi", tabDots.selectedTabPosition.toString())
                        btnDone.visibility = View.INVISIBLE
                    }else{
                        btnDone.visibility = View.VISIBLE
                    }
                }
            })
    }

    override fun onClick(v: View?) {
        when(v?.id){
            btnDone.id ->{
                val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val activeNetwork = cm.activeNetworkInfo
                if (activeNetwork == null || !activeNetwork.isConnected) {
                    this.startActivity(Intent(Settings.ACTION_SETTINGS))
                    Toast.makeText(this, "Aktifkan Koneksi Internet Anda", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }


            }
        }
    }

}
