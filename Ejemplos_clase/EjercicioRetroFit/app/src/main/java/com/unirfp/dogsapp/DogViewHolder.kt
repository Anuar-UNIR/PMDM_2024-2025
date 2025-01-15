package com.unirfp.dogsapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.unirfp.dogsapp.databinding.ItemDogBinding

class DogViewHolder (view: View): RecyclerView.ViewHolder (view) {

    private val binding = ItemDogBinding.bind(view)

    fun bind(image :String){
        Picasso.get().load(image).into(binding.ivDog)

    }
}