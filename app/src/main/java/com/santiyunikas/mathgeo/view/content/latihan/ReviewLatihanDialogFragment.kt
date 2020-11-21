package com.santiyunikas.mathgeo.view.content.latihan

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.presenter.latihan.DetailLatihanPresenter
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import kotlinx.android.synthetic.main.fragment_review_latihan_dialog.*

class ReviewLatihanDialogFragment : DialogFragment() {
    private lateinit var presenter: DetailLatihanPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        dialog?.window?.setGravity(Gravity.BOTTOM)
        return inflater.inflate(R.layout.fragment_review_latihan_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val state = arguments?.getString(DetailLatihanActivity.KEY_NILAI)
        presenter = DetailLatihanPresenter(view.context)
        if(state == "lulus"){
            tx_gagal.visibility = View.GONE
            btn_ulangi_latihan.visibility = View.GONE
            Glide.with(view)
                .load("https://mathgeo.ub-learningtechnology.com/asset/latihan/smile_emoji.png")
                .into(review_latihan_emoji)
            btn_selesai.setOnClickListener {
                var temp = Preferences.getRegisteredJumlahKoin(view.context)
                Log.d("koin before", temp.toString())
                temp = temp?.plus(1 )
                presenter.updateJumlahKoin(temp.toString())
                dismiss()
                activity?.finish()
            }
        }else if(state == "gagal"){
            tx_lulus.visibility = View.GONE
            btn_selesai.visibility = View.GONE
            Glide.with(view)
                .load("https://mathgeo.ub-learningtechnology.com/asset/latihan/sad_emoji.png")
                .into(review_latihan_emoji)
            btn_ulangi_latihan.setOnClickListener {
                dismiss()
                activity?.finish()
            }
        }

    }
}