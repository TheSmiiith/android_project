package com.example.androidproject.fragments.profile.favorites

import com.example.androidproject.mvp.BasePresenter
import com.example.androidproject.mvp.BaseView

interface FavoritesContract {

    interface View : BaseView {
        fun setData()
    }

    abstract class Presenter(view: View) : BasePresenter<View>(view) {
        abstract fun getData()
    }

}