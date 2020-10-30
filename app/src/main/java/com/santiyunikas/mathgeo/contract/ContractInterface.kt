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

    interface IPresenter{
        fun setView(view1: View?, view2: View?, view3: View?, view4: View?, view5: View?, view6: View?, view7: View?)
        fun isConnected(context: Context?):Boolean
    }
    interface IModel{
        fun getData()
    }
}