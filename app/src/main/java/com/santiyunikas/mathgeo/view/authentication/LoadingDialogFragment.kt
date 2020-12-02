package com.santiyunikas.mathgeo.view.authentication

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.santiyunikas.mathgeo.R

class LoadingDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loading_dialog, container, false)
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