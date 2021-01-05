package com.example.androidproject.fragments.profile

class ProfilePresenter(view: ProfileContract.View) : ProfileContract.Presenter(view) {
    override fun getData() {
        view.setData()
    }
}