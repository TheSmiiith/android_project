package com.example.androidproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.androidproject.fragments.ProfileFragment
import com.example.androidproject.fragments.RestaurantsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restaurantsFragment = RestaurantsFragment()
        val profileFragment = ProfileFragment()

        setFragment(restaurantsFragment)

        activity_main_bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_restaurants -> setFragment(restaurantsFragment)
                R.id.item_profile -> setFragment(profileFragment)
            }
            true
        }

    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.activity_main_wrapper, fragment)
            commit()
        }
    }

}