package com.firuz.humotransfersample.randomUser.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.firuz.humotransfersample.databinding.CardItemRandomUserBinding
import com.firuz.humotransfersample.databinding.LayoutRandomUserBinding
import com.firuz.humotransfersample.randomUser.model.ResultUser

class RandomUserAdapter(private val itemData: List<ResultUser>) :
    RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder>() {
    class RandomUserViewHolder(val binding: CardItemRandomUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder {
        val binding =
            CardItemRandomUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RandomUserViewHolder(binding)
    }

    override fun getItemCount(): Int = itemData.size

    override fun onBindViewHolder(holder: RandomUserViewHolder, position: Int) {
        val item = itemData[position]
        with(holder.binding){
            textViewTitle.text = "Hi, My name is"
            textViewSubtitle.text = "${item.name.first} ${item.name.last}"

            icUser.setOnClickListener {
                textViewTitle.text = "Hi, My name is"
                textViewSubtitle.text = "${item.name.first} ${item.name.last}"
            }
            icEmail.setOnClickListener {
                textViewTitle.text = "My email address is"
                textViewSubtitle.text = item.email
            }
            icPhone.setOnClickListener {
                textViewTitle.text = "My phone number is"
                textViewSubtitle.text = item.phone
            }

            Glide.with(holder.binding.root)
                .load(item.picture.medium)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageRandomUser)

        }

    }
}