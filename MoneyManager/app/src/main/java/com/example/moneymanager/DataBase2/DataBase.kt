package com.shivaraj.Moneymanager.DataBase2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version =1, exportSchema = false)
abstract class DataBase :RoomDatabase(){

abstract val dao:Dao

companion object{
    private var INSTANCE:DataBase?=null
    fun getInstance(context: Context):DataBase{
        var instance=INSTANCE
        if(instance==null){
            instance=Room.databaseBuilder(context,DataBase::class.java,"Money Database").build()
            INSTANCE=instance
        }
        return instance
    }
}
}