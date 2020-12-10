package com.example.androidproject.fragments.restaurants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentRestaurantsBinding
import com.example.androidproject.models.Restaurant
import com.example.androidproject.fragments.restaurants.adapters.RestaurantsAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class RestaurantsFragment : Fragment(), RestaurantsContract.View {

    private var _binding: FragmentRestaurantsBinding? = null
    private val binding get() = _binding!!

    /* Presenter */
    private lateinit var presenter: RestaurantsPresenter

    lateinit var alertDialog: androidx.appcompat.app.AlertDialog

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

        swipeToRefresh()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /* Set restaurants from presenter */
    override fun setRestaurants(restaurants: List<Restaurant>) {
        activity?.runOnUiThread {
            binding.restaurantsRecyclerView.adapter = RestaurantsAdapter(restaurants)
            binding.restaurantsRecyclerView.layoutManager = LinearLayoutManager(context)
            binding.restaurantsRecyclerView.setHasFixedSize(true)
        }
    }

    override fun showError(message: String?) {
        activity?.runOnUiThread {
            MaterialAlertDialogBuilder(context!!)
                .setTitle(getString(R.string.error_title))
                .setMessage(getString(R.string.error_message))
                .setCancelable(false)
                .show()
        }
    }

    override fun showLoading() {
        alertDialog = MaterialAlertDialogBuilder(context!!).create()
        alertDialog.setTitle(getString(R.string.loading_title))
        alertDialog.setMessage(getString(R.string.loading_message))
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    override fun hideLoading() {
        alertDialog.dismiss()
    }

    private fun swipeToRefresh() {
        binding.restaurantsSwipeToRefresh.setProgressBackgroundColorSchemeColor(resources.getColor(R.color.colorWhite))
        binding.restaurantsSwipeToRefresh.setColorSchemeColors(resources.getColor(R.color.colorPrimary))
        binding.restaurantsSwipeToRefresh.setOnRefreshListener {
            binding.restaurantsSwipeToRefresh.isRefreshing = false
            presenter.getRestaurants()
        }
    }

}