package com.shivaraj.Moneymanager.Home

import android.widget.TextView
import com.shivaraj.Moneymanager.DataBase2.User

interface SelectItem {
    fun OnSelected(user: User,position:Int)

}