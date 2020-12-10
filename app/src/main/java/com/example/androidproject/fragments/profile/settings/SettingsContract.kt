package com.example.androidproject.fragments.profile.settings

import android.content.Context
import com.example.androidproject.models.profile.Profile
import com.example.androidproject.mvp.BasePresenter
import com.example.androidproject.mvp.BaseView

interface SettingsContract {

    interface View : BaseView {
        fun setProfile(profile: Profile)
    }

    abstract class Presenter(view: View) : BasePresenter<View>(view) {
        abstract fun getProfile(
            context: Context
        )
        abstract fun updateProfile(
            context: Context, name: String, address: String, email: String, phone: String
        )
    }

}