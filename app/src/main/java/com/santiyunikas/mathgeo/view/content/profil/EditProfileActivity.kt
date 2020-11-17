package com.santiyunikas.mathgeo.view.content.profil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.*
import com.santiyunikas.mathgeo.presenter.profil.EditProfilPresenter
import com.santiyunikas.mathgeo.util.network.InternetConnection
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity(), IView, View.OnClickListener {
    private lateinit var presenter: EditProfilPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if(InternetConnection.isConnected(this)){
            initView()
        }else{
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                super.onOptionsItemSelected(item)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun initView() {
        btn_send_edit_profile.setOnClickListener(this)
        presenter = EditProfilPresenter(this)
        edt_profile_fullname.setText(Preferences.getRegisteredFullname(this))
        edt_profile_phone.setText(Preferences.getRegisteredPhone(this))
        edt_profile_email.setText(Preferences.getRegisteredEmail(this))
    }

    override fun updateViewData() {
        edt_profile_fullname.setText("")
        edt_profile_phone.setText("")
        edt_profile_email.setText("")
    }

    override fun onSuccess(msg: String?) {
        Toast.makeText(this, "Edit Profil Berhasil", Toast.LENGTH_LONG).show()
    }

    override fun onError(msg: String?) {
        Toast.makeText(this, "Edit Profil Gagal", Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_send_edit_profile ->{
                if(inputValid(edt_profile_fullname.text.toString(), edt_profile_phone.text.toString(), edt_profile_email.text.toString())){
                    presenter.editProfil(edt_profile_fullname.text.toString(), edt_profile_phone.text.toString(), edt_profile_email.text.toString())
                }

            }
        }
    }

    private fun inputValid(fullname: String, numberPhone: String, email: String):Boolean{
        var value = true
        if(fullname.isEmpty()){
            edt_profile_fullname.error = "Nama tidak boleh kosong"
            value = false
        }

        if(numberPhone.isEmpty()){
            edt_profile_phone.error = "Nomor telepon tidak boleh kosong"
            value = false
        }else if (!Patterns.PHONE.matcher(numberPhone).matches()){
            edt_profile_phone.error = "Masukkan nomor telepon"
            value = false
        }else if(numberPhone.length<10){
            edt_profile_phone.error = "Masukkan nomor telepon"
            value = false
        }

        if(email.isEmpty()){
            edt_profile_email.error = "Email tidak boleh kosong"
            value = false
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edt_profile_email.error = "Masukkan email"
            value = false
        }

        return value
    }


}