package com.example.androidproject.api

import com.example.androidproject.models.RestaurantResponse
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantsAPI {

    @GET("restaurants?country=US")
    fun getRestaurants(): Call<RestaurantResponse>

}