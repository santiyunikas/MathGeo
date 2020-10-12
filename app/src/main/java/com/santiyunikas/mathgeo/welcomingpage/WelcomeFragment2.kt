package com.santiyunikas.mathgeo.welcomingpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.santiyunikas.mathgeo.R

class WelcomeFragment2 : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome2, container, false)
    }

    companion object {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNextToFragment3: Button = view.findViewById(R.id.btn_next_to_fragment_3)
        btnNextToFragment3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_next_to_fragment_3->{
                val mWelcomeFragment3 = WelcomeFragment3()
                val mFragmentManager = fragmentManager
                mFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.frame_welcome_container, mWelcomeFragment3, WelcomeFragment3::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }
}
