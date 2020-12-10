package com.example.androidproject.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentProfileBinding
import com.example.androidproject.fragments.profile.adapters.TabAdapter
import com.example.androidproject.fragments.profile.favorites.FavoritesFragment
import com.example.androidproject.fragments.profile.settings.SettingsFragment
import com.example.androidproject.utils.MMaterialAlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.tabs.TabLayout

class ProfileFragment : Fragment(), ProfileContract.View {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    /* Presenter */
    private lateinit var presenter: ProfilePresenter

    lateinit var alertDialog: androidx.appcompat.app.AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* View Binding */
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        /* Instantiate Presenter */
        presenter = ProfilePresenter(this)

        /* Setup tabs with TabAdapter & ViewPager */
        val tabLayout: TabLayout = binding.profileTabLayout
        val viewPager: ViewPager = binding.profileViewPager

        val tabAdapter =
            TabAdapter(
                fragmentManager!!
            )
        tabAdapter.addFragment(FavoritesFragment(), getString(R.string.favorites))
        tabAdapter.addFragment(SettingsFragment(), getString(R.string.profile_settings))

        viewPager.adapter = tabAdapter
        tabLayout.setupWithViewPager(viewPager)

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