package com.unirfp.usersretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unirfp.usersretrofit.model.User

class UserAdapter(val users : List<User>) : RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        return UserViewHolder(layoutInflater.inflate(R.layout.itemuser, parent, false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item : User = users[position]
        holder.bind(item)
    }

}