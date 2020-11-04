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

class ProfileFragment : Fragment(){
    private lateinit var txFullname: TextView
    private lateinit var txPhone: TextView
    private lateinit var txEmail: TextView
    private lateinit var txNamaLengkapEdit: TextView
    private lateinit var btnChangePass: TextView
    private lateinit var btnEditProfile: LinearLayout
    private lateinit var btnKoin: RelativeLayout
    private lateinit var btnKompetensiTujuan: RelativeLayout
    private lateinit var btnPetunjuk: RelativeLayout
    private lateinit var btnLogout: RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txNamaLengkapEdit = view.findViewById(R.id.tx_nama_lengkap_edit)
        txFullname = view.findViewById(R.id.tx_nama_lengkap)
        txPhone = view.findViewById(R.id.tx_nomor_telepon)
        txEmail = view.findViewById(R.id.tx_email)
        btnChangePass = view.findViewById(R.id.tx_ubah_pass)
        btnEditProfile = view.findViewById(R.id.btn_edit_profile)
        btnKoin = view.findViewById(R.id.btn_kode_referal)
        btnKompetensiTujuan = view.findViewById(R.id.btn_kompetensi_dan_tujuan)
        btnPetunjuk = view.findViewById(R.id.btn_petunjuk)
        btnLogout = view.findViewById(R.id.btn_logout)

        btnChangePass.setOnClickListener {
            val intent: Intent = Intent(view.context, ResetPasswordActivity::class.java)
            startActivity(intent)
        }
        btnEditProfile.setOnClickListener{
            val intent: Intent = Intent(view.context, EditProfileActivity::class.java)
            startActivity(intent)
        }
        btnKoin.setOnClickListener{
            val intent: Intent = Intent(view.context, KoinGratisActivity::class.java)
            startActivity(intent)
        }
        btnKompetensiTujuan.setOnClickListener{
            val intent: Intent = Intent(view.context, KompetensiTujuanActivity::class.java)
            startActivity(intent)
        }
        btnPetunjuk.setOnClickListener{
            val intent: Intent = Intent(view.context, PetunjukActivity::class.java)
            startActivity(intent)
        }
        btnLogout.setOnClickListener {
            Preferences.clearLoggedInUser(view.context)
            val intent: Intent = Intent(view.context, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        txNamaLengkapEdit.text = Preferences.getRegisteredFullname(view.context)
        txFullname.text = Preferences.getRegisteredFullname(view.context)
        txPhone.text = Preferences.getRegisteredPhone(view.context)
        txEmail.text = Preferences.getRegisteredEmail(view.context)
    }
}