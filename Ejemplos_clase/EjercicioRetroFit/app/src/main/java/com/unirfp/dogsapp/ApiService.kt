package com.unirfp.dogsapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getDogsByBreed(@Url url : String): Response<DogsResponse>


}