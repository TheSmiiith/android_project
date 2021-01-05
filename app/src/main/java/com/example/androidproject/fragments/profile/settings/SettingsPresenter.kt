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
                val profile = ProfileRepository(profileDao).getProfile(0)
                /* If profile not found - create default profile */
                if (profile == null) {
                    val profile = Profile(
                        0,
                        "johnsmith@john.smith",
                        "John Smith",
                        "",
                        "John Smith's Address, 666",
                        "00000000000"
                    )
                    ProfileRepository(profileDao).addProfile(profile)
                    view.setProfile(profile)
                } else {
                    view.setProfile(profile)
                }
            } catch (e: Exception) {
                view.showError(null)
            }
        }
    }

    override fun updateProfile(context: Context, name: String, address: String, email: String, phone: String) {
        view.showLoading()
        val profile: Profile = Profile(
            0,
            email,
            name,
            "",
            address,
            phone
        )
        val profileDao = ProfileDatabase.getDatabase(context).profileDao()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                ProfileRepository(profileDao).updateProfile(profile)
                view.hideLoading()
                view.showSuccess()
            } catch (e: Exception) {
                view.hideLoading()
                view.showError(null)
            }
        }
    }
}