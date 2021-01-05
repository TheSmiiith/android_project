package com.example.androidproject.mvp

interface BaseView {
    fun showError(message: String?)
    fun showLoading()
    fun hideLoading()
}