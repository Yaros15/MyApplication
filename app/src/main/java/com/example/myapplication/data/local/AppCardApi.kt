package com.example.myapplication.data.local

import com.example.myapplication.data.dto.AppCardDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AppCardApi {

    @GET("catalog")
    suspend fun getCatalog(): List<AppCardDto>

    @GET("catalog/{id}")
    suspend fun getAppCard(@Path("id") id: String): AppCardDto

}