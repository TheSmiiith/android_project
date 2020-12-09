package com.example.androidproject.restaurants

import com.example.androidproject.api.RestaurantsAPI
import com.example.androidproject.api.RestaurantsAPIClient
import com.example.androidproject.models.RestaurantResponse
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    }

}