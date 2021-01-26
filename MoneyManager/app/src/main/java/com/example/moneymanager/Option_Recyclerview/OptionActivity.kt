package com.shivaraj.Moneymanager.Option_Recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.shivaraj.Moneymanager.DataBase2.DataBase
import com.shivaraj.Moneymanager.DataBase2.Expense_DataBase
import com.shivaraj.Moneymanager.DataBase2.Expense_User
import com.shivaraj.Moneymanager.DataBase2.User
import com.shivaraj.Moneymanager.Home.HomeActivity2
import com.shivaraj.Moneymanager.R
import kotlinx.android.synthetic.main.activity_home2.*
import kotlinx.android.synthetic.main.activity_option.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OptionActivity : AppCompatActivity(), OptionRV_Listner {


    val model_list = ArrayList<Model_Oprion>()
    var image: Int = 0
    var title: String = ""
    var listOfExpense = listOf<Expense_User>()
    var sum1 = 0
var concert:Int=0
    var jan:String=""


    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)
        onMonthSelect()
        SetRecyclerDat()
        SetAdapetr()
        intiviews()
        val option = arrayOf("Expenses", "Income")
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option)
        spinner.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {


            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //text_view.text = option.get(position)
                if (position == 1) {

                    call()


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
                val intent = Intent(this@OptionActivity, IncomeActivity::class.java)
                startActivity(intent)
            }

        }


    }

    fun SetRecyclerDat() {
        model_list.add(Model_Oprion("Hamburger", R.drawable.burger))
        model_list.add(Model_Oprion("Food", R.drawable.plate))
        model_list.add(Model_Oprion("Gym", R.drawable.gym))
        model_list.add(Model_Oprion("Parler", R.drawable.parler))
        model_list.add(Model_Oprion("Health", R.drawable.firstadekit1))
        model_list.add(Model_Oprion("Hospital", R.drawable.hospital))
        model_list.add(Model_Oprion("Make-up", R.drawable.cosmeticss))
        model_list.add(Model_Oprion("Shopping", R.drawable.shopping123))
        model_list.add(Model_Oprion("Beer", R.drawable.wine))
        model_list.add(Model_Oprion("Bills", R.drawable.light))
        model_list.add(Model_Oprion("Cloths", R.drawable.tshirt))
        model_list.add(Model_Oprion("Scooter", R.drawable.vespa))
        model_list.add(Model_Oprion("Car", R.drawable.car_1))
        model_list.add(Model_Oprion("Shirt", R.drawable.tshirt))

        model_list.add(Model_Oprion("Vegetable", R.drawable.vegetable111))
        // model_list.add(Model_Oprion("hamburger", R.drawable.food2))
        model_list.add(Model_Oprion("Language", R.drawable.bag))
        model_list.add(Model_Oprion("Snacks", R.drawable.snack123))

        model_list.add(Model_Oprion("Home", R.drawable.home1))
        model_list.add(Model_Oprion("Bone", R.drawable.bone))
        model_list.add(Model_Oprion("Pizza", R.drawable.pizza11))

        model_list.add(Model_Oprion("Pets", R.drawable.dog))


    }

    fun SetAdapetr() {
        val adapterOption = Adapter_Option(model_list, this)
        val gridLayoutManager = GridLayoutManager(this, 5)
        recyclerview.adapter = adapterOption
        recyclerview.layoutManager = gridLayoutManager
    }

    fun intiviews() {
        back_arrow.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, HomeActivity2::class.java)
            startActivity(intent)

        })

        ok.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, HomeActivity2::class.java)
            val total_amount: String = add_amount.text.toString()
             concert = total_amount.toInt()

            intent.putExtra("title123", title)
            intent.putExtra("image123", image)
            intent.putExtra("total123", total_amount)


            intent.putExtra("total", total_amount)
            intent.putExtra("s", total_amount)



            val dataBase = DataBase
            var a = 0;


            Thread {
                val user = User(a++, title, image, concert,jan)

                dataBase.getInstance(this@OptionActivity).dao.InsertData(user)


            }.start()

            startActivity(intent)
        })

    }


    override fun OnItemClick(modelOprion: Model_Oprion, position: Int) {
        title = modelOprion.title
        image = modelOprion.img
        calci.visibility = View.VISIBLE
        receiver_title.text = title
        receiver_image.setImageResource(image)

    }
  fun  onMonthSelect(){

      val option1 = arrayOf("Jan", "Feb","Mar","Apr","May","Jun","Jly","Aug","Sep","Oct","Nov","Dec")
        spinner_month.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option1)
        spinner_month.onItemSelectedListener = object : AdapterView.OnItemClickListener,
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
                Toast.makeText(this@OptionActivity,"Nothing Selected",Toast.LENGTH_SHORT).show()
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



