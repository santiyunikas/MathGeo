package com.santiyunikas.mathgeo.view.content.profil

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.santiyunikas.mathgeo.*
import com.santiyunikas.mathgeo.util.sharedpreferences.Preferences
import com.santiyunikas.mathgeo.view.authentication.LoginActivity
import com.santiyunikas.mathgeo.view.authentication.ResetPasswordActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tx_ubah_pass.setOnClickListener {
            val intent: Intent = Intent(view.context, ResetPasswordActivity::class.java)
            startActivity(intent)
        }
        btn_edit_profile.setOnClickListener{
            val intent: Intent = Intent(view.context, EditProfileActivity::class.java)
            startActivity(intent)
        }
        btn_kode_referal.setOnClickListener{
            val intent: Intent = Intent(view.context, KoinGratisActivity::class.java)
            startActivity(intent)
        }
        btn_kompetensi_dan_tujuan.setOnClickListener{
            val intent: Intent = Intent(view.context, KompetensiTujuanActivity::class.java)
            startActivity(intent)
        }
        btn_petunjuk.setOnClickListener{
            val intent: Intent = Intent(view.context, PetunjukActivity::class.java)
            startActivity(intent)
        }
        btn_logout.setOnClickListener {
            Preferences.clearLoggedInUser(view.context)
            val intent: Intent = Intent(view.context, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        tx_nama_lengkap_edit.text = Preferences.getRegisteredFullname(view.context)
        tx_nama_lengkap.text = Preferences.getRegisteredFullname(view.context)
        tx_nomor_telepon.text = Preferences.getRegisteredPhone(view.context)
        tx_email.text = Preferences.getRegisteredEmail(view.context)
    }
}