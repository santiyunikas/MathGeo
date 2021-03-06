package com.santiyunikas.mathgeo.view.content.materi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.santiyunikas.mathgeo.R

class PembahasanMateriImageFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pembahasan_materi_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString("IMAGE_KUBUS_URL")
        val imgKubus: ImageView = view.findViewById(R.id.img_kubus_pembahasan)
        Glide.with(view)
            .load(url)
            .into(imgKubus)
    }
}