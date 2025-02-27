package com.unirfp.usersretrofit.model

data class User(
    val _id: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val image: String,
    val last_name: String,
    val password: String,
    val username: String
)