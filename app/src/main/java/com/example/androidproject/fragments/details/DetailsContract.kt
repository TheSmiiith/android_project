package com.example.androidproject.fragments.details

import android.content.Context
import com.example.androidproject.models.restaurants.Restaurant
import com.example.androidproject.mvp.BasePresenter
import com.example.androidproject.mvp.BaseView

interface DetailsContract {

    interface View : BaseView {
        fun setRestaurant(
            restaurant: Restaurant
        )
    }

    abstract class Presenter(view: View) : BasePresenter<View>(view) {
        abstract fun getRestaurant(
            context: Context,
            id: Int
        )
    }

}