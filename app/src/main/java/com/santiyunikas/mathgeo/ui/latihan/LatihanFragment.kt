package com.santiyunikas.mathgeo.ui.latihan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.santiyunikas.mathgeo.R

class LatihanFragment : Fragment() {

    private lateinit var latihanViewModel: LatihanViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        latihanViewModel =
                ViewModelProviders.of(this).get(LatihanViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_latihan, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        latihanViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
