package com.example.androidproject.fragments.restaurants

import android.util.Log
import com.example.androidproject.api.RestaurantsAPIClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class RestaurantsPresenter(view: RestaurantsContract.View) : RestaurantsContract.Presenter(view) {
    override fun getRestaurants() {
        view.showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val restaurantResponse = RestaurantsAPIClient.getInstance().getRestaurants().execute().body()
                view.hideLoading()
                view.setRestaurants(restaurantResponse!!.restaurants)
            } catch (e: Exception) {
                view.hideLoading()
                view.showError(null)
            }

        }
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val restaurant = RestaurantsAPIClient.getInstance().getRestaurant(116272).execute().body()
                Log.i("SUCCESS", restaurant.toString())
            } catch (e: Exception) {
                Log.e("ERROR", e.message!!)
            }
        }
    }

}