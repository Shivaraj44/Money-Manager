package com.shivaraj.Moneymanager.Option_Recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shivaraj.Moneymanager.R

class Adapter_Option(private val modelist:List<Model_Oprion>,val optionrvListner: OptionRV_Listner):RecyclerView.Adapter<Viewholder_Option>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder_Option {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.option_item_layout,parent,false)
        return Viewholder_Option(view,optionrvListner)
    }

    override fun onBindViewHolder(holder: Viewholder_Option, position: Int) {
val model=modelist[position]
        holder.SetData(model)
    }

    override fun getItemCount(): Int {
return  modelist.size
    }
}