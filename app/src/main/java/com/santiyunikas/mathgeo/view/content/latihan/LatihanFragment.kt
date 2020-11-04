package com.santiyunikas.mathgeo.view.content.latihan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.santiyunikas.mathgeo.R

class LatihanFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_latihan, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        textView.text="Latihan"
        return root
    }
}
