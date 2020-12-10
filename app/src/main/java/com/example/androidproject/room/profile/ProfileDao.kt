package com.example.androidproject.room.profile

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.androidproject.models.Profile

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProfile(profile: Profile)

    @Update
    suspend fun updateProfile(profile: Profile)

}