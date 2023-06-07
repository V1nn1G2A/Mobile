package com.example.artgallery.data.network

import com.example.artgallery.data.models.Image
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/photos/?client_id=AAuC1m2vJCzAl_6xjsi1FPxu5WBZ0DTDCzTmuwXORmQ")
    suspend fun getAllArts() : Response<List<Image>>
}