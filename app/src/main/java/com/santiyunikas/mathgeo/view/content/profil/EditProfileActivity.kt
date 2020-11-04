package com.santiyunikas.mathgeo.view.content.profil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.*
import com.santiyunikas.mathgeo.presenter.profil.EditProfilPresenter
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences

class EditProfileActivity : AppCompatActivity(), IView, View.OnClickListener {
    private lateinit var edtName: EditText
    private lateinit var edtPhone: EditText
    private lateinit var edtEmail: EditText
    private lateinit var btnSend: Button
    private lateinit var presenter: EditProfilPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initView()
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
        edtName = findViewById(R.id.edt_profile_fullname)
        edtPhone = findViewById(R.id.edt_profile_phone)
        edtEmail = findViewById(R.id.edt_profile_email)
        btnSend = findViewById(R.id.btn_send_edit_profile)
        btnSend.setOnClickListener(this)
        presenter = EditProfilPresenter(this)
        edtName.setText(Preferences.getRegisteredFullname(this))
        edtPhone.setText(Preferences.getRegisteredPhone(this))
        edtEmail.setText(Preferences.getRegisteredEmail(this))
    }

    override fun updateViewData() {
        edtName.setText("")
        edtPhone.setText("")
        edtEmail.setText("")
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
                if(inputValid(edtName.text.toString(), edtPhone.text.toString(), edtEmail.text.toString())){
                    presenter.editProfil(edtName.text.toString(), edtPhone.text.toString(), edtEmail.text.toString())
                }

            }
        }
    }

    private fun inputValid(fullname: String, numberPhone: String, email: String):Boolean{
        var value:Boolean = true
        if(fullname.isEmpty()){
            edtName.error = "Nama tidak boleh kosong"
            value = false
        }

        if(numberPhone.isEmpty()){
            edtPhone.error = "Nomor telepon tidak boleh kosong"
            value = false
        }else if (!Patterns.PHONE.matcher(numberPhone).matches()){
            edtPhone.error = "Masukkan nomor telepon"
            value = false
        }else if(numberPhone.length<10){
            edtPhone.error = "Masukkan nomor telepon"
            value = false
        }

        if(email.isEmpty()){
            edtEmail.error = "Email tidak boleh kosong"
            value = false
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmail.error = "Masukkan email"
            value = false
        }

        return value
    }


}