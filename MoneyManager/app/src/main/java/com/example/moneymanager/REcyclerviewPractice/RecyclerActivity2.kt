package com.shivaraj.Moneymanager.REcyclerviewPractice

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.shivaraj.Moneymanager.DataBaseStoring.AppData
import com.shivaraj.Moneymanager.DataBaseStoring.Emp_Entitiy
import com.shivaraj.Moneymanager.R
import kotlinx.android.synthetic.main.activity_recycler2.*

class RecyclerActivity2 : AppCompatActivity() {
    val modellist = ArrayList<RecyclerMode>()
    val adapter = RecyclerAdaper(modellist)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler2)
        setdata()
        setAdaper()


        val db = Room.databaseBuilder(applicationContext, AppData::class.java, "Stroing").build()
        val emp = Emp_Entitiy()
        //
        //  addtodatabase.setOnClickListener(View.OnClickListener {
        Thread {

            emp.total_amount = "102210"
            emp.total_title = "shivraj  hhab"
            db.dao().SaveData(emp)
            db.dao().Fetchall().forEach {
                Log.i("jane", "id is ; ${it.id}")
                Log.i("jane", "id is ; ${it.total_title}")

                Log.i("jane", "id is ; ${it.total_amount}")

            }
        }.start()

        //    })


        btn_fetch.setOnClickListener(View.OnClickListener {

            modellist.add(RecyclerMode("halket"))
            adapter.notifyDataSetChanged()
        })
        remove.setOnClickListener(View.OnClickListener {
            modellist.removeAt(modellist.size - 1)
            adapter.notifyDataSetChanged()
        })
    }


    private fun setAdaper() {

        val linearLayoutManager = LinearLayoutManager(this)
        recyc.adapter = adapter
        recyc.layoutManager = linearLayoutManager


    }

    private fun setdata() {
        modellist.add(RecyclerMode("shv"))

        modellist.add(RecyclerMode("shv"))

        modellist.add(RecyclerMode("shv"))

        modellist.add(RecyclerMode("shv"))

        modellist.add(RecyclerMode("jane"))
    }

}