package com.example.androidproject

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.androidproject.databinding.ActivityMainBinding
import com.example.androidproject.profile.ProfileFragment
import com.example.androidproject.restaurants.RestaurantsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Data Binding */
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /* Set Orientation to portrait */
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        /* Bottom Navigation Implementation */
        val restaurantsFragment =
            RestaurantsFragment()
        val profileFragment =
            ProfileFragment()

        setFragment(restaurantsFragment)

        binding.activityMainBottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_restaurants -> setFragment(restaurantsFragment)
                R.id.item_profile -> setFragment(profileFragment)
            }
            true
        }

    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            add(binding.activityMainWrapper.id, fragment)
            commit()
        }
    }

}