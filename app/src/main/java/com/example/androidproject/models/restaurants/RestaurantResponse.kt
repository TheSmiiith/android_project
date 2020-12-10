package com.example.androidproject.models.restaurants

import com.example.androidproject.models.restaurants.Restaurant
import com.google.gson.annotations.SerializedName

data class RestaurantResponse(
    @SerializedName("total_entries")
    val total_entries: Int,

    @SerializedName("per_page")
    val per_page: Short,

    @SerializedName("restaurants")
    val restaurants: List<Restaurant>
)