package com.santiyunikas.mathgeo.presenter

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.Presenter
import com.santiyunikas.mathgeo.contract.ContractInterface.View
import com.santiyunikas.mathgeo.model.RegisterModel
import com.santiyunikas.mathgeo.view.RegisterActivity



class RegisterPresenter(_view: View): Presenter {

    private lateinit var view: RegisterActivity

    fun inputUser(mAuth: FirebaseAuth, user: RegisterModel){
        //add user to database
        var userId: String = mAuth.uid.toString().trim()

        val database = Firebase.database
        val myRef = database.getReference("user/")

        myRef.child(userId).setValue(user)
        mAuth.currentUser?.sendEmailVerification()
        Log.d("newUserCreate", userId)
    }

    fun showHidePass(editText: EditText, imageView: ImageView){
        if(editText.transformationMethod == PasswordTransformationMethod.getInstance()){
            imageView.setImageResource(R.drawable.ic_show_pass);
            //Show Password
            editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }
        else{
            imageView.setImageResource(R.drawable.ic_hide_pass);
            //Hide Password
            editText.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

}