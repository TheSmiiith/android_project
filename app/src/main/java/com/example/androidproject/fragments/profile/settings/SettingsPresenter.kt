package com.example.androidproject.fragments.profile.settings

import android.content.Context
import android.util.Log
import com.example.androidproject.R
import com.example.androidproject.models.profile.Profile
import com.example.androidproject.room.profile.ProfileDatabase
import com.example.androidproject.room.profile.ProfileRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class SettingsPresenter(view: SettingsContract.View) : SettingsContract.Presenter(view) {
    override fun getProfile(context: Context) {
        val profileDao = ProfileDatabase.getDatabase(context).profileDao()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val profile = ProfileRepository(profileDao).getProfile(1)
                view.setProfile(profile)
            } catch (e: Exception) {
                Log.e("ERROR", e.toString())
                view.showError(null)
            }
        }
    }

    override fun updateProfile(context: Context, name: String, address: String, email: String, phone: String) {
        view.showLoading()
        val profile: Profile = Profile(1, email, name, "", address, phone)
        val profileDao = ProfileDatabase.getDatabase(context).profileDao()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                ProfileRepository(profileDao).addProfile(profile)
                view.hideLoading()
                view.showSuccess()
            } catch (e: Exception) {
                view.hideLoading()
                view.showError(null)
            }
        }
    }
}