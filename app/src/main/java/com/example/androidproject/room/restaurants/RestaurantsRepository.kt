package com.example.androidproject.room.restaurants

import com.example.androidproject.models.restaurants.Restaurant

class RestaurantsRepository(private val restaurantsDao: RestaurantsDao) {

    suspend fun addRestaurant(restaurants: List<Restaurant>) {
        restaurantsDao.addRestaurant(restaurants)
    }

}