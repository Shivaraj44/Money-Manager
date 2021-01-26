package com.shivaraj.Moneymanager.DataBaseStoring

import androidx.room.Database
import androidx.room.RoomDatabase


@Database( entities = [(Emp_Entitiy::class)],version = 1)
abstract class AppData:RoomDatabase() {

   abstract fun dao():Dao
}