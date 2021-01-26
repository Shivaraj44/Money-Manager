package com.shivaraj.Moneymanager.Home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.shivaraj.Moneymanager.DataBase2.User
import kotlinx.android.synthetic.main.home_itemlayout.view.*

class ViewHolder_home(private val view:View,val selectItem: SelectItem):RecyclerView.ViewHolder(view) {
    fun SetDataHome(user: User){
        view.apply {
            coming_text.text=user.title
            coming_value.text=user.value.toString()
           coming_image.setImageResource(user.Image)
            linear_item.setOnClickListener(View.OnClickListener {
                selectItem.OnSelected(user,adapterPosition)
            })
        }
    }
}