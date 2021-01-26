package com.shivaraj.Moneymanager.DataBase2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Expense_Tablle")
data class Expense_User(


    @PrimaryKey(autoGenerate = true)
    var Ide: Int = 0,

    @ColumnInfo(name ="Expense_Amount")
    val expense:Int=0


)