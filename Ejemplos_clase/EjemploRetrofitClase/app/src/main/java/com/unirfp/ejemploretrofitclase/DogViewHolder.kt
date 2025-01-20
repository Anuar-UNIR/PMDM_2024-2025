package com.unirfp.ejemploretrofitclase

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.unirfp.ejemploretrofitclase.databinding.ItemDogBinding

class DogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemDogBinding.bind(view); //el layout particular que hemos creado

    fun bind(image: String){
        Picasso.get().load(image).into(binding.ivDog)
    }
}