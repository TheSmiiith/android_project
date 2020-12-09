package com.example.androidproject.restaurants

import com.example.androidproject.models.Restaurant

class RestaurantsPresenter(view: RestaurantsContract.View) : RestaurantsContract.Presenter(view) {
    override fun getRestaurants() {
        val restaurants: ArrayList<Restaurant> = ArrayList()
        view.setRestaurants(restaurants)
    }
}