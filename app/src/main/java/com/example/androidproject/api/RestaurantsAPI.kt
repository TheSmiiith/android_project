package com.example.androidproject.api

import com.example.androidproject.models.restaurants.Restaurant
import com.example.androidproject.models.restaurants.RestaurantResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantsAPI {

    @GET("restaurants")
    fun getRestaurants(): Call<RestaurantResponse>

    @GET("restaurants/{id}")
    fun getRestaurant(@Path("id") id: Int): Call<Restaurant>

}