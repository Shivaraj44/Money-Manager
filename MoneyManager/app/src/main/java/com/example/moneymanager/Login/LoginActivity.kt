package com.shivaraj.Moneymanager.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.shivaraj.Moneymanager.Home.HomeActivity2
import com.shivaraj.Moneymanager.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val PREF_STRING_KEY = "PREF_STRING_KEY"
    private val PREF_INT_KEY = "PREF_INT_KEY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        regester_main.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RegesterActivity::class.java)
            startActivity(intent)
        })
        login_main.setOnClickListener(View.OnClickListener {
            val ename: String = user_name.text.toString()
            val epasswor: String = user_password.text.toString()
            val preferenceHelper = PreferenceHelper()
            val stringFromPref: String? =
                preferenceHelper.getStringFromPreference(this, PREF_STRING_KEY)
            val sharepassword: String? =
                preferenceHelper.getStringFromPreference(this, PREF_INT_KEY)

            if (ename == stringFromPref && epasswor == sharepassword) {
                // val intent=Intent(this,)
                Toast.makeText(this, "Matched", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ::HomeActivity2::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Not Matched", Toast.LENGTH_SHORT).show()

            }
        })

    }
}