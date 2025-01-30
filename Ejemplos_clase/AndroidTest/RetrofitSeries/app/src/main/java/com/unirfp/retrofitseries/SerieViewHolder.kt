package com.unirfp.retrofitseries

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.unirfp.retrofitseries.databinding.ItemserieBinding
import com.unirfp.retrofitseries.model.Serie

class SerieViewHolder(view: View) :RecyclerView.ViewHolder(view) {

    private val binding = ItemserieBinding.bind(view)

    fun bind(serie: Serie){
        Picasso.get().load(serie.image).into(binding.ivSerie)
        binding.tvTitle.setText("Titulo: "+serie.title)
        binding.tvCreator.setText("Creador: " + serie.creator)
        binding.tvRating.setText("Puntuación: "+ serie.rating.toString())
    }
}