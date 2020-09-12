package com.santiyunikas.mathgeo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.santiyunikas.mathgeo.welcomingpage.WelcomeViewPagerAdapter

class WelcomeActivity : AppCompatActivity(){
    private var page: Int = 0
    private lateinit var welcomeViewPager: ViewPager
    private lateinit var welcomeViewPagerAdapter: FragmentPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        welcomeViewSet()
    }

    fun welcomeViewSet(){
        welcomeViewPager = findViewById(R.id.welcome_view_pager)
        welcomeViewPagerAdapter = WelcomeViewPagerAdapter(supportFragmentManager)
        welcomeViewPager.adapter = welcomeViewPagerAdapter

        val tabDots: TabLayout = findViewById(R.id.tab_dots)
        tabDots.setupWithViewPager(welcomeViewPager)

//        if (welcomeViewPager.currentItem == 2){
//            Log.d("posisi", tabDots.selectedTabPosition.toString())
//            btnDone.visibility = View.VISIBLE
//        }
    }

}
