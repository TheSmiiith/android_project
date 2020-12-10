package com.example.androidproject.api

import com.example.androidproject.models.Restaurant
import com.example.androidproject.models.RestaurantResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantsAPI {

    @GET("restaurants?country=US")
    fun getRestaurants(): Call<RestaurantResponse>

    @GET("restaurants/{id}")
    fun getRestaurant(@Path("id") id: Int): Call<Restaurant>

}