package com.santiyunikas.mathgeo.view.welcomingpage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.util.network.InternetConnection
import com.santiyunikas.mathgeo.view.authentication.LoginActivity

class WelcomeFragment3 : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView:View = inflater.inflate(R.layout.fragment_welcome3, container, false)
        // Inflate the layout for this fragment
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNextToLogin: Button = view.findViewById(R.id.btn_next_to_login)
        btnNextToLogin.setOnClickListener{
            if (InternetConnection.isConnected(view.context)){
                val mIntent = Intent(activity, LoginActivity::class.java)
                startActivity(mIntent)
                activity?.finish()
            }
        }
    }

}
