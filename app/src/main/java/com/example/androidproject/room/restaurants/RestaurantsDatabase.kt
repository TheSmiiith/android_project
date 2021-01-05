package com.example.androidproject.room.restaurants

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidproject.models.restaurants.Restaurant

@Database(entities = [Restaurant::class], version = 1, exportSchema = false)
abstract class RestaurantsDatabase: RoomDatabase() {

    abstract fun restaurantDao(): RestaurantsDao

    companion object {
        @Volatile
        private var INSTANCE: RestaurantsDatabase? = null

        fun getDatabase(context: Context): RestaurantsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RestaurantsDatabase::class.java,
                    "restaurants_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}