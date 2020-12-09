package com.example.androidproject.details

class DetailsPresenter(view: DetailsContract.View) : DetailsContract.Presenter(view) {
    override fun getData() {
        view.setData()
    }
}