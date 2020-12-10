package com.example.androidproject.room.restaurants

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.androidproject.models.restaurants.Restaurant

@Dao
interface RestaurantsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRestaurant(restaurants: List<Restaurant>)

}