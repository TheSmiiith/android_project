package com.example.androidproject.fragments.profile.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentFavoritesBinding
import com.example.androidproject.utils.MMaterialAlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class FavoritesFragment : Fragment(), FavoritesContract.View {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    /* Presenter */
    private lateinit var presenter: FavoritesPresenter

    lateinit var alertDialog: androidx.appcompat.app.AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* View Binding */
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val view = binding.root

        /* Instantiate Presenter */
        presenter = FavoritesPresenter(this)

        return view
    }

    override fun setData() {
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