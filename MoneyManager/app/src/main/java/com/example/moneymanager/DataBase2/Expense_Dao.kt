package com.shivaraj.Moneymanager.DataBase2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Expense_Dao {

    @Insert
    fun InsertData(expenseUser: Expense_User)

    @Query("select * from Expense_Tablle  ")
    fun getAllExpence():List<Expense_User>


}