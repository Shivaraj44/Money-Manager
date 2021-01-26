package com.shivaraj.Moneymanager.REcyclerviewPractice

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shivaraj.Moneymanager.R

class RecyclerAdaper(val recyclerModelist: List<RecyclerMode>):RecyclerView.Adapter<RecyclerCViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerCViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return RecyclerCViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerCViewHolder, position: Int) {
val model=recyclerModelist[position]
        holder.SetRecyclerData(model)
    }

    override fun getItemCount(): Int {
return recyclerModelist.size   }
}