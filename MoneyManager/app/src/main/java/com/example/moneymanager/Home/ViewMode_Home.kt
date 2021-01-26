package com.shivaraj.Moneymanager.Home

import android.util.Log
import androidx.lifecycle.ViewModel

class ViewMode_Home:ViewModel() {
    private var Store:Int=0

    fun updateStore(data:Int){

        Store=Store+data

    }


    fun getScore():Int{
        Log.d("shiview","data is  "+Store)
        return Store

    }


}