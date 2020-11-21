package com.santiyunikas.mathgeo.view.content.materi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.santiyunikas.mathgeo.R
import kotlinx.android.synthetic.main.fragment_materi_image_dialog.*

class MateriImageDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_materi_image_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString("IMAGE_KUBUS_URL")
        Glide.with(view)
            .load(url)
            .into(img_kubus)
    }
}