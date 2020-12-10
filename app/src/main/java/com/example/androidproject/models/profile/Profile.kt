package com.example.androidproject.models.profile

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profiles")
data class Profile (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var email: String,
    var name: String,
    var profile_pic: String,
    var Address: String,
    var phone_number: String
)