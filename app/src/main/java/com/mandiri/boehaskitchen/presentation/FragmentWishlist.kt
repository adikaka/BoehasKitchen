package com.mandiri.boehaskitchen.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.bebasinaja.base.BaseFragment
import com.mandiri.boehaskitchen.MainActivity
import com.mandiri.boehaskitchen.databinding.FragmentHomeBinding
import com.mandiri.boehaskitchen.databinding.FragmentWishlistBinding

class FragmentWishlist : BaseFragment<FragmentWishlistBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWishlistBinding {
        return FragmentWishlistBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}