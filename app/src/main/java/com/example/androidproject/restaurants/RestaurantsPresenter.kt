package com.example.androidproject.restaurants

import com.example.androidproject.models.Restaurant

class RestaurantsPresenter(view: RestaurantsContract.View) : RestaurantsContract.Presenter(view) {
    override fun getRestaurants() {
        val restaurants: ArrayList<Restaurant> = ArrayList()
        restaurants.add(
            Restaurant(
            "no_image",
            "Restaurant #1",
            "Restaurant description #1"
        )
        )
        restaurants.add(Restaurant(
            "no_image",
            "Restaurant #2",
            "Restaurant description #1"
        ))
        restaurants.add(Restaurant(
            "no_image",
            "Restaurant #3",
            "Restaurant description #1"
        ))
        view.setRestaurants(restaurants)
    }
}