package com.example.androidproject.room.profile

import androidx.room.*
import com.example.androidproject.models.profile.Profile

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProfile(profile: Profile)

    @Query("SELECT * FROM profiles WHERE id = :id")
    suspend fun getProfile(id: Int): Profile

    @Update
    suspend fun updateProfile(profile: Profile)

}