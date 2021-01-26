package com.shivaraj.Moneymanager.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.shivaraj.Moneymanager.R
import kotlinx.android.synthetic.main.activity_apr.*
import kotlinx.android.synthetic.main.activity_feb.*

class AprActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apr)
        val option = arrayOf("Apr","Feb","Jan","Mar","May")
        spinner_Apr.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option)
        spinner_Apr.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {


            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                text_feb.text = option.get(position)
                if (position == 1) {
                    val intent= Intent(this@AprActivity, FebActivity::class.java)
                    startActivity(intent)
                }else if(position==2){
                    val intent= Intent(this@AprActivity, HomeActivity2::class.java)
                    startActivity(intent)

                }
                else if(position==3){
                    val intent= Intent(this@AprActivity, MarActivity::class.java)
                    startActivity(intent)

                }
                else if(position==4){
                    val intent= Intent(this@AprActivity, MayActivity::class.java)
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