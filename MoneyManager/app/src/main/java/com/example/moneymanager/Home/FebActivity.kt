package com.shivaraj.Moneymanager.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.shivaraj.Moneymanager.R
import kotlinx.android.synthetic.main.activity_feb.*
import kotlinx.android.synthetic.main.activity_home2.*

class FebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feb)
        val option = arrayOf("Feb","Jan","Mar","Apr","May")
        spinner_feb.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option)
        spinner_feb.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {


            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                text_feb.text = option.get(position)
                if (position == 1) {
                    val intent= Intent(this@FebActivity, HomeActivity2::class.java)
                    startActivity(intent)
                }else if(position==2){
                    val intent= Intent(this@FebActivity, MarActivity::class.java)
                    startActivity(intent)

                }
                else if(position==3){
                    val intent= Intent(this@FebActivity, AprActivity::class.java)
                    startActivity(intent)

                }
                else if(position==4){
                    val intent= Intent(this@FebActivity, MayActivity::class.java)
                    startActivity(intent)

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            private fun call() {

            }

        }

    }
}