package com.example.androidproject.restaurants

import com.example.androidproject.models.RestaurantResponse
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.lang.Exception

class RestaurantsPresenter(view: RestaurantsContract.View) : RestaurantsContract.Presenter(view) {
    override fun getRestaurants() {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("https://opentable.herokuapp.com/api/restaurants?country=US&page=1")
            .build()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response: Response = client.newCall(request).execute()
                if (!response.isSuccessful) {
                    view.showError(null)
                }
                val gson = Gson()
                val restaurantResponse: RestaurantResponse = gson.fromJson(response.body()?.charStream(), RestaurantResponse::class.java)
                view.setRestaurants(restaurantResponse.restaurants)
            } catch (e: Exception) {
                view.showError(null)
            }
        }
    }

}