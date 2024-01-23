package com.mandiri.boehaskitchen.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.bebasinaja.base.BaseFragment
import com.mandiri.boehaskitchen.MainActivity
import com.mandiri.boehaskitchen.databinding.FragmentWelcomeBinding

class FragmentWelcome : BaseFragment<FragmentWelcomeBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWelcomeBinding {
        return FragmentWelcomeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        binding.btnWelcome.setOnClickListener {
            val fragmentToDisplay = FragmentLogin()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }
    }
}
