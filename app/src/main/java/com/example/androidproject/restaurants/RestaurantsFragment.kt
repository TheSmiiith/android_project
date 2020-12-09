package com.example.androidproject.restaurants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.databinding.FragmentRestaurantsBinding
import com.example.androidproject.models.Restaurant
import com.example.androidproject.restaurants.adapters.RestaurantsAdapter
import kotlinx.android.synthetic.main.fragment_restaurants.*

class RestaurantsFragment : Fragment(), RestaurantsContract.View {

    private var _binding: FragmentRestaurantsBinding? = null
    private val binding get() = _binding!!

    /* Presenter */
    private lateinit var presenter: RestaurantsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /* View Binding */
        _binding = FragmentRestaurantsBinding.inflate(inflater, container, false)
        val view = binding.root

        /* Instantiate Presenter */
        presenter = RestaurantsPresenter(this)

        /* Get restaurants from presenter  */
        presenter.getRestaurants()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /* Set restaurants from presenter */
    override fun setRestaurants(restaurants: List<Restaurant>) {
        binding.restaurantsRecyclerView.adapter = RestaurantsAdapter(restaurants)
        binding.restaurantsRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.restaurantsRecyclerView.setHasFixedSize(true)
    }

}