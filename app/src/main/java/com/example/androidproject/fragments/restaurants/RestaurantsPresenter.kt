package com.example.androidproject.fragments.restaurants

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.androidproject.api.RestaurantsAPIClient
import com.example.androidproject.room.restaurants.RestaurantsDatabase
import com.example.androidproject.room.restaurants.RestaurantsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class RestaurantsPresenter(view: RestaurantsContract.View) : RestaurantsContract.Presenter(view) {
    override fun getRestaurants(context: Context) {
        view.showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val restaurantResponse = RestaurantsAPIClient.getInstance().getRestaurants().execute().body()
                view.hideLoading()
                view.setRestaurants(restaurantResponse!!.restaurants)
                /* Save to local database */
                val restaurantsDao = RestaurantsDatabase.getDatabase(context).restaurantDao()
                RestaurantsRepository(restaurantsDao).addRestaurant(restaurantResponse.restaurants)
            } catch (e: Exception) {
                view.hideLoading()
                view.showError(null)
            }

        }
    }

}