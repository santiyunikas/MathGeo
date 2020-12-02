package com.santiyunikas.mathgeo.view.content.profil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.IView
import com.santiyunikas.mathgeo.presenter.profil.KoinGratisPresenter
import com.santiyunikas.mathgeo.util.network.InternetConnection
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import com.santiyunikas.mathgeo.view.authentication.LoadingDialogFragment
import kotlinx.android.synthetic.main.activity_koin_gratis.*

class KoinGratisActivity : AppCompatActivity(), IView, View.OnClickListener {
    private lateinit var presenter: KoinGratisPresenter
    private val fragment = LoadingDialogFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koin_gratis)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Dapatkan Koin Gratis!"
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
        btn_share.setOnClickListener(this)
        btn_periksa.setOnClickListener(this)

        kode_referal.text = Preferences.getRegisteredKodeReferal(this)

        presenter = KoinGratisPresenter(this)
    }

    override fun updateViewData() {
        kode_teman.setText("")
    }

    override fun onSuccess(msg: String?) {
        when(msg){
            "addCoinSuccess"->{
                fragment.dismiss()
                Toast.makeText(this, "Berhasil menambah koin", Toast.LENGTH_LONG).show()
                updateViewData()
            }
            "valid"->{
                if(presenter.cekKodeSendiri(kode_teman.text.toString())){
                    presenter.tambahKodeTeman(kode_teman.text.toString())
                }
            }
        }
    }

    override fun onError(msg: String?) {
        when(msg){
            "notValid"->{
                Toast.makeText(this, "Kode Referal Tidak Ditemukan", Toast.LENGTH_LONG).show()
            }
            "kodeSendiri"->{
                Toast.makeText(this, "Masukkan Kode Referal Teman Kamu", Toast.LENGTH_LONG).show()
            }
            "sudahAdaKodeTeman"->{
                Toast.makeText(this, "Masukkan Kode Teman Lainnya", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_share -> {
                val referal = Preferences.getRegisteredKodeReferal(this)
                val nama = Preferences.getRegisteredFullname(this)
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Hai! Ayo belajar bersama '$nama' di aplikasi MathGeo. Masukkan kode unik '$referal' dan dapatkan satu koin gratis untuk belajar. Tunggu apalagi, yuk download aplikasinya sekarang!")
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
            R.id.btn_periksa -> {
                if (inputValid(kode_teman.text.toString())){
                    val bundle = Bundle()

                    fragment.arguments = bundle

                    val fm = supportFragmentManager
                    fragment.show(fm, LoadingDialogFragment::class.java.simpleName)
                    Log.d("kodeteman", kode_teman.text.toString())
                    presenter.validasiKode(kode_teman.text.toString()).toString()
                }
            }
        }
    }

    private fun inputValid(kodeteman: String): Boolean{
        var value = true
        if (kodeteman.isEmpty()){
            kode_teman.error = "Kode Referal Tidak Boleh Kosong"
            value = false
        }
        return value
    }
}