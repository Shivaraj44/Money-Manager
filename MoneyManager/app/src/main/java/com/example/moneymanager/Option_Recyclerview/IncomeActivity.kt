package com.shivaraj.Moneymanager.Option_Recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.shivaraj.Moneymanager.DataBase2.DataBase
import com.shivaraj.Moneymanager.DataBase2.Income_Database
import com.shivaraj.Moneymanager.DataBase2.Income_User
import com.shivaraj.Moneymanager.DataBase2.User
import com.shivaraj.Moneymanager.Home.HomeActivity2
import com.shivaraj.Moneymanager.R
import kotlinx.android.synthetic.main.activity_home2.*
import kotlinx.android.synthetic.main.activity_income.*
import kotlinx.android.synthetic.main.activity_option.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IncomeActivity : AppCompatActivity(),IncomeClickListner {

    val model_list1 = ArrayList<Model_Income>()
    var image1: Int = 0
    var title1: String = ""
    var listofTncome = listOf<Income_User>()
    var jan:String=""

var sum2=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income)
        onMonthSelect()
        SetRecyclerDat()
        SetAdapetr()
        intiviews()
        val option1 = arrayOf(" Income", "Expense")
        spinner_income.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option1)
        spinner_income.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {


            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                text_view_income.text = option1.get(position)
                if (position == 1) {

                    call()
                }else{

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
                val intent1= Intent(this@IncomeActivity,OptionActivity::class.java)
                startActivity(intent1)
            }

        }

    }

    fun SetRecyclerDat() {
        model_list1.add(Model_Income("Wallet", R.drawable.wallet1))
        model_list1.add(Model_Income("Bonus", R.drawable.bonus))
        model_list1.add(Model_Income("Refund", R.drawable.refund))
        model_list1.add(Model_Income("Sale", R.drawable.sale))
        model_list1.add(Model_Income("Gifts", R.drawable.giftbox1))
        model_list1.add(Model_Income("Doller", R.drawable.dollar))
        model_list1.add(Model_Income("Book", R.drawable.openbook1))





    }
    fun SetAdapetr() {
        val adapter = Adapter_Income(model_list1, this)
        val gridLayoutManager = GridLayoutManager(this, 5)
        recyclerview_income.adapter = adapter
        recyclerview_income.layoutManager = gridLayoutManager
    }


    fun intiviews() {
        back_arrow_income.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, HomeActivity2::class.java)
            startActivity(intent)

        })

        ok_income.setOnClickListener(View.OnClickListener {
            calci1.visibility=View.VISIBLE
            val intent = Intent(this, HomeActivity2::class.java)
            val total_amount: String = add_amount_income.text.toString()
            val con=total_amount.toInt()
//            intent.putExtra("title1", title1)
//            intent.putExtra("image1", image1)
          intent.putExtra("total1", total_amount)
            intent.putExtra("s1",total_amount)

            var a=0
            val b=total_amount

             val database=DataBase
            Thread {

                // if (image != 0) {

                val user = User(a++, title1, image1,con, jan)

                database.getInstance(this).dao.InsertData(user)
                runOnUiThread {
                    //Runnable {
                      //  adapter.notifyDataSetChanged()

                    //}
                }

            }.start()

//
            var q = 0
            var m:Int=b.toInt()
//            Thread {
//                val incomeUser = Income_User(q++, m)
//                val incomeDatabase = Income_Database
//                incomeDatabase.getIncomeInstance(this).incomeDao.InsertData(incomeUser)
//            }.start()
//
//
//
//            CoroutineScope(Dispatchers.IO).launch {
//                listofTncome = Income_Database.getIncomeInstance(this@IncomeActivity).incomeDao.getAllExpence()
//
//            }.invokeOnCompletion {
//                obserincometomainThread()
//            }


            startActivity(intent)
         //   finish()

        })


    }
    fun obserincometomainThread(){

        CoroutineScope(Dispatchers.Main).launch {
            listofTncome.forEachIndexed { index, incomeUSer ->
                sum2 += incomeUSer.income
            }

//            listofTncome.forEachIndexed { index, incomeUser ->
//                sum2 += incomeUSer.income
//            } { index, incomeUSer ->
//               //
//             //  sum2= listofTncome.sum()
//            }
            val intenr122=Intent()
            intenr122.putExtra("sum2",sum2)
            //bundle.putInt("sum2",sum2)
           // total_income_amount.text = sum2.toString()
            print(":debug$sum2")



        }
        //    total_income=sum2

        Log.d("shivv",""+sum2)
    }
    override fun Onclicked(modelIncome: Model_Income, position: Int) {
        title1 = modelIncome.title_income
        image1 = modelIncome.img_income
            calci1.visibility = View.VISIBLE
        receiver_title_income.text = title1
        receiver_image_income.setImageResource(image1)

    }
    fun  onMonthSelect(){

        val option1 = arrayOf("Jan", "Feb","Mar","Apr","May","Jun","Jly","Aug","Sep","Oct","Nov","Dec")
        spinner_month_income.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option1)
        spinner_month_income.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {


            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //text_view.text = option.get(position)
                if (position == 0) {
                    jan="Jan"
                    var i=intent.putExtra("mon","Jan")



                } else if (position == 1) {
                    jan="Feb"
                    var i=intent.putExtra("mon","Feb")



                } else if (position == 2){
                    jan="Mar"
                    var i=intent.putExtra("mon","Mar")


                }
                else if (position == 3){
                    jan="Apr"
                    var i=intent.putExtra("mon","Apr")


                }
                else if (position == 4){
                    jan="May"
                    var i=intent.putExtra("mon","Apr")


                }
                else if (position == 5){
                    jan="Jun"
                    var i=intent.putExtra("mon","Apr")


                }
                else if (position == 6){
                    jan="Jly"
                    var i=intent.putExtra("mon","Apr")


                }
                else if (position == 7){
                    jan="Aug"
                    var i=intent.putExtra("mon","Apr")


                }
                else if (position == 8){
                    jan="Sep"
                    var i=intent.putExtra("mon","Apr")


                }
                else if (position == 9){
                    jan="Oct"
                    var i=intent.putExtra("mon","Apr")


                }
                else if (position == 10){
                    jan="Nov"
                    var i=intent.putExtra("mon","Apr")


                }
                else if (position == 11){
                    jan="Dec"
                    var i=intent.putExtra("mon","Apr")


                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@IncomeActivity,"Nothing Selected", Toast.LENGTH_SHORT).show()
            }

            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }
        }

    }
}