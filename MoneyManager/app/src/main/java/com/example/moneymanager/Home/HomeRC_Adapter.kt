package com.shivaraj.Moneymanager.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shivaraj.Moneymanager.DataBase2.User
import com.shivaraj.Moneymanager.R

class HomeRC_Adapter(var userlist:List<User>, val selectItem: SelectItem):RecyclerView.Adapter<ViewHolder_home>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_home {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.home_itemlayout,parent,false)
        return ViewHolder_home(view,selectItem)
    }

    override fun onBindViewHolder(holder: ViewHolder_home, position: Int) {
    var model=userlist[position]
        holder.SetDataHome(model)
    }

    override fun getItemCount(): Int {
        return  userlist.size
    }

    fun UpdateData(user:List<User>){
        userlist=user
        notifyDataSetChanged()
    }
}