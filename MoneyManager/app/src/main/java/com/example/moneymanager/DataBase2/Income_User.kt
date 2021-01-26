package com.shivaraj.Moneymanager.DataBase2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity(tableName = "Income_Tablle")
    data class Income_User(


        @PrimaryKey(autoGenerate = true)
        var Id: Int = 0,

        @ColumnInfo(name ="Income_Amount")
        val income:Int=0


    )