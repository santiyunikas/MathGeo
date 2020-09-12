package com.santiyunikas.mathgeo.welcomingpage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.WelcomeActivity

class WelcomeViewPagerAdapter: FragmentPagerAdapter {

    constructor(fragmentManager: FragmentManager) : super(fragmentManager) {

    }
    //private var context: Context
//    private lateinit var layoutInflater: LayoutInflater
    private var welcomeLayouts: IntArray = intArrayOf(R.layout.fragment_welcome1, R.layout.fragment_welcome2, R.layout.fragment_welcome3)

//    constructor(context: Context){
//        this.context = context
//    }

//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return view == `object`
//    }

    override fun getCount(): Int {
        return welcomeLayouts.size
    }

//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val view: View = layoutInflater.inflate(welcomeLayouts[position], container, false)
//        container.addView(view)
//        return view
//    }

    override fun getItem(position: Int): Fragment {
        if (position == 0){
            return WelcomeFragment1()
        }else if (position == 1){
            return WelcomeFragment2()
        }else{
            return WelcomeFragment3()
        }
    }

//    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        val view: View = `object` as View
//        container.removeView(view)
//    }
}