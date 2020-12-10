package com.example.androidproject.fragments.profile.favorites

class FavoritesPresenter(view: FavoritesContract.View) : FavoritesContract.Presenter(view) {
    override fun getData() {
        view.setData()
    }
}