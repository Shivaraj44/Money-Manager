package com.shivaraj.Moneymanager.Option_Recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shivaraj.Moneymanager.R

class Adapter_Income (private val modelIncome: List<Model_Income>,val incomeClickListner: IncomeClickListner):
    RecyclerView.Adapter<ViewHolder_Income>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_Income {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.income_item_layout,parent,false)
        return ViewHolder_Income(view,incomeClickListner)
    }

    override fun onBindViewHolder(holder: ViewHolder_Income, position: Int) {
        val model=modelIncome[position]
        holder.SetData(model)
    }

    override fun getItemCount(): Int {
        return  modelIncome.size
    }
}