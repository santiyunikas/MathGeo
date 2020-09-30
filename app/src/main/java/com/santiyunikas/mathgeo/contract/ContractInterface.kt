package com.santiyunikas.mathgeo.contract

import android.content.Intent

interface ContractInterface {

    interface View{
        fun initView()
        fun updateViewData()
        fun isConnected():Boolean
    }

    interface Presenter{
    }
    interface Model{
    }
}