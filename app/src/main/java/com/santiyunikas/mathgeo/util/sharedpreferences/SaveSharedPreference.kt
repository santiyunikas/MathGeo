package com.santiyunikas.mathgeo.util.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class SaveSharedPreference {

    companion object{
        fun getPreferences(context: Context): SharedPreferences{
            return PreferenceManager.getDefaultSharedPreferences(context)
        }
        fun setLoggedIn(context: Context, loggedIn:Boolean){
            val editor: SharedPreferences.Editor = getPreferences(context).edit()
            editor.putBoolean(PreferencesUtility.LOGGGED_IN_PREF, loggedIn)
            editor.apply()
        }
        fun getLoggedStatus(context: Context): Boolean{
            return getPreferences(context).getBoolean(PreferencesUtility.LOGGGED_IN_PREF, false)
        }

    }

}