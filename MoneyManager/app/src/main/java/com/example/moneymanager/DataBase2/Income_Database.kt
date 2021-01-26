package com.shivaraj.Moneymanager.DataBase2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Income_User::class], version =1, exportSchema = false)
abstract class Income_Database : RoomDatabase(){

    abstract val incomeDao:Income_Dao

    companion object{
        private var INSTANCE:Income_Database?=null
        fun getIncomeInstance(context: Context):Income_Database{
            var instance=INSTANCE
            if(instance==null){
                instance= Room.databaseBuilder(context,Income_Database::class.java,"Income").build()
                INSTANCE=instance
            }
            return instance
        }
    }
}