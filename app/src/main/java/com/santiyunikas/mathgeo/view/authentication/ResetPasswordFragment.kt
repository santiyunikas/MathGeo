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
import com.santiyunikas.mathgeo.presenter.ResetPasswordPresenter
import com.santiyunikas.mathgeo.contract.ContractInterface.IView


class ResetPasswordFragment : Fragment(), IView, View.OnClickListener {

    private lateinit var edtPassReset: EditText
    private lateinit var edtConfirmpassReset: EditText
    private lateinit var imgShowHidePassReset: ImageView
    private lateinit var imgShowHideConfirmpassReset: ImageView
    private lateinit var btnSend: Button
    private lateinit var txBack: TextView
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
        edtPassReset = view.findViewById(R.id.edt_pass_reset)
        edtConfirmpassReset = view.findViewById(R.id.edt_confirmpass_reset)
        imgShowHidePassReset = view.findViewById(R.id.img_showhide_pass_reset)
        imgShowHideConfirmpassReset = view.findViewById(R.id.img_showhide_confirmpass_reset)
        btnSend = view.findViewById(R.id.btn_send)
        txBack = view.findViewById(R.id.tx_back)

        imgShowHidePassReset.setOnClickListener(this)
        imgShowHideConfirmpassReset.setOnClickListener(this)
        btnSend.setOnClickListener(this)
        txBack.setOnClickListener(this)

        presenter = ResetPasswordPresenter(this)
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun updateViewData() {
        edtConfirmpassReset.setText("")
        edtPassReset.setText("")
    }

    override fun onSuccess(msg: String?) {
        Toast.makeText(activity,
            "Berhasil atur ulang password",
            Toast.LENGTH_LONG).show()
        updateViewData()
        val intent: Intent = Intent(activity, LoginActivity::class.java)
        startActivity(intent)
        activity?.finish()
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
                presenter.showHidePass(edtPassReset, imgShowHidePassReset)

            }
            R.id.img_showhide_confirmpass_reset -> {
                presenter.showHidePass(edtConfirmpassReset, imgShowHideConfirmpassReset)
            }
            R.id.btn_send -> {
                val bundle = this.arguments
                if (bundle != null) {
                    email = bundle.getString("EMAIL_KEY", defaultValue.toString())
                    Log.d("emailPass", "$email")
                }

                val pass = edtPassReset.text.toString().trim()
                val confirmPass = edtConfirmpassReset.text.toString().trim()

                if (inputValid(pass, confirmPass) && presenter.isConnected(activity)) {
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
            edtPassReset.error = "Password tidak boleh kosong"
            value = false
        }else if(pass.length<6){
            edtPassReset.error = "Password tidak boleh kurang dari 6 digit"
            value = false
        }

        if(confirmPass.isEmpty()){
            edtConfirmpassReset.error = "Konfirmasi password tidak boleh kosong"
            value = false
        }else if(confirmPass != pass){
            edtConfirmpassReset.error = "Konfirmasi password tidak sama dengan password"
            value = false
        }

        return value
    }
}