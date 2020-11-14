package com.santiyunikas.mathgeo.view.authentication

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mukesh.OnOtpCompletionListener
import com.santiyunikas.mathgeo.presenter.auth.OtpPresenter
import com.santiyunikas.mathgeo.R
import com.santiyunikas.mathgeo.contract.ContractInterface.IView
import com.santiyunikas.mathgeo.util.network.InternetConnection
import kotlinx.android.synthetic.main.fragment_otp.*
import java.util.concurrent.TimeUnit


class OtpFragment : Fragment(), IView, View.OnClickListener{
    private lateinit var presenter: OtpPresenter
    private var kodeOtp: String = ""
    private lateinit var timerClass: TimerClass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
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
            btn_get_otp.visibility = View.VISIBLE
            timer.visibility = View.INVISIBLE
        }
    }

    override fun initView() {
        timer.visibility = View.INVISIBLE
        btn_get_otp.setOnClickListener(this)
        btn_verifikasi.setOnClickListener(this)
        tx_kembali.setOnClickListener(this)

        presenter = OtpPresenter(this)

        otp_view.setOtpCompletionListener(OnOtpCompletionListener { otp -> // do Stuff
            Log.d("onOtpCompleted=>", otp)
        })
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
                btn_get_otp.visibility = View.VISIBLE
                timer.visibility=View.INVISIBLE
            }
            msg.equals("noEmail")->{
                Toast.makeText(activity,
                    "Akun anda belum terdaftar",
                    Toast.LENGTH_LONG).show()
                btn_get_otp.visibility = View.VISIBLE
                timer.visibility=View.INVISIBLE
            }
            else -> {
                Toast.makeText(activity, "Ubah password gagal", Toast.LENGTH_LONG).show()
                btn_get_otp.visibility = View.VISIBLE
                timer.visibility = View.INVISIBLE
                Log.d("erorResetPassword", msg)
            }
        }
    }

    private fun inputValid(): Boolean{
        var value = true
        if(edt_email_reset_pass.text.toString().isEmpty()){
            edt_email_reset_pass.error = "Email tidak boleh kosong"
            value = false
        }else if(!Patterns.EMAIL_ADDRESS.matcher(edt_email_reset_pass.text.toString()).matches()){
            edt_email_reset_pass.error = "Masukkan email"
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
                    btn_get_otp.visibility = View.INVISIBLE
                    timer.visibility = View.VISIBLE
                    val email = edt_email_reset_pass.text.toString().trim()
                    Log.d("emailmasuk",email)
                    presenter.sendOtp(email)
                }
            }
            R.id.btn_verifikasi ->{
                if (otp_view.text?.isEmpty()!!){
                    Toast.makeText(activity,
                        "Masukkan OTP",
                        Toast.LENGTH_LONG).show()
                }else if(kodeOtp.isEmpty()){
                    Toast.makeText(activity,
                        "Dapatkan OTP baru",
                        Toast.LENGTH_LONG).show()
                }else{
                    if (otp_view.text.toString().trim() == kodeOtp){
                        timerClass.cancel()

                        val fragmentResetPassword = ResetPasswordFragment()
                        val mBundle = Bundle()
                        mBundle.putString("EMAIL_KEY", edt_email_reset_pass.text.toString().trim())
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