package com.shivaraj.Moneymanager.DataBase2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Expense_User::class], version =1, exportSchema = false)
abstract class Expense_DataBase : RoomDatabase(){

    abstract val expenseDao:Expense_Dao

    companion object{
        private var INSTANCE:Expense_DataBase?=null
        fun getExpenseInstance(context: Context):Expense_DataBase{
            var instance=INSTANCE
            if(instance==null){
                instance= Room.databaseBuilder(context,Expense_DataBase::class.java,"expense").build()
                INSTANCE=instance
            }
            return instance
        }
    }
}