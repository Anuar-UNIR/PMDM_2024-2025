package com.unirfp.ejemploretrofitclase

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getDogsByBreed(@Url url : String) : Response<DogsResponse>

    @GET
    suspend fun getAllBreeds(@Url url : String): Response<DogsResponse>
    // Definir tantas peticiones como necesite

    //getDogById(id)

    // @POST

    // @PUT

    // @DELETE
}