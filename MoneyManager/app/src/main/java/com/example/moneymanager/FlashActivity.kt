package com.shivaraj.Moneymanager

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.MediaController
import com.shivaraj.Moneymanager.Home.ChatActivity
import com.shivaraj.Moneymanager.Home.HomeActivity2
import com.shivaraj.Moneymanager.Login.LoginActivity
import kotlinx.android.synthetic.main.activity_flash.*
import java.net.URI

class FlashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)
        Handler().postDelayed({
            val intent = Intent(this, HomeActivity2::class.java)
            startActivity(intent)
            finish()
        }, 1500) // 3000 is the delayed time in milliseconds.


    }

}