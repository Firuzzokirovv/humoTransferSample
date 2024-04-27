package com.firuz.humotransfersample.ChooseCountry.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.firuz.humotransfersample.ChooseCountry.ChooseCountryActivity
import com.firuz.humotransfersample.ChooseCountry.model.ChooseCountryModel
import com.firuz.humotransfersample.R
import com.firuz.humotransfersample.Transfer.TransferActivity

class ChooseCountryAdapter(private var itemData: List<ChooseCountryModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        var onClickItem : ((ChooseCountryModel) -> Unit)? = null


    class ChooseCountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.hum_transfer_image)
        val countryName: TextView = view.findViewById(R.id.hum_transfer_countryName)
    }


    fun setFilteredList(itemData: List<ChooseCountryModel>){
        this.itemData = itemData
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item_choose_country,parent,false)
        return ChooseCountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemData[position]
        if(holder is ChooseCountryViewHolder){
            holder.image.setImageResource(item.image)
            holder.countryName.text = item.countryName

            holder.itemView.setOnClickListener{
                onClickItem?.invoke(item)
            }
        }
    }

}