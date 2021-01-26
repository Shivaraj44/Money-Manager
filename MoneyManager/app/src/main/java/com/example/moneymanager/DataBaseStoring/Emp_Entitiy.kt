package com.shivaraj.Moneymanager.DataBaseStoring

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Emp_Entitiy {

    @PrimaryKey ()

    var id:Int=0

    @ColumnInfo (name = "Amount")
    var total_amount:String=""

@ColumnInfo(name = "Title")
    var total_title:String=""

}