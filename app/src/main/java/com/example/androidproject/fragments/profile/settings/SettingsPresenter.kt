package com.example.androidproject.fragments.profile.settings

class SettingsPresenter(view: SettingsContract.View) : SettingsContract.Presenter(view) {
    override fun getData() {
        view.setData()
    }
}