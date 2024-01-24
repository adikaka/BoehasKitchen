package com.mandiri.boehaskitchen.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.bebasinaja.base.BaseFragment
import com.mandiri.boehaskitchen.MainActivity
import com.mandiri.boehaskitchen.databinding.FragmentHomeBinding
import com.mandiri.boehaskitchen.databinding.FragmentLoyaltyBinding

class FragmentLoyalty : BaseFragment<FragmentLoyaltyBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoyaltyBinding {
        return FragmentLoyaltyBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}