package com.shivaraj.Moneymanager.Home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shivaraj.Moneymanager.R
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        val intent22 = Intent()
        val value = intent22.getIntExtra("val1", 0)
        val image = intent22.getIntExtra("img1", 0)
        val title = intent22.getStringExtra("tit1")
        desplai_image.setImageResource(image)
        display_title.text = title
        money_text.text = value.toString()


    }
}