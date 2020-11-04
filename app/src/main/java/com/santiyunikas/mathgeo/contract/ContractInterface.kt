package com.santiyunikas.mathgeo.contract

import android.content.Context
import android.view.View

interface ContractInterface {

    interface IView{
        fun initView()
        fun updateViewData()
        fun onSuccess(msg: String?)
        fun onError(msg: String?)
    }
}