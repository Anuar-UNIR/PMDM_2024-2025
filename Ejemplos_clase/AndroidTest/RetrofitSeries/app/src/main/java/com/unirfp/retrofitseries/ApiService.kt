package com.unirfp.retrofitseries

import com.unirfp.retrofitseries.model.SeriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getAllSeries(@Url url : String): Response<SeriesResponse>


}