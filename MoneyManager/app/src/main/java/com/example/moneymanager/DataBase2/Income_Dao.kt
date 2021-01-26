package com.shivaraj.Moneymanager.DataBase2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface Income_Dao {

    @Insert
    fun InsertData(incomeUser: Income_User)

    @Query("select * from Income_Tablle  ")
    fun getAllExpence():List<Income_User>
}