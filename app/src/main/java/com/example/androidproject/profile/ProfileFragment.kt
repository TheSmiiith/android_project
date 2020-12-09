package com.example.androidproject.profile

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentProfileBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ProfileFragment : Fragment(), ProfileContract.View {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    /* Presenter */
    private lateinit var presenter: ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* View Binding */
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        /* Instantiate Presenter */
        presenter = ProfilePresenter(this)

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