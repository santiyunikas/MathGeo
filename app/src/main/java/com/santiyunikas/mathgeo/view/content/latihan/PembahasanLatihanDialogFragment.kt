package com.santiyunikas.mathgeo.view.content.latihan

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import kotlinx.android.synthetic.main.fragment_pembahasan_latihan_dialog.*


class PembahasanLatihanDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pembahasan_latihan_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_next.setOnClickListener {
            dismiss()
        }
        val kunci = arguments?.getString(DetailLatihanActivity.KEY_KUNCI)
        val jawaban = Preferences.getTempJawaban(activity?.applicationContext!!)
        if (kunci == jawaban) {
            jawaban_benar.visibility = View.VISIBLE
            jawaban_salah.visibility = View.GONE
            val txPembahasan = arguments?.getString(DetailLatihanActivity.KEY_TEXT_PEMBAHASAN)
            tx_pembahasan.text = txPembahasan
            val gambar = arguments?.getString(DetailLatihanActivity.KEY_GAMBAR_PEMBAHASAN)
            if (gambar == "-") {
                img_pembahasan.visibility = View.GONE
            } else {
                Glide.with(this)
                    .load(gambar)
                    .into(img_pembahasan)
            }

//            Preferences.setTempPembahasan(view.context, true)
        } else {
            jawaban_benar.visibility = View.GONE
            jawaban_salah.visibility = View.VISIBLE
        }
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window?.setLayout(width, height)
            val back = ColorDrawable(Color.TRANSPARENT)
            val inset = InsetDrawable(back, 0)
            dialog.window!!.setBackgroundDrawable(inset)
            dialog.window!!.attributes.horizontalMargin = 0F
            dialog.window!!.attributes.verticalMargin = 0F

        }
    }
}