package com.example.androidproject.room.profile

import com.example.androidproject.models.profile.Profile

class ProfileRepository(private val profileDao: ProfileDao) {

    suspend fun addProfile(profile: Profile) {
        profileDao.addProfile(profile)
    }

    suspend fun getProfile(id: Int): Profile = profileDao.getProfile(id)

    suspend fun updateProfile(profile: Profile) {
        profileDao.updateProfile(profile)
    }

}