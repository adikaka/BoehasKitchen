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
            val email = binding.etEmail.text.toString()
            val password = binding.etPass.text.toString()

            if (email == "admin@gmail.com" && password == "admin123") {
                val fragmentToDisplay = FragmentHome()
                (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
            } else {
                showToast("Berikan masukan yang sesuai")
            }
        }
        binding.btnSignup.setOnClickListener {
            val fragmentToDisplay = FragmentSignup()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }
    }
}