package com.example.androidproject.fragments.restaurants

import com.example.androidproject.models.restaurants.Restaurant
import com.example.androidproject.mvp.BasePresenter
import com.example.androidproject.mvp.BaseView

interface RestaurantsContract {

    interface View : BaseView {
        fun setRestaurants(restaurants: List<Restaurant>)
    }

    abstract class Presenter(view: View) : BasePresenter<View>(view) {
        abstract fun getRestaurants()
    }

}