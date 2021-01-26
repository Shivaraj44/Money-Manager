package com.shivaraj.Moneymanager.Option_Recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.option_item_layout.view.*

class Viewholder_Option(private val view:View,val optionrvListner: OptionRV_Listner):RecyclerView.ViewHolder(view) {
     fun SetData (modelOprion: Model_Oprion){
         view.apply {
             option_title.text=modelOprion.title
             option_image.setImageResource(modelOprion.img)
             optio_item.setOnClickListener(View.OnClickListener {
                 optionrvListner.OnItemClick(modelOprion,adapterPosition)
             })

         }


     }
}