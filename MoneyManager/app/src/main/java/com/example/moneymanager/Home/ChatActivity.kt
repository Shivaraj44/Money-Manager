package com.shivaraj.Moneymanager.Home

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.shivaraj.Moneymanager.R
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel





class ChatActivity : AppCompatActivity() {

    var tvR: TextView? =
        null
    var tvPython:TextView? = null
    var tvCPP:TextView? = null
    var tvJava:TextView? = null
    var pieChart: PieChart? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        tvR = findViewById(R.id.tvR);
        tvPython = findViewById(R.id.tvPython);
        tvCPP = findViewById(R.id.tvCPP);
        tvJava = findViewById(R.id.tvJava);
        pieChart = findViewById(R.id.piechart);
        setData()
    }
    private fun setData() {

        // Set the percentage of language used
        tvR!!.text = Integer.toString(42)
        tvPython!!.text = Integer.toString(30)
        tvCPP!!.text = Integer.toString(5)
        tvJava!!.text = Integer.toString(25)

        // Set the data and color to the pie chart
        pieChart!!.addPieSlice(
            PieModel(
                "Bonus", tvR!!.text.toString().toInt().toFloat(),
                Color.parseColor("#FFA726")
            )
        )
        pieChart!!.addPieSlice(
            PieModel(
                "Car", tvPython!!.text.toString().toInt().toFloat(),
                Color.parseColor("#66BB6A")
            )
        )
        pieChart!!.addPieSlice(
            PieModel(
                "Bill", tvCPP!!.text.toString().toInt().toFloat(),
                Color.parseColor("#EF5350")
            )
        )
        pieChart!!.addPieSlice(
            PieModel(
                "Home", tvJava!!.text.toString().toInt().toFloat(),
                Color.parseColor("#29B6F6")
            )
        )

        // To animate the pie chart
        pieChart!!.startAnimation()
    }
}