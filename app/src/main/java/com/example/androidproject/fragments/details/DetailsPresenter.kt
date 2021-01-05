package com.example.androidproject.fragments.details

import android.content.Context
import android.util.Log
import com.example.androidproject.api.RestaurantsAPIClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailsPresenter(view: DetailsContract.View) : DetailsContract.Presenter(view) {
    override fun getRestaurant(context: Context, id: Int) {
        view.showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val restaurant = RestaurantsAPIClient.getInstance().getRestaurant(id).execute().body()
                if (restaurant != null) {
                    view.hideLoading()
                    view.setRestaurant(restaurant)
                } else {
                    view.hideLoading()
                    view.showError(null)
                }
            } catch (e: Exception) {
                view.hideLoading()
                view.showError(null)
            }
        }
    }
}