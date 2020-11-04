package com.santiyunikas.mathgeo.view.authentication

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mukesh.OnOtpCompletionListener
import com.mukesh.OtpView
import com.santiyunikas.mathgeo.presenter.auth.OtpPresenter
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.IView
import com.santiyunikas.mathgeo.util.network.InternetConnection
import java.util.concurrent.TimeUnit


class OtpFragment : Fragment(), IView, View.OnClickListener{
    private lateinit var presenter: OtpPresenter
    private var kodeOtp: String = ""
    private lateinit var timerClass: TimerClass
    private lateinit var timer: TextView
    private lateinit var edtEmail: EditText
    private lateinit var btnGetOtp: Button
    private lateinit var otpView: OtpView
    private lateinit var btnVerification: Button
    private lateinit var txtBack: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        timer = view.findViewById(R.id.timer)
        edtEmail = view.findViewById(R.id.edt_email_reset_pass)
        btnGetOtp  = view.findViewById(R.id.btn_get_otp)
        otpView  = view.findViewById(R.id.otp_view)
        btnVerification  = view.findViewById(R.id.btn_verifikasi)
        txtBack = view.findViewById(R.id.tx_kembali)
        timer.visibility = View.INVISIBLE

        btnGetOtp.setOnClickListener(this)
        btnVerification.setOnClickListener(this)
        txtBack.setOnClickListener(this)

        presenter = OtpPresenter(this)

        otpView.setOtpCompletionListener(OnOtpCompletionListener { otp -> // do Stuff
            Log.d("onOtpCompleted=>", otp)
        })
    }

    inner class TimerClass(
        millisInFuture: Long, countDownInterval: Long
    ): CountDownTimer(millisInFuture, countDownInterval) {

        override fun onTick(millisUntilFinished: Long) {
            val waktu = String.format(
                "%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                        TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(
                                millisUntilFinished
                            )
                        )
            )
            timer.text= waktu
        }

        override fun onFinish() {
            btnGetOtp.visibility = View.VISIBLE
            timer.visibility = View.INVISIBLE
        }
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun updateViewData() {
    }

    override fun onSuccess(msg: String?) {
        kodeOtp = msg.toString().trim()
        Toast.makeText(activity,
            "Cek Email Kamu",
            Toast.LENGTH_LONG).show()
    }

    override fun onError(msg: String?) {
        when {
            msg.equals("notActive") -> {
                Toast.makeText(activity,
                    "Ubah password gagal: Cek email untuk konfirmasi akun anda",
                    Toast.LENGTH_LONG).show()
                btnGetOtp.visibility = View.VISIBLE
                timer.visibility=View.INVISIBLE
            }
            msg.equals("noEmail")->{
                Toast.makeText(activity,
                    "Akun anda belum terdaftar",
                    Toast.LENGTH_LONG).show()
                btnGetOtp.visibility = View.VISIBLE
                timer.visibility=View.INVISIBLE
            }
            else -> {
                Toast.makeText(activity, "Ubah password gagal", Toast.LENGTH_LONG).show()
                btnGetOtp.visibility = View.VISIBLE
                timer.visibility = View.INVISIBLE
                Log.d("erorResetPassword", msg)
            }
        }
    }

    private fun inputValid(): Boolean{
        var value = true
        if(edtEmail.text.toString().isEmpty()){
            edtEmail.error = "Email tidak boleh kosong"
            value = false
        }else if(!Patterns.EMAIL_ADDRESS.matcher(edtEmail.text.toString()).matches()){
            edtEmail.error = "Masukkan email"
            value = false
        }

        return value
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_get_otp ->{
                if(inputValid() && InternetConnection.isConnected(activity)){
                    timerClass = TimerClass(60000 * 3, 1000)
                    timerClass.start()
                    btnGetOtp.visibility = View.INVISIBLE
                    timer.visibility = View.VISIBLE
                    val email = edtEmail.text.toString().trim()
                    Log.d("emailmasuk",email)
                    presenter.sendOtp(email)
                }
            }
            R.id.btn_verifikasi ->{
                if (otpView.text?.isEmpty()!!){
                    Toast.makeText(activity,
                        "Masukkan OTP",
                        Toast.LENGTH_LONG).show()
                }else if(kodeOtp.isEmpty()){
                    Toast.makeText(activity,
                        "Dapatkan OTP baru",
                        Toast.LENGTH_LONG).show()
                }else{
                    if (otpView.text.toString().trim() == kodeOtp){
                        timerClass.cancel()

                        val fragmentResetPassword = ResetPasswordFragment()
                        val mBundle = Bundle()
                        mBundle.putString("EMAIL_KEY", edtEmail.text.toString().trim())
                        fragmentResetPassword.arguments = mBundle

                        val fragmentOtp: Fragment? = fragmentManager?.findFragmentByTag(OtpFragment::class.java.simpleName)
                        val fragmentResetPasswordManager = fragmentManager
                        fragmentResetPasswordManager?.beginTransaction()?.apply {
                            replace(R.id.frame_reset_password_container,
                                fragmentResetPassword,
                                ResetPasswordFragment::class.java.simpleName)
                            if (fragmentOtp != null) {
                                remove(fragmentOtp)
                            }
                            commit()
                        }
                    }else{
                        Toast.makeText(activity,
                            "OTP salah",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }
            R.id.tx_kembali ->{
                activity?.finish()
            }
        }
    }

}