package com.santiyunikas.mathgeo.view.content.latihan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.presenter.latihan.DetailLatihanPresenter
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import kotlinx.android.synthetic.main.fragment_gagal_latihan_dialog.*
import kotlinx.android.synthetic.main.fragment_lulus_latihan_dialog.*

class GagalLatihanDialogFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gagal_latihan_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view)
            .load("https://mathgeo.ub-learningtechnology.com/asset/latihan/sad_emoji.png")
            .into(sad_emoji)
        btn_ulangi_latihan.setOnClickListener {
            dismiss()
            activity?.finish()
        }
    }
}