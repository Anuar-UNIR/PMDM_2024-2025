package com.unirfp.usersretrofit

import com.unirfp.usersretrofit.model.ResponseUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getAllUsers(@Url url : String): Response<ResponseUser>
}

