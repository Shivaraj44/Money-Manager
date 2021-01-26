package com.shivaraj.Moneymanager.DataBase2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MoneyMaker")
data class User(


    @PrimaryKey   (autoGenerate = true)
   var Id: Int = 1,



   @ColumnInfo(name = "Title")
    val title: String,

    @ColumnInfo(name = "Image")
    val Image:Int,


    @ColumnInfo(name = "Value")
     val value:Int,

    @ColumnInfo(name = "Month")
    val month: String




)
