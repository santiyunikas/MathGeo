package com.santiyunikas.mathgeo.view.welcomingpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.santiyunikas.mathgeo.R

class WelcomeFragment1 : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome1, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNextToFragment2: Button = view.findViewById(R.id.btn_next_to_fragment_2)
        btnNextToFragment2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_next_to_fragment_2->{
                val mWelcomeFragment2 = WelcomeFragment2()
                val mFragmentManager = parentFragmentManager
                mFragmentManager.beginTransaction().apply {
                    replace(R.id.frame_welcome_container, mWelcomeFragment2, WelcomeFragment2::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }


}
