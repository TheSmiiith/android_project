package com.example.androidproject.fragments.details

import com.example.androidproject.mvp.BasePresenter
import com.example.androidproject.mvp.BaseView

interface DetailsContract {

    interface View : BaseView {
        fun setData()
    }

    abstract class Presenter(view: View) : BasePresenter<View>(view) {
        abstract fun getData()
    }

}