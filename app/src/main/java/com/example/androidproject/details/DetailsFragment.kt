package com.example.androidproject.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentDetailsBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DetailsFragment : Fragment(), DetailsContract.View {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    /* Presenter */
    private lateinit var presenter: DetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /* View Binding */
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        /* Instantiate Presenter */
        presenter = DetailsPresenter(this)

        /* Test function  */
        presenter.getData()

        return view
    }

    override fun setData() {
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

}