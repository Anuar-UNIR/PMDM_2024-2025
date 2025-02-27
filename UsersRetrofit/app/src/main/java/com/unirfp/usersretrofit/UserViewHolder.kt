package com.unirfp.usersretrofit

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.unirfp.usersretrofit.databinding.ItemuserBinding
import com.unirfp.usersretrofit.model.User

class UserViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemuserBinding.bind(view)

    fun bind(user: User){
        Picasso.get().load(user.image).into(binding.ivUser)
        binding.tvFirstName.setText("Nombre: "+user.first_name)
        binding.tvLastName.setText("Apellidos: " + user.last_name)
        binding.tvEmail.setText("Email: "+ user.email.toString())
    }
}