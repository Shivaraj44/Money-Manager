package com.shivaraj.Moneymanager.Option_Recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.income_item_layout.view.*
import kotlinx.android.synthetic.main.option_item_layout.view.*
import kotlinx.android.synthetic.main.option_item_layout.view.optio_item

class ViewHolder_Income(val view:View,val incomeClickListner: IncomeClickListner):RecyclerView.ViewHolder(view) {
    fun SetData(modelIncome: Model_Income){
        view.apply {
            option_title_income.text=modelIncome.title_income
            option_image_income.setImageResource(modelIncome.img_income)
            optio_item_income.setOnClickListener(View.OnClickListener {
                incomeClickListner.Onclicked(modelIncome,adapterPosition)
            })

        }

    }
}