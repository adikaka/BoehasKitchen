package com.mandiri.boehaskitchen.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.bebasinaja.base.BaseFragment
import com.mandiri.boehaskitchen.MainActivity
import com.mandiri.boehaskitchen.databinding.FragmentHomeBinding
import com.mandiri.boehaskitchen.databinding.FragmentNavigationMenuBinding

class FragmentNavigationMenu : BaseFragment<FragmentNavigationMenuBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNavigationMenuBinding {
        return FragmentNavigationMenuBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        binding.btnProfile.setOnClickListener {
            val fragmentToDisplay = FragmentProfile()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }
        binding.btnWishlist.setOnClickListener {
            val fragmentToDisplay = FragmentWishlist()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }
        binding.btnLoyalty.setOnClickListener {
            val fragmentToDisplay = FragmentLoyalty()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}