package com.shivaraj.Moneymanager.Login

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {
    private val SHARED_PREFERENCE_KEY = "com.xyz.sharedpreferences"
    fun getSharedPreference(context: Context): SharedPreferences? {
        return context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)
    }
    fun writeStringtopreference(context: Context, key: String, value: String){
        val editor = getSharedPreference(context)!!.edit()
        editor.putString(key, value)
        editor.apply()
    }
    fun getStringFromPreference(context: Context?, key: String?): String? {
        return getSharedPreference(context!!)!!.getString(key, null)
    }

}