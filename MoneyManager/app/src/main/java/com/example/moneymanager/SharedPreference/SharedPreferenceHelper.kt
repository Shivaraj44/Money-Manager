package com.shivaraj.Moneymanager.SharedPreference

import android.content.Context
import android.content.SharedPreferences


class SharedPreferenceHelper {
    private val SHARED_PREFERENCE_KEY = "jane"


    fun getSharedPreference(context: Context): SharedPreferences? {
        return context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)
    }


    fun writeIntToPreference_Expence(context: Context?, key: String?, value: Int) {
        val editor = getSharedPreference(context!!)!!.edit()
        editor.putInt(key, value)
        editor.apply()
    }
    fun writeIntToPreference_Income(context: Context?, key: String?, value: Int) {
        val editor = getSharedPreference(context!!)!!.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getIntFromPreference_Income(context: Context?, key: String?): Int {
        return getSharedPreference(context!!)!!.getInt(key, 0)
    }

    fun getIntFromPreference_Expence(context: Context?, key: String?): Int {
        return getSharedPreference(context!!)!!.getInt(key, 0)
    }



//    fun writeinc(context: Context?, key: String?, value: Int) {
//        val editor = getSharedPreference(context!!)!!.edit()
//        editor.putInt(key, value)
//        editor.apply()
//    }
//    fun writeexp(context: Context?, key: String?, value: Int) {
//        val editor = getSharedPreference(context!!)!!.edit()
//        editor.putInt(key, value)
//        editor.apply()
//    }
//
//    fun getexp(context: Context?, key: String?): Int {
//        return getSharedPreference(context!!)!!.getInt(key, 0)
//    }
//    fun getinc(context: Context?, key: String?): Int {
//        return getSharedPreference(context!!)!!.getInt(key, 0)
//    }
}