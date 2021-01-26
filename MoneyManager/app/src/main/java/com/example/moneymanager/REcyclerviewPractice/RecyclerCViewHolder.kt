package com.shivaraj.Moneymanager.REcyclerviewPractice

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerCViewHolder(private val view:View):RecyclerView.ViewHolder(view) {
    fun SetRecyclerData(recyclermodel:RecyclerMode){
        view.apply {
            name123.text=recyclermodel.name
        }
    }
}