package com.mandiri.boehaskitchen.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.bebasinaja.base.BaseFragment
import com.mandiri.boehaskitchen.MainActivity
import com.mandiri.boehaskitchen.databinding.FragmentHomeBinding
import com.mandiri.boehaskitchen.databinding.FragmentSignupBinding

class FragmentSignup : BaseFragment<FragmentSignupBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignupBinding {
        return FragmentSignupBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        binding.btnSignin.setOnClickListener{
            val fragmentToDisplay = FragmentHome()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }
    }
}