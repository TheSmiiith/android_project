package com.example.androidproject.fragments.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentDetailsBinding
import com.example.androidproject.models.restaurants.Restaurant
import com.example.androidproject.utils.MMaterialAlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DetailsFragment : Fragment(), DetailsContract.View {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    /* Presenter */
    private lateinit var presenter: DetailsPresenter

    /* Views */
    private lateinit var imageView: ImageView
    private lateinit var titleView: TextView
    private lateinit var locationView: TextView
    private lateinit var priceView: TextView
    private lateinit var phoneView: TextView
    private lateinit var callButton: Button
    private lateinit var mapButton: Button

    lateinit var alertDialog: androidx.appcompat.app.AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /* View Binding */
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        /* Instantiate Presenter */
        presenter = DetailsPresenter(this)

        initViews()

        /* Get Restaurant ID from bundle */
        val extras = arguments
        if (extras?.get("id") != null) {
            presenter.getRestaurant(context!!, extras?.get("id") as Int)
        }

        return view
    }

    private fun initViews() {
        imageView = binding.detailsImage
        titleView = binding.detailsTitle
        locationView = binding.detailsLocation
        priceView = binding.detailsPrice
        phoneView = binding.detailsPhone
        callButton = binding.detailsCall
        mapButton = binding.detailsGoogleMaps
    }

    override fun setRestaurant(restaurant: Restaurant) {
        activity?.runOnUiThread {
            Glide
                .with(context!!)
                .load(restaurant.image_url)
                .placeholder(R.drawable.ic_time_280px)
                .fallback(R.drawable.ic_not_280px)
                .into(imageView)
            titleView.text = restaurant.name
            locationView.text = restaurant.getLocation()
            priceView.text = "Price - ${restaurant.getPriceInLetters()} (${restaurant.price})"
            phoneView.text = restaurant.phone
        }
    }

    override fun showError(message: String?) {
        activity?.runOnUiThread {
            MMaterialAlertDialog.getErrorDialog(context!!)
        }
    }

    override fun showLoading() {
        activity?.runOnUiThread {
            alertDialog = MMaterialAlertDialog.getLoadingDialog(context!!)
        }
    }

    override fun hideLoading() {
        activity?.runOnUiThread {
            alertDialog.dismiss()
        }
    }

}