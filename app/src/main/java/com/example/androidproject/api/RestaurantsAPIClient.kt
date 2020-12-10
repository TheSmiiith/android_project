package com.example.androidproject.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestaurantsAPIClient {

    private val restaurantsApi: RestaurantsAPI

    init {
        val client = OkHttpClient()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ratpark-api.imok.space/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        restaurantsApi = retrofit.create(RestaurantsAPI::class.java)
    }

    fun getInstance(): RestaurantsAPI {
        return restaurantsApi
    }

}