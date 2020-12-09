package com.example.androidproject

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.androidproject.databinding.ActivityMainBinding
import com.example.androidproject.fragments.ProfileFragment
import com.example.androidproject.fragments.RestaurantsFragment
import kotlinx.android.synthetic.main.activity_main.*

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
        val restaurantsFragment = RestaurantsFragment()
        val profileFragment = ProfileFragment()

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
            replace(binding.activityMainWrapper.id, fragment)
            commit()
        }
    }

}