package com.santiyunikas.mathgeo.util.network

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.provider.Settings
import android.widget.Toast

object InternetConnection {
    fun isConnected(context: Context?): Boolean {
        val state: Boolean
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetwork
        state = if (activeNetwork == null) {
            context.startActivity(Intent(Settings.ACTION_SETTINGS))
            Toast.makeText(context, "Aktifkan Koneksi Internet Kamu", Toast.LENGTH_SHORT)
                .show()
            false
        } else {
            true
        }
        return state
    }
}