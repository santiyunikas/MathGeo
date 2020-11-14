package com.santiyunikas.mathgeo.view.authentication

import android.R.attr.defaultValue
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.presenter.auth.ResetPasswordPresenter
import com.santiyunikas.mathgeo.contract.ContractInterface.IView
import com.santiyunikas.mathgeo.util.network.InternetConnection
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import kotlinx.android.synthetic.main.fragment_reset_password.*


class ResetPasswordFragment : Fragment(), IView, View.OnClickListener {
    private lateinit var presenter: ResetPasswordPresenter
    private  var email: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reset_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {
        img_showhide_pass_reset.setOnClickListener(this)
        img_showhide_confirmpass_reset.setOnClickListener(this)
        btn_send.setOnClickListener(this)
        tx_back.setOnClickListener(this)

        presenter = ResetPasswordPresenter(this)
    }

    override fun updateViewData() {
        edt_confirmpass_reset.setText("")
        edt_pass_reset.setText("")
    }

    override fun onSuccess(msg: String?) {
        Toast.makeText(activity,
            "Berhasil atur ulang password",
            Toast.LENGTH_LONG).show()
        updateViewData()
        view?.context?.let { Preferences.clearLoggedInUser(it) }
        val intent = Intent(activity, LoginActivity::class.java)
        startActivity(intent)
        activity?.finishAffinity()
    }

    override fun onError(msg: String?) {
        when(msg){
            "noResponse" -> {
                Toast.makeText(activity,
                    "Atur ulang password gagal",
                    Toast.LENGTH_LONG).show()
            }
            "noAccount" -> {
                Toast.makeText(activity,
                    "Email yang anda masukkan salah",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.img_showhide_pass_reset -> {
                presenter.showHidePass(edt_pass_reset, img_showhide_pass_reset)

            }
            R.id.img_showhide_confirmpass_reset -> {
                presenter.showHidePass(edt_confirmpass_reset, img_showhide_confirmpass_reset)
            }
            R.id.btn_send -> {
                val bundle = this.arguments
                if (bundle != null) {
                    email = bundle.getString("EMAIL_KEY", defaultValue.toString())
                    Log.d("emailPass", "$email")
                }

                val pass = edt_pass_reset.text.toString().trim()
                val confirmPass = edt_confirmpass_reset.text.toString().trim()

                if (inputValid(pass, confirmPass) && InternetConnection.isConnected(activity)) {
                    presenter.changePassword(email, pass)
                    Log.d("emailPass", "$email $pass")
                }
            }
            R.id.tx_back -> {
                val fragmentOtp = OtpFragment()
                val fragmentResetPassword: Fragment? = fragmentManager?.findFragmentByTag(
                    ResetPasswordFragment::class.java.simpleName)
                val fragmentOtpManager = fragmentManager
                fragmentOtpManager?.beginTransaction()?.apply {
                    replace(R.id.frame_reset_password_container,
                        fragmentOtp,
                        ResetPasswordFragment::class.java.simpleName)
                    if (fragmentResetPassword != null) {
                        remove(fragmentResetPassword)
                    }
                    commit()
                }
            }
        }
    }

    private fun inputValid(pass: String, confirmPass: String): Boolean{
        var value: Boolean = true
        if (pass.isEmpty()){
            edt_pass_reset.error = "Password tidak boleh kosong"
            value = false
        }else if(pass.length<6){
            edt_pass_reset.error = "Password tidak boleh kurang dari 6 digit"
            value = false
        }

        if(confirmPass.isEmpty()){
            edt_confirmpass_reset.error = "Konfirmasi password tidak boleh kosong"
            value = false
        }else if(confirmPass != pass){
            edt_confirmpass_reset.error = "Konfirmasi password tidak sama dengan password"
            value = false
        }

        return value
    }
}