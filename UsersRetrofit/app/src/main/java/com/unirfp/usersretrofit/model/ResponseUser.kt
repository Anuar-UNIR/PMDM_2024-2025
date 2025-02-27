package com.unirfp.usersretrofit.model

data class ResponseUser(
    val page: Int,
    val per_page: Int,
    val results: List<User>,
    val total: Int,
    val total_pages: Int
)