package com.shivaraj.Moneymanager.Login

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.shivaraj.Moneymanager.R
import kotlinx.android.synthetic.main.activity_regester.*

class RegesterActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences

    private val PREF_INT_KEY = "PREF_INT_KEY"
    private val PREF_STRING_KEY = "PREF_STRING_KEY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regester)
        new_reg.setOnClickListener(View.OnClickListener {

            val preferenceHelper=PreferenceHelper()
            preferenceHelper.writeStringtopreference(this,PREF_STRING_KEY,new_name.text.toString())
            preferenceHelper.writeStringtopreference(this,PREF_INT_KEY,new_password.text.toString())
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)

        })
    }
}