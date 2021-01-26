package com.shivaraj.Moneymanager.DataBaseStoring

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {

    @Insert
    fun SaveData(emp:Emp_Entitiy)

@Query("select * from Emp_Entitiy")
    fun Fetchall():List<Emp_Entitiy>
}