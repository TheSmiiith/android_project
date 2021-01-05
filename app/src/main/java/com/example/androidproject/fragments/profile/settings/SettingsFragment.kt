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
import com.example.androidproject.utils.MMaterialAlertDialog
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
            MMaterialAlertDialog.getSuccessDialog(context!!, getString(R.string.settings_success_update))
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