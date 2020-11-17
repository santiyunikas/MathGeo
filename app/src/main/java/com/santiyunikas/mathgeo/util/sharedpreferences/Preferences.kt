package com.santiyunikas.mathgeo.util.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

object Preferences {
    /** Pendeklarasian key-data berupa String, untuk sebagai wadah penyimpanan data.
     * Jadi setiap data mempunyai key yang berbeda satu sama lain  */
    const val KEY_ID_USER_TEREGISTER = "id_user"
    const val KEY_NAMA_LENGKAP_TEREGISTER = "nama_lengkap"
    const val KEY_NOMOR_TELEPON_TEREGISTER = "nomor_telepon"
    const val KEY_EMAIL_TEREGISTER = "email"
    const val KEY_KODE_REFERAL_TEREGISTER = "kode_referal"
    const val KEY_JUMLAH_KOIN_TEREGISTER = "jumlah_koin"

    const val KEY_STATUS_SEDANG_LOGIN = "Status_logged_in"

    const val KEY_TEMP_JAWABAN = "jawaban"

    /** Pendlakarasian Shared Preferences yang berdasarkan paramater context  */
    private fun getSharedPreference(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun setTempJawaban(context: Context, jawaban: String?) {
        val editor = getSharedPreference(context).edit()
        editor.putString(KEY_TEMP_JAWABAN, jawaban)
        editor.apply()
    }

    fun getTempJawaban(context: Context): String? {
        return getSharedPreference(context).getString(KEY_TEMP_JAWABAN, "null")
    }

    @SuppressLint("CommitPrefEdits")
    fun clearTempJawaban(context: Context) {
        val editor = getSharedPreference(context).edit()
        editor.remove(KEY_TEMP_JAWABAN)
        editor.apply()
    }


    fun setRegisteredFullname(context: Context, fullname: String?) {
        val editor = getSharedPreference(context).edit()
        editor.putString(KEY_NAMA_LENGKAP_TEREGISTER, fullname)
        editor.apply()
    }

    fun getRegisteredFullname(context: Context): String? {
        return getSharedPreference(context).getString(KEY_NAMA_LENGKAP_TEREGISTER, "Nama Lengkap")
    }

    fun setRegisteredPhone(context: Context, phone: String?) {
        val editor = getSharedPreference(context).edit()
        editor.putString(KEY_NOMOR_TELEPON_TEREGISTER, phone)
        editor.apply()
    }

    fun getRegisteredPhone(context: Context): String? {
        return getSharedPreference(context).getString(KEY_NOMOR_TELEPON_TEREGISTER, "Nomor telepon")
    }

    fun setRegisteredEmail(context: Context, email: String?) {
        val editor = getSharedPreference(context).edit()
        editor.putString(KEY_EMAIL_TEREGISTER, email)
        editor.apply()
    }

    fun getRegisteredEmail(context: Context): String? {
        return getSharedPreference(context).getString(KEY_EMAIL_TEREGISTER, "")
    }

    fun setRegisteredKodeReferal(context: Context, kodeReferal: String?) {
        val editor = getSharedPreference(context).edit()
        editor.putString(KEY_KODE_REFERAL_TEREGISTER, kodeReferal)
        editor.apply()
    }

    fun getRegisteredKodeReferal(context: Context): String? {
        return getSharedPreference(context).getString(KEY_KODE_REFERAL_TEREGISTER, "")
    }

    fun setRegisteredJumlahKoin(context: Context, n: Int?) {
        val editor = getSharedPreference(context).edit()
        if (n != null) {
            editor.putInt(KEY_JUMLAH_KOIN_TEREGISTER, n)
        }
        editor.apply()
    }

    fun getRegisteredJumlahKoin(context: Context): Int? {
        return getSharedPreference(context).getInt(KEY_JUMLAH_KOIN_TEREGISTER, 0)
    }

    fun setRegisteredIdUser(context: Context, id: Int?) {
        val editor = getSharedPreference(context).edit()
        if (id != null) {
            editor.putInt(KEY_ID_USER_TEREGISTER, id)
        }
        editor.apply()
    }

    fun getRegisteredIdUser(context: Context): Int? {
        return getSharedPreference(context).getInt(KEY_ID_USER_TEREGISTER, 0)
    }

    fun setLoggedInStatus(context: Context, status: Boolean) {
        val editor = getSharedPreference(context).edit()
        editor.putBoolean(KEY_STATUS_SEDANG_LOGIN, status)
        editor.apply()
    }

    fun getLoggedInStatus(context: Context): Boolean {
        return getSharedPreference(context).getBoolean(KEY_STATUS_SEDANG_LOGIN, false)
    }

    @SuppressLint("CommitPrefEdits")
    fun clearLoggedInUser(context: Context) {
        val editor = getSharedPreference(context).edit()
        editor.remove(KEY_STATUS_SEDANG_LOGIN)
        editor.remove(KEY_ID_USER_TEREGISTER)
        editor.remove(KEY_NAMA_LENGKAP_TEREGISTER)
        editor.remove(KEY_NOMOR_TELEPON_TEREGISTER)
        editor.remove(KEY_EMAIL_TEREGISTER)
        editor.remove(KEY_KODE_REFERAL_TEREGISTER)
        editor.remove(KEY_JUMLAH_KOIN_TEREGISTER)
        editor.apply()
    }
}