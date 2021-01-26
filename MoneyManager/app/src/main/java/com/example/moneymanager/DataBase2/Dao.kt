package com.shivaraj.Moneymanager.DataBase2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {

    @Insert
    fun InsertData(user: User)

    @Query("select * from MoneyMaker")
    fun getAlldata():List<User>

    @Query("select * from MoneyMaker where Month = 'Jan' ")
    fun getJan():List<User>

    @Query("select * from MoneyMaker where Month = 'Feb' ")
    fun getFeb():List<User>


    @Query("select * from MoneyMaker where Month = 'Mar' ")
    fun getMar():List<User>


    @Query("select * from MoneyMaker where Month = 'Apr' ")
    fun getApr():List<User>

    @Query("select * from MoneyMaker where Month = 'May' ")
    fun getMay():List<User>


    @Query("select * from MoneyMaker where Month = 'Jun' ")
    fun getJun():List<User>


    @Query("select * from MoneyMaker where Month = 'Jly' ")
    fun getJly():List<User>


    @Query("select * from MoneyMaker where Month = 'Aug' ")
    fun getAug():List<User>


    @Query("select * from MoneyMaker where Month = 'Sep' ")
    fun getSep():List<User>


    @Query("select * from MoneyMaker where Month = 'Oct' ")
    fun getOct():List<User>


    @Query("select * from MoneyMaker where Month = 'Nov' ")
    fun getNov():List<User>

    @Query("select * from MoneyMaker where Month = 'Dec' ")
    fun getDec():List<User>


    @Delete
    fun deletUser(user: User)

}