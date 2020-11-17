package com.santiyunikas.mathgeo.contract

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.jstarczewski.pc.mathview.src.MathView

interface ContractInterface {

    interface IView{
        fun initView()
        fun updateViewData()
        fun onSuccess(msg: String?)
        fun onError(msg: String?)
    }
    interface CustomView{
        fun getImageView(url: String)
        fun getButton(name: String)
        fun getTextview(text: String?)
        fun setImageView(url: String, image: ImageView)
        fun setButton(name: String, btn: Button)
        fun setTextview(tx: String?, tv: TextView)
        fun setMathview(tx: String?, mv: MathView)
    }
}