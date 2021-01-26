package com.shivaraj.Moneymanager.Home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivaraj.Moneymanager.DataBase2.*
import com.shivaraj.Moneymanager.Option_Recyclerview.OptionActivity
import com.shivaraj.Moneymanager.R
import com.shivaraj.Moneymanager.SharedPreference.SharedPreferenceHelper
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_apr.*
import kotlinx.android.synthetic.main.activity_home2.*
import kotlinx.android.synthetic.main.activity_home2.recycler
import kotlinx.android.synthetic.main.activity_home2.total_balance_anount
import kotlinx.android.synthetic.main.activity_home2.total_income_amount
import kotlinx.android.synthetic.main.activity_mar.*
import kotlinx.android.synthetic.main.activity_option.*
import kotlinx.android.synthetic.main.bottom_layout.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch


class HomeActivity2 : AppCompatActivity(), SelectItem {

    lateinit var viewModel: ViewMode_Home


    private val PREF_EXPENCE_MONEY = "PREF_EXPENCE_MONEY"
    private val PREF_INCOME_MONEY = "PREF_INCOME_MONEY"
    private val EXP = "EXP"
    private val INC = "INC"
    var a = 0

    var total_income = 0
    var total_expense = 0

    val dataBase = DataBase
    var title: String = ""
    var value: String = ""

    val user = ArrayList<User>()
    val adapter = HomeRC_Adapter(user, this)


    var expence_money: Int = 0;
    var income_money: Int = 0

    var listOfExpense = listOf<Expense_User>()
    var listofTncome = listOf<Income_User>()

    val sharedPreferenceHelper = SharedPreferenceHelper()


    var sum1 = 0
    var sum2 = 0
    var ex_sh: Int = 0
    var in_sh = 0
    // var swm=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        viewModel = ViewModelProvider(this).get(ViewMode_Home::class.java)
        //  total_balance_anount.text=swm.toString()

        expence_amout_exp.text = sharedPreferenceHelper.getIntFromPreference_Expence(
            this,
            PREF_EXPENCE_MONEY
        ).toString()

        total_income_amount.text = sharedPreferenceHelper.getIntFromPreference_Income(
            this,
            PREF_INCOME_MONEY
        ).toString()


        for (i in 0..10) {
            didTapButton()
        }

        initviews()
        getdata()
        setadapter()

//        val c: String = total_income_amount.text.toString()
//        var v: String = expence_amout_exp.text.toString()
//
//        var ca: Int = c.toInt()
//        var ba = v.toInt()
//        Balance = ca - ba

        sharedPreferenceHelper.writeIntToPreference_Expence(this, PREF_EXPENCE_MONEY, total_expense)
        sharedPreferenceHelper.writeIntToPreference_Income(this, PREF_INCOME_MONEY, total_income)

        //  val tot=in_sh-ex_sh
        // total_balance_anount.text=tot.toString()


    }

    private fun initviews() {
        list123.setOnClickListener(View.OnClickListener {
            val diaglog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.bottom_layout, null)
            diaglog.setContentView(view)


            val textv: TextView? = diaglog.findViewById(R.id.chat)
            textv?.setOnClickListener(View.OnClickListener {
                val intent = Intent(applicationContext, ChatActivity::class.java)
                startActivity(intent)
            })
            val rate: TextView? = diaglog.findViewById(R.id.rateus)
            rate?.setOnClickListener(View.OnClickListener {
                val intent = Intent(applicationContext, WebViewActivity::class.java)
                startActivity(intent)
            })

            val set: TextView? = diaglog.findViewById(R.id.setting)
            set?.setOnClickListener(View.OnClickListener {
                val intent = Intent(applicationContext, WebViewActivity::class.java)
                startActivity(intent)
            })

            diaglog.show()
        })
//
//        view.apply {
//            chat.setOnClickListener(View.OnClickListener {
//
//            })
//        }


        plus_button1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, OptionActivity::class.java)
            startActivity(intent)
        })


    }


    fun getdata() {


        //expence
        //  if (intent.getStringExtra("title") != null) {
        //  title = intent.getStringExtra("title").toString()
        //  image = intent.getIntExtra("image", 0)

        // value = intent.getStringExtra("total").toString()
        if (intent.getStringExtra("total") != null) {
            val b = intent.getStringExtra("total")!!

            expence_money = b.toInt()
            //  ex_sh+=expence_money;
        } else {
            expence_money = 0
        }

//            Thread {
//                val user = User(a++, title, image, value)
//
//                dataBase.getInstance(this).dao.InsertData(user)
//                runOnUiThread {
//                    Runnable {
//                        adapter.notifyDataSetChanged()
//                    }
//                }
//            }.start()


        val s = expence_money

        //database
        val expenseDatabase = Expense_DataBase
        var z = 0;
        Thread {
            val expenseUser = Expense_User(z++, s)

            expenseDatabase.getExpenseInstance(this).expenseDao.InsertData(expenseUser)
        }.start()


        CoroutineScope(IO).launch {
            listOfExpense = Expense_DataBase.getExpenseInstance(this@HomeActivity2).expenseDao
                .getAllExpence()
        }.invokeOnCompletion {
            oberserveOnMainThread()
        }


        //  }
        // if (intent.getStringExtra("title1") != null) {

        // title = intent.getStringExtra("title1").toString()
        //  image = intent.getIntExtra("image1", 0)
        if (intent.getStringExtra("total1") != null) {
            //   value = intent.getStringExtra("total1").toString()
            val d = intent.getStringExtra("total1")
            income_money = d?.toInt()!!
            //  in_sh+=income_money

        }

//            Thread {
//
//                // if (image != 0) {
//
//                val user = User(a++, title, image, value)
//
//                dataBase.getInstance(this).dao.InsertData(user)
//                runOnUiThread {
//                    Runnable {
//                        adapter.notifyDataSetChanged()
//
//                    }
//                }
//
//            }.start()


        var q = 0
        Thread {
            val incomeUser = Income_User(q++, income_money)
            val incomeDatabase = Income_Database
            incomeDatabase.getIncomeInstance(this).incomeDao.InsertData(incomeUser)
        }.start()
        CoroutineScope(IO).launch {
            listofTncome =
                Income_Database.getIncomeInstance(this@HomeActivity2).incomeDao.getAllExpence()

        }.invokeOnCompletion {
            obserincometomainThread()
        }

        //  }
    }

    private fun oberserveOnMainThread() {

        CoroutineScope(Main).launch {
            listOfExpense.forEachIndexed { index, incomeUSer ->
                sum1 += incomeUSer.expense
            }
            expence_amout_exp.text = sum1.toString()
//
//            val message = Message()
////            message.what = COUNT
//            message.arg1 = sum1
//            mHandlerThread.sendMessage(message)

        }
        // total_expense=sum1

    }

    override fun onStart() {
        super.onStart()

    }

    fun obserincometomainThread() {

        CoroutineScope(Main).launch {
            listofTncome.forEachIndexed { index, incomeUSer ->
                sum2 += incomeUSer.income

            }


            Log.d("sum1", "" + sum1)
            //  val intenr122 = Intent()
            //  intenr122.putExtra("sum2", sum2)
            //bundle.putInt("sum2",sum2)
            //  sharedPreferenceHelper.writeinc(this@HomeActivity2,INC,sum2)
            total_income_amount.text = sum2.toString()

            Log.d("suminside", "" + sum2)
            var ink = total_balance_anount.text.toString().toInt()
            // total_balance_anount.text = (ink - sum2).toString()
            print(":debug$sum2")


        }
        //    total_income=sum2
    }


    fun setadapter() {

        selectMonth()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("sum1", sum1)
        outState.putInt("sum2", sum2)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        total_income_amount.text = savedInstanceState.getInt("sum1").toString()
        expence_amout_exp.text = savedInstanceState.getInt("sum2").toString()
        var x = savedInstanceState.getInt("sum1");
        var y = savedInstanceState.getInt("sum1")
        // total_balance_anount.text = (x - y).toString()

    }

    override fun onStop() {
        super.onStop()


    }


    override fun OnSelected(user: User, position: Int) {
        val intent11 = Intent(this, DisplayActivity::class.java)
        intent11.putExtra("img1", user.Image)
        intent11.putExtra("tit1", user.title)
        intent11.putExtra("val1", user.value)
        startActivity(intent11)
        Log.d("janee", "title is" + user.title)
    }

    fun didTapButton() {
        val button: Button = findViewById<View>(R.id.plus_button) as Button

        val myAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.bounce)


        //bounce

        val interpolator = MyBounceInterpolator(0.2, 20)
        myAnim.setInterpolator(interpolator)

        button.startAnimation(myAnim)
    }

    override fun onResume() {
        super.onResume()
        didTapButton()
        val se = total_income_amount.text.toString().toInt()
        val re = expence_amout_exp.text.toString().toInt()
        val swm = se - re
        total_balance_anount.text = swm.toString()

    }


    override fun onPause() {
        super.onPause()

    }


    fun getset(view: View) {
        val etext = findViewById<TextView>(R.id.total_income_amount)
        val itext = findViewById<TextView>(R.id.expence_amout_exp)

        val n = etext.toString()
        var o = n.toInt()
        val m = itext.toString()
        val p = m.toInt()
        val z = p - o
        val s = z.toString()
        val ttext = findViewById<TextView>(R.id.total_balance_anount).apply {
            text = s
        }


    }

    fun selectMonth() {
        val option = arrayOf("Jan", "Feb","Mar","Apr","May","Jun","Jly","Aug","Sep","Oct","Nov","Dec")
        spinner_jan.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option)
        spinner_jan.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {


            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // text_jan.text = option.get(position)
                if (position == 0) {
                    Thread {
                        val userlist = dataBase.getInstance(this@HomeActivity2).dao.getJan()
                        val adapter = HomeRC_Adapter(userlist, this@HomeActivity2)
                        runOnUiThread(Runnable {
                            val linearLayoutManager = LinearLayoutManager(this@HomeActivity2)
                            recycler.layoutManager = linearLayoutManager
                            recycler.adapter = adapter
                        })
                    }.start()

                } else if (position == 1) {
                    Thread {
                        val userlist = dataBase.getInstance(this@HomeActivity2).dao.getFeb()
                        val adapter = HomeRC_Adapter(userlist, this@HomeActivity2)
                        runOnUiThread(Runnable {
                            val linearLayoutManager = LinearLayoutManager(this@HomeActivity2)
                            recycler.layoutManager = linearLayoutManager
                            recycler.adapter = adapter
                        })
                    }.start()

                } else if (position == 2) {
                    Thread {
                        val userlist = dataBase.getInstance(this@HomeActivity2).dao.getMar()
                        val adapter = HomeRC_Adapter(userlist, this@HomeActivity2)
                        runOnUiThread(Runnable {
                            val linearLayoutManager = LinearLayoutManager(this@HomeActivity2)
                            recycler.layoutManager = linearLayoutManager
                            recycler.adapter = adapter
                        })
                    }.start()

                } else if (position == 3) {
                    Thread {
                        val userlist = dataBase.getInstance(this@HomeActivity2).dao.getApr()
                        val adapter = HomeRC_Adapter(userlist, this@HomeActivity2)
                        runOnUiThread(Runnable {
                            val linearLayoutManager = LinearLayoutManager(this@HomeActivity2)
                            recycler.layoutManager = linearLayoutManager
                            recycler.adapter = adapter
                        })
                    }.start()

                }
                else if (position == 4) {
                    Thread {
                        val userlist = dataBase.getInstance(this@HomeActivity2).dao.getMay()
                        val adapter = HomeRC_Adapter(userlist, this@HomeActivity2)
                        runOnUiThread(Runnable {
                            val linearLayoutManager = LinearLayoutManager(this@HomeActivity2)
                            recycler.layoutManager = linearLayoutManager
                            recycler.adapter = adapter
                        })
                    }.start()

                }
                else if (position == 5) {
                    Thread {
                        val userlist = dataBase.getInstance(this@HomeActivity2).dao.getJun()
                        val adapter = HomeRC_Adapter(userlist, this@HomeActivity2)
                        runOnUiThread(Runnable {
                            val linearLayoutManager = LinearLayoutManager(this@HomeActivity2)
                            recycler.layoutManager = linearLayoutManager
                            recycler.adapter = adapter
                        })
                    }.start()

                }
                else if (position == 6) {
                    Thread {
                        val userlist = dataBase.getInstance(this@HomeActivity2).dao.getJly()
                        val adapter = HomeRC_Adapter(userlist, this@HomeActivity2)
                        runOnUiThread(Runnable {
                            val linearLayoutManager = LinearLayoutManager(this@HomeActivity2)
                            recycler.layoutManager = linearLayoutManager
                            recycler.adapter = adapter
                        })
                    }.start()

                }
                else if (position == 7) {
                    Thread {
                        val userlist = dataBase.getInstance(this@HomeActivity2).dao.getAug()
                        val adapter = HomeRC_Adapter(userlist, this@HomeActivity2)
                        runOnUiThread(Runnable {
                            val linearLayoutManager = LinearLayoutManager(this@HomeActivity2)
                            recycler.layoutManager = linearLayoutManager
                            recycler.adapter = adapter
                        })
                    }.start()

                }
                else if (position == 8) {
                    Thread {
                        val userlist = dataBase.getInstance(this@HomeActivity2).dao.getSep()
                        val adapter = HomeRC_Adapter(userlist, this@HomeActivity2)
                        runOnUiThread(Runnable {
                            val linearLayoutManager = LinearLayoutManager(this@HomeActivity2)
                            recycler.layoutManager = linearLayoutManager
                            recycler.adapter = adapter
                        })
                    }.start()

                }
                else if (position == 9) {
                    Thread {
                        val userlist = dataBase.getInstance(this@HomeActivity2).dao.getOct()
                        val adapter = HomeRC_Adapter(userlist, this@HomeActivity2)
                        runOnUiThread(Runnable {
                            val linearLayoutManager = LinearLayoutManager(this@HomeActivity2)
                            recycler.layoutManager = linearLayoutManager
                            recycler.adapter = adapter
                        })
                    }.start()

                }
                else if (position == 10) {
                    Thread {
                        val userlist = dataBase.getInstance(this@HomeActivity2).dao.getNov()
                        val adapter = HomeRC_Adapter(userlist, this@HomeActivity2)
                        runOnUiThread(Runnable {
                            val linearLayoutManager = LinearLayoutManager(this@HomeActivity2)
                            recycler.layoutManager = linearLayoutManager
                            recycler.adapter = adapter
                        })
                    }.start()

                }
                else if (position == 11) {
                    Thread {
                        val userlist = dataBase.getInstance(this@HomeActivity2).dao.getDec()
                        val adapter = HomeRC_Adapter(userlist, this@HomeActivity2)
                        runOnUiThread(Runnable {
                            val linearLayoutManager = LinearLayoutManager(this@HomeActivity2)
                            recycler.layoutManager = linearLayoutManager
                            recycler.adapter = adapter
                        })
                    }.start()

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
        }
    }


    }

