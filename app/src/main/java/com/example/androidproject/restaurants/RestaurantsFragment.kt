package com.example.androidproject.restaurants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidproject.databinding.FragmentRestaurantsBinding

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

        /* Test function  */
        presenter.getData()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun setData() {
    }

}