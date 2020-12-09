package com.example.androidproject.restaurants

class RestaurantsPresenter(view: RestaurantsContract.View) : RestaurantsContract.Presenter(view) {
    override fun getData() {
        view.setData()
    }
}