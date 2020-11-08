package com.santiyunikas.mathgeo.contract

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
    }
}