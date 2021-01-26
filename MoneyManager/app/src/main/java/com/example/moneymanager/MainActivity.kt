package com.shivaraj.Moneymanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.shivaraj.Moneymanager.LoginFragments.Fragment1
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {


    private lateinit var viewpager: ViewPager
    private lateinit var tabs: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment1= Fragment1()
        fragment1.arguments=intent.extras
    supportFragmentManager.beginTransaction().add(R.id.frame,fragment1).addToBackStack("first").commit()

    }


}