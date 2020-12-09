package com.example.androidproject.restaurants

import android.util.Log
import com.example.androidproject.models.Restaurant
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import java.lang.Exception
import kotlin.reflect.typeOf

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
                    // TODO: implement onError() function to all views
                }
                Log.d("SUCCESS", response.message())
            } catch (e: Exception) {
                // TODO: implement onError() function to all views
            }
        }
    }

}