package com.mandiri.boehaskitchen.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.bebasinaja.base.BaseFragment
import com.mandiri.boehaskitchen.MainActivity
import com.mandiri.boehaskitchen.databinding.FragmentLoginBinding

class FragmentLogin : BaseFragment<FragmentLoginBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        binding.btnLogin.setOnClickListener {
            val fragmentToDisplay = FragmentHome()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }
        binding.btnSignup.setOnClickListener {
            val fragmentToDisplay = FragmentSignup()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }
    }
}