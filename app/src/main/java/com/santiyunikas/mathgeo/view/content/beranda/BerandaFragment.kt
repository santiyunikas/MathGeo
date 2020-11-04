package com.santiyunikas.mathgeo.view.content.beranda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.santiyunikas.mathgeo.R

class BerandaFragment : Fragment(){



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_beranda, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        textView.text="Beranda"
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


}
