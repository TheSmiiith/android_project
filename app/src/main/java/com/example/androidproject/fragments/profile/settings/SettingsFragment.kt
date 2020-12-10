package com.example.androidproject.fragments.profile.settings

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentSettingsBinding
import com.example.androidproject.models.profile.Profile
import com.example.androidproject.utils.FormUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import java.time.Duration

class SettingsFragment : Fragment(), SettingsContract.View {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    /* Presenter */
    private lateinit var presenter: SettingsPresenter

    /* Views */
    lateinit var nameLayout: TextInputLayout
    lateinit var addressLayout: TextInputLayout
    lateinit var emailLayout: TextInputLayout
    lateinit var phoneLayout: TextInputLayout
    lateinit var saveButton: Button

    lateinit var alertDialog: androidx.appcompat.app.AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* View Binding */
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root

        /* Instantiate Presenter */
        presenter = SettingsPresenter(this)

        initForm()

        presenter.getProfile(context!!)

        return view
    }

    private fun initForm() {
        nameLayout = binding.settingsNameTextInputLayout
        addressLayout = binding.settingsAddressTextInputLayout
        emailLayout = binding.settingsEmailTextInputLayout
        phoneLayout = binding.settingsPhoneTextInputLayout
        saveButton = binding.settingsSave
        saveButton.setOnClickListener {
            if (FormUtils.validateSettingsForm(
                    nameLayout, addressLayout, emailLayout, phoneLayout
                )) {
                presenter.updateProfile(
                    context!!,
                    nameLayout.editText?.text.toString(),
                    addressLayout.editText?.text.toString(),
                    emailLayout.editText?.text.toString(),
                    phoneLayout.editText?.text.toString()
                )
            }
        }
    }

    override fun setProfile(profile: Profile) {
        activity?.runOnUiThread {
            nameLayout.editText?.setText(profile.name)
            addressLayout.editText?.setText(profile.address)
            emailLayout.editText?.setText(profile.email)
            phoneLayout.editText?.setText(profile.phone_number)
        }
    }

    override fun showSuccess() {
        activity?.runOnUiThread {
            MaterialAlertDialogBuilder(context!!)
                .setTitle(getString(R.string.success_title))
                .setMessage(getString(R.string.settings_success_update))
                .setIcon(R.drawable.ic_success_24)
                .setCancelable(false)
                .show()
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

}